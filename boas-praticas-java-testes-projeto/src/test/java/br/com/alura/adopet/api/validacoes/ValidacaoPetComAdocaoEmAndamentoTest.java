package br.com.alura.adopet.api.validacoes;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;

@ExtendWith(MockitoExtension.class)
public class ValidacaoPetComAdocaoEmAndamentoTest {

    @InjectMocks
    private ValidacaoPetComAdocaoEmAndamento validacao;

    @Mock
    private AdocaoRepository adocaoRepository;

    @Mock
    private SolicitacaoAdocaoDto dto;

    @Test
    void shouldThrowValidacaoExceptionWhenAdoptingPet() {
        // ARRANGE
        when(adocaoRepository.existsByPetIdAndStatus(dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO)).thenReturn(true);

        // ASSERT + ACT
        ValidacaoException exception = assertThrows(ValidacaoException.class, () -> validacao.validar(dto));

        assertEquals(exception.getMessage(), "Pet já está aguardando avaliação para ser adotado!");
    }

    @Test
    void shouldNotThrowValidacaoExceptionWhenAdoptingPet() {
         // ARRANGE
        when(adocaoRepository.existsByPetIdAndStatus(dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO)).thenReturn(false);

        // ASSERT + ACT
       assertDoesNotThrow(() -> validacao.validar(dto));
    }
}
