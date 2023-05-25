package libreria;

import java.util.InputMismatchException;
import java.util.Scanner;
import libreria.servicios.AutorServicios;

public class Libreria {

    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);
        AutorServicios as = new AutorServicios();
        char eleccion;
        do {
            System.out.println("=========================================");
            System.out.println("SELECCIONE UNA DE LAS SIGUIENTES OPCIONES");
            System.out.println("=========================================");
            System.out.println("              SECCION AUTOR              ");
            System.out.println("=========================================");
            System.out.println("a) Dar de alta un nuevo autor");
            System.out.println("b) Dar de baja un autor por id");
            System.out.println("c) Dar de baja un autor por nombre");
            System.out.println("d) Buscar autor por nombre");

            eleccion = leer.next().toLowerCase().charAt(0);
            switch (eleccion) {
                case 'a':
                    as.nuevoAutor();
                    break;

                case 'b':
                    try {  
                        System.out.println("ingrese el codigo");
                        int codigo = leer.nextInt();
                        leer.nextLine();
                        as.eliminarAutorPorCodigo(codigo);
                    } catch (InputMismatchException e) {
                        System.out.println("Opción no valida");
                    }
                    break;
                case 'c':
                    
                    System.out.println("Ingrese el nombre");
                    String nombreAutor = leer.nextLine();
                    as.eliminarAutorPorNombre(nombreAutor);
                    
                    break;
                case 'd':
                    System.out.println("Ingrese el nombre");
                    String nombre = leer.nextLine();
                    as.buscarAutorPorNombre(nombre);
                    break;

                default:
                    throw new AssertionError();
            }
        } while (eleccion != 'z');
    }

}
