package br.com.multicinema.cinemaapi.service;

import br.com.multicinema.cinemaapi.model.entity.CupomDesconto;
import br.com.multicinema.cinemaapi.model.entity.Fileira;
import br.com.multicinema.cinemaapi.repository.FileiraRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FileiraService {
    private FileiraRepository fileiraRepository;

    public FileiraService(FileiraRepository fileiraRepository) {
        this.fileiraRepository = fileiraRepository;
    }

    public List<Fileira> getFileiras() {
        return fileiraRepository.findAll();
    }

    public Optional<Fileira> getFileiraById(Long id) {
        return fileiraRepository.findById(id);
    }

    @Transactional
    public Fileira salvar(Fileira fileira) {
        return fileiraRepository.save(fileira);
    }

    @Transactional
    public void excluir(Fileira fileira) {
        fileiraRepository.delete(fileira);
    }
}
