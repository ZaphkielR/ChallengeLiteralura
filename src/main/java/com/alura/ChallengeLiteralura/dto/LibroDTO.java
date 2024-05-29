package com.alura.ChallengeLiteralura.dto;

public record LibroDTO(
        Long id,
        String titulo,
        String autor,
        String idioma,
        Integer numeroDeDescargas
) {
}
