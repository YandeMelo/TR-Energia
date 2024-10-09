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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @Operation(summary = "Cadastrar Usuário")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ok"),
        @ApiResponse(responseCode = "422", description = "Unprocessable Entity", content = @Content()),
        @ApiResponse(responseCode = "409", description = "Conflict", content = @Content())
    })
    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioDTO> cadastrarUsuario(@RequestBody @Valid UsuarioDTO dto){
        dto = usuarioService.cadastrar(dto);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Consultar Usuário por Id")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ok"),
        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content())
    })
    @GetMapping("/consultarId/{id}")
    public ResponseEntity<UsuarioDTO> consultarPorId(@PathVariable UUID id){
        UsuarioDTO dto = usuarioService.consultarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Consultar Usuário por Cpf")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ok"),
        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content())
    })
    @GetMapping("/consultarCpf/{cpf}")
    public ResponseEntity<UsuarioDTO> consultarPorId(@PathVariable String cpf){
        UsuarioDTO dto = usuarioService.consultarPorCpf(cpf);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Consultar Usuário por Id")
    @ApiResponse(responseCode = "200", description = "Ok")
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioDTO>> listarUsuarios(){
        List<UsuarioDTO> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @Operation(summary = "Atualizar Dados do Usuário")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Ok"),
        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content()),
        @ApiResponse(responseCode = "422", description = "Unprocessable Entity", content = @Content())
    })
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable UUID id, @RequestBody @Valid UsuarioDTO dto){
        dto = usuarioService.atualizarUsuario(id, dto);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Excluir Usuário")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "No Content"),
        @ApiResponse(responseCode = "404", description = "Not Found", content = @Content())
    })
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable UUID id){
        usuarioService.excluirUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
