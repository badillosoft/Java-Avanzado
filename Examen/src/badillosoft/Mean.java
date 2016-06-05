/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

/**
 *
 * @author alan
 */
public class Mean {
    public static void main(String[] args) {
        int[] numbers = new int[] {1, 5, 11, 17, 27};
        
        int s = 0;
        
        for (int i = 0; i < numbers.length; i++) {
            s += numbers[i];
        }
        
        double m = s / (double)numbers.length;
        
        System.out.println(m);
    }
}
