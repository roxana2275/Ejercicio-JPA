package libreria.persistencia;

import libreria.entidades.Autor;

public class AutorDAO extends DAO<Autor> {

    @Override
    public void guardar(Autor autor){
        try{
            super.guardar(autor);
            System.out.println("El autor fue guardado");
        }catch(Exception e){
            throw e;
        }
        
    }

    public Autor buscarAutorPorCodigo(int id) {
        Autor autor = new Autor();
        try {            
            autor = em.find(Autor.class, id);
        } catch (IllegalArgumentException e) {
            System.out.println("El autor no existe");
        }
        return autor;
    }

    public Autor buscarAutorPorNombre(String nombre) {
        
        Autor autor = new Autor();
        try {
            autor = em.find(Autor.class, nombre);
        } catch (IllegalArgumentException e) {
            System.out.println("El autor no existe");
        }
        return autor;
    }

    public void eliminarAutorPorCodigo(int id) throws Exception{
        try {
            Autor autor = buscarAutorPorCodigo(id);
            super.eliminar(autor);
            System.out.println("El autor fue borrado");
        } catch(Exception e){
            throw e;
        }

    }

    public void eliminarAutorPorNombre(String nombre) {
        Autor autor = buscarAutorPorNombre(nombre);
        super.eliminar(autor);
    }

    public void actualizarAutorNombre(String nombre, String nuevoNombre) {
        Autor autor = buscarAutorPorNombre(nombre);
        autor.setNombre(nuevoNombre);
        super.editar(autor);
    }

}
