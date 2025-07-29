package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.IntervaloExibicaoDTO;
import br.com.multicinema.cinemaapi.model.entity.IntervaloExibicao;
import br.com.multicinema.cinemaapi.service.IntervaloExibicaoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/intervalos-exibicao")
public class IntervaloExibicaoController {

    private final IntervaloExibicaoService intervaloExibicaoService;

    public IntervaloExibicaoController(IntervaloExibicaoService intervaloExibicaoService) {
        this.intervaloExibicaoService = intervaloExibicaoService;
    }

    @GetMapping()
    public ResponseEntity get() {
        var intervalos = intervaloExibicaoService.getIntervalosExibicao();
        return ResponseEntity.ok(intervalos.stream().map(IntervaloExibicaoDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        var intervalo = intervaloExibicaoService.getIntervaloExibicaoById(id);
        if (intervalo.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(intervalo.map(IntervaloExibicaoDTO::create));
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody IntervaloExibicaoDTO intervaloExibicaoDTO){
        try{
            IntervaloExibicao intervaloExibicao = converter(intervaloExibicaoDTO);
            intervaloExibicao = intervaloExibicaoService.salvar(intervaloExibicao);
            return new ResponseEntity(intervaloExibicao, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar o intervalo de exibição: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody IntervaloExibicaoDTO intervaloExibicaoDTO) {
        if (!intervaloExibicaoService.getIntervaloExibicaoById(id).isPresent()) {
            return new ResponseEntity("Intervalo de exibição não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            IntervaloExibicao intervaloExibicao = converter(intervaloExibicaoDTO);
            intervaloExibicao.setId(id);
            intervaloExibicaoService.salvar(intervaloExibicao);
            return ResponseEntity.ok(intervaloExibicao);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar o intervalo de exibição: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Optional<IntervaloExibicao> intervaloExibicao = intervaloExibicaoService.getIntervaloExibicaoById(id);
        if (!intervaloExibicao.isPresent()) {
            return new ResponseEntity("Intervalo de exibição não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            intervaloExibicaoService.excluir(intervaloExibicao.get());
            return new ResponseEntity("Intervalo de exibição excluído com sucesso", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao excluir o intervalo de exibição: " + e.getMessage());
        }
    }

    private IntervaloExibicao converter(IntervaloExibicaoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        IntervaloExibicao intervaloExibicao = modelMapper.map(dto, IntervaloExibicao.class);
        return intervaloExibicao;
    }
}
