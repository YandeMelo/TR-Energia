package com.yandemelo.TREnergia.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yandemelo.TREnergia.dto.UsuarioDTO;
import com.yandemelo.TREnergia.entities.Usuario;
import com.yandemelo.TREnergia.exceptions.ResourceNotFoundException;
import com.yandemelo.TREnergia.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public UsuarioDTO cadastrar(UsuarioDTO dto){
        Usuario usuario = new Usuario();
        copiarDtoParaEntity(dto, usuario);
        usuario = usuarioRepository.save(usuario);
        return new UsuarioDTO(usuario);
    }

    @Transactional(readOnly = true)
    public UsuarioDTO consultarPorId(UUID id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));
        return new UsuarioDTO(usuario);
    }

    private void copiarDtoParaEntity(UsuarioDTO dto, Usuario usuario){
        usuario.setNome(dto.getNome());
        usuario.setCpf(dto.getCpf());
        usuario.setIdade(dto.getIdade());
        usuario.setEndereco(dto.getEndereco());
        usuario.setCorFavorita(dto.getCorFavorita());
    }
}
