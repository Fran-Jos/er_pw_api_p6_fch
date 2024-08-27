package com.example.er_pw_api_p6_fch.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.er_pw_api_p6_fch.service.IMateriaService;
import com.example.er_pw_api_p6_fch.service.To.MateriaCompleta;
import com.example.er_pw_api_p6_fch.service.To.MateriaDTO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RequestMapping(path = "/materias")
@RestController
public class MateriaController {

    @Autowired
    private IMateriaService iMateriaService;

    // http://localhost:8082/API/v1.0/Matricula/materias
    @GetMapping(path = "/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MateriaCompleta> buscarPorCodigo(@PathVariable String codigo) {
        MateriaCompleta m = this.iMateriaService.buscarPorCodigo(codigo);
        return ResponseEntity.ok().body(m);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MateriaDTO>> listar() {
        List<MateriaDTO> materias = this.iMateriaService.listar();
        for (MateriaDTO materiaDTO : materias) {

            Link link = linkTo(methodOn(MateriaController.class).buscarPorCodigo(materiaDTO.getCodigo()))
            .withRel("MateriaCompletas");
            materiaDTO.add(link);
        }
        return ResponseEntity.ok().body(materias);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MateriaCompleta> guardar(@RequestBody MateriaCompleta materiaCompleta) {
        this.iMateriaService.guardar(materiaCompleta);
        MateriaCompleta m = this.iMateriaService.buscarPorCodigo(materiaCompleta.getCodigo());
        return ResponseEntity.ok().body(m);

    }

    @PutMapping(path = "/{codigo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MateriaCompleta> actualizar(@PathVariable String codigo,
            @RequestBody MateriaCompleta materiaCompleta) {

        MateriaCompleta materiaActualizada = this.iMateriaService.buscarPorCodigo(codigo);
        materiaActualizada.setCodigo(codigo);
        materiaActualizada.setCreditos(materiaCompleta.getCreditos());
        materiaActualizada.setDescripcion(materiaCompleta.getDescripcion());
        materiaActualizada.setNombre(materiaCompleta.getNombre());
        this.iMateriaService.actialuzar(materiaActualizada);

        return ResponseEntity.ok().body(materiaActualizada);
    }

    @DeleteMapping(path = "/{codigo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> eliminar(@PathVariable String codigo) {
        this.iMateriaService.eliminar(codigo);
        String msj = "Se ha eliminado ";
        return ResponseEntity.ok().body(msj);
    }

}
