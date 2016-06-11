/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Aula E3
 */
public class CopyChars {
    
    public static void main(String[] args) throws IOException {
        FileReader in = null;
        FileWriter out = null;
        
        try {
            in = new FileReader("C:/data/hola.txt");
            out = new FileWriter("C:/data/hola_copy_chars.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        
        int c;
        
        while ((c = in.read()) != -1) {
            System.out.println(c);
            out.write(c);
        }
        
        in.close();
        out.close();
    }
    
}
