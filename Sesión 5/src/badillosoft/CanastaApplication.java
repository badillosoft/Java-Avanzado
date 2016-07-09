/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

import java.lang.management.ManagementFactory;
import java.util.Scanner;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

/**
 *
 * @author root
 */
public class CanastaApplication {
    
    public static void main(String[] args) throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        
        Canasta obj = new Canasta();
        
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        
        ObjectName name = new ObjectName("badillosoft:type=Canasta");
        
        server.registerMBean(obj, name);
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Pulsa enter para salir...");
        scanner.nextLine();
    }
    
}
