package com.example.er_pw_api_p6_fch.service;

import java.util.List;

import com.example.er_pw_api_p6_fch.service.To.MateriaCompleta;
import com.example.er_pw_api_p6_fch.service.To.MateriaDTO;

public interface IMateriaService {

    void guardar(MateriaCompleta completa);

    void actialuzar(MateriaCompleta materia);

    List<MateriaDTO> listar();

    void eliminar(String codigo);

    MateriaCompleta buscarPorCodigo(String codigo);
}
