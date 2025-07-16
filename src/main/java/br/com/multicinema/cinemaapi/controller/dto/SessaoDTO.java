package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.Sessao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;


public class SessaoDTO {
    private Long id;
    private LocalDateTime data;
    private String idioma;

    private Long idFilme;
    private Long idSala;
    private Long idTipoSessao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public Long getIdSala() {
        return idSala;
    }

    public void setIdSala(Long idSala) {
        this.idSala = idSala;
    }

    public Long getIdTipoSessao() {
        return idTipoSessao;
    }

    public void setIdTipoSessao(Long idTipoSessao) {
        this.idTipoSessao = idTipoSessao;
    }

    public static SessaoDTO create(Sessao sessao){
        ModelMapper modelMapper = new ModelMapper();
        SessaoDTO sessaoDTO = modelMapper.map(sessao, SessaoDTO.class);
        return sessaoDTO;
    }
}
