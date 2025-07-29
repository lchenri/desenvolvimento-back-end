package br.com.multicinema.cinemaapi.service;

import br.com.multicinema.cinemaapi.model.entity.Cadeira;
import br.com.multicinema.cinemaapi.repository.CadeiraRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CadeiraService {
    private CadeiraRepository cadeiraRepository;

    public CadeiraService(CadeiraRepository cadeiraRepository) {
        this.cadeiraRepository = cadeiraRepository;
    }

    public List<Cadeira> getCadeiras() {
        return cadeiraRepository.findAll();
    }

    public Optional<Cadeira> getCadeiraById(Long id) {
        return cadeiraRepository.findById(id);
    }

    @Transactional
    public Cadeira salvar(Cadeira cadeira) {
        return cadeiraRepository.save(cadeira);
    }

    @Transactional
    public void excluir(Cadeira cadeira) {
        cadeiraRepository.delete(cadeira);
    }
}
