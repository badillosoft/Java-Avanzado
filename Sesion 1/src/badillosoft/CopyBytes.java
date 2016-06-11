/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Aula E3
 */
public class CopyBytes {
    
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        
        try {
            in = new FileInputStream("C:/data/hola.txt");
            out = new FileOutputStream("C:/data/hola_copy.txt");
        } catch(IOException e) {
            System.out.println(e.getMessage());
            if (in != null) {
                in.close();
            }
            System.exit(0);
        }
        
        int b;
        
        while ((b = in.read()) != -1) {
            out.write(b);
        }
        
        in.close();
        out.close();
    }
}
