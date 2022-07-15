package edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AddressDTO {

    private Long id;
    private String name;
    private String description;
}
