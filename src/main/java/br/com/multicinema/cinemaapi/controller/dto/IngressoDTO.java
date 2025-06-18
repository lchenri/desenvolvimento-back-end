package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.Ingresso;
import br.com.multicinema.cinemaapi.model.entity.TipoMeiaEntrada;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngressoDTO {
    private Long id;
    private TipoMeiaEntrada tipoMeiaEntrada;
    private BigDecimal preco;
    private boolean validado;
    private Long idSessao;
    private Long idPedido;
    private Long idCadeira;

    public static IngressoDTO create(Ingresso ingresso){
        ModelMapper mapper = new ModelMapper();
        IngressoDTO ingressoDTO = mapper.map(ingresso, IngressoDTO.class);
        return ingressoDTO;
    }

}
