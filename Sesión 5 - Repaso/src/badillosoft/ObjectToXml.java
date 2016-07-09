/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author root
 */
public class ObjectToXml {
    
    public static void main(String[] args) throws JAXBException {
        Fruta obj = new Fruta("Bananya");
        
        JAXBContext context = JAXBContext.newInstance(Fruta.class);
        
        Marshaller marshaller = context.createMarshaller();
        
        marshaller.marshal(obj, new File("/Users/alan/bananya.xml"));
        
        System.out.println("\r\nXML creado correctamente");
        
        // <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
        // <fruta><Nombre>Bananya</Nombre></fruta>
    }
    
}
