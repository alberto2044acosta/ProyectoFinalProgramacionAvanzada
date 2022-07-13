package edu.programacion.avanzada.albertoacosta.ProyectoFinal.repositories;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain.Address;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Long, Product> {
}
