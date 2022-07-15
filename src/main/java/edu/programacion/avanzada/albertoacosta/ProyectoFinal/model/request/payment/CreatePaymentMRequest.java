package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.payment;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain.PaymentMethod;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreatePaymentMRequest {

    private String name;
    private String description;

    public PaymentMethod toPaymentMethod() {
        return PaymentMethod.builder()
                .name(name)
                .description(description)
                .build();
    }
}
