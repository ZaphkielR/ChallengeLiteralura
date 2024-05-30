package com.alura.ChallengeLiteralura.repository;

import com.alura.ChallengeLiteralura.model.Autor;
import com.alura.ChallengeLiteralura.model.Idioma;
import com.alura.ChallengeLiteralura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long>{
    List<Libro> findByIdioma(Idioma idioma);
    @Query("SELECT a FROM Autor a WHERE (a.fechaNacimiento <= :fecha AND a.fechaMuerte >= :fecha) AND (a.fechaMuerte IS NOT NULL AND a.fechaMuerte >= :fecha)")
    List<Autor> autorEnELRangoDeFecha(Integer fecha);
}
