package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.Cadeira;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadeiraDTO {

    private Long id;
    private int numero;
    private boolean isDisponivel;
    private boolean isEspecial;
    private Long idFileira;
    private String letraFileira;
    private Long idIngresso;

    public static CadeiraDTO create(Cadeira cadeira){
        ModelMapper mapper = new ModelMapper();
        CadeiraDTO cadeiraDTO = mapper.map(cadeira, CadeiraDTO.class);
        cadeiraDTO.letraFileira = cadeira.getFileira().getLetra();
        return cadeiraDTO;
    }
}
