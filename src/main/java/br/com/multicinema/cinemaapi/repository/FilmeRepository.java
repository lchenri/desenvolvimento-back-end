package br.com.multicinema.cinemaapi.repository;

import br.com.multicinema.cinemaapi.model.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

    // You can add custom query methods here if needed
    // For example:
    // List<Filme> findByTituloContaining(String titulo);
}
