package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;


import java.time.LocalDateTime;
import java.util.Date;

public class ClienteDTO {

    private Long id;
    private String cpf;
    private String celular;
    private boolean pgtoSalvo;
    private Date dataNascimento;
    private String email;
    private String senha;
    private String nome;
    private LocalDateTime criadoEm;
    private LocalDateTime ultimoAcesso;
    private boolean emailConfirmado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(LocalDateTime ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public boolean isEmailConfirmado() {
        return emailConfirmado;
    }

    public void setEmailConfirmado(boolean emailConfirmado) {
        this.emailConfirmado = emailConfirmado;
    }

    public static ClienteDTO create(Cliente cliente){
        ModelMapper modelMapper = new ModelMapper();
        ClienteDTO dto = modelMapper.map(cliente, ClienteDTO.class);
        return dto;
    }
}
