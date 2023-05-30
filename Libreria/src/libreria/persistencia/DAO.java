package libreria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO<T> {

    protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    protected EntityManager em = emf.createEntityManager();

    protected void conectar() {
        if (!em.isOpen()) {
            em = emf.createEntityManager();
        }
    }

    protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }

    protected void guardar(T object) {
        conectar();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        desconectar();
    }

    protected void editar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
    }


    protected void eliminar(T objeto) {
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }
   /* 
    protected void eliminarPorNombre(Class<T> type, String nombre){
        conectar();
        T object;
        em.getTransaction().begin();
        object = em.find(type, nombre);
        em.remove(object);
        em.getTransaction().commit();
        desconectar();
    }

    protected T buscarPorNombre(Class<T> type, String nombre) {
        conectar();
        T object;
        em.getTransaction().begin();
        object = em.find(type, nombre);
        em.getTransaction().commit();
        desconectar();
        return object;
    }

        protected T buscarPorCodigo(Class<T> type, int id) {
        conectar();
        T object;
        em.getTransaction().begin();
        object = em.find(type, id);
        em.getTransaction().commit();
        desconectar();
        return object;
    }
*/
}
