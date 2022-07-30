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
    public ResponseEntity<GetAddressResponse> getAll(@RequestParam(required =false, defaultValue = "10")  Integer pageSize,
                                                     @RequestParam(required = false, defaultValue = "0") Integer page,
                                                     @RequestParam(required = false, defaultValue = "") String name) {
        return ResponseEntity.ok(addressService.getAll(pageSize, page, name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetAddressResponse> get(@RequestParam(required = false, defaultValue = "0") Long id) {
        return ResponseEntity.ok(addressService.get(id));
    }

    @PostMapping
    public ResponseEntity<CreateAddressResponse> create(@RequestBody(required =false) CreateAddressRequest createAddressRequest) {
        return ResponseEntity.ok(addressService.create(createAddressRequest));
    }

    @PutMapping
    public ResponseEntity<UpdateAddressResponse> update(@RequestBody(required =false) UpdateAddressRequest updateAddressRequest) {
        return ResponseEntity.ok(addressService.update(updateAddressRequest));
    }

    @DeleteMapping
    public ResponseEntity<DeleteAddressResponse> delete(@RequestBody(required =false) DeleteAddressRequest deleteAddressRequest) {
        return ResponseEntity.ok(addressService.delete(deleteAddressRequest));
    }
}
