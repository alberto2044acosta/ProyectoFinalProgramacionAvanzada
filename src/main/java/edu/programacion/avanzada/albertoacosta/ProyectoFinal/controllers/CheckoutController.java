package edu.programacion.avanzada.albertoacosta.ProyectoFinal.controllers;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.address.CreateAddressRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.address.DeleteAddressRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.address.UpdateAddressRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address.CreateAddressResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address.DeleteAddressResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address.GetAddressResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address.UpdateAddressResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.checkout.GetCheckoutResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.services.AddressService;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.services.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @GetMapping
    public ResponseEntity<GetCheckoutResponse> get() {
        return ResponseEntity.ok(GetCheckoutResponse.builder()
                .checkouts(checkoutService.getAll())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCheckoutResponse> get(@RequestParam UUID id) {
        return ResponseEntity.ok(GetCheckoutResponse.builder()
                .checkouts(List.of(checkoutService.get(id)))
                .build());
    }

}
