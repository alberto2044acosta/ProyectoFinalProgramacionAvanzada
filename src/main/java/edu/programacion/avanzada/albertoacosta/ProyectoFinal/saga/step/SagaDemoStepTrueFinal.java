package edu.programacion.avanzada.albertoacosta.ProyectoFinal.saga.step;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.DemoCommand;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.DemoResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga.model.SagaPayLoadKey;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga.model.SagaStep;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga.model.SagaStepCompensator;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga.model.SagaStepHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SagaDemoStepTrueFinal implements SagaStep<DemoResponse> {

    @Override
    public String getName() {
        return "Demo step true final";
    }

    @Override
    public SagaStepHandler<DemoResponse> getHandler() {
        return sagaPayLoad -> {
            DemoCommand command = sagaPayLoad.getProperty(new SagaPayLoadKey<>("command", DemoCommand.class));
            log.info("Running {} Handler", getName());
            if(command.isExplote()) {
                throw new RuntimeException("Mi servicio explota!");
            }
        };
    }

    @Override
    public SagaStepCompensator<DemoResponse> getCompensator() {
        return ;
    }
}
