package com.alura.challenge_libros.principal;

import com.alura.challenge_libros.model.Datos;
import com.alura.challenge_libros.service.ConsumoAPI;
import com.alura.challenge_libros.service.ConvierteDatos;

import java.util.Scanner;

public class Principal {

    private Scanner scanner = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE= "http://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();
    public void mostrarMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    ***************
                    Elige la opcion a través de su número:
                    1 - Buscar libro por titulo 
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - listar libros por idioma
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listAuthorsRegistered();
                    break;
                case 4:
                    listAuthorsByLivedYears();
                    break;
                case 5:
                    listBooksByIdioma();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }


    }

    private void buscarLibroPorTitulo() {

    }

    private void listarLibrosRegistrados() {
    }

    private void listAuthorsRegistered(){

    }

    private void listAuthorsByLivedYears(){

    }

    private void listBooksByIdioma(){

    }


}
