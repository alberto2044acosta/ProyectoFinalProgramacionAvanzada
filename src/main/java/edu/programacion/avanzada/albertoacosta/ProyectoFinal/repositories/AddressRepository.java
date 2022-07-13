package edu.programacion.avanzada.albertoacosta.ProyectoFinal.repositories;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Long, Address> {
}
