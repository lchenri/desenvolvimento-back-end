package br.com.multicinema.cinemaapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cadeira {
// priorizar many para um. Curso(many) -> Aluno(um). Colocar a anotação @ManyToOne na classe curso

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private boolean isDisponivel;
    private boolean isEspecial;

    @ManyToOne
    private Fileira fileira;
    @OneToOne
    private Ingresso ingresso;
}
