package com.alura.challenge_libros.principal;

import com.alura.challenge_libros.model.*;
import com.alura.challenge_libros.repository.IAutorRepository;
import com.alura.challenge_libros.repository.ILibroRepository;
import com.alura.challenge_libros.service.ConsumoAPI;
import com.alura.challenge_libros.service.ConvierteDatos;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private Scanner scanner = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private final String URL_BASE= "http://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();
    private ILibroRepository repositorio;
    private IAutorRepository autorRepositorio;
    private List<Libro> librosBuscado;
    public Principal(ILibroRepository repository, IAutorRepository autorRepository) {
        this.repositorio = repository;
        this.autorRepositorio = autorRepository;
    }
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

    private List<DatosLibros> getDatosLibros() {
        System.out.println("Escribe el titulo del libro :");
        var tituloLibro = scanner.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ", "+"));
        System.out.println("Respuesta JSON de la API: " + json);

        // Convierte el JSON en un objeto Datos
        Datos respuesta = conversor.obtenerDatos(json, Datos.class);

        if (respuesta == null || respuesta.respuestaLibros() == null || respuesta.respuestaLibros().isEmpty()) {
            System.out.println("No se encontraron libros para el título ingresado.");
            return List.of();
        }
        return respuesta.respuestaLibros();

    }

    private void buscarLibroPorTitulo(){
        List<DatosLibros> librosDatos = getDatosLibros();

        if (librosDatos == null || librosDatos.isEmpty()) {
            System.out.println("No se encontraron libros para el título ingresado.");
            return;
        }

        for (DatosLibros datos : librosDatos) {
            if (datos.autor() == null || datos.autor().isEmpty()) {
                System.out.println("El libro '" + datos.titulo() + "' no tiene autores registrados.");
                continue;
            }
            // Toma el primer autor de la lista de autores
            DatosAutor datosAutor = datos.autor().get(0);

            // Crea el autor y el libro
            Autor autor = new Autor(datosAutor);
            Optional<Autor> autorExistente = autorRepositorio.findAuthorByNombre(autor.getNombre());
            if (autorExistente.isPresent()) {
                autor = autorExistente.get(); // Reutiliza el autor existente
            } else {
                autor = autorRepositorio.save(autor); // Guarda el autor si no existe
            }
            Libro libro = new Libro(datos, autor);
            repositorio.save(libro);
            System.out.println("Libro guardado: " + libro);
        }
    }

    private void listarLibrosRegistrados() {
        List<Libro> libros = repositorio.findAll();
        System.out.println(libros);

    }

    private void listAuthorsRegistered(){
        List<Autor> autores = autorRepositorio.findAll();
        System.out.println(autores);
    }

    private void listAuthorsByLivedYears(){
        System.out.println("ingresa el año en el que vivio el autor ");
        int anoAutor = scanner.nextInt();
        scanner.nextLine();

        if (anoAutor < 100 ){
            System.out.println("Ingresa un año valido");
            return;
        }

        List<Autor> autores = autorRepositorio.findAuthorBetweenYear(anoAutor);
        if (autores.isEmpty()){
            System.out.println("Nose encontraron autores vivos en la base de datos con el año :" + anoAutor);
        }else {
            autores.forEach(System.out::println);
        }

    }

    private void listBooksByIdioma(){
        System.out.println("""
                Ingrese el idioma a buscar:
                    ES -> Español
                    EN -> Inglés
                    FR -> Francés
                    PT -> Portugés
                """);
        String idiomaIngresado = scanner.nextLine().trim().toUpperCase();

        List<Libro> libroIdioma = repositorio.findBookByIdiomas(idiomaIngresado);

        if (libroIdioma.isEmpty()) {
            System.out.println("No se encontraron libros con el idioma: " + idiomaIngresado);
        } else {
            libroIdioma.forEach(System.out::println);
        }

    }


}
