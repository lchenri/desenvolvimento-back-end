package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.ItemBomboniereDTO;
import br.com.multicinema.cinemaapi.model.entity.ItemBomboniere;
import br.com.multicinema.cinemaapi.service.ItemBomboniereService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/item-bomboniere")
public class ItemBomboniereController {

    private final ItemBomboniereService itemBomboniereService;

    public ItemBomboniereController(ItemBomboniereService itemBomboniereService) {
        this.itemBomboniereService = itemBomboniereService;
    }

    @GetMapping()
    public ResponseEntity get(){
        var items = itemBomboniereService.getItensBomboniere();
        return ResponseEntity.ok(items.stream().map(ItemBomboniereDTO::create).collect(java.util.stream.Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        var item = itemBomboniereService.getItemBomboniereById(id);
        if (item.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(item.map(ItemBomboniereDTO::create));
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody ItemBomboniereDTO itemBomboniereDTO){
        try{
            ItemBomboniere itemBomboniere = converter(itemBomboniereDTO);
            itemBomboniere = itemBomboniereService.salvar(itemBomboniere);
            return new ResponseEntity(itemBomboniere, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar o item da bomboniere: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody ItemBomboniereDTO itemBomboniereDTO) {
        if (!itemBomboniereService.getItemBomboniereById(id).isPresent()) {
            return new ResponseEntity("Item da bomboniere não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            ItemBomboniere itemBomboniere = converter(itemBomboniereDTO);
            itemBomboniere.setId(id);
            itemBomboniereService.salvar(itemBomboniere);
            return ResponseEntity.ok(itemBomboniere);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar o item da bomboniere: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Optional<ItemBomboniere> itemBomboniere = itemBomboniereService.getItemBomboniereById(id);
        if (!itemBomboniere.isPresent()) {
            return new ResponseEntity("Item da bomboniere não encontrado", HttpStatus.NOT_FOUND);
        }
        try {
            itemBomboniereService.excluir(itemBomboniere.get());
            return new ResponseEntity("Item da bomboniere excluído com sucesso", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao excluir o item da bomboniere: " + e.getMessage());
        }
    }

    private ItemBomboniere converter(ItemBomboniereDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        ItemBomboniere itemBomboniere = modelMapper.map(dto, ItemBomboniere.class);
        return itemBomboniere;
    }
}
