package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.Filme;
import br.com.multicinema.cinemaapi.model.entity.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.List;


public class FilmeDTO {
    private Long id;

    private String titulo;
    private String sinopse;
    private Integer duracao;
    private String classificacao;
    private Boolean emCartaz;
    private Boolean emPreVenda;
    private LocalDateTime dataEstreia;

    private Long idIntervaloExibicao;
    private List<Genero> idGeneros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Boolean getEmCartaz() {
        return emCartaz;
    }

    public void setEmCartaz(Boolean emCartaz) {
        this.emCartaz = emCartaz;
    }

    public Boolean getEmPreVenda() {
        return emPreVenda;
    }

    public void setEmPreVenda(Boolean emPreVenda) {
        this.emPreVenda = emPreVenda;
    }

    public LocalDateTime getDataEstreia() {
        return dataEstreia;
    }

    public void setDataEstreia(LocalDateTime dataEstreia) {
        this.dataEstreia = dataEstreia;
    }

    public Long getIdIntervaloExibicao() {
        return idIntervaloExibicao;
    }

    public void setIdIntervaloExibicao(Long idIntervaloExibicao) {
        this.idIntervaloExibicao = idIntervaloExibicao;
    }

    public List<Genero> getIdGeneros() {
        return idGeneros;
    }

    public static FilmeDTO create(Filme filme){
        ModelMapper mapper = new ModelMapper();
        FilmeDTO filmeDTO = mapper.map(filme, FilmeDTO.class);
        filmeDTO.setIdGeneros(filme.getGeneros());
        return filmeDTO;
    }

    public void setIdGeneros(List<Genero> idGeneros) {
        this.idGeneros = idGeneros;
    }
}
