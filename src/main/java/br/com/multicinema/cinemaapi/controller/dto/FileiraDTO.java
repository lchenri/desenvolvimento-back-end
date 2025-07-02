package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.Fileira;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;


public class FileiraDTO {
    private Long id;

    private String letra;
    private Long idSala;

    public static FileiraDTO create(Fileira fileira){
        ModelMapper modelMapper = new ModelMapper();
        FileiraDTO fileiraDTO = modelMapper.map(fileira, FileiraDTO.class);
        return fileiraDTO;
    }
}
