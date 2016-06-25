/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
//import java.util.Iterator;

/**
 *
 * @author Aula E3
 */
public class ChatImp extends UnicastRemoteObject implements Chat {

    ArrayList usuarios = new ArrayList();
    
    public ChatImp() throws RemoteException {
        super();
    }
    
    @Override
    public boolean conectar(Usuario usuario) throws RemoteException {
        String nombre = usuario.obtenerNombre();
        
        /*Iterator it = usuarios.iterator();
        
        while(it.hasNext()) {
            Usuario u = (Usuario)(it.next());
            
            String unombre = u.obtenerNombre();
            
            if (unombre == nombre) {
                return false;
            }
        }*/
        
        for (Object obj : usuarios) {
            Usuario u = (Usuario)(obj);
            
            String unombre = u.obtenerNombre();
            
            if (unombre == null ? nombre == null : unombre.equals(nombre)) {
                return false;
            }
        }
        
        usuarios.add(usuario);
        
        System.out.printf("El usuario %s se ha conectado %s",
                nombre, (new Date().toString()));
        
        return true;
    }

    @Override
    public void enviarMensaje(Usuario usuario, String mensaje) throws RemoteException {
        String nombre = usuario.obtenerNombre();
        
        String m = String.format("%s %s> %s", (new Date()).toString(), nombre, mensaje);
        
        for (Object obj : usuarios) {
            Usuario u = (Usuario)(obj);
            
            u.recibirMensaje(m);
        }
    }
    
}
