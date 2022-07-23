package edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.product;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.product.DeleteProductResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.Command;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeleteProductCommand extends Command<DeleteProductResponse> {

    private Long id;
}

