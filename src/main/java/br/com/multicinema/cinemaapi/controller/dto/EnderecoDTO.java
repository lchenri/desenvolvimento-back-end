package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;


public class EnderecoDTO {
    private Long id;

    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;

    public static EnderecoDTO create(Endereco endereco) {
        ModelMapper mapper = new ModelMapper();
        EnderecoDTO enderecoDTO = mapper.map(endereco, EnderecoDTO.class);
        return enderecoDTO;
    }
}
