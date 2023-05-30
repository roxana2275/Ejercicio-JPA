
package libreria.persistencia;

import java.util.List;
import javax.persistence.Query;
import libreria.entidades.Libro;

public class LibroDAO extends DAO<Libro>{
    
    @Override
    public void guardar(Libro libro){
        super.guardar(libro);
    }
       public Libro buscarLibroPorCodigo(int id){
        Libro libro = em.find(Libro.class, id);
        return libro;
    }
    
    
    public Libro buscarLibroPorNombre(String nombre){
        conectar();
        Query query = em.createQuery("SELECT l FROM Libro l WHERE l.nombre = :nombre");
        query.setParameter("nombre", nombre);
        Libro libro = (Libro) query.getSingleResult();
        desconectar();
        return libro;
    }
    
    
    public void bajaLibroPorCodigo(int id){
        Libro libro = em.find(Libro.class, id);
        libro.setAlta(false);
        super.editar(libro);
        System.out.println("El libro "+libro.toString()+" fue dado de baja");
    }
    
    public void bajaLibroPorNombre(String nombre){
        conectar();
        Query query = em.createQuery("SELECT l FROM Libro l WHERE l.nombre = :nombre");
        query.setParameter("nombre", nombre);
        Libro libro = (Libro) query.getSingleResult();
        libro.setAlta(false);
        super.editar(libro);
        desconectar();
        System.out.println("El libro "+libro.toString()+" fue dado de baja");
    }

    
    public void actualizarLibroTituloPorCodigo(int id, String nuevoTitulo){
        Libro libro = buscarLibroPorCodigo(id);
        libro.setTitulo(nuevoTitulo);
        super.editar(libro);
    }
    
    public void actualizarLibroTituloPorNombre(String titulo, String nuevoTitulo){
        Libro libro = buscarLibroPorNombre(titulo);
        libro.setTitulo(nuevoTitulo);
        super.editar(libro);
    }
      
    public List<Libro> listarTodos() throws Exception {
        conectar();
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l")
                .getResultList();
        desconectar();
        return libros;
    }

}
