package br.com.multicinema.cinemaapi.model.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Entity

public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String sinopse;
    private Integer duracao;
    private String classificacao;
    private Boolean emCartaz;
    private Boolean emPreVenda;
    private LocalDateTime dataEstreia;

    @OneToOne
    private IntervaloExibicao intervalo;

    @JsonIgnore
    @ManyToMany
    private List<Genero> generos;

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

    public IntervaloExibicao getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(IntervaloExibicao intervalo) {
        this.intervalo = intervalo;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }
}


