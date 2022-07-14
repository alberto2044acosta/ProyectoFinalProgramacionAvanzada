package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ProductDTO {

    private Long id;

    private String name;
    private String description;
    private long availableQuantity;
    private BigDecimal price;
}
