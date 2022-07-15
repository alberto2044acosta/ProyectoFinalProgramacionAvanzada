package edu.programacion.avanzada.albertoacosta.ProyectoFinal.controllers;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.address.CreateAddressRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.address.DeleteAddressRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.request.address.UpdateAddressRequest;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address.CreateAddressResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address.DeleteAddressResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address.GetAddressResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.response.address.UpdateAddressResponse;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<GetAddressResponse> get() {
        return ResponseEntity.ok(GetAddressResponse.builder()
                .addresses(addressService.getAll())
                .build());
    }

    @PostMapping
    public ResponseEntity<CreateAddressResponse> create(@RequestBody CreateAddressRequest createAddressRequest) {
        return ResponseEntity.ok(CreateAddressResponse.builder()
                .address(addressService.create(createAddressRequest))
                .build());
    }

    @PutMapping
    public ResponseEntity<UpdateAddressResponse> update(@RequestBody UpdateAddressRequest updateAddressRequest) {
        return ResponseEntity.ok(UpdateAddressResponse.builder()
                .address(addressService.update(updateAddressRequest))
                .build());
    }

    @DeleteMapping
    public ResponseEntity<DeleteAddressResponse> delete(@RequestBody DeleteAddressRequest deleteAddressRequest) {
        addressService.delete(deleteAddressRequest);
        return ResponseEntity.ok(DeleteAddressResponse.builder().build());
    }
}
