/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Redes;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;

/**
 *
 * @author root
 */
public class ChatServer {
    
    public static void main(String[] args) throws IOException {
        
        ArrayList<Socket> usuarios = new ArrayList<Socket>();
        
        try (ServerSocket server = new ServerSocket(13)) {
            while (true) {
                try (Socket connection = server.accept()) {
                    
                    if (usuarios.indexOf(connection) < 0) {
                        usuarios.add(connection);
                    }
                    
                    // TODO: Obtener el mensaje del socket
                    String message = "";
                    
                    try (BufferedReader out = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()))) {
                        message = out.readLine();
                    }
                    
                    // TODO: Replicar el mensaje a los demás sockets
                    for (Socket other : usuarios) {
                        try (BufferedWriter out = new BufferedWriter(
                                new OutputStreamWriter(other.getOutputStream()))) {
                            out.write(message);
                        }
                    }
                    
                }
            }
        }
    }
    
}
