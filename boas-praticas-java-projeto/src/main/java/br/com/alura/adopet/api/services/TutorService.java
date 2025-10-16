package br.com.alura.adopet.api.services;

import br.com.alura.adopet.api.dto.RegisterTutorDto;
import br.com.alura.adopet.api.dto.UpdateTutorDto;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import br.com.alura.adopet.api.strategy.ValidacaoTutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private List<ValidacaoTutor> validacoes;

    public String cadastrar (RegisterTutorDto dto) {
        validacoes.forEach(v -> v.validar(dto));
        return "Tutor cadastrado com sucesso!";
    }

    public String update (UpdateTutorDto dto) {
        Tutor tutor = tutorRepository.getReferenceById(dto.tutorId());
        tutor.updateTutor(dto.nome(), dto.telefone(), dto.email());
        return "Tutor atualizado com sucesso!";
    }
}
