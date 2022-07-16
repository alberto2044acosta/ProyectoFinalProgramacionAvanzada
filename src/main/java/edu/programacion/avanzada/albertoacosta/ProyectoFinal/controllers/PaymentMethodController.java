package edu.programacion.avanzada.albertoacosta.ProyectoFinal.controllers;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.payment.CreatePaymentMRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.payment.DeletePaymentMRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.payment.UpdatePaymentMRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address.GetAddressResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.payment.CreatePaymentMResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.payment.DeletePaymentMResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.payment.GetPaymentMResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.payment.UpdatePaymentMResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.services.PaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payment/methods")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    @GetMapping
    public ResponseEntity<GetPaymentMResponse> get() {
        return ResponseEntity.ok(GetPaymentMResponse.builder()
                .paymentMethods(paymentMethodService.getAll())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPaymentMResponse> get(@RequestParam Long id) {
        return ResponseEntity.ok(GetPaymentMResponse.builder()
                .paymentMethods(List.of(paymentMethodService.get(id)))
                .build());
    }

    @PostMapping
    public ResponseEntity<CreatePaymentMResponse> create(@RequestBody CreatePaymentMRequest createPaymentMRequest) {
        return ResponseEntity.ok(CreatePaymentMResponse.builder()
                .paymentMethod(paymentMethodService.create(createPaymentMRequest))
                .build());
    }

    @PutMapping
    public ResponseEntity<UpdatePaymentMResponse> update(@RequestBody UpdatePaymentMRequest updatePaymentMRequest) {
        return ResponseEntity.ok(UpdatePaymentMResponse.builder()
                .paymentMethod(paymentMethodService.update(updatePaymentMRequest))
                .build());
    }

    @DeleteMapping
    public ResponseEntity<DeletePaymentMResponse> delete(@RequestBody DeletePaymentMRequest deletePaymentMRequest) {
        paymentMethodService.delete(deletePaymentMRequest);
        return ResponseEntity.ok(DeletePaymentMResponse.builder().build());
    }
}
