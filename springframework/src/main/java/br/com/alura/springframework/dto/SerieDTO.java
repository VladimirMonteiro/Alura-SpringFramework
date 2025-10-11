package br.com.alura.springframework.dto;

import br.com.alura.springframework.models.Categoria;

public record SerieDTO(Long id,
                       String titulo,
                       Categoria genero,
                       Integer totalTemporadas,
                       Double avaliacao,
                       String atores,
                       String poster,
                       String sinopse) {
}
