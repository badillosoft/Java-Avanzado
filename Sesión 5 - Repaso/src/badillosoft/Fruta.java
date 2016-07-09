/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

import javax.xml.bind.annotation.*;

/**
 *
 * @author root
 */
@XmlRootElement
public class Fruta {
    
    @XmlElement
    public String Nombre;
    
    public Fruta() {}
    
    public Fruta(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
