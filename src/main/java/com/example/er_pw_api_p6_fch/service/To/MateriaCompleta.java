package com.example.er_pw_api_p6_fch.service.To;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class MateriaCompleta extends RepresentationModel<MateriaCompleta> implements Serializable {

    private Integer id;

    private String codigo;

    private String nombre;

    private String Descripcion;

    private Integer creditos;

    // get and set


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    
}
