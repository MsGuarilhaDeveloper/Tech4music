package com.br.tech4me.tech4music.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("music")
public class Music {
    @Id
    private String id;
    @NotBlank (message = "Nao foi deigitado o titulo")
    @NotEmpty (message = "Nao foi cadastrado nenhum tilo, mas foi colocado espassamnetos")
    private String titulo;
    @NotBlank (message = "Nao foi deigitado o artista")
    @NotEmpty (message = "Nao foi cadastrado nenhum artista, mas foi colocado espassamnetos")
    private String artista;
    @NotBlank (message = "Nao foi deigitado o album")
    @NotEmpty (message = "Nao foi cadastrado nenhum album, mas foi colocado espassamnetos")
    private String album;
    @NotBlank (message = "Nao foi deigitado o genero")
    @NotEmpty (message = "Nao foi cadastrado nenhum genero, mas foi colocado espassamnetos")
    private String genero;
    private int ano;
    @NotBlank (message = "Nao foi deigitado o compositor")
    @NotEmpty (message = "Nao foi cadastrado nenhum compositor, mas foi colocado espassamnetos")
    private String compositor;
    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }
    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public String getCompositor() {
        return compositor;
    }
    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Music [album=" + album + ", ano=" + ano + ", artista=" + artista + ", compositor=" + compositor
                + ", genero=" + genero + ", id=" + id + ", titulo=" + titulo + "]";
    }
    
    
    
}
