package edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.address;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain.Address;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address.CreateAddressResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.command.Command;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateAddressCommand extends Command<CreateAddressResponse> {

    private String name;
    private String description;

    public Address toPaymentMethod() {
        return Address.builder()
                .name(name)
                .description(description)
                .build();
    }
}

