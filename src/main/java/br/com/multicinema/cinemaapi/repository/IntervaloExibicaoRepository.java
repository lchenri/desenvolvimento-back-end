package br.com.multicinema.cinemaapi.repository;

import br.com.multicinema.cinemaapi.model.entity.IntervaloExibicao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntervaloExibicaoRepository extends JpaRepository<IntervaloExibicao, Long> {
    // Custom query methods can be added here if needed
}
