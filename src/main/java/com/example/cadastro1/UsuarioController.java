package com.example.cadastro1;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    ArrayList<Usuario> usuarios = new ArrayList<>();

    @GetMapping
    public ArrayList<Usuario> listarTodosUsuarios() {
        return usuarios;
    }

    @PostMapping
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        usuarios.add(usuario);
        return usuarios.getLast();
    }
}
