/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

import java.rmi.*;

/**
 *
 * @author Aula E3
 */
public interface Chat extends Remote {
    
    boolean conectar(Usuario usuario) throws RemoteException;
    
    void enviarMensaje(Usuario usuario, String mensaje)
            throws RemoteException;
    
}
