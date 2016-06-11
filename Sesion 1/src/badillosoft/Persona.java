/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

/**
 *
 * @author Aula E3
 */
public class Persona implements Invertible {
    
    String nombre;
    int key;
    
    Persona(String nombre, int key) {
        this.nombre = nombre;
        this.key = key;
    }
    
    @Override
    public void reverse() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        
        String aux = "";
        
        for (char c: nombre.toCharArray()) {
            int i = alphabet.indexOf(c);
            
            char k = alphabet.charAt((i + key) % alphabet.length());
            
            aux += k;
        }
        
        nombre = aux;
        key = -key;
    }
    
    @Override
    public String toString() {
        return this.nombre;
    }
    
    public static void main(String[] args) {
        Persona pepe = new Persona("holamundo", 17);
        
        System.out.println(pepe);
        
        pepe.reverse();
        
        System.out.println(pepe);
        
        pepe.reverse();
        
        System.out.println(pepe);
    }
}
