package br.com.multicinema.cinemaapi.model.entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    @JsonIgnore
    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FilmeGenero> filmeGeneros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<FilmeGenero> getFilmeGeneros() {
        return filmeGeneros;
    }

    public void setFilmeGeneros(List<FilmeGenero> filmeGeneros) {
        this.filmeGeneros = filmeGeneros;
    }
}
