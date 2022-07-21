package edu.programacion.avanzada.albertoacosta.ProyectoFinal.command;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address.GetAddressResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.command.Command;
import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class GetAllAddressCommand extends Command<GetAddressResponse> {

}

