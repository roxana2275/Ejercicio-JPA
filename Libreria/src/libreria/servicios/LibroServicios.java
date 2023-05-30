package libreria.servicios;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import javax.persistence.NoResultException;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.LibroDAO;

public class LibroServicios {

    private final LibroDAO libroDao;
    Scanner leer = new Scanner(System.in);
    AutorServicios as = new AutorServicios();
    EditorialServicios es = new EditorialServicios();

    public LibroServicios() {
        this.libroDao = new LibroDAO();
    }

    public void nuevoAutorLibro() throws Exception {
        Libro libro = new Libro();
        libro.setAlta(true);

        try {
            System.out.println("Ingrese el anio");
            int anio = leer.nextInt();
            libro.setAnio(anio);
            System.out.println("Ingrese la cantidad de ejemplares");
            int ejemplares = leer.nextInt();
            leer.nextLine();
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(0);
            libro.setEjemplaresRestantes(ejemplares);

        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
        }

        System.out.println("Ingrese el nombre del libro");
        String nombre = leer.nextLine();
        libro.setTitulo(nombre);

        Autor autor = new Autor();

        try {
            do{
            autor = as.devolverAutorPorNombre();
            if (autor.getNombre() == null) {
                System.out.println("El autor no existe, primero debe ingresarlo");
                as.nuevoAutor();
            } else {
                if (autor.getAlta() == false) {
                    autor.setAlta(true);
                }

            }
            }while(autor.getNombre()==null);
            libro.setAutor(autor);
        } catch (Exception e) {
            e.getStackTrace();
        }

        Editorial editorial = new Editorial();

        try {
            do{
            editorial = es.devolverEditorialPorNombre();
            if (editorial.getNombre() == null) {
                System.out.println("La editorial no existe, primero debe ingresarla");
                es.nuevaEditorial();
            } else {
                if (editorial.getAlta() == false) {
                    autor.setAlta(true);
                }
            }
            }while(editorial.getNombre()==null);
            libro.setEditorial(editorial);
        } catch (Exception e) {
            e.getStackTrace();
        }

        try {
            int contador = 0;
            List<Libro> libros = new ArrayList<>();
            libros = libroDao.listarTodos();
            for (Libro libro1 : libros) {
                if (libro1.getTitulo() == libro.getTitulo()
                        && libro1.getAutor() == libro.getAutor()
                        && libro1.getEditorial() == libro.getEditorial()
                        && libro1.getAnio() == libro.getAnio()) {
                    contador++;
                    System.out.println("El libro ya existe debe cargar mas ejemplares");
                    break;
                }
            }
            if (contador == 0) {
                libroDao.guardar(libro);
                System.out.println("El libro " + libro.toString() + " fue guardado ");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    public void buscarLibroPorCodigo() {
        try {
            System.out.println("Ingrese el codigo");
            int codigo = leer.nextInt();
            Libro libro = libroDao.buscarLibroPorCodigo(codigo);
            System.out.println(libro.toString());
        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
        } catch (NoResultException | NullPointerException en) {
            System.out.println("No se encontraron coincidencias");
        }

    }

    public void buscarLibroPorNombre() {
        try {
            System.out.println("Ingrese el nombre");
            String nombre = leer.nextLine();
            Libro libro = libroDao.buscarLibroPorNombre(nombre);
            System.out.println(libro.toString());
        } catch (NoResultException | NullPointerException en) {
            System.out.println("No se encontraron coincidencias");
        }
    }

    public void bajaLibroPorCodigo() {
        try {
            System.out.println("Ingrese el codigo");
            int codigo = leer.nextInt();
            libroDao.bajaLibroPorCodigo(codigo);
        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
        } catch (NoResultException | NullPointerException en) {
            System.out.println("No se encontraron coincidencias");
        }
    }

    public void bajaLibroPorNombre() {
        try {
            System.out.println("Ingrese el nombre");
            String nombre = leer.nextLine();
            libroDao.bajaLibroPorNombre(nombre);
        } catch (NoResultException | NullPointerException en) {
            System.out.println("No se encontraron coincidencias");
        }
    }

    public void cambiarLibroNombrePorCodigo() {
        try {
            System.out.println("Ingrese el codigo del libro");
            int codigo = leer.nextInt();
            System.out.println("Ingrese el nuevo nombre");
            String nuvoNombre = leer.nextLine();
            Libro libro = libroDao.buscarLibroPorCodigo(codigo);
            libroDao.actualizarLibroTituloPorCodigo(codigo, nuvoNombre);
        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
        } catch (NoResultException | NullPointerException en) {
            System.out.println("No se encontraron coincidencias");
        }
    }

    public void cambiarLibroNombre() {
        try {
            System.out.println("Ingrese el nombre del libro");
            String nombre = leer.nextLine();
            System.out.println("Ingrese el nuevo nombre");
            String nuvoNombre = leer.nextLine();
            Libro libro = libroDao.buscarLibroPorNombre(nombre);
            libroDao.actualizarLibroTituloPorNombre(nombre, nuvoNombre);
        } catch (NoResultException | NullPointerException en) {
            System.out.println("No se encontraron coincidencias");
        }
    }

    public void listarLibros() {
        List<Libro> libros = new ArrayList<>();
        try {
            libros = libroDao.listarTodos();
            for (Libro libro : libros) {
                System.out.println(libro.toString());
            }
            if (libros.isEmpty()) {
                System.out.println("No hay libros cargados");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void listaLibrosPorAutor() throws Exception{
        List<Libro> libros = new ArrayList<>();
        System.out.println("Ingrese el nombre del autor");
        String nombre = leer.nextLine();
        libros = libroDao.listarTodos();
        try{
            for (Libro libro : libros) {
                if(libro.getAutor().getNombre() == null ? nombre == null : libro.getAutor().getNombre().equals(nombre)){
                    System.out.println(libro);
                }
            }  
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
        public void listaLibrosPorEditorial() throws Exception{
        List<Libro> libros = new ArrayList<>();
        System.out.println("Ingrese el nombre de la editorial");
        String nombre = leer.nextLine();
        libros = libroDao.listarTodos();
        try{
            for (Libro libro : libros) {
                if(libro.getEditorial().getNombre()==null ? nombre==null : libro.getEditorial().getNombre().equals(nombre)){
                    System.out.println(libro);
                }
            }
            
        }catch (Exception e) {
            System.out.println(e);
        }
    }

}
