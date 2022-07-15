package edu.programacion.avanzada.albertoacosta.ProyectoFinal.controllers;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.product.CreateProductRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.product.DeleteProductRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.product.UpdateProductRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.CreateProductResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.DeleteProductResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.GetProductResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.UpdateProductResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<GetProductResponse> get() {
        return ResponseEntity.ok(GetProductResponse.builder()
                        .products(productService.getAll())
                .build());
    }

    @PostMapping
    public ResponseEntity<CreateProductResponse> create(@RequestBody CreateProductRequest createProductRequest) {
        return ResponseEntity.ok(CreateProductResponse.builder()
                .product(productService.create(createProductRequest))
                .build());
    }

    @PutMapping
    public ResponseEntity<UpdateProductResponse> update(@RequestBody UpdateProductRequest updateProductRequest) {
        return ResponseEntity.ok(UpdateProductResponse.builder()
                .product(productService.update(updateProductRequest))
                .build());
    }

    @DeleteMapping
    public ResponseEntity<DeleteProductResponse> delete(@RequestBody DeleteProductRequest deleteEmployeeRequest) {
        productService.delete(deleteEmployeeRequest);
        return ResponseEntity.ok(DeleteProductResponse.builder().build());
    }
}
