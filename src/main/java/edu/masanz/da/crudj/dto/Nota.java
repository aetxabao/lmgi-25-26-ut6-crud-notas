package edu.masanz.da.crudj.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Nota {

    private Long id;

    private String titulo;

    private String contenido;

    private LocalDateTime creado;

    private LocalDateTime modificado;


    public Nota() {
        this(0L, "", "", LocalDateTime.now(), LocalDateTime.now());
    }

    public Nota(Long id) {
        this(id, "Título " + id, "Contenido de la nota " + id);
    }

    public Nota(Long id, String titulo, String contenido) {
        this(id, titulo, contenido, LocalDateTime.now(), LocalDateTime.now());
    }

    public Nota(String titulo, String contenido) {
        this(0L, titulo, contenido);
    }

    public Nota(Long id, String titulo, String contenido, LocalDateTime creado, LocalDateTime tsModificacion) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.creado = creado;
        this.modificado = tsModificacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getCreado() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return creado.format(formatter);
    }

    public void setCreado(LocalDateTime creado) {
        this.creado = creado;
    }

    public void setCreado(String creado) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.creado = LocalDateTime.parse(creado, formatter);
    }

    public String getModificado() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return modificado.format(formatter);
    }

    public void setModificado(LocalDateTime modificado) {
        this.modificado = modificado;
    }

    public void setModificado(String modificado) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.modificado = LocalDateTime.parse(modificado, formatter);
    }

}