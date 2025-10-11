package br.com.alura.springframework.repositories;

import br.com.alura.springframework.models.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<Serie, Long> {
}
