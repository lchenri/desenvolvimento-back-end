package br.com.multicinema.cinemaapi.controller.dto;

import br.com.multicinema.cinemaapi.model.entity.Imagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;


public class ImagemDTO {
    private Long id;
    private String descricao;
    private String nameUrl;
    private Long idFilme;
    private String tituloFilme;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNameUrl() {
        return nameUrl;
    }

    public void setNameUrl(String nameUrl) {
        this.nameUrl = nameUrl;
    }

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public String getTituloFilme() {
        return tituloFilme;
    }

    public void setTituloFilme(String tituloFilme) {
        this.tituloFilme = tituloFilme;
    }

    public static ImagemDTO create(Imagem imagem){
        ModelMapper mapper = new ModelMapper();
        ImagemDTO imagemDTO = mapper.map(imagem, ImagemDTO.class);
        imagemDTO.tituloFilme = imagem.getFilme().getTitulo();
        return imagemDTO;
    }
}
