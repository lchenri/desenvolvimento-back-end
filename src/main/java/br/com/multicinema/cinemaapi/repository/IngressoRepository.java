package br.com.multicinema.cinemaapi.repository;

import br.com.multicinema.cinemaapi.model.entity.Ingresso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngressoRepository extends JpaRepository<Ingresso, Long> {
}
