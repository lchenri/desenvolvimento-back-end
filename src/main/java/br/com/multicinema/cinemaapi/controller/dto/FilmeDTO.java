package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.Filme;
import br.com.multicinema.cinemaapi.model.entity.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public static FilmeDTO create(Filme filme){
        ModelMapper mapper = new ModelMapper();
        FilmeDTO filmeDTO = mapper.map(filme, FilmeDTO.class);
        filmeDTO.setIdGeneros(filme.getGeneros());
        return filmeDTO;
    }
}
