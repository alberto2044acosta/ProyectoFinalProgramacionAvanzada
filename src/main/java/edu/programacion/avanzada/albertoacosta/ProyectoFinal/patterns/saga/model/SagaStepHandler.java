package edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga.model;

public interface SagaStepHandler {

    void handle(SagaPayLoad<T> sagaPayLoad);
}
