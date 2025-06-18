package br.com.multicinema.cinemaapi.repository;

import br.com.multicinema.cinemaapi.model.entity.Cadeira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadeiraRepository extends JpaRepository<Cadeira, Long> {
}
