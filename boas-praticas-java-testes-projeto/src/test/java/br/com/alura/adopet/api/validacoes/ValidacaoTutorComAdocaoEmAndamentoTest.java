package br.com.alura.adopet.api.validacoes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.TutorRepository;

@ExtendWith(MockitoExtension.class)
class ValidacaoTutorComAdocaoEmAndamentoTest {

    @InjectMocks
    private ValidacaoTutorComAdocaoEmAndamento validacao;

    @Mock
    private AdocaoRepository adocaoRepository;

    @Mock
    private TutorRepository tutorRepository;

    @Mock
    private SolicitacaoAdocaoDto dto;

    @Mock
    private Adocao adocao;

    @Mock
    private Tutor tutor;

    @Test
    void shouldThrowValidacaoExceptionWhenTutorHasAdocaoAguardandoAvaliacao() {
        // ARRANGE
        when(adocaoRepository.findAll()).thenReturn(List.of(adocao));
        when(tutorRepository.getReferenceById(dto.idTutor())).thenReturn(tutor);
        when(adocao.getStatus()).thenReturn(StatusAdocao.AGUARDANDO_AVALIACAO);
        when(adocao.getTutor()).thenReturn(tutor);

        // ACT + ASSERT
        ValidacaoException exception = assertThrows(
            ValidacaoException.class,
            () -> validacao.validar(dto)
        );

        assertEquals("Tutor já possui outra adoção aguardando avaliação!", exception.getMessage());
    }

    @Test
    void shouldNotThrowValidacaoExceptionWhenTutorHasNoAdocaoAguardandoAvaliacao() {
        // ARRANGE
        when(adocaoRepository.findAll()).thenReturn(List.of(adocao));
        when(tutorRepository.getReferenceById(dto.idTutor())).thenReturn(tutor);
        when(adocao.getStatus()).thenReturn(StatusAdocao.APROVADO);
        when(adocao.getTutor()).thenReturn(tutor);

        // ACT + ASSERT
        assertDoesNotThrow(() -> validacao.validar(dto));
    }
}

