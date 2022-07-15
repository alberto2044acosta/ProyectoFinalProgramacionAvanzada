package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.address;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateAddressRequest {

    private Long id;
    private String description;

}
