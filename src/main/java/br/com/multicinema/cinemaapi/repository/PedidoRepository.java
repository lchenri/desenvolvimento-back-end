package br.com.multicinema.cinemaapi.repository;

import br.com.multicinema.cinemaapi.model.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
