/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class Canasta implements CanastaMBean {

    List<String> frutas = new ArrayList<>();
    
    @Override
    public int getNumeroFrutas() {
        return frutas.size();
    }

    @Override
    public String getNombreFrutas() {
        String nombres = "";
        
        for (String nombre : frutas) {
            nombres += nombre + "\r\n";
        }
        
        return nombres;
    }

    @Override
    public void agregarFruta(String fruta) {
        frutas.add(fruta);
    }

    @Override
    public void vaciarFrutas() {
        frutas.clear();
    }
    
}
