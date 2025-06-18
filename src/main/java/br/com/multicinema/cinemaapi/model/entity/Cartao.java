package br.com.multicinema.cinemaapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import br.com.multicinema.cinemaapi.model.entity.Cliente;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private String nomeTitular;
    private Date dataValidade;

    @ManyToOne
    private Cliente cliente;
}
