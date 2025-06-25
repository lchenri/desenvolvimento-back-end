package br.com.multicinema.cinemaapi.service;

import br.com.multicinema.cinemaapi.model.entity.Genero;
import br.com.multicinema.cinemaapi.repository.GeneroRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroService {
    private GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public List<Genero> getGeneros() {
        return generoRepository.findAll();
    }

    public Optional<Genero> getGeneroById(Long id) {
        return generoRepository.findById(id);
    }

    @Transactional
    public Genero salvar(Genero genero) {
        return generoRepository.save(genero);
    }
}
