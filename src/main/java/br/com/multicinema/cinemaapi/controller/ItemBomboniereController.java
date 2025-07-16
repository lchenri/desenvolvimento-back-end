package br.com.multicinema.cinemaapi.controller;

import br.com.multicinema.cinemaapi.controller.dto.ItemBomboniereDTO;
import br.com.multicinema.cinemaapi.service.ItemBomboniereService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
