package com.gym.controller;

import com.gym.entity.InscripcionClase;
import com.gym.service.InscripcionClaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones-clase")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class InscripcionClaseController {
    private final InscripcionClaseService service;
    @GetMapping
    public List<InscripcionClase> obtenerTodos() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public InscripcionClase obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InscripcionClase crear(@RequestBody InscripcionClase datos) {
        return service.crear(datos);
    }

    @PutMapping("/{id}")
    public InscripcionClase actualizar(@PathVariable Long id, @RequestBody InscripcionClase datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

}
