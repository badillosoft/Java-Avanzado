/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package badillosoft;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.management.ManagementFactory;
import java.net.ServerSocket;
import java.net.Socket;
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
public class Server {
    
    public static void main(String[] args) throws IOException, MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
        Canasta canasta = new Canasta();
        
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("badillosoft:type=Canasta");
        mbs.registerMBean(canasta, name);
        
        try (ServerSocket server = new ServerSocket(2121)) {
            while (true) {
                try (Socket socket = server.accept()) {
                    try(Scanner in = new Scanner(socket.getInputStream())) {
                        canasta.agregarFruta(in.nextLine());
                    }
                }
            }
        }
    }
    
}
