package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.checkout;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.dto.CheckoutDTO;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.dto.PaymentMethodDTO;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetCheckoutResponse {

    private List<CheckoutDTO> checkouts;
}
