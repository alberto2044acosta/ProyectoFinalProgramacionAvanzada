package edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.dto.OrderDTO;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.dto.ProductDTO;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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
@Table(name = "orders")
public class Order {

    @Id
    private UUID id;

    @OneToOne
    private Address address;

    @OneToOne
    private PaymentMethod paymentMethod;

    @OneToMany
    private List<CheckoutProduct> productsToBuy;

    @Column
    private BigDecimal total;

    @Column
    private LocalDateTime buyDateTime;

    public OrderDTO toDTO() {
        return OrderDTO.builder()
                .id(id)
                .address(address == null ? null : address.toDTO())
                .paymentMethod(paymentMethod == null ? null : paymentMethod.toDTO())
                .productsToBuy(productsToBuy == null ? new ArrayList<>() : productsToBuy.stream().map(CheckoutProduct::toDTO).collect(Collectors.toList()))
                .total(total)
                .buyDateTime(buyDateTime)
                .build();
    }
}
