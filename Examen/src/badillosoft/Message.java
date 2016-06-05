/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

import java.util.Scanner;

/**
 *
 * @author alan
 */
public class Message {
    public static void main(String[] args) {
        System.out.print("Ingresa un mensaje: ");
        Scanner s = new Scanner(System.in);
        
        String line = s.nextLine();
        
        System.out.printf("Mensaje recibido: %s\n", line);
    }
}
