/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.persistencia;

import libreria.entidades.Libro;

/**
 *
 * @author Usuario
 */
public class LibroDAO extends DAO<Libro>{
    
    @Override
    public void guardar(Libro libro){
        super.guardar(libro);
    }
    
    public Libro buscarLibroPorTitulo(String nombre){
        conectar();
        Libro libro = em.find(Libro.class, nombre);
        desconectar();
        return libro;
    }
    
    public Libro buscarLibroPorId(int id){
        conectar();
        Libro libro = em.find(Libro.class, id);
        desconectar();
        return libro;
    }
    
    public void eliminiarLibroPorId(int id){
        Libro libro = buscarLibroPorId(id);
        super.eliminar(libro);
    }
    
    public void eliminarLibroPorNombre(String nombre){
        Libro libro = buscarLibroPorTitulo(nombre);
        super.eliminar(libro);
    }
    
    public void actualizarLibroTituloPorId(int id, String titulo){
        conectar();
        Libro libro = buscarLibroPorId(id);
        libro.setTitulo(titulo);
        super.editar(libro);
        desconectar();

    }
    
    public void actualizarLibroTituloPorNobre(String titulo, String nuevoTitulo){
        conectar();
        Libro libro = buscarLibroPorTitulo(titulo);
        libro.setTitulo(nuevoTitulo);
        super.editar(libro);
        desconectar();
    }
}
