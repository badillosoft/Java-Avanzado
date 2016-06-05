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
public class StudentV1 extends PersonV1 {
    
    String enrollment;
    
    public StudentV1(String name, String curp, String enrollment) {
        super(name, curp);
        
        this.enrollment = enrollment;
    }
    
    @Override
    public String description() {
        return String.format("%s: %s (%s)", enrollment, name, curp);
    }
    
    public static void main(String[] args) {
        PersonV1 pepe = new StudentV1("Pepe", "PP123", "2016PP");
        
        System.out.println(pepe.description());
    }
}
