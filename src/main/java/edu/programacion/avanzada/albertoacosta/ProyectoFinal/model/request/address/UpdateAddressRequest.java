package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.address;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.UpdateAddressCommand;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateAddressRequest {

    private Long id;
    private String name;
    private String description;

    public UpdateAddressCommand toCommand() {
        return UpdateAddressCommand.builder()
                .id(id)
                .name(name)
                .description(description)
                .build();
    }

}
