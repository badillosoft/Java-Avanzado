/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author Aula E3
 */
public class ClienteChat {
    
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        Scanner s = new Scanner(System.in);
        
        System.out.print("Dame el usuario: ");
        
        String nombre = s.nextLine();
        
        Usuario usuario = new UsuarioImp(nombre, null);
        
        Chat con = (Chat)Naming.lookup("chat");
        
        con.conectar(usuario);
    }
    
}
