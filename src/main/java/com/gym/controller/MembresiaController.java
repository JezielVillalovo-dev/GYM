package com.gym.controller;

import com.gym.entity.Membresia;
import com.gym.service.MembresiaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membresias")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class MembresiaController {
    private final MembresiaService service;
    @GetMapping
    public List<Membresia> listar()
    {
        return service.listar();
    }
    @GetMapping("/{id}")
    public Membresia obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Membresia crear(@RequestBody Membresia datos) {
        return service.crear(datos);
    }

    @PutMapping("/{id}")
    public Membresia actualizar(@PathVariable Long id, @RequestBody Membresia datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

}
