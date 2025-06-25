package br.com.multicinema.cinemaapi.service;

import br.com.multicinema.cinemaapi.model.entity.Imagem;
import br.com.multicinema.cinemaapi.repository.ImagemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ImagemService {
    private ImagemRepository imagemRepository;

    public ImagemService(ImagemRepository imagemRepository) {
        this.imagemRepository = imagemRepository;
    }

    public List<Imagem> getImagens(){
        return imagemRepository.findAll();
    }

    public Optional<Imagem> getImagemById(Long id){
        return imagemRepository.findById(id);
    }

    @Transactional
    public Imagem salvar(Imagem imagem){
        return imagemRepository.save(imagem);
    }
}
