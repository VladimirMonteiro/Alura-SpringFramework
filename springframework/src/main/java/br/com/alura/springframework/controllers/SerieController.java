package br.com.alura.springframework.controllers;

import br.com.alura.springframework.dto.SerieDTO;
import br.com.alura.springframework.repositories.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/series", produces = "application/json")
public class SerieController {

    @Autowired
    private SerieRepository serieRepository;

    @GetMapping
    public List<SerieDTO> obterSeries () {
        return serieRepository.findAll()
                .stream().map(s -> new SerieDTO(s.getId(),
                        s.getTitulo(), s.getGenero(),
                        s.getTotalTemporadas(),
                        s.getAvaliacao(),
                        s.getAtores(),
                        s.getPoster(),
                        s.getSinopse())).toList();
    }

}
