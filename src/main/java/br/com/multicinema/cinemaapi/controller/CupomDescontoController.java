package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.CupomDescontoDTO;
import br.com.multicinema.cinemaapi.model.entity.CupomDesconto;
import br.com.multicinema.cinemaapi.service.CupomDescontoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity post(@RequestBody CupomDescontoDTO cupomDescontoDTO){
        try{
            CupomDesconto cupomDesconto = converter(cupomDescontoDTO);
            cupomDesconto = cupomDescontoService.salvar(cupomDesconto);
            return new ResponseEntity(cupomDesconto, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar o cupom de desconto: " + e.getMessage());
        }
    }

    private CupomDesconto converter(CupomDescontoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        CupomDesconto cupomDesconto = modelMapper.map(dto, CupomDesconto.class);
        return cupomDesconto;
    }
}
