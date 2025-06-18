package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {

    private Long id;

    private String email;
    private String senha;
    private String nome;
    private LocalDateTime criadoEm;
    private LocalDateTime ultimoAcesso;
    private boolean emailConfirmado;

    private boolean ativo;
    private boolean isGerente;
    private Long idCinema;

    public static FuncionarioDTO create(Funcionario funcionario){
        ModelMapper mapper = new ModelMapper();
        FuncionarioDTO funcionarioDTO = mapper.map(funcionario, FuncionarioDTO.class);
        return funcionarioDTO;
    }
}
