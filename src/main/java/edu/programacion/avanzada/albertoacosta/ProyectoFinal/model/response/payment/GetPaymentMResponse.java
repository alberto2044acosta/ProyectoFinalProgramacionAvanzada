package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.payment;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.dto.PaymentMethodDTO;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.dto.ProductDTO;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetPaymentMResponse {

    private List<PaymentMethodDTO> paymentMethods;
}
