package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneroDTO {
    private Long id;
    private String descricao;

    public static GeneroDTO create(Genero genero){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(genero, GeneroDTO.class);
    }
}
