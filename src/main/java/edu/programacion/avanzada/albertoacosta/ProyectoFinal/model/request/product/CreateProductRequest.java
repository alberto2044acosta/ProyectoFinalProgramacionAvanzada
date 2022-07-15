package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.product;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain.Product;
import lombok.*;

import javax.persistence.Column;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateProductRequest {

    private String name;
    private String description;
    private long availableQuantity;
    private BigDecimal price;

    public Product toProduct() {
        return Product.builder()
                .name(name)
                .description(description)
                .availableQuantity(availableQuantity)
                .price(price)
                .build();
    }
}
