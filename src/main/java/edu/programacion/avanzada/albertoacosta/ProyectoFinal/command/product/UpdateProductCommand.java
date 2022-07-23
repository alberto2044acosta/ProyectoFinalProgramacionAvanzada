package edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.product;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.product.UpdateProductResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.command.Command;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateProductCommand extends Command<UpdateProductResponse> {

    private Long id;
    private String description;
    private long availableQuantity;
    private BigDecimal price;
}

