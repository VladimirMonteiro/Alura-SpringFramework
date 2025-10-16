package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.dto.RegisterTutorDto;
import br.com.alura.adopet.api.dto.UpdateTutorDto;
import br.com.alura.adopet.api.services.TutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar (@RequestBody @Valid RegisterTutorDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tutorService.cadastrar(dto));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> atualizar (@RequestBody @Valid UpdateTutorDto dto) {
        return ResponseEntity.ok().body(tutorService.update(dto));
    }
}
