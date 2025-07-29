package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.IngressoDTO;
import br.com.multicinema.cinemaapi.model.entity.Ingresso;
import br.com.multicinema.cinemaapi.service.IngressoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity post(@RequestBody IngressoDTO ingressoDTO){
        try{
            Ingresso ingresso = converter(ingressoDTO);
            ingresso = ingressoService.salvar(ingresso);
            return new ResponseEntity(ingresso, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar o ingresso: " + e.getMessage());
        }
    }

    private Ingresso converter(IngressoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Ingresso ingresso = modelMapper.map(dto, Ingresso.class);
        return ingresso;
    }
}
