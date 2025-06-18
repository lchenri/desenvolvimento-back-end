package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.Unidade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnidadeDTO {
    private Long id;
    private String unidade;

    private Long idEndereco;

    public static UnidadeDTO create(Unidade unidade){
        ModelMapper mapper = new ModelMapper();
        UnidadeDTO dto = mapper.map(unidade, UnidadeDTO.class);
        return dto;
    }

}
