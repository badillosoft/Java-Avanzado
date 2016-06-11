/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Redes;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;

/**
 *
 * @author alan
 */
public class GetHTML extends Thread {
    
    URL url;
    String destino;
    
    public GetHTML(String url, String destino) throws MalformedURLException {
        this.url = new URL(url);
        this.destino = destino;
    }
    
    @Override
    public void run() {
        
        try (BufferedInputStream in = new BufferedInputStream(url.openStream())) {
            
            try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(this.destino))) {
                
                int b;
                while ((b = in.read()) != -1) {
                    out.write(b);
                }
                
            }
            
        } catch (IOException ex) {
            System.out.println("Hubo un error al obtener los datos del servidor");
        }
    }
 
    public static void main(String[] args) throws MalformedURLException {
        GetHTML gh = new GetHTML("http://google.com", "/Users/alan/Desktop/google.html");
        
        gh.start();
    }
    
}
