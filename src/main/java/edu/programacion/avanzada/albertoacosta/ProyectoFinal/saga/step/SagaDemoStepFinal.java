package edu.programacion.avanzada.albertoacosta.ProyectoFinal.saga.step;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.DemoCommand;
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
public class SagaDemoStepFinal implements SagaStep<DemoResponse> {

    @Override
    public String getName() {
        return "Demo step final";
    }

    @Override
    public SagaStepHandler<DemoResponse> getHandler() {
        return sagaPayLoad -> {
            DemoCommand command = sagaPayLoad.getProperty(new SagaPayLoadKey<>("command", DemoCommand.class));
            log.info("Running {} Handler", getName());
            System.out.println("Testing demo handler");
            BigDecimal decimal = sagaPayLoad.getProperty(new SagaPayLoadKey<>("decimal", BigDecimal.class));
            log.info("Reading value from step 1: {}", decimal);
            sagaPayLoad.setResult(DemoResponse.builder().data("Wiiii complete!").build());
        };
    }

    @Override
    public SagaStepCompensator<T> getCompensator() {
        return null;
    }
}
