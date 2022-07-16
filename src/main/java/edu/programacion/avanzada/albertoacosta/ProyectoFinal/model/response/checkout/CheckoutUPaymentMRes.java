package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.checkout;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.dto.CheckoutDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CheckoutUPaymentMRes {

    private CheckoutDTO checkout;
}
