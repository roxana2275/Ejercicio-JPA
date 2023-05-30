package libreria.servicios;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import javax.persistence.NoResultException;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;

public class EditorialServicios {

    private final EditorialDAO editorialDao;
    Scanner leer = new Scanner(System.in);

    public EditorialServicios() {
        this.editorialDao = new EditorialDAO();
    }

    public void nuevaEditorial() {

        System.out.println("Ingrese el nombre");
        String nombre = leer.nextLine();
        Editorial editorial = new Editorial();

        try {
            editorial = editorialDao.buscarEditorialPorNombre(nombre);
        } catch (NoResultException|NullPointerException en) {
            editorial.setNombre(nombre);
            editorial.setAlta(true);
            editorialDao.guardar(editorial);
            System.out.println("La editorial " + editorial.toString() + " fue guardada");
        }

    }

    public void buscarEditorialPorCodigo() {
        try {
            System.out.println("Ingrese el codigo de la editorial");
            int codigo = leer.nextInt();
            Editorial editorial = editorialDao.buscarEditorialPorCodigo(codigo);
            System.out.println(editorial.toString());
        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
        } catch (NoResultException|NullPointerException en) {
            System.out.println("No se encontraron coincidencias");
        }
    }

    public void buscarEditorialPorNombre() {
        try {
            System.out.println("Ingrese el nombre de la editorial");
            String nombre = leer.nextLine();
            Editorial editorial = editorialDao.buscarEditorialPorNombre(nombre);
            System.out.println(editorial.toString());
        } catch (NoResultException|NullPointerException en) {
            System.out.println("No se encontraron coincidencias");
        }
    }

    public Editorial devolverEditorialPorNombre() {
        Editorial editorial = new Editorial();
        try {
            System.out.println("Ingrese el nombre de la editorial");
            String nombre = leer.nextLine();
            editorial = editorialDao.buscarEditorialPorNombre(nombre);

        } catch (NoResultException|NullPointerException en) {
            System.out.println("No se encontraron coincidencias");
        }
        return editorial;
    }

    public void bajaEditorialPorCodigo() {
        try {
            System.out.println("Ingrese el codigo de la editorial");
            int codigo = leer.nextInt();
            editorialDao.bajaEditorialPorCodigo(codigo);
        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
        } catch (NoResultException|NullPointerException en) {
            System.out.println("No se encontraron coincidencias");
        }
    }

    public void cambiarEditorialNombrePorCodigo() {
        try {
            System.out.println("Ingrese el codigo de la Editorial");
            int codigo = leer.nextInt();
            leer.nextLine();
            System.out.println("Ingrese el nuevo nombre de la editorial");
            String nuvoNombre = leer.nextLine();
            Editorial editorial = editorialDao.buscarEditorialPorCodigo(codigo);
            editorialDao.actualizarEditorialNombrePorCodigo(codigo, nuvoNombre);
        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar un numero");
        } catch (NoResultException|NullPointerException en) {
            System.out.println("No se encontraron coincidencias");
        }
    }

    public void cambiarEditorialNombre() {
        try {
            System.out.println("Ingrese el nombre  de la editorial");
            String nombre = leer.nextLine();
            System.out.println("Ingrese el nuevo nombre de la editorial");
            String nuvoNombre = leer.nextLine();
            Editorial editorial = editorialDao.buscarEditorialPorNombre(nombre);
            editorialDao.actualizarEditorialNombre(nombre, nuvoNombre);
        } catch (NoResultException|NullPointerException en) {
            System.out.println("No se encontraron coincidencias");
        }
    }

    public void listarEditoriales() {
        List<Editorial> editoriales = new ArrayList<>();
        try {
            editoriales = editorialDao.listarTodos();
            for (Editorial editorial : editoriales) {
                System.out.println(editorial.toString());
            }

            if (editoriales.isEmpty()) {
                System.out.println("No hay editoriales cargadas");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
