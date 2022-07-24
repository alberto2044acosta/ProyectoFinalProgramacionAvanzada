package edu.programacion.avanzada.albertoacosta.ProyectoFinal.saga.step;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.DemoResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Slf4j
public class SagaDemoStep1 implements SagaStep<DemoResponse> {

    @Override
    public String getName() {
        return "Demo step 1";
    }

    @Override
    public SagaStepHandler<DemoResponse> getHandler() {
        return sagaPayLoad -> {
            log.info("Running {} Handler", getName());
            System.out.println("Testing demo handler");
            sagaPayLoad.addProperty(new SagaPayLoadKey<>("decimal", BigDecimal.class), new BigDecimal(600));
        };
    }

    @Override
    public SagaStepCompensator<DemoResponse> getCompensator() {
        return sagaPayLoad -> {
            log.info("Running {} compensator", getName());
            log.info("Fallando epicamente!");
        };
    }
}
