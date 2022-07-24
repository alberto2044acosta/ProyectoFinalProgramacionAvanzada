package edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga.model;

public class SagaPayLoadKey<T> {

    private final String id;
    private Class<T> type;

    public SagaPayLoadKey(String id, Class<T> type){
        this.id = id;
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SagaPayLoadKey) {
            return ((SagaPayLoadKey) obj).id.equals(id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
