package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.ItemBomboniere;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;


public class ItemBomboniereDTO {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private String descricao;
    private Boolean disponivel;
    private Long idPedido;

    public static ItemBomboniereDTO create(ItemBomboniere itemBomboniere) {
        ModelMapper modelMapper = new ModelMapper();
        ItemBomboniereDTO itemBomboniereDTO = modelMapper.map(itemBomboniere, ItemBomboniereDTO.class);
        return itemBomboniereDTO;
    }
}
