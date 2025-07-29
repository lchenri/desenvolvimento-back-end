package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.SessaoDTO;
import br.com.multicinema.cinemaapi.model.entity.Sessao;
import br.com.multicinema.cinemaapi.service.SessaoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/sessoes")
public class SessaoController {

    private final SessaoService sessaoService;

    public SessaoController(SessaoService sessaoService) {
        this.sessaoService = sessaoService;
    }

    @GetMapping()
    public ResponseEntity get(){
        var sessoes = sessaoService.getSessoes();
        return ResponseEntity.ok(sessoes.stream().map(SessaoDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        var sessao = sessaoService.getSessaoById(id);
        if (sessao.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(sessao.map(SessaoDTO::create));
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody SessaoDTO sessaoDTO){
        try{
            Sessao sessao = converter(sessaoDTO);
            sessao = sessaoService.salvar(sessao);
            return new ResponseEntity(sessao, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar a sessão: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody SessaoDTO sessaoDTO) {
        if (!sessaoService.getSessaoById(id).isPresent()) {
            return new ResponseEntity("Sessão não encontrada", HttpStatus.NOT_FOUND);
        }
        try {
            Sessao sessao = converter(sessaoDTO);
            sessao.setId(id);
            sessaoService.salvar(sessao);
            return ResponseEntity.ok(sessao);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar a sessão: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Optional<Sessao> sessao = sessaoService.getSessaoById(id);
        if (!sessao.isPresent()) {
            return new ResponseEntity("Sessão não encontrada", HttpStatus.NOT_FOUND);
        }
        try {
            sessaoService.excluir(sessao.get());
            return new ResponseEntity("Sessão excluída com sucesso", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao excluir a sessão: " + e.getMessage());
        }
    }

    private Sessao converter(SessaoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Sessao sessao = modelMapper.map(dto, Sessao.class);
        return sessao;
    }
}
