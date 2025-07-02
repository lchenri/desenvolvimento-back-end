package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;


import java.time.LocalDateTime;
import java.util.Date;

public class ClienteDTO {

    private Long id;
    private String cpf;
    private String celular;
    private boolean pgtoSalvo;
    private Date dataNascimento;
    private String email;
    private String senha;
    private String nome;
    private LocalDateTime criadoEm;
    private LocalDateTime ultimoAcesso;
    private boolean emailConfirmado;

    public static ClienteDTO create(Cliente cliente){
        ModelMapper modelMapper = new ModelMapper();
        ClienteDTO dto = modelMapper.map(cliente, ClienteDTO.class);
        return dto;
    }
}
