package com.example.cadastro1.application.service;

import com.example.cadastro1.domain.entity.Usuario;
import com.example.cadastro1.domain.repository.UsuarioRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UsuarioService {
    final UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(UUID id) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if(usuarioOpt.isPresent()) {
            return  usuarioOpt.get();
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario update(UUID id, Usuario usuario) {
        Usuario usuarioExistente = findById(id);
        usuarioExistente.setNome(usuario.getNome());
        usuarioExistente.setCpf(usuario.getCpf());
        usuarioExistente.setEmail(usuario.getEmail());

        return usuarioRepository.save(usuarioExistente);
    }

    public void delete(UUID id) {
        usuarioRepository.delete(findById(id));
    }
}

