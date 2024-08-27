package com.example.er_pw_api_p6_fch.service.To;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class MateriaDTO  extends RepresentationModel<MateriaDTO> implements Serializable {

    private String codigo;

    private String nombre;
    

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

    
    
}
