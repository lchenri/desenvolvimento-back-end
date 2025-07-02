package br.com.multicinema.cinemaapi.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class Funcionario extends Usuario{

    private boolean ativo;
    private boolean isGerente;

    @ManyToOne
    private Unidade cinema;

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public boolean isGerente() {
        return isGerente;
    }

    public void setGerente(boolean gerente) {
        isGerente = gerente;
    }

    public Unidade getCinema() {
        return cinema;
    }

    public void setCinema(Unidade cinema) {
        this.cinema = cinema;
    }
}
