package com.yandemelo.TREnergia.dto;

import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import com.yandemelo.TREnergia.entities.Usuario;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    
    private UUID id;
    
    @NotBlank(message = "O nome não pode estar vazio!")
    private String nome;
    
    @CPF(message = "Formato inválido ou Cpf não existe!")
    @NotBlank(message = "O cpf não pode estar vazio!")
    private String cpf;
    
    @Min(value = 18, message = "Usuário deve ser maior de idade!")
    @NotNull(message = "A idade não pode estar vazia!")
    private int idade;
    
    @NotBlank(message = "O endereço não pode estar vazio!")
    private String endereco;
    
    @NotBlank(message = "A cor favoria não pode estar vazia!")
    private String corFavorita;
    
    public UsuarioDTO(Usuario usuario) {
        id = usuario.getId();
        nome = usuario.getNome();
        cpf = usuario.getCpf();
        idade = usuario.getIdade();
        endereco = usuario.getEndereco();
        corFavorita = usuario.getCorFavorita();
    }
}
