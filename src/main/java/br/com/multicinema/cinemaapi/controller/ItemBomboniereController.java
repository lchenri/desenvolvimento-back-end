package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.ItemBomboniereDTO;
import br.com.multicinema.cinemaapi.model.entity.ItemBomboniere;
import br.com.multicinema.cinemaapi.service.ItemBomboniereService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    private ItemBomboniere converter(ItemBomboniereDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        ItemBomboniere itemBomboniere = modelMapper.map(dto, ItemBomboniere.class);
        return itemBomboniere;
    }
}
