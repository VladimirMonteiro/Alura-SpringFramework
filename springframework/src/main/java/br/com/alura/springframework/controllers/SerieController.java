package br.com.alura.springframework.controllers;

import br.com.alura.springframework.dto.SerieDTO;
import br.com.alura.springframework.repositories.SerieRepository;
import br.com.alura.springframework.services.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/series", produces = "application/json")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @GetMapping
    public List<SerieDTO> obterSeries () {
       return serieService.findAll();
    }

    @GetMapping("/top5")
    public List<SerieDTO> getTop5Series(){
        return serieService.getTop5Series();
    }

    @GetMapping("/lancamentos")
    public List<SerieDTO> getLancamentos() {
        return serieService.getLancamento();
    }

    @GetMapping("/{id}")
    public SerieDTO findById(@PathVariable("id") Long id) {
        return serieService.findById(id);
    }

}
