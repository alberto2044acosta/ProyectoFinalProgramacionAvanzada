package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.address;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain.Address;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain.PaymentMethod;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateAddressRequest {

    private String name;
    private String description;

    public Address toPaymentMethod() {
        return Address.builder()
                .name(name)
                .description(description)
                .build();
    }
}
