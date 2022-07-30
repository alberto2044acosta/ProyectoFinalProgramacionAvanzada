package edu.programacion.avanzada.albertoacosta.ProyectoFinal.controllers;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.product.CreateProductRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.product.DeleteProductRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.product.UpdateProductRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.product.CreateProductResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.product.DeleteProductResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.product.GetProductResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.product.UpdateProductResponse;
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
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetProductResponse> get(@RequestParam(required =false, defaultValue = "") Long id) {
        return ResponseEntity.ok(productService.get(id));
    }

    @PostMapping
    public ResponseEntity<CreateProductResponse> create(@RequestBody(required =false) CreateProductRequest createProductRequest) {
        return ResponseEntity.ok(productService.create(createProductRequest));
    }

    @PutMapping
    public ResponseEntity<UpdateProductResponse> update(@RequestBody(required =false) UpdateProductRequest updateProductRequest) {
        return ResponseEntity.ok(productService.update(updateProductRequest));
    }

    @DeleteMapping
    public ResponseEntity<DeleteProductResponse> delete(@RequestBody(required =false) DeleteProductRequest deleteEmployeeRequest) {
        return ResponseEntity.ok(productService.delete(deleteEmployeeRequest));
    }
}
