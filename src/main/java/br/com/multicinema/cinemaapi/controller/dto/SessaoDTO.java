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

    public static SessaoDTO create(Sessao sessao){
        ModelMapper modelMapper = new ModelMapper();
        SessaoDTO sessaoDTO = modelMapper.map(sessao, SessaoDTO.class);
        return sessaoDTO;
    }
}
