package com.lucca.clientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public record ClientRequestDTO(
        @CPF(message = "o CPF informado é inválido")
        @NotBlank(message = "o CPF é obrigatório")
        String cpf,

        @NotBlank(message = "o nome é obrigatório")
        String nome,

        @Pattern(regexp = "^\\d{10,11}$", message = "Telefone deve estar no formato XX9XXXXXXXX")
        @NotBlank(message = "o telefone é obrigatório")
        String telefone,

        @Email(message = "formato de e-mail inválido")
        @NotBlank(message = "e-mail é obrigatório")
        String email,

        List<String> vehicles
) {
}
