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
public class XmlToObject {
    
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Fruta.class);
        
        Unmarshaller unmarshaller = context.createUnmarshaller();
        
        Fruta obj = (Fruta)unmarshaller.unmarshal(new File("/Users/alan/bananya.xml"));
        
        System.out.printf("Fruta: %s\r\n", obj.Nombre);
    }
    
}
