package br.com.multicinema.cinemaapi.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Funcionario extends Usuario{

    private boolean ativo;
    private boolean isFuncionario = true;

    @ManyToOne
    private Unidade cinema;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isFuncionario() {
        return isFuncionario;
    }

    public void setFuncionario(boolean funcionario) {
        isFuncionario = funcionario;
    }

    public Unidade getCinema() {
        return cinema;
    }

    public void setCinema(Unidade cinema) {
        this.cinema = cinema;
    }
}
