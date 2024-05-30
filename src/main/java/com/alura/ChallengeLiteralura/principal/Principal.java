package com.alura.ChallengeLiteralura.principal;

import com.alura.ChallengeLiteralura.model.*;
import com.alura.ChallengeLiteralura.repository.LibroRepository;
import com.alura.ChallengeLiteralura.service.ConsumoAPI;
import com.alura.ChallengeLiteralura.service.ConvierteDatos;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI api = new ConsumoAPI();
    private ConvierteDatos consersor = new ConvierteDatos();
    private LibroRepository repository;

    public Principal(LibroRepository repository) {
        this.repository = repository;
    }

    public void muestraElMenu() throws InterruptedException, JsonProcessingException {
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

    private void buscarLibroApi() throws InterruptedException, JsonProcessingException {
        System.out.println("Ingrese el Titulo del Libro: ");
        var titulo = teclado.nextLine(); //?search=the%20tragedy%20of%20romeo%20and%20juliet
        try {
            var url = URLEncoder.encode(titulo, "UTF-8");
            var json = api.obtenerDatos(URL_BASE + "?search=" + url.toLowerCase());
            RespuestaApi datos = consersor.obtenerDatos(json, RespuestaApi.class);

            if (!datos.resultados().isEmpty()){
                String libroStringJson = consersor.convertirAStringJson(datos.resultados().get(0));
                DatosLibro datoslibro = consersor.obtenerDatos(libroStringJson, DatosLibro.class);
                Libro libro = new Libro(datoslibro);
                System.out.println(libro);
                repository.save(libro);
                return;
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (DataIntegrityViolationException e) {
            System.out.println("Ya se encuentra registrado");
            return;
        }

        System.out.println("No se encontro el titulo");
    }

    private void listarLibros() {
        repository.findAll().forEach(System.out::println);
    }

    private void listarAutores() {
        List<Libro> listaDeLibros = repository.findAll();
        Set<String> listaDeAutoresUnicos = new HashSet<>();
        listaDeLibros.forEach(s -> {
            if (listaDeAutoresUnicos.add(s.getAutor().getAutor())) {
                System.out.println(s.getAutor().toString());
            }
        });
    }

    private void listarAutoresVivos() {
        System.out.println("Ingrese el Año para Buscar Autores:");
        Integer fecha = teclado.nextInt();
        teclado.nextLine();
        repository.autorEnELRangoDeFecha(fecha).forEach(System.out::println);
    }

    private void listarLibrosPorIdioma() {
        Idioma.getIdiomas();
        System.out.println("Ingrese el Idioma Para Filtrar");
        var entradaDeIdioma = teclado.nextLine();
        var idioma = Idioma.idiomaExtendido(entradaDeIdioma);
        repository.findByIdioma(idioma).forEach(System.out::println);

    }
}
