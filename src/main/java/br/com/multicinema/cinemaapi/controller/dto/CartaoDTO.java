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



    public static CartaoDTO create(Cartao cartao){
        ModelMapper mapper = new ModelMapper();
        CartaoDTO cartaoDTO = mapper.map(cartao, CartaoDTO.class);
        return cartaoDTO;
    }
}
