package libreria.servicios;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import javax.persistence.NoResultException;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

public class AutorServicios {

    private final AutorDAO autorDao;
    Scanner leer = new Scanner(System.in);

    public AutorServicios() {
        this.autorDao = new AutorDAO();
    }

    public void nuevoAutor() {

        System.out.println("Ingrese el nombre del autor");
        String nombre = leer.nextLine();
        Autor autor = new Autor();

        try {
            autor = autorDao.buscarAutorPorNombre(nombre);
        } catch (NoResultException|NullPointerException en) {
            autor.setNombre(nombre);
            autor.setAlta(true);
            autorDao.guardar(autor);
            System.out.println("El autor " + autor.toString() + " fue guardado ");
        }
    }

    public void buscarAutorPorCodigo() {
        try {
            System.out.println("Ingrese el codigo del autor");
            int codigo = leer.nextInt();
            Autor autor = autorDao.buscarAutorPorCodigo(codigo);
            System.out.println(autor.toString());
        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
        } catch (NoResultException|NullPointerException en) {
            System.out.println("No se encontraron coincidencias");
        }

    }

    public void buscarAutorPorNombre() {
        try {
            System.out.println("Ingrese el nombre  del autor");
            String nombre = leer.nextLine();
            Autor autor = autorDao.buscarAutorPorNombre(nombre);
            System.out.println(autor.toString());
        } catch (NoResultException|NullPointerException en) {
            System.out.println("No se encontraron coincidencias");
        }
    }
    
    public Autor devolverAutorPorNombre(){
        Autor autor = new Autor();
        try {
            System.out.println("Ingrese el nombre del autor");
            String nombre = leer.nextLine();
            autor = autorDao.buscarAutorPorNombre(nombre);
            System.out.println(autor.toString());
        } catch (NoResultException|NullPointerException en) {
            System.out.println("No se encontraron coincidencias");
        }
        return autor;
    }

    public void bajaAutorPorCodigo() {
        try {
            System.out.println("Ingrese el codigo del autor");
            int codigo = leer.nextInt();
            autorDao.bajaAutorPorCodigo(codigo);
        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
        } catch (NoResultException|NullPointerException en) {
            System.out.println("No se encontraron coincidencias");
        }
    }

    public void bajaAutorPorNombre() {
        try {
            System.out.println("Ingrese el nombre del autor");
            String nombre = leer.nextLine();
            autorDao.bajaAutorPorNombre(nombre);
        } catch (NoResultException|NullPointerException en) {
            System.out.println("No se encontraron coincidencias");
        }
    }

    public void cambiarAutorNombrePorCodigo() {
        try {
            System.out.println("Ingrese el codigo del autor");
            int codigo = leer.nextInt();
            System.out.println("Ingrese el nuevo nombre del autor");
            String nuvoNombre = leer.nextLine();
            Autor autor = autorDao.buscarAutorPorCodigo(codigo);
            autorDao.actualizarAutorNombrePorCodigo(codigo, nuvoNombre);
        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
        } catch (NoResultException|NullPointerException en) {
            System.out.println("No se encontraron coincidencias");
        }
    }

    public void cambiarAutorNombre() {
        try {
            System.out.println("Ingrese el nombre del autor");
            String nombre = leer.nextLine();
            System.out.println("Ingrese el nuevo nombre del autor");
            String nuvoNombre = leer.nextLine();
            Autor autor = autorDao.buscarAutorPorNombre(nombre);
            autorDao.actualizarAutorNombre(nombre, nuvoNombre);
        } catch (NullPointerException en) {
            System.out.println("No se encontraron coincidencias");
        }
    }
    
        public void listarAutores() {
            List<Autor> autores = new ArrayList<>();
        try {
            autores = autorDao.listarTodos();
            for (Autor autore : autores) {
                System.out.println(autore.toString());
            }
            if(autores.isEmpty()){
                System.out.println("No hay autores cargados");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

}
