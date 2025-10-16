package br.com.alura.adopet.api.strategy;

import br.com.alura.adopet.api.dto.RegisterTutorDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoTelefoneTutor implements ValidacaoTutor {

    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public void validar (RegisterTutorDto dto) {
        boolean telefoneJaCadastrado = tutorRepository.existsByTelefone(dto.telefone());
        if (telefoneJaCadastrado) {
            throw new ValidacaoException("Dados já cadastrados para outro tutor!");
        }
    }
}
