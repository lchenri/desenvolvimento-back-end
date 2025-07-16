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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Boolean getUsoCupom() {
        return usoCupom;
    }

    public void setUsoCupom(Boolean usoCupom) {
        this.usoCupom = usoCupom;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public static PedidoDTO create(Pedido pedido){
        ModelMapper mapper = new ModelMapper();
        PedidoDTO dto = mapper.map(pedido, PedidoDTO.class);
        return dto;
    }
}
