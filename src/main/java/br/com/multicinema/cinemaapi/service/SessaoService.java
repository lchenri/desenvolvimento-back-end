package br.com.multicinema.cinemaapi.service;

import br.com.multicinema.cinemaapi.model.entity.Sessao;
import br.com.multicinema.cinemaapi.repository.SessaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SessaoService {
    private SessaoRepository sessaoRepository;

    public SessaoService(SessaoRepository sessaoRepository) {
        this.sessaoRepository = sessaoRepository;
    }

    public List<Sessao> getSessoes() {
        return sessaoRepository.findAll();
    }

    public Optional<Sessao> getSessaoById(Long id) {
        return sessaoRepository.findById(id);
    }

    @Transactional
    public Sessao salvar(Sessao sessao) {
        return sessaoRepository.save(sessao);
    }

    @Transactional
    public void excluir(Sessao sessao) {
        sessaoRepository.delete(sessao);
    }
}
