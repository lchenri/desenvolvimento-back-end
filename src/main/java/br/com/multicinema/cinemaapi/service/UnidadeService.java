package br.com.multicinema.cinemaapi.service;

import br.com.multicinema.cinemaapi.model.entity.Unidade;
import br.com.multicinema.cinemaapi.repository.UnidadeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadeService {
    private UnidadeRepository unidadeRepository;

    public UnidadeService(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    public List<Unidade> getUnidades() {
        return unidadeRepository.findAll();
    }

    public Optional<Unidade> getUnidadeById(Long id) {
        return unidadeRepository.findById(id);
    }

    @Transactional
    public Unidade salvar(Unidade unidade) {
        return unidadeRepository.save(unidade);
    }

    @Transactional
    public void excluir(Unidade unidade) {
        unidadeRepository.delete(unidade);
    }
}
