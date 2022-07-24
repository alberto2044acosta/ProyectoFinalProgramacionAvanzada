package edu.programacion.avanzada.albertoacosta.ProyectoFinal.saga.step;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.DemoResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga.model.SagaPayLoadKey;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga.model.SagaStep;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga.model.SagaStepCompensator;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga.model.SagaStepHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
public class SagaDemoStep2 implements SagaStep<DemoResponse> {

    @Override
    public String getName() {
        return "Demo step 2";
    }

    @Override
    public SagaStepHandler<DemoResponse> getHandler() {
        return sagaPayLoad -> {
            log.info("Running {} Handler", getName());
        };
    }

    @Override
    public SagaStepCompensator<DemoResponse> getCompensator() {
        return sagaPayLoad -> {
            log.info("Running {} compensator", getName());
            log.info("Only show 2 comments here");
        };
    }
}
