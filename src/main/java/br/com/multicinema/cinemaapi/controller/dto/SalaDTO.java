package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.Sala;
import br.com.multicinema.cinemaapi.model.entity.TipoSessao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaDTO {

    private Long id;
    private Integer capacidade;
    private List<TipoSessao> tiposSessaoSuportados;

    public static SalaDTO create(Sala sala){
        ModelMapper modelMapper = new ModelMapper();
        SalaDTO salaDTO = modelMapper.map(sala, SalaDTO.class);
        return salaDTO;
    }
}
