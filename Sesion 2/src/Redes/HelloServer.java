/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Redes;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.*;
import java.util.Date;

/**
 *
 * @author alan
 */
public class HelloServer {
    
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(13)) {
            while (true) {
                try (Socket connection = server.accept()) {
                    System.out.println(connection.toString());
                    
                    try (Writer out = new OutputStreamWriter(connection.getOutputStream())) {
                        
                        Date now = new Date();
                        
                        out.write(String.format("%s\r\n", now.toString()));
                    }
                    
                }
            }
        }
    }
    
}
