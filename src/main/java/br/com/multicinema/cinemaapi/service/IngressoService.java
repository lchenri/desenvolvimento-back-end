package br.com.multicinema.cinemaapi.service;

import br.com.multicinema.cinemaapi.model.entity.Ingresso;
import br.com.multicinema.cinemaapi.repository.IngressoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class IngressoService {
    private IngressoRepository ingressoRepository;

    public IngressoService(IngressoRepository ingressoRepository) {
        this.ingressoRepository = ingressoRepository;
    }

    public List<Ingresso> getIngressos() {
        return ingressoRepository.findAll();
    }

    public Optional<Ingresso> getIngressoById(Long id) {
        return ingressoRepository.findById(id);
    }

    @Transactional
    public Ingresso salvar(Ingresso ingresso) {
        return ingressoRepository.save(ingresso);
    }

    @Transactional
    public void excluir(Ingresso ingresso) {
        ingressoRepository.delete(ingresso);
    }
}
