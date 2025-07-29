package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.SalaDTO;
import br.com.multicinema.cinemaapi.model.entity.Sala;
import br.com.multicinema.cinemaapi.service.SalaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/salas")
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping()
    public ResponseEntity get(){
        var salas = salaService.getSalas();
        return ResponseEntity.ok(salas.stream().map(SalaDTO::create).collect(java.util.stream.Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        var sala = salaService.getSalaById(id);
        if (sala.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sala.map(SalaDTO::create));
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody SalaDTO salaDTO){
        try{
            Sala sala = converter(salaDTO);
            sala = salaService.salvar(sala);
            return new ResponseEntity(sala, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar a sala: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody SalaDTO salaDTO) {
        if (!salaService.getSalaById(id).isPresent()) {
            return new ResponseEntity("Sala não encontrada", HttpStatus.NOT_FOUND);
        }
        try {
            Sala sala = converter(salaDTO);
            sala.setId(id);
            salaService.salvar(sala);
            return ResponseEntity.ok(sala);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar a sala: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Optional<Sala> sala = salaService.getSalaById(id);
        if (!sala.isPresent()) {
            return new ResponseEntity("Sala não encontrada", HttpStatus.NOT_FOUND);
        }
        try {
            salaService.excluir(sala.get());
            return new ResponseEntity("Sala excluída com sucesso", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao excluir a sala: " + e.getMessage());
        }
    }

    private Sala converter(SalaDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Sala sala = modelMapper.map(dto, Sala.class);
        return sala;
    }
}
