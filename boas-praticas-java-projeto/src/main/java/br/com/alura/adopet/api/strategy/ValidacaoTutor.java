package br.com.alura.adopet.api.strategy;

import br.com.alura.adopet.api.dto.RegisterTutorDto;

public interface ValidacaoTutor {
    void validar(RegisterTutorDto dto);
}
