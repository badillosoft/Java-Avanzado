/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author root
 */
public class BibliotecaTest2 {
    
    public static void main(String[] args) throws JAXBException {
        
        JAXBContext context = JAXBContext.newInstance(Biblioteca.class);
        
        Unmarshaller unmarshaller = context.createUnmarshaller();
        
        Biblioteca biblio = (Biblioteca)unmarshaller.unmarshal(
            new File("/Users/alan/biblioteca.xml"));
        
        for (Libro libro : biblio.libros.libro) {
            System.out.printf("Autor: %s, Título: %s, ISBN: %s\r\n",
                libro.autor, libro.título, libro.isbn);
        }
    }
    
}
