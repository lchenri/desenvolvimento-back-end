package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.Unidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;


public class UnidadeDTO {
    private Long id;
    private String unidade;

    private Long idEndereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public static UnidadeDTO create(Unidade unidade){
        ModelMapper mapper = new ModelMapper();
        UnidadeDTO dto = mapper.map(unidade, UnidadeDTO.class);
        return dto;
    }

}
