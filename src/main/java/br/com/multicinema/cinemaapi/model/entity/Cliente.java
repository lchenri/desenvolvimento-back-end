package br.com.multicinema.cinemaapi.model.entity;

import br.com.multicinema.cinemaapi.utils.validation.cpf.ValidaCPF;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


import java.sql.Date;
import java.util.List;

@Entity
public class Cliente extends Usuario{

    @NotBlank(message = "CPF não pode estar em branco")
    @ValidaCPF
    private String cpf;
    @NotBlank(message = "Celular não pode estar em branco")
    @Pattern(regexp = "\\d{2}9\\d{8}", message = "Celular deve estar no formato DD9XXXXXXXX")
    private String celular;
    private boolean pgtoSalvo;
    private Date dataNascimento;
    private boolean isFuncionario = false;

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

    public boolean isFuncionario() {
        return isFuncionario;
    }

    public void setFuncionario(boolean funcionario) {
        isFuncionario = funcionario;
    }
}
