/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Aula E3
 */
public class UsuarioImp extends UnicastRemoteObject implements Usuario {

    String nombre;
    
    public UsuarioImp(String nombre) throws RemoteException {
       super();
        
       this.nombre = nombre; 
    }
    
    @Override
    public String obtenerNombre() throws RemoteException {
        return this.nombre;
    }

    @Override
    public void recibirMensaje(String mensaje) throws RemoteException {
        System.out.println(mensaje);
    }
    
}
