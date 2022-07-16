package edu.programacion.avanzada.albertoacosta.ProyectoFinal.services;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain.*;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.dto.CheckoutDTO;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.checkout.CheckoutAddProductReq;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.checkout.CheckoutUAddressReq;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.checkout.CheckoutUPaymentMReq;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CheckoutService {

    private final CheckoutRepository checkoutRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;

    public List<CheckoutDTO> getAll() {
        return checkoutRepository.findAll().stream().map(Checkout::toDTO).collect(Collectors.toList());
    }

    public CheckoutDTO get(UUID id) {
        return checkoutRepository.findById(id).orElseThrow().toDTO();
    }

    public CheckoutDTO updatePaymentMethod(CheckoutUPaymentMReq checkoutUPaymentMReq) {
        Checkout checkout = checkoutRepository.findById(checkoutUPaymentMReq.getId()).orElseThrow();
        PaymentMethod paymentMethod = paymentMethodRepository.findById(checkoutUPaymentMReq.getPaymentMethod()).orElseThrow();
        checkout.setPaymentMethod(paymentMethod);
        checkoutRepository.save(checkout);
        return checkout.toDTO();
    }

    public CheckoutDTO updateAddress(CheckoutUAddressReq checkoutUAddressReq) {
        Checkout checkout = checkoutRepository.findById(checkoutUAddressReq.getId()).orElseThrow();
        Address address = addressRepository.findById(checkoutUAddressReq.getAddress()).orElseThrow();
        checkout.setAddress(address);
        checkoutRepository.save(checkout);
        return checkout.toDTO();
    }

    public CheckoutDTO addProducts(CheckoutAddProductReq addProductCheckoutReq) {
        Checkout checkout = checkoutRepository.findById(addProductCheckoutReq.getId()).orElseThrow();
        Product product = productRepository.findById(addProductCheckoutReq.getProduct()).orElseThrow();
        List<CheckoutProduct> productsToBuy = checkout.getProductsToBuy();
        if(productsToBuy == null){
            productsToBuy = new ArrayList<>();
        }
        //TODO si el producto no existe lo agrego
        //TODO si el producto existe lo actualizo
        checkout.setProductsToBuy(productsToBuy);
        checkoutRepository.save(checkout);
        return checkout.toDTO();
    }
}
