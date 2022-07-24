package edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga.model;

public interface SagaStepCompensator {

    void handle(SagaPayLoad<T> sagaPayLoad);
}
