package edu.programacion.avanzada.albertoacosta.ProyectoFinal.services;

import edu.programacion.avanzada.albertoacosta.ProyectoFinal.domain.Order;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.model.dto.OrderDTO;
import edu.programacion.avanzada.albertoacosta.ProyectoFinal.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream().map(Order::toDTO).collect(Collectors.toList());
    }
}
