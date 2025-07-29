package br.com.multicinema.cinemaapi.service;

import br.com.multicinema.cinemaapi.model.entity.TipoSessao;
import br.com.multicinema.cinemaapi.repository.TipoSessaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TipoSessaoService {
    private TipoSessaoRepository tipoSessaoRepository;

    public TipoSessaoService(TipoSessaoRepository tipoSessaoRepository) {
        this.tipoSessaoRepository = tipoSessaoRepository;
    }

    public List<TipoSessao> getTipoSessao() {
        return tipoSessaoRepository.findAll();
    }

    public Optional<TipoSessao> getTipoSessaoById(Long id) {
        return tipoSessaoRepository.findById(id);
    }

    @Transactional
    public TipoSessao salvar(TipoSessao tipoSessao) {
        return tipoSessaoRepository.save(tipoSessao);
    }

    @Transactional
    public void excluir(TipoSessao tipoSessao) {
        tipoSessaoRepository.delete(tipoSessao);
    }
}
