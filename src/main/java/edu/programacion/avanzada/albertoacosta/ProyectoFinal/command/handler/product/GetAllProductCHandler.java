package edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.handler.product;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.GetAllAddressCommand;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.product.GetAllProductCommand;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain.Address;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain.Product;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.dto.AddressDTO;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.dto.ProductDTO;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address.GetAddressResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.product.GetProductResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.repositories.AddressRepository;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@CommandEvent(command = GetAllProductCommand.class)
@Slf4j
public class GetAllProductCHandler implements CommandHandler<GetProductResponse, GetAllProductCommand> {

    private final ProductRepository productRepository;

    @Override
    public GetProductResponse handle(GetAllProductCommand getAllProductCommand) {
        log.debug("Get Products {}", getAllProductCommand.toString());
        List<ProductDTO> productDTOS = productRepository.findAll()
                .stream()
                .map(Product::toDTO)
                .collect(Collectors.toList());
        return GetProductResponse.builder()
                .products(productDTOS)
                .build();
    }
}

