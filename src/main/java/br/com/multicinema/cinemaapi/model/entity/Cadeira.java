package br.com.multicinema.cinemaapi.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity

public class Cadeira {
// priorizar many para um. Curso(many) -> Aluno(um). Colocar a anotação @ManyToOne na classe curso

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private int numero;
    private boolean isDisponivel = true;
    private boolean isEspecial;

    @ManyToOne
    private Fileira fileira;
    @OneToOne
    private Ingresso ingresso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isDisponivel() {
        return isDisponivel;
    }

    public void setDisponivel(boolean disponivel) {
        isDisponivel = disponivel;
    }

    public boolean isEspecial() {
        return isEspecial;
    }

    public void setEspecial(boolean especial) {
        isEspecial = especial;
    }

    public Fileira getFileira() {
        return fileira;
    }

    public void setFileira(Fileira fileira) {
        this.fileira = fileira;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }
}
