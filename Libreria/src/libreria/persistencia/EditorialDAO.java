package libreria.persistencia;

import java.util.List;
import javax.persistence.Query;
import libreria.entidades.Editorial;

public class EditorialDAO extends DAO<Editorial>{

    @Override
    public void guardar(Editorial editorial) {
        super.guardar(editorial);
    }

    
    public Editorial buscarEditorialPorCodigo(int id) {

        conectar();
        Editorial editorial = em.find(Editorial.class, id);
        desconectar();
        return editorial;
    }

    public Editorial buscarEditorialPorNombre(String nombre) {     
        conectar();
        Query query = em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre");
        query.setParameter("nombre", nombre);
        Editorial editorial = (Editorial) query.getSingleResult();
        desconectar();
        return editorial;
    }

    public void bajaEditorialPorCodigo(int id) {
        Editorial editorial = buscarEditorialPorCodigo(id);
        editorial.setAlta(false);
        super.editar(editorial);
        System.out.println("La editorial "+editorial.toString()+" fue dada de baja");

    }

    public void bajaEditorialPorNombre(String nombre) {
        conectar();
        Query query = em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre");
        query.setParameter("nombre", nombre);
        Editorial editorial = (Editorial) query.getSingleResult();
        editorial.setAlta(false);
        super.editar(editorial);
        desconectar();
        System.out.println("El autor "+editorial.toString()+" fue dado de baja");

    }
    
        public void actualizarEditorialNombrePorCodigo(int codigo, String nuevoNombre){
        Editorial editorial = buscarEditorialPorCodigo(codigo);
        editorial.setNombre(nuevoNombre);
        super.editar(editorial);
    }

    public void actualizarEditorialNombre(String nombre, String nuevoNombre) {
        Editorial editorial = buscarEditorialPorNombre(nombre);
        editorial.setNombre(nuevoNombre);
        super.editar(editorial);
    }
    
        public List<Editorial> listarTodos() throws Exception {
        conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e")
                .getResultList();
        desconectar();
        return editoriales;
    }

}
