package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.address;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.DeleteAddressCommand;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain.Address;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeleteAddressRequest {

    private Long id;

    public DeleteAddressCommand toCommand() {
        return DeleteAddressCommand.builder()
                .id(id)
                .build();
    }
}
