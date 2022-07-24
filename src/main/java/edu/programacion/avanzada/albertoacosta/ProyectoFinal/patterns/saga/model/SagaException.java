package edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga.model;

public class SagaException extends RuntimeException{

    public SagaException(Throwable cause) {
        super(cause);
    }
}
