/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alan
 */
public class CopiadorThread extends Thread {
    
    String origen;
    String destino;
    
    public CopiadorThread(String origen, String destino) {
        this.origen = origen;
        this.destino = destino;
    }
    
    @Override
    public void run() {
        try {
            this.exec();
        } catch (IOException ex) {
            Logger.getLogger(CopiadorThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(
            String.format("Se copió el archivo %s en %s", this.origen, this.destino)
        );
    }
    
    public void exec() throws IOException {
        try (InputStream in = new FileInputStream(this.origen)) {
            try (OutputStream out = new FileOutputStream(this.destino)) {
                int b;
                
                while ((b = in.read()) != -1) {
                    out.write(b);
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        for (int i = 0; i < 10; i++) {
            CopiadorThread copiador = new CopiadorThread(
                "/Users/alan/Desktop/origen.zip",
                String.format("/Users/alan/Desktop/cp_%d", i)
            );
            
            copiador.start();
        }
    }
}
