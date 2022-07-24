package edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.saga.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class SagaPayLoad<T> {

    private final Map<SagaPayLoadKey<?>, Object> properties = new HashMap<>();
    @Getter
    @Setter
    private T result;

    public <N> N getProperty(SagaPayLoadKey<N> sagaPayLoadKey) {
        return sagaPayLoadKey.getType().cast(properties.get(sagaPayLoadKey));
    }

    public <N> void addProperty(SagaPayLoadKey<N> sagaPayLoadKey, N value) {
        properties.put(sagaPayLoadKey, value);
    }

    public <N> boolean hasProperty(SagaPayLoadKey<N> sagaPayLoadKey) {
        return properties.containsKey(sagaPayLoadKey);
    }
}
