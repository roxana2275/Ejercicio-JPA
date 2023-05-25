
package libreria.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DAO<T> {
    
    protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    protected EntityManager em = emf.createEntityManager();
    
    protected void conectar(){
        if(!em.isOpen()){
            em = emf.createEntityManager();
        }
    }
    
    protected void desconectar(){
        if(em.isOpen()){
            em.close();
        }
    }
    
   
    protected void guardar (T object){
        conectar();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        desconectar();
    }
    
    protected void editar(T objeto){
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        desconectar();
    }

    protected void eliminar(T objeto){
        conectar();
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }
    
    protected void buscar(T objeto){
        conectar();
        em.find(type, em);
    }
}
