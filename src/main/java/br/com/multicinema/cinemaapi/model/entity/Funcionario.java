package br.com.multicinema.cinemaapi.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario extends Usuario{

    private boolean ativo;
    private boolean isGerente;

    @ManyToOne
    private Unidade cinema;
}
