package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain.Product;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeleteProductRequest {

    private Long id;
}
