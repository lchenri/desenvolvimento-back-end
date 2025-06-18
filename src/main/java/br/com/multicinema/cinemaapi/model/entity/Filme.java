package br.com.multicinema.cinemaapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToMany
    private List<Genero> generos;
}

