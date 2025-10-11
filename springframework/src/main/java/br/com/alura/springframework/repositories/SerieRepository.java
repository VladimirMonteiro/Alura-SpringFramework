package br.com.alura.springframework.repositories;

import br.com.alura.springframework.models.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SerieRepository extends JpaRepository<Serie, Long> {

    List<Serie> findTop5ByOrderByAvaliacaoDesc();

    List<Serie> findTop5ByOrderByEpisodiosDataLancamentoDesc();
}
