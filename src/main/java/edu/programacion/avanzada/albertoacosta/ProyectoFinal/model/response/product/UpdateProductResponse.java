package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.product;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.dto.ProductDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateProductResponse {

    private ProductDTO product;
}
