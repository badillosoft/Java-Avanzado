/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Redes;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

/**
 *
 * @author root
 */
public class HelloClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 13)) {
            
            try (InputStream in = socket.getInputStream()) {
                
                int b;
                while ((b = in.read()) != -1) {
                    System.out.print((char)b);
                }
                
            } catch(IOException ex) {
                System.out.println(ex.getMessage());
            }
            
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
