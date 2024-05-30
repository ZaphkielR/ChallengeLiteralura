package com.alura.ChallengeLiteralura.model;

import java.util.Arrays;
import java.util.List;

public enum Idioma {
    NATIVOAMERICANO("nai", "Nativo Americano"),
    ESPANOL("es", "Español"),
    INGLES("en", "Ingles"),
    FRANCES("fr", "Frances");

    private String idiomaApi;
    private String idiomaEspanol;

    Idioma (String idiomaApi, String idiomaEspanol) {
        this.idiomaApi = idiomaApi;
        this.idiomaEspanol = idiomaEspanol;
    }

    public static Idioma fromString(String text) {
        for (Idioma idioma : Idioma.values()) {
            if (idioma.idiomaApi.equalsIgnoreCase(text)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }

    public static Idioma idiomaExtendido(String text) {
        for (Idioma idioma : Idioma.values()) {
            if (idioma.idiomaEspanol.equalsIgnoreCase(text)) {
                return idioma;
            }
        }
        throw new IllegalArgumentException("Ninguna categoria encontrada: " + text);
    }

    public static void getIdiomas() {
        System.out.println("Los Idiomas Registrados Son:");
        for (Idioma idioma : Idioma.values()){
            System.out.print(idioma.idiomaEspanol + "   ");
        }
        System.out.println("\n");
    }

}
