/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Cliente {
    
    public static void main(String[] args) throws IOException {
        
        System.out.print("Escribe el nombre de una fruta: ");
        Scanner scanner = new Scanner(System.in);
        String fruta = scanner.nextLine();
        
        try (Socket socket = new Socket("127.0.0.1", 2121)) {
            try (Writer out = new OutputStreamWriter(socket.getOutputStream())) {
                out.write(fruta);
            }
        }
        
    }
    
}
