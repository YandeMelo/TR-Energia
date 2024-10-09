package com.yandemelo.TREnergia.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.yandemelo.TREnergia.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    
    @Query("SELECT u FROM Usuario u WHERE u.cpf = :cpf")
    Usuario findByCpf(String cpf);

}
