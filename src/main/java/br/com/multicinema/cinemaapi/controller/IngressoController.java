package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.IngressoDTO;
import br.com.multicinema.cinemaapi.service.IngressoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/ingressos")
public class IngressoController {

    private final IngressoService ingressoService;

    public IngressoController(IngressoService ingressoService) {
        this.ingressoService = ingressoService;
    }

    @GetMapping()
    public ResponseEntity get(){
        var ingressos = ingressoService.getIngressos();
        return ResponseEntity.ok(ingressos.stream().map(IngressoDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        var ingresso = ingressoService.getIngressoById(id);
        if (ingresso.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingresso.map(IngressoDTO::create));
    }
}
