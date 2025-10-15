package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.TipoPet;

public record PetDto(Long id,
                     TipoPet tipoPet,
                     String nome,
                     String raca,
                     Integer idade,
                     String cor,
                     Float peso) {
}
