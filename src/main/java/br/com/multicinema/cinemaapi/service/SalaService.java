package br.com.multicinema.cinemaapi.service;

import br.com.multicinema.cinemaapi.model.entity.Sala;
import br.com.multicinema.cinemaapi.repository.SalaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {
    private SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public List<Sala> getSalas() {
        return salaRepository.findAll();
    }

    public Optional<Sala> getSalaById(Long id) {
        return salaRepository.findById(id);
    }

    @Transactional
    public Sala salvar(Sala sala) {
        return salaRepository.save(sala);
    }

    @Transactional
    public void excluir(Sala sala) {
        salaRepository.delete(sala);
    }
}
