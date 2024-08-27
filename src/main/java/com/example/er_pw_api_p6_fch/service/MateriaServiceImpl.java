package com.example.er_pw_api_p6_fch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.er_pw_api_p6_fch.repository.IMateriaRepository;
import com.example.er_pw_api_p6_fch.repository.model.Materia;
import com.example.er_pw_api_p6_fch.service.To.MateriaCompleta;
import com.example.er_pw_api_p6_fch.service.To.MateriaDTO;

@Service
public class MateriaServiceImpl implements IMateriaService {

    @Autowired
    private IMateriaRepository iMateriaRepository;

    @Override
    public void guardar(MateriaCompleta completa) {
        // TODO Auto-generated method stub
        this.iMateriaRepository.guardar(this.castearAMateria(completa));
    }

    @Override
    public void actialuzar(MateriaCompleta materia) {
        // TODO Auto-generated method stub
        this.iMateriaRepository.actialuzar(this.castearAMateria(materia));
    }

    @Override
    public List<MateriaDTO> listar() {
        // TODO Auto-generated method stub
        List<Materia> materias = this.iMateriaRepository.listar();
        List<MateriaDTO> materiasDTO = new ArrayList<MateriaDTO>();

        for (Materia materia : materias) {
            materiasDTO.add(castearADTO(materia));
        }

        return materiasDTO;
    }

    @Override
    public void eliminar(String codigo) {
        // TODO Auto-generated method stub
        this.iMateriaRepository.eliminar(this.iMateriaRepository.buscarPorCodigo(codigo));
    }

    @Override
    public MateriaCompleta buscarPorCodigo(String codigo) {
        // TODO Auto-generated method stub

        Materia materia = iMateriaRepository.buscarPorCodigo(codigo);
        MateriaCompleta materiaCompleta = castearACompleta(materia);

        return materiaCompleta;
    }

    //casteos

    public MateriaCompleta castearACompleta( Materia materia){
        MateriaCompleta materiaCompleta = new MateriaCompleta();
        materiaCompleta.setCodigo(materia.getCodigo());
        materiaCompleta.setCreditos(materia.getCreditos());
        materiaCompleta.setDescripcion(materia.getDescripcion());
        materiaCompleta.setId(materia.getId());
        materiaCompleta.setNombre(materia.getNombre());

        return materiaCompleta;

    }

    public Materia castearAMateria( MateriaCompleta materia){
        Materia materiaCompleta = new Materia();
        materiaCompleta.setCodigo(materia.getCodigo());
        materiaCompleta.setCreditos(materia.getCreditos());
        materiaCompleta.setDescripcion(materia.getDescripcion());
        materiaCompleta.setId(materia.getId());
        materiaCompleta.setNombre(materia.getNombre());

        return materiaCompleta;
        
    }

    public MateriaDTO castearADTO( Materia materia){
        MateriaDTO materiaDTO = new MateriaDTO();
        materiaDTO.setCodigo(materia.getCodigo());
        materiaDTO.setNombre(materia.getNombre());

        return materiaDTO;
    }

    

    
}
