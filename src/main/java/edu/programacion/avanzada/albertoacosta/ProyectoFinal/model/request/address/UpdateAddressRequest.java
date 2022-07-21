package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.address;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.DeleteAddressCommand;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.UpdateAddressCommand;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateAddressRequest {

    private Long id;
    private String description;

    public UpdateAddressCommand toCommand() {
        return UpdateAddressCommand.builder()
                .id(id)
                .description(description)
                .build();
    }

}
