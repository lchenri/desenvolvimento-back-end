package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.Sala;
import br.com.multicinema.cinemaapi.model.entity.TipoSessao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;


public class SalaDTO {

    private Long id;
    private Integer capacidade;
    private List<TipoSessao> tiposSessaoSuportados;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public List<TipoSessao> getTiposSessaoSuportados() {
        return tiposSessaoSuportados;
    }

    public void setTiposSessaoSuportados(List<TipoSessao> tiposSessaoSuportados) {
        this.tiposSessaoSuportados = tiposSessaoSuportados;
    }

    public static SalaDTO create(Sala sala){
        ModelMapper modelMapper = new ModelMapper();
        SalaDTO salaDTO = modelMapper.map(sala, SalaDTO.class);
        return salaDTO;
    }
}
