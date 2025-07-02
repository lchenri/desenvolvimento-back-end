package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.IntervaloExibicao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;


public class IntervaloExibicaoDTO {
    private Long id;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    public static IntervaloExibicaoDTO create(IntervaloExibicao intervaloExibicao){
        ModelMapper mapper = new ModelMapper();
        IntervaloExibicaoDTO intervaloExibicaoDTO = mapper.map(intervaloExibicao, IntervaloExibicaoDTO.class);
        return intervaloExibicaoDTO;
    }
}

