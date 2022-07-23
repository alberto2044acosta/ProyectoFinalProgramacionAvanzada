package edu.programacion.avanzada.albertoacosta.ProyectoFinal.command;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address.UpdateAddressResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.command.Command;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateAddressCommand extends Command<UpdateAddressResponse> {

    private Long id;
    private String name;
    private String description;
}

