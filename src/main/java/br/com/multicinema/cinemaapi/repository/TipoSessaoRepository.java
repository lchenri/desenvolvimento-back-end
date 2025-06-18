package br.com.multicinema.cinemaapi.repository;

import br.com.multicinema.cinemaapi.model.entity.TipoSessao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoSessaoRepository extends JpaRepository<TipoSessao, Long> {
}
