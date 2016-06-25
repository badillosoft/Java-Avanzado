/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.swing.JTextArea;

/**
 *
 * @author Aula E3
 */
public class UsuarioImp extends UnicastRemoteObject implements Usuario {

    String nombre;
    JTextArea txt_consola;
    
    public UsuarioImp(String nombre, JTextArea txt_consola) throws RemoteException {
       super();
        
       this.nombre = nombre;
       this.txt_consola = txt_consola;
    }
    
    @Override
    public String obtenerNombre() throws RemoteException {
        return this.nombre;
    }

    @Override
    public void recibirMensaje(String mensaje) throws RemoteException {
        System.out.println(mensaje);
        txt_consola.append("\r\n" + mensaje);
    }
    
}
