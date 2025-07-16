package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.CupomDescontoDTO;
import br.com.multicinema.cinemaapi.model.entity.CupomDesconto;
import br.com.multicinema.cinemaapi.service.CupomDescontoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/cupons-desconto")
public class CupomDescontoController {

    private final CupomDescontoService cupomDescontoService;

    public CupomDescontoController(CupomDescontoService cupomDescontoService) {
        this.cupomDescontoService = cupomDescontoService;
    }

    @GetMapping()
    public ResponseEntity get(){
        List<CupomDesconto> cupomDescontoList = cupomDescontoService.getCuponsDesconto();
        return ResponseEntity.ok(cupomDescontoList.stream().map(CupomDescontoDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        Optional<CupomDesconto> cupom = cupomDescontoService.getCupomDescontoById(id);
        if (!cupom.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cupom.map(CupomDescontoDTO::create));
    }
}
