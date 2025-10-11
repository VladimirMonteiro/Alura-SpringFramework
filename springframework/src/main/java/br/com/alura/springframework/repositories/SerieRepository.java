package br.com.alura.springframework.repositories;

import br.com.alura.springframework.models.Episodio;
import br.com.alura.springframework.models.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SerieRepository extends JpaRepository<Serie, Long> {

    List<Serie> findTop5ByOrderByAvaliacaoDesc();

    List<Serie> findTop5ByOrderByEpisodiosDataLancamentoDesc();

    @Query("SELECT e FROM Serie s JOIN s.episodios e WHERE s.id = :id AND e.temporada = :numero")
    List<Episodio> getEpisodiosPorTemporada(Long id, Integer numero);
}
