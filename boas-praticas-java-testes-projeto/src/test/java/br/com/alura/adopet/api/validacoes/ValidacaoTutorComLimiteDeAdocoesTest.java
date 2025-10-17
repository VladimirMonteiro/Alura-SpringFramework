package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ValidacaoTutorComLimiteDeAdocoesTest {

    @InjectMocks ValidacaoTutorComLimiteDeAdocoes validacao;

    @Mock
    private AdocaoRepository adocaoRepository;

    @Mock
    private TutorRepository tutorRepository;

    @Mock
    private Adocao adocao;

    @Mock
    private Tutor tutor;

    @Mock
    private SolicitacaoAdocaoDto dto;

    @Test
    void shouldThrowsValidacaoExceptionWhenTutorHave5Adopt() {
        // Arrange
        when(dto.idTutor()).thenReturn(1L);
        when(tutorRepository.getReferenceById(1L)).thenReturn(tutor);

        // Cria 5 mocks diferentes de Adocao
        List<Adocao> adocoes = java.util.stream.IntStream.range(0, 5)
                .mapToObj(i -> {
                    Adocao a = mock(Adocao.class);
                    when(a.getTutor()).thenReturn(tutor);
                    when(a.getStatus()).thenReturn(StatusAdocao.APROVADO);
                    return a;
                })
                .toList();

        when(adocaoRepository.findAll()).thenReturn(adocoes);

        // Act & Assert
        ValidacaoException e = assertThrows(ValidacaoException.class, () -> validacao.validar(dto));
        assertEquals("Tutor chegou ao limite máximo de 5 adoções!", e.getMessage());
    }

    @Test
    void shouldNotThrowsValidacaoExceptionWhenTutorHaveMinusOf5Adopt() {
        // Arrange
        when(dto.idTutor()).thenReturn(1L);
        when(tutorRepository.getReferenceById(1L)).thenReturn(tutor);

        // Cria 5 mocks diferentes de Adocao
        List<Adocao> adocoes = java.util.stream.IntStream.range(0, 3)
                .mapToObj(i -> {
                    Adocao a = mock(Adocao.class);
                    when(a.getTutor()).thenReturn(tutor);
                    when(a.getStatus()).thenReturn(StatusAdocao.APROVADO);
                    return a;
                })
                .toList();

        when(adocaoRepository.findAll()).thenReturn(adocoes);

        // Act & Assert
        assertDoesNotThrow(() -> validacao.validar(dto));
        assertEquals(3, adocoes.size() );
    }
}