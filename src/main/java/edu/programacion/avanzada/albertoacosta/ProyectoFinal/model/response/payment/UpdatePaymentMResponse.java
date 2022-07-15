package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.payment;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.dto.PaymentMethodDTO;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.dto.ProductDTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdatePaymentMResponse {

    private PaymentMethodDTO paymentMethod;
}
