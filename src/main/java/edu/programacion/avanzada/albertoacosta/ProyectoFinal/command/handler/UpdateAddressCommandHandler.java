package edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.handler;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.CreateAddressCommand;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.UpdateAddressCommand;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain.Address;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address.CreateAddressResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address.UpdateAddressResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@CommandEvent(command = UpdateAddressCommand.class)
public class UpdateAddressCommandHandler implements CommandHandler<UpdateAddressResponse, UpdateAddressCommand> {

    private final AddressRepository addressRepository;

    @Override
    public UpdateAddressResponse handle(UpdateAddressCommand updateAddressCommand) {
        Address address = addressRepository.findById(updateAddressCommand.getId()).orElseThrow();
        address.setDescription(updateAddressCommand.getDescription());
        addressRepository.save(address);
        return UpdateAddressResponse.builder()
                .address(address.toDTO())
                .build();
    }
}

