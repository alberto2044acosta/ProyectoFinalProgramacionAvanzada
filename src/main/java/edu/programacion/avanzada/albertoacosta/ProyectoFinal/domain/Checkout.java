package edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.dto.CheckoutDTO;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.dto.OrderDTO;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "checkouts")
public class Checkout {

    @Id
    private UUID id;

    @OneToOne
    private Address address;

    @OneToOne
    private PaymentMethod paymentMethod;

    @OneToMany
    private List<CheckoutProduct> productsToBuy;

    public CheckoutDTO toDTO() {
        return CheckoutDTO.builder()
                .id(id)
                .address(address == null ? null : address.toDTO())
                .paymentMethod(paymentMethod == null ? null : paymentMethod.toDTO())
                .productsToBuy(productsToBuy == null ? new ArrayList<>() : productsToBuy.stream().map(CheckoutProduct::toDTO).collect(Collectors.toList()))
                .build();
    }
}
