package br.com.alura.springframework.services;

import br.com.alura.springframework.dto.SerieDTO;
import br.com.alura.springframework.repositories.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    private final SerieRepository serieRepository;

    public SerieService (SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public List<SerieDTO> findAll() {
        return serieRepository.findAll().stream().map(s -> new SerieDTO(
                s.getId(),
                s.getTitulo(),
                s.getGenero(),
                s.getTotalTemporadas(),
                s.getAvaliacao(),
                s.getAtores(),
                s.getPoster(),
                s.getSinopse()
        )).toList();
    }
}
