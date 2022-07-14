package edu.programacion.avanzada.albertoacosta.ProyectoFinal.repositories;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain.Order;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
}
