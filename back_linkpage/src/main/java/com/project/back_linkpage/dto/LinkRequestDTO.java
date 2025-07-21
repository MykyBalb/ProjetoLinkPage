package com.project.back_linkpage.dto;

import jakarta.validation.constraints.NotBlank;

public record LinkRequestDTO(
    @NotBlank(message = "Título é obrigatório") String titulo,
    @NotBlank(message = "URL é obrigatória") String url,
    Long userId
) {}
