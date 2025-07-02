package br.com.multicinema.cinemaapi.model.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity

public class Ingresso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoMeiaEntrada tipoMeiaEntrada;
    private BigDecimal preco;
    private boolean validado;

    @ManyToOne
    private Sessao sessao;
    @ManyToOne
    private Pedido pedido;
    @OneToOne
    private Cadeira cadeira;

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

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Cadeira getCadeira() {
        return cadeira;
    }

    public void setCadeira(Cadeira cadeira) {
        this.cadeira = cadeira;
    }
}
