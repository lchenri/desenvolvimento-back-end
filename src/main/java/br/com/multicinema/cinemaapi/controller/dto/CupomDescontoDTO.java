package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.CupomDesconto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;


public class CupomDescontoDTO {
    private Long id;

    private String codigo;
    private Integer percentual;
    private BigDecimal valorMaximo;
    private LocalDateTime dataValidade;
    private Boolean ativo;

    private Long idPedido;
    private Long idCliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getPercentual() {
        return percentual;
    }

    public void setPercentual(Integer percentual) {
        this.percentual = percentual;
    }

    public BigDecimal getValorMaximo() {
        return valorMaximo;
    }

    public void setValorMaximo(BigDecimal valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    public LocalDateTime getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDateTime dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public static CupomDescontoDTO create(CupomDesconto cupomDesconto){
        ModelMapper mapper = new ModelMapper();
        CupomDescontoDTO cupomDescontoDTO = mapper.map(cupomDesconto, CupomDescontoDTO.class);
        return cupomDescontoDTO;
    }
}
