package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.SessaoDTO;
import br.com.multicinema.cinemaapi.service.SessaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
