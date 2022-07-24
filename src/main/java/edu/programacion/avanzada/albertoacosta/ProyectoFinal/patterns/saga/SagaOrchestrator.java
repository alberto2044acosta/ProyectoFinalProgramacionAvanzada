package edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga.model.Saga;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga.model.SagaException;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga.model.SagaStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.concurrent.*;

@Slf4j
@Component
public class SagaOrchestrator {

    private final AplicationContext aplicationContext;

    public SagaOrchestrator(AplicationContext aplicationContext) {
        this.aplicationContext = aplicationContext;
    }

    public <T> T orchestrate(Saga<T> saga, int secondTimeOut) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<T> future = executorService.submit(() -> orchestrate(saga));
        try {
            return future.get(secondTimeOut, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw new SagaException(ex);
        } catch (TimeoutException | ExecutionException ex) {
            future.cancel(true);
            throw new SagaException(ex);
        }
    }

    private <T> T orchestrate(Saga<T> saga){
        for (Class<? extends SagaStep<T>> sagaStep : saga.getRequiredStep()) {
            if(Thread.interrupted()){
                triggerCompensation(saga);
            }
            saga.setCurrentStep(sagaStep);
            try {
                SagaStep<T> bean = aplicationContext.getBean(sagaStep);
                log.info("Executing step for SAGA: {}", saga.getName(), bean.getName());
                bean.getHandler().handle(saga.getPayLoad());
            } catch (Exception ex) {
                triggerCompensation(saga);
                saga.setIsCompleteExecution(true);
                throw ex;
            }
        }
        saga.setIsCompleteExecution(true);
        return saga.getPayLoad().getResult();
    }

    private <T> void triggerCompensation(Saga<T> saga){
        log.info("Triggering compensation SAGA {} : {}", saga.getName(), saga.getKey());
        List<Class<? extends SagaStep<T>>> steps = new ArrayList<>();
        for (Class<? extends SagaStep<T>> sagaStep : saga.getRequiredStep()) {
            if (saga.getCurrentStep().equals(sagaStep)) {
                break;
            }
            steps.add(sagaStep);
        }
        for (int i = steps.size() - 1; i >=0; i--) {
            Class<? extends SagaStep<T>> sagaStep = steps.get(i);
            SagaStep<T> bean = aplicationContext.getBean(sagaStep);
            if (bean.getCompensator() != null) {
                bean.getCompensator().handle(saga.getPayLoad());
            } else {
                log.info("Step {}, no have compensation", bean.getName());
            }
        }
    }
}
