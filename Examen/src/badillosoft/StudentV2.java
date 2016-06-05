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
public class StudentV2 extends PersonV1 {
    
    String enrollment;
    
    //<editor-fold defaultstate="collapsed" desc="Property: isActive">
    private boolean _active = true;

    public boolean isActive() {
        return _active;
    }

    public void setActive(boolean _active) {
        this._active = _active;
    }
    
    //</editor-fold>
    
    public StudentV2(String name, String curp, String enrollment) {
        super(name, curp);
        
        this.enrollment = enrollment;
    }
    
    @Override
    public String description() {
        return String.format("%s: %s (%s) %s", enrollment, name, curp,
                isActive() ? "Activo" : "Inactivo");
    }
    
    public static void main(String[] args) {
        PersonV1 pepe = new StudentV2("Pepe", "PP123", "2016PP");
        
        System.out.println(pepe.description());
    }
    
}
