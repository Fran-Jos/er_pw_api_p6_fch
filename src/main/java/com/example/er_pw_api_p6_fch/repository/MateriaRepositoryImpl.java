package com.example.er_pw_api_p6_fch.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.er_pw_api_p6_fch.repository.model.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Transactional
@Repository
public class MateriaRepositoryImpl implements IMateriaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(Materia materia) {
        // TODO Auto-generated method stub
        this.entityManager.persist(materia);
    }

    @Override
    public void actialuzar(Materia materia) {
        // TODO Auto-generated method stub
        this.entityManager.merge(materia);
    }

    @Override
    public List<Materia> listar() {
        // TODO Auto-generated method stub
        TypedQuery <Materia> query = this.entityManager.createQuery("SELECT m FROM Materia m ORDER BY m.id", Materia.class);
        return query.getResultList();
    }

    @Override
    public void eliminar(Materia materia) {
        // TODO Auto-generated method stub
        this.entityManager.remove(materia);
    }

    @Override
    public Materia buscarPorCodigo(String codigo) {
        // TODO Auto-generated method stub
        TypedQuery <Materia> query = this.entityManager.createQuery("SELECT m FROM Materia m WHERE m.codigo = :codigo", Materia.class)
        .setParameter("codigo", codigo);
        return query.getSingleResult();
    }

}
