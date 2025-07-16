package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.Ingresso;
import br.com.multicinema.cinemaapi.model.entity.TipoMeiaEntrada;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;


public class IngressoDTO {
    private Long id;
    private TipoMeiaEntrada tipoMeiaEntrada;
    private BigDecimal preco;
    private boolean validado;
    private Long idSessao;
    private Long idPedido;
    private Long idCadeira;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoMeiaEntrada getTipoMeiaEntrada() {
        return tipoMeiaEntrada;
    }

    public void setTipoMeiaEntrada(TipoMeiaEntrada tipoMeiaEntrada) {
        this.tipoMeiaEntrada = tipoMeiaEntrada;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    public Long getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(Long idSessao) {
        this.idSessao = idSessao;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdCadeira() {
        return idCadeira;
    }

    public void setIdCadeira(Long idCadeira) {
        this.idCadeira = idCadeira;
    }

    public static IngressoDTO create(Ingresso ingresso){
        ModelMapper mapper = new ModelMapper();
        IngressoDTO ingressoDTO = mapper.map(ingresso, IngressoDTO.class);
        return ingressoDTO;
    }

}
