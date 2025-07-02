package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.Pedido;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;


public class PedidoDTO {
    private Long id;

    private BigDecimal valorTotal;
    private Boolean usoCupom;
    private Long idCliente;

    public static PedidoDTO create(Pedido pedido){
        ModelMapper mapper = new ModelMapper();
        PedidoDTO dto = mapper.map(pedido, PedidoDTO.class);
        return dto;
    }
}
