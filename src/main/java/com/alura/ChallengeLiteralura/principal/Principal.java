package com.alura.ChallengeLiteralura.principal;

import com.alura.ChallengeLiteralura.repository.LibroRepository;

import java.util.Scanner;

public class Principal {
    //private LibroRepository repositorio;
    private int a;
    private Scanner teclado = new Scanner(System.in);

    public Principal() {
        this.a = 1;
        //this.repositorio = repository;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar Libro por Título (Importar)
                    2 - Listar Libros Registrados
                    3 - Listar Autores Registrados
                    4 - Listar Autores Vivos en Años Especifico
                    5 - Listar Libros por Idioma
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1:
                    buscarLibroApi();
                    break;
                case 2:
                    listarLibros();
                    break;
                case 3:
                    listarAutores();
                    break;
                case 4:
                    listarAutoresVivos();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                case 0:
                    System.out.println("###CERRANDO LA APLICACION###");
                    break;
                default:
                    System.out.println("Opcion Invalida");
            }
        }
    }

    private void buscarLibroApi() {
        System.out.println("a");
    }

    private void listarLibros() {
        System.out.println("a");

    }

    private void listarAutores() {
        System.out.println("a");

    }

    private void listarAutoresVivos() {
        System.out.println("a");

    }

    private void listarLibrosPorIdioma() {
        System.out.println("a");

    }
}
