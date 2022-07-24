package edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.product;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.product.GetProductResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.command.Command;
import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class GetAllProductCommand extends Command<GetProductResponse> {

}

