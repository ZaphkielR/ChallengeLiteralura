package com.alura.ChallengeLiteralura.model;

import com.alura.ChallengeLiteralura.repository.LibroRepository;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @OneToOne(mappedBy = "libro", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Autor autor;
    @Enumerated(EnumType.STRING)
    private Idioma idioma;
    private Integer numeroDeDescargas;

    public Libro(){}

    public Libro(DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();
        this.idioma = Idioma.fromString(datosLibro.idiomas().get(0));
        this.numeroDeDescargas = datosLibro.numeroDeDescargas();
        this.autor = new Autor(datosLibro.autores().get(0));
        this.autor.setLibro(this);
    }

    @Override
    public String toString(){
        return "\n=== === === === === LIBRO === === === === ===\n" +
                "Titulo :: " + this.titulo + "\n" +
                "Autor :: " + this.autor.getAutor() + "\n" +
                "Idioma(s) :: " + this.idioma + "\n" +
                "Numero de Descargas :: "+ this.numeroDeDescargas + "\n" +
                "=== === === === === === === === === === ===\n";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Integer numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
