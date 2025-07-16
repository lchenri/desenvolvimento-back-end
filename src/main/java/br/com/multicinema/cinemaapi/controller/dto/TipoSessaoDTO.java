package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.TipoSessao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;


public class TipoSessaoDTO {
    private Long id;
    private String tipo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public static TipoSessaoDTO create(TipoSessao tipoSessao) {
        ModelMapper modelMapper = new ModelMapper();
        TipoSessaoDTO tipoSessaoDTO = modelMapper.map(tipoSessao, TipoSessaoDTO.class);
        return tipoSessaoDTO;
    }
}
