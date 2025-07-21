package com.project.back_linkpage.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
        @NotBlank(message = "Nome é obrigatório") String name,
        @NotBlank(message = "Username é obrigatório") String username,
        @Email(message = "Email inválido") String email,
        @NotBlank(message = "Senha é obrigatória") String password
) {}