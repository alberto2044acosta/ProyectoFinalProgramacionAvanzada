package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain.Product;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateProductRequest {

    private Long id;
    private String description;
    private long availableQuantity;
    private BigDecimal price;

}
