package edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.handler.address;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.address.DeleteAddressCommand;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address.DeleteAddressResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@CommandEvent(command = DeleteAddressCommand.class)
@Slf4j
public class DeleteAddressCHandler implements CommandHandler<DeleteAddressResponse, DeleteAddressCommand> {

    private final AddressRepository addressRepository;

    @Override
    public DeleteAddressResponse handle(DeleteAddressCommand deleteAddressCommand) {
        addressRepository.deleteById(deleteAddressCommand.getId());
        log.info("Address {} deleted", deleteAddressCommand.getId());
        return DeleteAddressResponse.builder()
                .build();
    }
}

