package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.UnidadeDTO;
import br.com.multicinema.cinemaapi.model.entity.Unidade;
import br.com.multicinema.cinemaapi.service.UnidadeService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/unidades")
public class UnidadeController {

    private final UnidadeService unidadeService;

    public UnidadeController(UnidadeService unidadeService) {
        this.unidadeService = unidadeService;
    }

    @GetMapping()
    public ResponseEntity get() {
        var unidades = unidadeService.getUnidades();
        return ResponseEntity.ok(unidades.stream().map(UnidadeDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        var unidade = unidadeService.getUnidadeById(id);
        if (unidade.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(unidade.map(UnidadeDTO::create));
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody UnidadeDTO unidadeDTO){
        try{
            Unidade unidade = converter(unidadeDTO);
            unidade = unidadeService.salvar(unidade);
            return new ResponseEntity(unidade, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar a unidade: " + e.getMessage());
        }
    }

    private Unidade converter(UnidadeDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Unidade unidade = modelMapper.map(dto, Unidade.class);
        return unidade;
    }
}
