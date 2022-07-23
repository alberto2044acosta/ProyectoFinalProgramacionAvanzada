package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.address;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.address.CreateAddressCommand;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateAddressRequest {

    private String name;
    private String description;

    public CreateAddressCommand toCommand() {
        return CreateAddressCommand.builder()
                .name(name)
                .description(description)
                .build();
    }
}
