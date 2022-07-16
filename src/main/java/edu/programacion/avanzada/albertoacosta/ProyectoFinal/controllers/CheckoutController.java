package edu.programacion.avanzada.albertoacosta.ProyectoFinal.controllers;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.address.CreateAddressRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.address.DeleteAddressRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.address.UpdateAddressRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.checkout.CheckoutAddProductReq;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.checkout.CheckoutUAddressReq;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.checkout.CheckoutUPaymentMReq;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.payment.CreatePaymentMRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address.CreateAddressResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address.DeleteAddressResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address.GetAddressResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address.UpdateAddressResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.checkout.CheckoutAddProductRes;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.checkout.CheckoutUAddressRes;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.checkout.CheckoutUPaymentMRes;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.checkout.GetCheckoutResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.payment.CreatePaymentMResponse;
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

    @PostMapping("/update/address")
    public ResponseEntity<CheckoutUAddressRes> uptadeAddress(@RequestBody CheckoutUAddressReq checkoutUAddressReq) {
        return ResponseEntity.ok(CheckoutUAddressRes.builder()
                .checkout(checkoutService.updateAddress(checkoutUAddressReq))
                .build());
    }

    @PostMapping("/update/payment/method")
    public ResponseEntity<CheckoutUPaymentMRes> updatePaymentMethod(@RequestBody CheckoutUPaymentMReq checkoutUPaymentMReq) {
        return ResponseEntity.ok(CheckoutUPaymentMRes.builder()
                .checkout(checkoutService.updatePaymentMethod(checkoutUPaymentMReq))
                .build());
    }

    @PostMapping("/add/product")
    public ResponseEntity<CheckoutAddProductRes> addProduct(@RequestBody CheckoutAddProductReq checkoutAddProductReq) {
        return ResponseEntity.ok(CheckoutAddProductRes.builder()
                .checkout(checkoutService.addProducts(checkoutAddProductReq))
                .build());
    }

}
