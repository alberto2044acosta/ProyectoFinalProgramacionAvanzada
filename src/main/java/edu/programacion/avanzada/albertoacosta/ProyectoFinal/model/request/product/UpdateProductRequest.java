package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.product;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.UpdateAddressCommand;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.product.UpdateProductCommand;
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

    public UpdateProductCommand toCommand() {
        return UpdateProductCommand.builder()
                .id(id)
                .description(description)
                .availableQuantity(availableQuantity)
                .price(price)
                .build();
    }

}
