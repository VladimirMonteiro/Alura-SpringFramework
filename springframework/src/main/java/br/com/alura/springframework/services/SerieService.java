package br.com.alura.springframework.services;

import br.com.alura.springframework.dto.EpisodioDTO;
import br.com.alura.springframework.dto.SerieDTO;
import br.com.alura.springframework.models.Serie;
import br.com.alura.springframework.repositories.SerieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {

    private final SerieRepository serieRepository;

    public SerieService (SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }

    public List<SerieDTO> findAll() {
        return convertToSerieDTO(serieRepository.findAll());
    }

    public List<SerieDTO> getTop5Series () {
        return convertToSerieDTO(serieRepository.findTop5ByOrderByAvaliacaoDesc());
    }
    public List<SerieDTO> getLancamento () {
        return convertToSerieDTO(serieRepository.findTop5ByOrderByAvaliacaoDesc());
    }

    private List<SerieDTO> convertToSerieDTO (List<Serie> series) {
        return series.stream().map(s -> new SerieDTO(
                s.getId(),
                s.getTitulo(),
                s.getGenero(),
                s.getTotalTemporadas(),
                s.getAvaliacao(),
                s.getAtores(),
                s.getPoster(),
                s.getSinopse()
        )).collect(Collectors.toList());
    }

    public SerieDTO findById (Long id) {
        Optional<Serie> serie = serieRepository.findById(id);

        if (serie.isPresent()) {
            var s = serie.get();
            return new SerieDTO(s.getId(), s.getTitulo(), s.getGenero(), s.getTotalTemporadas(),
                    s.getAvaliacao(), s.getAtores(), s.getPoster(), s.getSinopse());
        }

        return null;
    }

    public List<EpisodioDTO> getAllTemporadas (Long id) {
        Optional<Serie> serie = serieRepository.findById(id);

        if (serie.isPresent()) {
            var s = serie.get();
            return s.getEpisodios().stream()
                    .map(e -> new EpisodioDTO(e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo())).toList();
        }

        return null;
    }

    public List<EpisodioDTO> getTemporadaById (Long id, Integer numero) {
        return serieRepository.getEpisodiosPorTemporada(id, numero).stream()
                .map(e -> new EpisodioDTO(e.getTemporada(), e.getNumeroEpisodio(), e.getTitulo())).toList();
    }
}
