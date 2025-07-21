package com.project.back_linkpage.dto;

public record LinkResponseDTO(
        Long id,
        String titulo,
        String url,
        String usernameDono
) {}
