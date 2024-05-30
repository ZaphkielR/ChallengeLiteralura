package com.alura.ChallengeLiteralura.model;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String autor;
    private Integer fechaNacimiento;
    private Integer fechaMuerte;
    @OneToOne
    private Libro libro;

    public Autor(){}

    public Autor(DatosAutor datosAutor){
        this.autor = datosAutor.autor();
        this.fechaNacimiento = datosAutor.fechaNacimiento();
        this.fechaMuerte = datosAutor.fechaMuerte();

    }

    @Override
    public String toString(){
        return "\n=== === === === === AUTOR === === === === ===\n" +
                "Autor :: " + this.autor + "\n" +
                "Fecha de Nacimiento :: " + this.fechaNacimiento + "\n" +
                "Fecha de Muerte :: " + this.fechaMuerte + "\n" +
                "=== === === === === === === === === === ===\n";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getFechaMuerte() {
        return fechaMuerte;
    }

    public void setFechaMuerte(Integer fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}
