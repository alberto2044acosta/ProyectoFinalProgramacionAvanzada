package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.payment;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdatePaymentMRequest {

    private Long id;
    private String description;
    private long availableQuantity;
    private BigDecimal price;

}
