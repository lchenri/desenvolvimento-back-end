package br.com.multicinema.cinemaapi.service;

import br.com.multicinema.cinemaapi.model.entity.ItemBomboniere;
import br.com.multicinema.cinemaapi.repository.ItemBomboniereRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItemBomboniereService {
    private ItemBomboniereRepository itemBomboniereRepository;

    public ItemBomboniereService(ItemBomboniereRepository itemBomboniereRepository) {
        this.itemBomboniereRepository = itemBomboniereRepository;
    }

    public List<ItemBomboniere> getItensBomboniere() {
        return itemBomboniereRepository.findAll();
    }

    public Optional<ItemBomboniere> getItemBomboniereById(Long id) {
        return itemBomboniereRepository.findById(id);
    }

    @Transactional
    public ItemBomboniere salvar(ItemBomboniere itemBomboniere) {
        return itemBomboniereRepository.save(itemBomboniere);
    }

    @Transactional
    public void excluir(ItemBomboniere itemBomboniere) {
        itemBomboniereRepository.delete(itemBomboniere);
    }
}
