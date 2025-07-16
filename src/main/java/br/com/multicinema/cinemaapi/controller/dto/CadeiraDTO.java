package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.Cadeira;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

public class CadeiraDTO {

    private Long id;
    private int numero;
    private boolean isDisponivel;
    private boolean isEspecial;
    private Long idFileira;
    private String letraFileira;
    private Long idIngresso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isDisponivel() {
        return isDisponivel;
    }

    public void setDisponivel(boolean disponivel) {
        isDisponivel = disponivel;
    }

    public boolean isEspecial() {
        return isEspecial;
    }

    public void setEspecial(boolean especial) {
        isEspecial = especial;
    }

    public Long getIdFileira() {
        return idFileira;
    }

    public void setIdFileira(Long idFileira) {
        this.idFileira = idFileira;
    }

    public String getLetraFileira() {
        return letraFileira;
    }

    public void setLetraFileira(String letraFileira) {
        this.letraFileira = letraFileira;
    }

    public Long getIdIngresso() {
        return idIngresso;
    }

    public void setIdIngresso(Long idIngresso) {
        this.idIngresso = idIngresso;
    }

    public static CadeiraDTO create(Cadeira cadeira){
        ModelMapper mapper = new ModelMapper();
        CadeiraDTO cadeiraDTO = mapper.map(cadeira, CadeiraDTO.class);
        cadeiraDTO.letraFileira = cadeira.getFileira().getLetra();
        return cadeiraDTO;
    }
}
