package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.ImagemDTO;
import br.com.multicinema.cinemaapi.model.entity.Imagem;
import br.com.multicinema.cinemaapi.service.ImagemService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity post(@RequestBody ImagemDTO imagemDTO){
        try{
            Imagem imagem = converter(imagemDTO);
            imagem = imagemService.salvar(imagem);
            return new ResponseEntity(imagem, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar a imagem: " + e.getMessage());
        }
    }

    private Imagem converter(ImagemDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Imagem imagem = modelMapper.map(dto, Imagem.class);
        return imagem;
    }
}
