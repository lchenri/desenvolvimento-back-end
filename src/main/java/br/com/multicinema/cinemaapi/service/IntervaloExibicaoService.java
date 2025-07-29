package br.com.multicinema.cinemaapi.service;

import br.com.multicinema.cinemaapi.model.entity.IntervaloExibicao;
import br.com.multicinema.cinemaapi.repository.IntervaloExibicaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class IntervaloExibicaoService {
    private IntervaloExibicaoRepository intervaloExibicaoRepository;

    public IntervaloExibicaoService(IntervaloExibicaoRepository intervaloExibicaoRepository) {
        this.intervaloExibicaoRepository = intervaloExibicaoRepository;
    }

    public List<IntervaloExibicao> getIntervalosExibicao() {
        return intervaloExibicaoRepository.findAll();
    }

    public Optional<IntervaloExibicao> getIntervaloExibicaoById(Long id) {
        return intervaloExibicaoRepository.findById(id);
    }

    @Transactional
    public IntervaloExibicao salvar(IntervaloExibicao intervaloExibicao) {
        return intervaloExibicaoRepository.save(intervaloExibicao);
    }

    @Transactional
    public void excluir(IntervaloExibicao intervaloExibicao) {
        intervaloExibicaoRepository.delete(intervaloExibicao);
    }
}
