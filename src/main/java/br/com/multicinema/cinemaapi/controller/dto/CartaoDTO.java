package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.Cartao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.Date;

public class CartaoDTO {
    private Long id;
    private String numero;
    private String nomeTitular;
    private Date dataValidade;
    private Long idCliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public static CartaoDTO create(Cartao cartao){
        ModelMapper mapper = new ModelMapper();
        CartaoDTO cartaoDTO = mapper.map(cartao, CartaoDTO.class);
        return cartaoDTO;
    }
}
