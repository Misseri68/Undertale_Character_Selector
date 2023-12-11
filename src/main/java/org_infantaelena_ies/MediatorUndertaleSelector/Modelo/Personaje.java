package org_infantaelena_ies.MediatorUndertaleSelector.Modelo;

import javafx.scene.image.Image;
import javafx.scene.media.Media;

import java.io.File;
import java.util.Objects;


public class Personaje {

    String nombre;
    Image imagen, imagen2;
    String descripcion;
    String residencia;
    Image imagenBackground;
    Media voz;
    Media musica;

    public Personaje() {
    }

    public Personaje(String nombre) {
        this.nombre = nombre;
    }

    public Personaje(String nombre, Image imagen, Image imagen2, String descripcion, String residencia, Image imagenBackground, Media voz, Media musica) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.imagen2 = imagen2;
        this.descripcion = descripcion;
        this.residencia = residencia;
        this.imagenBackground = imagenBackground;
        this.voz = voz;
        this.musica = musica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(String rutaImagen) {
        this.imagen = new Image(new File(rutaImagen).toURI().toString());
    }

    public Image getImagen2() {
        return imagen2;
    }

    public void setImagen2(String rutaImagen2) {
        this.imagen2 = new Image(new File(rutaImagen2).toURI().toString());
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public Image getImagenBackground() {
        return imagenBackground;
    }

    public void setImagenBackground(String rutaImagenBackground) {
        if(!rutaImagenBackground.equals("vacio")) {
            this.imagenBackground = new Image(new File(rutaImagenBackground).toURI().toString());
        } else{
            this.imagenBackground = new Image(new File(rutaImagenBackground).toURI().toString());

        }
    }

    public Media getVoz() {
        return voz;
    }

    public void setVoz(String rutaVoz) {
        if(!rutaVoz.equals("vacio")){
            this.voz = new Media(new File(rutaVoz).toURI().toString());
        }
    }

    public Media getMusica() {
        return musica;
    }

    public void setMusica(String rutaMusica) {
        this.musica = new Media(new File(rutaMusica).toURI().toString());
    }
}
