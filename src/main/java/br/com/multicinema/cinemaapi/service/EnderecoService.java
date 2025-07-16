package br.com.multicinema.cinemaapi.service;

import br.com.multicinema.cinemaapi.model.entity.Endereco;
import br.com.multicinema.cinemaapi.repository.EnderecoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class EnderecoService {
    private EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    public List<Endereco> getEnderecos() {
        return enderecoRepository.findAll();
    }

    public Optional<Endereco> getEnderecoById(Long id) {
        return enderecoRepository.findById(id);
    }

    @Transactional
    public Endereco save(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }
}
