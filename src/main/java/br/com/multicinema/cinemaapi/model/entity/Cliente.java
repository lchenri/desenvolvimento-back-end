package br.com.multicinema.cinemaapi.model.entity;

import javax.persistence.Entity;


import java.sql.Date;
import java.util.List;

@Entity

public class Cliente extends Usuario{

    private String cpf;
    private String celular;
    private boolean pgtoSalvo;
    private Date dataNascimento;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public boolean isPgtoSalvo() {
        return pgtoSalvo;
    }

    public void setPgtoSalvo(boolean pgtoSalvo) {
        this.pgtoSalvo = pgtoSalvo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
