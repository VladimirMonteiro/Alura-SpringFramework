package br.com.alura.adopet.api.repository;

import br.com.alura.adopet.api.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Long> {

    @Query(value = "SELECT * FROM pets WHERE adotado = false", nativeQuery = true)
    List<Pet> getPetsAvailable();
}
