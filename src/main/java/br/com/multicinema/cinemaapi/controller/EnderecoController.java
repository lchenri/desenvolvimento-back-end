package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.EnderecoDTO;
import br.com.multicinema.cinemaapi.model.entity.Endereco;
import br.com.multicinema.cinemaapi.service.EnderecoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping()
    public ResponseEntity get(){
        List<Endereco> enderecos = enderecoService.getEnderecos();
        return ResponseEntity.ok(enderecos.stream().map(EnderecoDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id){
        Optional<Endereco> endereco = enderecoService.getEnderecoById(id);
        if (!endereco.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(endereco.map(EnderecoDTO::create));
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody EnderecoDTO enderecoDTO){
        try{
            Endereco endereco = converter(enderecoDTO);
            endereco = enderecoService.save(endereco);
            return new ResponseEntity(endereco, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar o endereço: " + e.getMessage());
        }
    }

    private Endereco converter(EnderecoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Endereco endereco = modelMapper.map(dto, Endereco.class);
        return endereco;
    }

}
