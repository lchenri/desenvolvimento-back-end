package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.CadeiraDTO;
import br.com.multicinema.cinemaapi.model.entity.Cadeira;
import br.com.multicinema.cinemaapi.service.CadeiraService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
