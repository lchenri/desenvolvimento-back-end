package br.com.multicinema.cinemaapi.repository;

import br.com.multicinema.cinemaapi.model.entity.Fileira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileiraRepository extends JpaRepository<Fileira, Long> {
}
