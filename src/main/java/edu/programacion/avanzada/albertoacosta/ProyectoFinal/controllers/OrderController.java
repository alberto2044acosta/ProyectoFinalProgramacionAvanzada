package edu.programacion.avanzada.albertoacosta.ProyectoFinal.controllers;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.order.GetOrderResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<GetOrderResponse> get() {
        return ResponseEntity.ok(GetOrderResponse.builder()
                .orders(orderService.getAll())
                .build());
    }

}
