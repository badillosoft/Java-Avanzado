/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author root
 */
public class BibliotecaTest {
    
    public static void main(String[] args) throws JAXBException {
        
        Biblioteca biblio = new Biblioteca();
        
        biblio.libros = new Libros();
        
        biblio.libros.libro = new ArrayList<Libro>();
        
        Libro libro1 = new Libro();
        
        libro1.autor = "Jean Paul Sartre";
        libro1.título = "La naúsea";
        libro1.isbn = "123-456-789";
        
        biblio.libros.libro.add(libro1);
        
        Libro libro2 = new Libro();
        
        libro2.autor = "Pablo Cohelo";
        libro2.título = "El alquimista";
        libro2.isbn = "987-654-321";
        
        biblio.libros.libro.add(libro2);
        
        JAXBContext context = JAXBContext.newInstance(Biblioteca.class);
        
        Marshaller marshaller = context.createMarshaller();
        
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        marshaller.marshal(biblio, new File("/Users/alan/biblioteca.xml"));
    }
    
}
