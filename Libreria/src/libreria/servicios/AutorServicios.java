/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.servicios;

import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

/**
 *
 * @author Usuario
 */
public class AutorServicios {
    
    private final AutorDAO autorDao;

    public AutorServicios() {
        this.autorDao = new AutorDAO();
    }

   public void nuevoAutor(){
       Scanner leer = new Scanner (System.in);
       System.out.println("Ingrese el nombre");
       String nombre = leer.nextLine();
       Autor autor = new Autor();
       autor.setNombre(nombre);
       autor.setAlta(true);

       autorDao.guardar(autor);
   }
   
   public void eliminarAutorPorCodigo(int id) throws Exception{
           autorDao.eliminarAutorPorCodigo(id);
       
   }
   
   public void eliminarAutorPorNombre(String nombre){
       autorDao.eliminarAutorPorNombre(nombre);
   }
   
   public Autor buscarAutorPorNombre(String nombre){
       Autor autor = autorDao.buscarAutorPorNombre(nombre);
       return autor;
   }

    
    
  
    
}
