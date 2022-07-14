package edu.programacion.avanzada.albertoacosta.ProyectoFinal.services;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain.Product;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.dto.ProductDTO;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.CreateProductRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.DeleteProductRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.UpdateProductRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDTO> getAll() {
        return productRepository.findAll().stream().map(Product::toDTO).collect(Collectors.toList());
    }

    public ProductDTO create(CreateProductRequest createProductRequest) {
        Product product = productRepository.save(createProductRequest.toProduct());
        return product.toDTO();
    }

    public ProductDTO update(UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(updateProductRequest.getId()).orElseThrow();
        product.applyChanges(updateProductRequest);
        productRepository.save(product);
        return product.toDTO();
    }

    public void delete(DeleteProductRequest deleteProductRequest) {
        productRepository.deleteById(deleteProductRequest.getId());
    }
}
