package com.yandemelo.TREnergia.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yandemelo.TREnergia.dto.UsuarioDTO;
import com.yandemelo.TREnergia.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody @Valid UsuarioDTO dto){
        dto = usuarioService.cadastrar(dto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/consultarId/{id}")
    public ResponseEntity<UsuarioDTO> consultarPorId(@PathVariable UUID id){
        UsuarioDTO dto = usuarioService.consultarPorId(id);
        return ResponseEntity.ok(dto);
    }

}
