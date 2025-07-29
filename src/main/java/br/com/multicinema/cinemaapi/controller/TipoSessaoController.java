package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.TipoSessaoDTO;
import br.com.multicinema.cinemaapi.model.entity.TipoSessao;
import br.com.multicinema.cinemaapi.service.TipoSessaoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping()
    public ResponseEntity post(@RequestBody TipoSessaoDTO tipoSessaoDTO){
        try{
            TipoSessao tipoSessao = converter(tipoSessaoDTO);
            tipoSessao = tipoSessaoService.salvar(tipoSessao);
            return new ResponseEntity(tipoSessao, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar o tipo de sessão: " + e.getMessage());
        }
    }

    private TipoSessao converter(TipoSessaoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        TipoSessao tipoSessao = modelMapper.map(dto, TipoSessao.class);
        return tipoSessao;
    }
}
