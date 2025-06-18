package br.com.multicinema.cinemaapi.repository;

import br.com.multicinema.cinemaapi.model.entity.Imagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagemRepository extends JpaRepository<Imagem, Long> {
    // This interface extends JpaRepository, which provides CRUD operations for the Imagem entity.
    // Additional query methods can be defined here if needed.
}
