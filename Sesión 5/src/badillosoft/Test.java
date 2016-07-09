/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

import java.lang.management.ManagementFactory;
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
public class Test {
    
    public static void main(String[] args) throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException, InterruptedException {
        ApplicationCache cache = new ApplicationCache();
        
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        
        ObjectName name = new ObjectName("badillosoft:type=ApplicationCache");
        
        server.registerMBean(cache, name);
        
        System.out.println("Ejecutando bean");
        
        fakeCache(cache);
    }
    
    public static void fakeCache(ApplicationCache cache) throws InterruptedException {
        while (true) {
            cache.add(new Object());
            Thread.sleep(1000);
        }
    }
    
}
