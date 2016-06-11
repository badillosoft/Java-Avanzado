/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alan
 */
public class HelloThreadI implements Runnable {
    int millis;
    int id;
    
    public HelloThreadI(int id, int millis) {
        this.id = id;
        this.millis = millis;
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(this.millis);
        } catch (InterruptedException ex) {
            Logger.getLogger(HelloThreadC.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        System.out.println(
            String.format("Hola desde el hilo %d después de %d segundos",
                    this.id, (this.millis / 1000))
        );
    }
    
    public static void main(String[] args) {
        HelloThreadC hello1 = new HelloThreadC(1, 4000);
        HelloThreadC hello2 = new HelloThreadC(2, 2000);
        HelloThreadC hello3 = new HelloThreadC(3, 1000);
        HelloThreadC hello4 = new HelloThreadC(4, 2000);
        HelloThreadC hello5 = new HelloThreadC(5, 4000);
        
        
        hello1.start();
        hello2.start();
        hello3.start();
        hello4.start();
        hello5.start();
    }
}
