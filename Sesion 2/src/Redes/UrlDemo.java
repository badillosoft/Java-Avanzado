/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Redes;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

/**
 *
 * @author alan
 */
public class UrlDemo {
    
    private static void testProtocol(String url) {
        try {
            URL u = new URL(url);
            
            System.out.println(u.getProtocol() + " is supported");
        } catch (MalformedURLException ex) {
            String protocol = url.substring(0, url.indexOf(':'));
            System.out.println(protocol + " is not supported");
        }
    }
    
    public static void main(String[] args) throws IOException {
        testProtocol("http://google.com");
        
        InputStream in = null;
        
        try {
            URL u = new URL("http://google.com");
            
            in = u.openStream();
            
            int b;
            
            System.out.println();
            
            while ((b = in.read()) != -1) {
                System.out.print((char)b);
            }
            
            System.out.println();
        } catch (MalformedURLException ex) {
            System.out.println("Error");
        }
        
        if (in != null) {
            in.close();
        }
    }
    
}
