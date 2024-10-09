package com.yandemelo.TREnergia.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/consultarCpf/{cpf}")
    public ResponseEntity<UsuarioDTO> consultarPorId(@PathVariable String cpf){
        UsuarioDTO dto = usuarioService.consultarPorCpf(cpf);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios(){
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable UUID id, @RequestBody @Valid UsuarioDTO dto){
        dto = usuarioService.atualizarUsuario(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable UUID id){
        usuarioService.excluirUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
