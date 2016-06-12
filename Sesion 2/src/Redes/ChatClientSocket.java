/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Redes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.function.Consumer;

/**
 *
 * @author root
 */
public class ChatClientSocket {
    
    Socket socket;
    
    public ChatClientSocket(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }
    
    public String receive() {
        
        try (BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()))) {
            
            StringBuilder text = new StringBuilder();
            
            in.lines().forEach((String line) -> {
                text.append(line);
            });
            
            in.close();
            
            return text.toString();
        } catch (IOException ex) {
            return "Hubo error al conectarse con el servidor.";
        }
        
    }
    
}
