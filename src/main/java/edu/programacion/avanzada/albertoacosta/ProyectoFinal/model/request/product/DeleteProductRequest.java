package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.product;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.product.DeleteProductCommand;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeleteProductRequest {

    private Long id;

    public DeleteProductCommand toCommand() {
        return DeleteProductCommand.builder()
                .id(id)
                .build();
    }
}
