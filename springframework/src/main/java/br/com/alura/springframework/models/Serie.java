package br.com.alura.springframework.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "series")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @Enumerated(EnumType.STRING)
    private Categoria genero;

    private Integer totalTemporadas;
    private Double avaliacao;
    private String atores;
    private String poster;
    private String sinopse;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Episodio> episodios = new ArrayList<>();

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getTitulo () {
        return titulo;
    }

    public void setTitulo (String titulo) {
        this.titulo = titulo;
    }

    public Categoria getGenero () {
        return genero;
    }

    public void setGenero (Categoria genero) {
        this.genero = genero;
    }

    public Integer getTotalTemporadas () {
        return totalTemporadas;
    }

    public void setTotalTemporadas (Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public Double getAvaliacao () {
        return avaliacao;
    }

    public void setAvaliacao (Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getAtores () {
        return atores;
    }

    public void setAtores (String atores) {
        this.atores = atores;
    }

    public String getPoster () {
        return poster;
    }

    public void setPoster (String poster) {
        this.poster = poster;
    }

    public String getSinopse () {
        return sinopse;
    }

    public void setSinopse (String sinopse) {
        this.sinopse = sinopse;
    }

    public List<Episodio> getEpisodios () {
        return episodios;
    }

    @Override
    public String toString () {
        return
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero=" + genero +
                ", totalTemporadas=" + totalTemporadas +
                ", avaliacao=" + avaliacao +
                ", atores='" + atores + '\'' +
                ", poster='" + poster + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", episodios=" + episodios;
    }
}
