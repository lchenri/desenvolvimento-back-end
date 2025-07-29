package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.GeneroDTO;
import br.com.multicinema.cinemaapi.model.entity.Genero;
import br.com.multicinema.cinemaapi.service.GeneroService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/generos")
public class GeneroController {

    private final GeneroService generoService;

    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @GetMapping()
    public ResponseEntity get(){
        var generos = generoService.getGeneros();
        return ResponseEntity.ok(generos.stream().map(GeneroDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        var genero = generoService.getGeneroById(id);
        if (genero.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(genero.map(GeneroDTO::create));
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody GeneroDTO generoDTO){
        try{
            Genero genero = converter(generoDTO);
            genero = generoService.salvar(genero);
            return new ResponseEntity(genero, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar o gênero: " + e.getMessage());
        }
    }

    private Genero converter(GeneroDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Genero genero = modelMapper.map(dto, Genero.class);
        return genero;
    }
}
