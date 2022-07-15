package edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
}