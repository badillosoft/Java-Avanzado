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

/**
 *
 * @author alan
 */
public class Copiar {
    
    String origen;
    String destino;
    
    public Copiar(String origen, String destino) {
        this.origen = origen;
        this.destino = destino;
    }
    
    public void exec() throws IOException {
        /*InputStream in = null;
        OutputStream out = null;
        
        try {
            in = new FileInputStream(this.origen);
            out = new FileOutputStream(this.destino);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Copiar.class.getName()).log(Level.SEVERE, null, ex);
            
            if (in != null) {
                in.close();
            }
        }
        
        out.close();*/
        
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(this.origen))) {
            try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(this.destino))) {
                int b;
                
                while ((b = in.read()) != -1) {
                    out.write(b);
                    
                    // TODO: Mostrar el progreso del archivo
                    //this.progress = tamaño_escrito / tamaño_total;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        
        for (int i = 0; i < 10; i++) {
            Copiar copiador = new Copiar(
                "/Users/alan/Desktop/origen.zip",
                String.format("/Users/alan/Desktop/cp_%d", i)
            );
            
            copiador.exec();
        }
    }
}
