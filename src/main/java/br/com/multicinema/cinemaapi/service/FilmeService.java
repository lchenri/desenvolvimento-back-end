package br.com.multicinema.cinemaapi.service;

import br.com.multicinema.cinemaapi.model.entity.Filme;
import br.com.multicinema.cinemaapi.repository.FilmeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {
    private FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public List<Filme> getFilmes() {
        return filmeRepository.findAll();
    }

    public Optional<Filme> getFilmeById(Long id) {
        return filmeRepository.findById(id);
    }

    @Transactional
    public Filme salvar(Filme filme) {
        return filmeRepository.save(filme);
    }
}
