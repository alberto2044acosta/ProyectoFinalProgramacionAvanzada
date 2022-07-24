package edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga.model;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class Saga {

    private String name;
    private String key;
    private List<Class<? extends SagaStep<T> requiredStep;
    private SagaPayLoad<T> payLoad;

    @Setter
    private boolean isErrorOcurred;

    private boolean isCompleteExecution;

    @Setter
    private Class<? extends SagaStep<T>> currentStep;

    public void setIsCompleteExecution(boolean value) {
        if (value) {
            clearCurrentStep();
        }
        this.isCompleteExecution = value;
    }

    public void clearCurrentStep() {
        this.currentStep = null;
    }
}
