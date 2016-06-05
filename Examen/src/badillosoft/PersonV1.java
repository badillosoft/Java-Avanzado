/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

/**
 *
 * @author alan
 */
public class PersonV1 {
    String name;
    String curp;
    
    public PersonV1(String name, String curp) {
        this.name = name;
        this.curp = curp;
    }
    
    public String description() {
        return String.format("%s - %s", curp, name);
    }
    
    public static void main(String[] args) {
        PersonV1 pepe = new PersonV1("Pepe", "PP123");
        
        System.out.println(pepe.description());
    }
}
