package edu.programacion.avanzada.albertoacosta.ProyectoFinal.saga;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.DemoCommand;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.DemoResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga.model.Saga;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga.model.SagaPayLoad;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga.model.SagaPayLoadKey;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.saga.step.SagaDemoStep1;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.saga.step.SagaDemoStep2;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.saga.step.SagaDemoStepFinal;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.saga.step.SagaDemoStepTrueFinal;

import java.util.List;

public class SagaFactory {

    public static Saga<DemoResponse> createDemoSaga(String key, DemoCommand command){
        SagaPayLoad<DemoResponse> sagaPayLoad = new SagaPayLoad<>();
        SagaPayLoad.addProperty(new SagaPayLoadKey<>("command", DemoCommand.class), command);
        return Saga.<DemoResponse>builder()
                .name("Demo Saga")
                .key(key)
                .payLoad(sagaPayLoad)
                .requiredStep(List.of(
                        SagaDemoStep1.class,
                        SagaDemoStep2.class,
                        SagaDemoStepFinal.class,
                        SagaDemoStepTrueFinal.class
                ))
                .build();
    }
}
