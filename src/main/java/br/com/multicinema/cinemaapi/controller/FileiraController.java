package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.FileiraDTO;
import br.com.multicinema.cinemaapi.model.entity.Fileira;
import br.com.multicinema.cinemaapi.service.FileiraService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/fileiras")
public class FileiraController {
    private final FileiraService fileiraService;

    public FileiraController(FileiraService fileiraService) {
        this.fileiraService = fileiraService;
    }

    @GetMapping()
    public ResponseEntity get(){
        List<Fileira> fileiras = fileiraService.getFileiras();
        return ResponseEntity.ok(fileiras.stream().map(FileiraDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        Optional<Fileira> fileira = fileiraService.getFileiraById(id);
        if (fileira.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fileira.map(FileiraDTO::create));
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody FileiraDTO fileiraDTO){
        try{
            Fileira fileira = converter(fileiraDTO);
            fileira = fileiraService.salvar(fileira);
            return new ResponseEntity(fileira, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar a fileira: " + e.getMessage());
        }
    }

    private Fileira converter(FileiraDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Fileira fileira = modelMapper.map(dto, Fileira.class);
        return fileira;
    }
}
