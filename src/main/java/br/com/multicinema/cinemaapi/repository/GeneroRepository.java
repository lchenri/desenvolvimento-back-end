package br.com.multicinema.cinemaapi.repository;

import br.com.multicinema.cinemaapi.model.entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
}
