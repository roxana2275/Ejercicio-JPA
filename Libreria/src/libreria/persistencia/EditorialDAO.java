package libreria.persistencia;

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
        Editorial editorial = em.find(Editorial.class, nombre);
        desconectar();
        return editorial;
    }

    public void eliminarEditorialPorCodigo(int id) {
        Editorial editorial = buscarEditorialPorCodigo(id);
        super.eliminar(editorial);

    }

    public void eliminarEditorialPorNombre(String nombre) {
        Editorial editorial = buscarEditorialPorNombre(nombre);
        super.eliminar(editorial);
    }

    public void actualizarEditorialNombre(String nombre, String nuevoNombre) {
        Editorial editorial = buscarEditorialPorNombre(nombre);
        editorial.setNombre(nuevoNombre);
        super.editar(editorial);
    }

}
