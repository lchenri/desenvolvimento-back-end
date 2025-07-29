package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.CadeiraDTO;
import br.com.multicinema.cinemaapi.model.entity.Cadeira;
import br.com.multicinema.cinemaapi.service.CadeiraService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("api/v1/cadeiras")
public class CadeiraController {

    private final CadeiraService cadeiraService;

    public CadeiraController(CadeiraService cadeiraService) {
        this.cadeiraService = cadeiraService;
    }

    @GetMapping
    public ResponseEntity get(){
        List<Cadeira> cadeiras = cadeiraService.getCadeiras();
        return ResponseEntity.ok(cadeiras.stream().map(CadeiraDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        Optional<Cadeira> cadeira = cadeiraService.getCadeiraById(id);
        if (cadeira.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cadeira.map(CadeiraDTO::create));
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody CadeiraDTO cadeiraDTO) {
        try {
            Cadeira cadeira = converter(cadeiraDTO);
            cadeira = cadeiraService.salvar(cadeira);
            return new ResponseEntity(cadeira, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar a cadeira: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody CadeiraDTO cadeiraDTO) {
        if (!cadeiraService.getCadeiraById(id).isPresent()) {
            return new ResponseEntity("Cadeira não encontrada", HttpStatus.NOT_FOUND);
        }
        try {
            Cadeira cadeira = converter(cadeiraDTO);
            cadeira.setId(id);
            cadeiraService.salvar(cadeira);
            return ResponseEntity.ok(cadeira);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar a cadeira: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Optional<Cadeira> cadeira = cadeiraService.getCadeiraById(id);
        if (!cadeira.isPresent()) {
            return new ResponseEntity("Cadeira não encontrada", HttpStatus.NOT_FOUND);
        }
        try {
            cadeiraService.excluir(cadeira.get());
            return new ResponseEntity("Cadeira excluída com sucesso", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao excluir a cadeira: " + e.getMessage());
        }
    }

    private Cadeira converter(CadeiraDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Cadeira cadeira = modelMapper.map(dto, Cadeira.class);
        return cadeira;
    }
}
