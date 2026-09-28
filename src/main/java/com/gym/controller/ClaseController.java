package com.gym.controller;

import com.gym.entity.Clases;
import com.gym.service.ClaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ClaseController {
    private final ClaseService service;

    @GetMapping
    public List<Clases> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Clases obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Clases crear(@RequestBody Clases datos) {
        return service.crear(datos);
    }

    @PutMapping("/{id}")
    public Clases actualizar(@PathVariable Long id, @RequestBody Clases datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}

