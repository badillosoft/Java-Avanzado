# Recetas para Java Avanzado

Alan Badillo Salas

Email: [badillo.soft@hotmail.com](mailto:badillo.soft@hotmail.com)

Twitter: @badillosoft

Github: https://github.com/badillosoft

## Parte I - Java Streams

> FileReader Crear un stream para leer un archivo

~~~java
package badillosoft;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {
    
    public static void read(String filename) throws IOException {
        
        try (FileInputStream in = new FileInputStream(filename)) {
        
            int b;

            while ((b = in.read()) != -1) {
                System.out.print((char)b);
            }

            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        
        System.out.print("Ingresa la ruta y nombre del archivo a leer: ");
        
        try {
            FileReader.read(s.nextLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
~~~ 

### Crear un stream para escribir un archivo

