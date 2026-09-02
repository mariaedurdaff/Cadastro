package com.example.cadastro1.interface_ui.controller;

import com.example.cadastro1.application.service.UsuarioService;
import com.example.cadastro1.domain.repository.UsuarioRepository;
import com.example.cadastro1.domain.entity.Usuario;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    final UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listarTodosUsuarios() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable UUID id) {
        return usuarioService.findById(id);
    }
    @PostMapping
    public Usuario cadastrarUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable UUID id, @Valid @RequestBody Usuario usuario) {
        return usuarioService.update(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable UUID id) {
        usuarioService.delete(id);
    }
}