package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.dto.PetDto;
import br.com.alura.adopet.api.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<PetDto>> listarTodosDisponiveis() {
        return ResponseEntity.status(HttpStatus.OK).body(petService.listarPetsDisponiveis());
    }
}
