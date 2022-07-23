package edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.handler;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.UpdateAddressCommand;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain.Address;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address.UpdateAddressResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@CommandEvent(command = UpdateAddressCommand.class)
@Slf4j
public class UpdateAddressCommandHandler implements CommandHandler<UpdateAddressResponse, UpdateAddressCommand> {

    private final AddressRepository addressRepository;

    @Override
    public UpdateAddressResponse handle(UpdateAddressCommand updateAddressCommand) {
        Address address = addressRepository.findById(updateAddressCommand.getId()).orElseThrow();
        address.setDescription(updateAddressCommand.getDescription());
        address.setName(updateAddressCommand.getName());
        addressRepository.save(address);
        log.info("Address {} update", updateAddressCommand.getId());
        return UpdateAddressResponse.builder().address(address.toDTO()).build();
    }
}

