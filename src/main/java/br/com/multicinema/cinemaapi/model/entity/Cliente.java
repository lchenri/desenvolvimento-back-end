package br.com.multicinema.cinemaapi.model.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends Usuario{

    private String cpf;
    private String celular;
    private boolean pgtoSalvo;
    private Date dataNascimento;

}
