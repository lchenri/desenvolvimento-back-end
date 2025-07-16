package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.ImagemDTO;
import br.com.multicinema.cinemaapi.service.ImagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/imagens")
public class ImagemController {

    private final ImagemService imagemService;

    public ImagemController(ImagemService imagemService) {
        this.imagemService = imagemService;
    }

    @GetMapping()
    public ResponseEntity get(){
        var imagens = imagemService.getImagens();
        return ResponseEntity.ok(imagens.stream().map(ImagemDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        var imagem = imagemService.getImagemById(id);
        if (imagem.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(imagem.map(ImagemDTO::create));
    }
}
