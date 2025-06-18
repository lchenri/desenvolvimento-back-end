package br.com.multicinema.cinemaapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
