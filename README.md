# Proyecto de Gestión de Libros

Este proyecto consiste en una aplicación de consola que interactúa con la API de **Gutenberg** para obtener información sobre libros, autores y sus idiomas. Los datos obtenidos se guardan en una base de datos y se pueden consultar de forma local.

## Funcionalidades

La aplicación permite realizar las siguientes acciones:

1. **Buscar libro por título**: Permite buscar un libro utilizando su título y guardarlo en la base de datos.
2. **Listar libros registrados**: Muestra todos los libros que han sido registrados en la base de datos.
3. **Listar autores registrados**: Muestra todos los autores que están asociados con los libros registrados.
4. **Listar autores vivos en un determinado año**: Permite consultar autores que estuvieron vivos durante un año específico.
5. **Listar libros por idioma**: Muestra todos los libros que están registrados en un idioma específico.

## Requisitos

- **Java 11 o superior**: Asegúrate de tener instalado Java 11 o una versión posterior.
- **Base de datos**: El proyecto utiliza **JPA** para interactuar con la base de datos. Asegúrate de tener configurada la base de datos con las tablas correspondientes.
