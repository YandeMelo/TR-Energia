package com.yandemelo.TREnergia.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yandemelo.TREnergia.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    
}
