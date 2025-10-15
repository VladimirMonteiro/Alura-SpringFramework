package br.com.alura.adopet.api.services;

import br.com.alura.adopet.api.dto.PetDto;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public List<PetDto> listarPetsDisponiveis () {
        List<Pet> pets = petRepository.getPetsAvailable();
        return pets.stream().map(p -> new PetDto
                (p.getId(), p.getTipo(), p.getNome(), p.getRaca(), p.getIdade(), p.getCor(), p.getPeso())).toList();
    }
}
