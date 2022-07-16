package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.checkout;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AddProductCheckoutReq {

    private UUID id;

    private Long product;
}
