package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.CupomDesconto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CupomDescontoDTO {
    private Long id;

    private String codigo;
    private Integer percentual;
    private BigDecimal valorMaximo;
    private LocalDateTime dataValidade;
    private Boolean ativo;

    private Long idPedido;
    private Long idCliente;

    public static CupomDescontoDTO create(CupomDesconto cupomDesconto){
        ModelMapper mapper = new ModelMapper();
        CupomDescontoDTO cupomDescontoDTO = mapper.map(cupomDesconto, CupomDescontoDTO.class);
        return cupomDescontoDTO;
    }
}
