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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public static ItemBomboniereDTO create(ItemBomboniere itemBomboniere) {
        ModelMapper modelMapper = new ModelMapper();
        ItemBomboniereDTO itemBomboniereDTO = modelMapper.map(itemBomboniere, ItemBomboniereDTO.class);
        return itemBomboniereDTO;
    }
}
