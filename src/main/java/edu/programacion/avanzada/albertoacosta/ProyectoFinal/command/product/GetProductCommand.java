package edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.product;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.product.GetProductResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.Command;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetProductCommand extends Command<GetProductResponse> {

    private Long id;
}

