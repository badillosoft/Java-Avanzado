/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

/**
 *
 * @author root
 */
public interface CanastaMBean {
    
    int getNumeroFrutas();
    
    String getNombreFrutas();
    
    void agregarFruta(String fruta);
    
    void vaciarFrutas();
    
}
