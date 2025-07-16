package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {

    private Long id;

    private String email;
    private String senha;
    private String nome;
    private LocalDateTime criadoEm;
    private LocalDateTime ultimoAcesso;
    private boolean emailConfirmado;

    private boolean ativo;
    private boolean isGerente;
    private Long idCinema;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(Long idCinema) {
        this.idCinema = idCinema;
    }

    public static FuncionarioDTO create(Funcionario funcionario){
        ModelMapper mapper = new ModelMapper();
        FuncionarioDTO funcionarioDTO = mapper.map(funcionario, FuncionarioDTO.class);
        return funcionarioDTO;
    }
}
