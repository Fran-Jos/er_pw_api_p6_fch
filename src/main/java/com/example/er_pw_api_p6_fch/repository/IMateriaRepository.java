package com.example.er_pw_api_p6_fch.repository;

import java.util.List;

import com.example.er_pw_api_p6_fch.repository.model.Materia;

public interface IMateriaRepository {

    void guardar(Materia materia);
    void actialuzar(Materia materia);
    List<Materia> listar();
    void eliminar(Materia materia);
    Materia buscarPorCodigo(String codigo);
    

}
