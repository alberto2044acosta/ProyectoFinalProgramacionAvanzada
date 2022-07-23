package edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.handler.product;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.command.product.DeleteProductCommand;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.product.DeleteProductResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@CommandEvent(command = DeleteProductCommand.class)
@Slf4j
public class DeleteProductCHandler implements CommandHandler<DeleteProductResponse, DeleteProductCommand> {

    private final ProductRepository productRepository;

    @Override
    public DeleteProductResponse handle(DeleteProductCommand deleteProductCommand) {
        productRepository.deleteById(deleteProductCommand.getId());
        log.info("Product {} deleted", deleteProductCommand.getId());
        return DeleteProductResponse.builder()
                .build();
    }
}

