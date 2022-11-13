package com.miniprojeto.miniprojeto.dto;

import com.miniprojeto.miniprojeto.Model.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
public class UsuarioDto {
    @NotBlank(message = "nome é obrigatório")
    private String nomeUsuario;
    @NotBlank(message = "email é obrigatório")
    @Email
    private String email;
    @NotBlank(message = "cpf é obrigatório")
    @CPF
    private String cpf;

    private Integer totalPontos;

    public UsuarioDto(String nomeUsuario, String cpf, String email, int totalPontos) {
        this.nomeUsuario = nomeUsuario;
        this.cpf = cpf;
        this.email = email;
        this.totalPontos = totalPontos;
    }

    public UsuarioModel transformaParaObjeto() {
        return new UsuarioModel( nomeUsuario, email, cpf);
    }
}

