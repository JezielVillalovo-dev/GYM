package com.gym.controller;

import com.gym.entity.usuario;
import com.gym.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UsuarioController {
private final UsuarioService service;
    @GetMapping
    public List<usuario> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public usuario obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public usuario crear(@RequestBody usuario datos) {
        return service.crear(datos);
    }

    @PutMapping("/{id}")
    public usuario actualizar(@PathVariable Long id, @RequestBody usuario datos) {
        return service.actualizar(id, datos);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
