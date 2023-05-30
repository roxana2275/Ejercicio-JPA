package libreria.persistencia;

import java.util.List;
import javax.persistence.Query;
import libreria.entidades.Autor;

public class AutorDAO extends DAO<Autor> {

    @Override
    public void guardar(Autor autor){
        try{
        super.guardar(autor);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public Autor buscarAutorPorCodigo(int id) {
        Autor autor = em.find(Autor.class, id);
        return autor;
    }

    public Autor buscarAutorPorNombre(String nombre) {     
        conectar();
        Query query = em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre");
        query.setParameter("nombre", nombre);
        Autor autor = (Autor) query.getSingleResult();
        desconectar();
        return autor;
    }

    public void bajaAutorPorCodigo(int id){
        Autor autor = em.find(Autor.class, id);
        autor.setAlta(false);
        super.editar(autor);
        System.out.println("El autor "+autor.toString()+" fue dado de baja");  
    }

    public void bajaAutorPorNombre(String nombre) {
        conectar();
        Query query = em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre");
        query.setParameter("nombre", nombre);
        Autor autor = (Autor) query.getSingleResult();
        autor.setAlta(false);
        super.editar(autor);
        desconectar();
        System.out.println("El autor "+autor.toString()+" fue dado de baja");

    }

    public void actualizarAutorNombrePorCodigo(int codigo, String nuevoNombre){
        Autor autor = buscarAutorPorCodigo(codigo);
        autor.setNombre(nuevoNombre);
        super.editar(autor);
    }
    public void actualizarAutorNombre(String nombre, String nuevoNombre) {
        Autor autor = buscarAutorPorNombre(nombre);
        autor.setNombre(nuevoNombre);
        super.editar(autor);
    }
    
    
    public List<Autor> listarTodos() throws Exception {
        conectar();
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a")
                .getResultList();
        desconectar();
        return autores;
    }
    


}
