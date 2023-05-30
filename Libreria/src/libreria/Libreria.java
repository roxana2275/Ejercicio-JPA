package libreria;

import java.util.Scanner;
import libreria.servicios.AutorServicios;
import libreria.servicios.EditorialServicios;
import libreria.servicios.LibroServicios;

public class Libreria {

    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);
        AutorServicios as = new AutorServicios();
        EditorialServicios es = new EditorialServicios();
        LibroServicios ls = new LibroServicios();
        char eleccion;
        do {
            System.out.println("=========================================");
            System.out.println("SELECCIONE UNA DE LAS SIGUIENTES OPCIONES");
            System.out.println("=========================================");
            System.out.println("a) Sección autor");
            System.out.println("b) Sección editorial");
            System.out.println("c) Seccion libro");
            System.out.println("d) Listados");
            System.out.println("z) Salir");
            eleccion = leer.next().toLowerCase().charAt(0);

            switch (eleccion) {

                case 'a':
                    System.out.println("=========================================");
                    System.out.println("              SECCION AUTOR              ");
                    System.out.println("=========================================");
                    System.out.println("a) Dar de alta un nuevo autor");
                    System.out.println("b) Buscar autor por codigo");
                    System.out.println("c) Buscar autor por nombre");
                    System.out.println("d) Dar de baja un autor por codigo");
                    System.out.println("e) Dar de baja un autor por nombre");
                    System.out.println("f) Cambiar nombre de autor buscando por codigo");
                    System.out.println("g) Cambiar nombre de autor buscando por nombre");
                    char eleccionA = leer.next().toLowerCase().charAt(0);
                    switch (eleccionA) {
                        //seccion Autor
                        case 'a':
                            as.nuevoAutor();
                            break;
                        case 'b':
                            as.buscarAutorPorCodigo();
                            break;
                        case 'c':
                            as.buscarAutorPorNombre();
                            break;
                        case 'd':
                            as.bajaAutorPorCodigo();
                            break;
                        case 'e':
                            as.bajaAutorPorNombre();
                            break;
                        case 'f':
                            as.cambiarAutorNombrePorCodigo();
                            break;
                        case 'g':
                            as.cambiarAutorNombre();
                            break;
                        default:
                            System.out.println("Opción no valida");
                            break;
                    }
                    break;
                case 'b':
                    System.out.println("=========================================");
                    System.out.println("            SECCION EDITORIAL            ");
                    System.out.println("=========================================");
                    System.out.println("a) Dar de alta una editorial");
                    System.out.println("b) Buscar editorial por codigo");
                    System.out.println("c) Buscar editorial por nombre");
                    System.out.println("d) Dar de baja una editorial por codigo");
                    System.out.println("e) Dar de baja una editorial por nombre");
                    System.out.println("f) Cambiar nombre de editorial buscando por codigo");
                    System.out.println("g) Cambiar nombre de editorial buscando por nombre");
                    char eleccionB = leer.next().toLowerCase().charAt(0);
                    switch (eleccionB) {

                        //seccion Editorial
                        case 'a':
                            es.nuevaEditorial();
                            break;
                        case 'b':
                            es.buscarEditorialPorCodigo();
                            break;
                        case 'c':
                            es.buscarEditorialPorNombre();
                            break;
                        case 'd':
                            es.bajaEditorialPorCodigo();
                            break;
                        case 'e':
                            es.buscarEditorialPorNombre();
                            break;
                        case 'f':
                            es.cambiarEditorialNombrePorCodigo();
                            break;
                        case 'g':
                            es.cambiarEditorialNombre();
                            break;
                        default:
                            System.out.println("Opción no valida");
                            break;
                    }
                    break;
                case 'c':
                    System.out.println("=========================================");
                    System.out.println("              SECCION LIBRO              ");
                    System.out.println("=========================================");
                    System.out.println("a) Dar de alta un libro");
                    System.out.println("b) Buscar libro por codigo");
                    System.out.println("c) Buscar libro por nombre");
                    System.out.println("d) Dar de baja un autor por codigo");
                    System.out.println("e) Dar de baja un autor por nombre");
                    System.out.println("f) Cabiar nombre de libro bucando por codigo");
                    System.out.println("g) Cabiar nombre de libro bucando por nombre");
                    char eleccionC = leer.next().toLowerCase().charAt(0);
                    switch (eleccionC) {
                        case 'a':
                            ls.nuevoAutorLibro();
                            break;
                        case 'b':
                            ls.buscarLibroPorCodigo();
                            break;
                        case 'c':
                            ls.buscarLibroPorNombre();
                            break;
                        case 'd':
                            ls.bajaLibroPorCodigo();
                            break;
                        case 'e':
                            ls.bajaLibroPorNombre();
                            break;
                        case 'f':
                            ls.cambiarLibroNombrePorCodigo();
                            break;
                        case 'g':
                            ls.cambiarLibroNombre();
                            break;

                        default:
                            System.out.println("Opción no valida");
                            break;
                    }
                    break;
                case 'd': {
                    System.out.println("=========================================");
                    System.out.println("              SECCION LISTA              ");
                    System.out.println("=========================================");
                    System.out.println("a) Lista de autores");
                    System.out.println("b) Lista de editoriales");
                    System.out.println("c) Lista de libros");
                    System.out.println("d) Lista de libros por autor");
                    System.out.println("e( Lista de libros por editorial");
                    char eleccionD = leer.next().toLowerCase().charAt(0);
                    switch (eleccionD) {
                        case 'a':
                            as.listarAutores();
                            break;
                        case 'b':
                            es.listarEditoriales();
                            break;
                        case 'c':
                            ls.listarLibros();
                            break;
                        case 'd':
                            ls.listaLibrosPorAutor();
                            break;
                        case 'e':
                            ls.listaLibrosPorEditorial();
                            break;
                        default:
                            System.out.println("Opción no valida");
                            break;
                    }

                }
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        } while (eleccion != 'z');
    }

}
