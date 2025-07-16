package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.TipoSessaoDTO;
import br.com.multicinema.cinemaapi.service.TipoSessaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tipos-sessao")
public class TipoSessaoController {

    private final TipoSessaoService tipoSessaoService;

    public TipoSessaoController(TipoSessaoService tipoSessaoService) {
        this.tipoSessaoService = tipoSessaoService;
    }

    @GetMapping()
    public ResponseEntity get(){
        var tiposSessao = tipoSessaoService.getTipoSessao();
        return ResponseEntity.ok(tiposSessao.stream().map(TipoSessaoDTO::create).collect(java.util.stream.Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        var tipoSessao = tipoSessaoService.getTipoSessaoById(id);
        if (tipoSessao.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tipoSessao.map(TipoSessaoDTO::create));
    }
}
