//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2016.07.02 a las 05:02:05 PM CDT 
//


package badillosoft;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}libros"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "libros"
})
@XmlRootElement(name = "biblioteca")
public class Biblioteca {

    @XmlElement(required = true)
    protected Libros libros;

    /**
     * Obtiene el valor de la propiedad libros.
     * 
     * @return
     *     possible object is
     *     {@link Libros }
     *     
     */
    public Libros getLibros() {
        return libros;
    }

    /**
     * Define el valor de la propiedad libros.
     * 
     * @param value
     *     allowed object is
     *     {@link Libros }
     *     
     */
    public void setLibros(Libros value) {
        this.libros = value;
    }

}
