package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.dto.AddressDTO;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.dto.PaymentMethodDTO;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetAddressResponse {

    private List<AddressDTO> addresses;
}
