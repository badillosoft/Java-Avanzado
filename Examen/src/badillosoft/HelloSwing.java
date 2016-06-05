/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author alan
 */
public class HelloSwing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            
            frame.setBounds(0, 0, 600, 400);
            
            HelloPanel panel = new HelloPanel();
            
            frame.add(panel);
            
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
