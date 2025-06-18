package br.com.multicinema.cinemaapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CupomDesconto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private Integer percentual;
    private BigDecimal valorMaximo;
    private LocalDateTime dataValidade;
    private Boolean ativo;

    @OneToOne
    private Pedido pedido;

    @ManyToOne
    private Cliente cliente;
}
