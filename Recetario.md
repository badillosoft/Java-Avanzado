# Recetas para Java Avanzado

Intructor: Alan Badillo Salas

Email: [badillo.soft@hotmail.com](mailto:badillo.soft@hotmail.com)

Twitter: @badillosoft

Github: https://github.com/badillosoft/Java-Avanzado

## Streams

Los _Streams_ (flujos de datos) pertenecen a las clases _InputStream_ y
_OutputStream_. Todas las clases derivadas de estas y algunas otras que
extienden funcionalidad permiten manejar datos de forma transparente
_byte_ por _byte_. Algunas clases como _BufferedInputStream_ toman
en su constructor una instancia de _InputStream_ para mejorar la eficiencia
y extender algunos métodos extras.

> Leer los bytes de un archivo

~~~java
try (InputStream in = new FileInputStream(filename)) {    
    int b;
    while ((b = in.read()) != -1) {
        System.out.printf("[%d]", b);
    }
}
~~~

> Escribir bytes en un archivo

~~~java
byte bytes[] = {104, 111, 108, 97};

try (OutputStream out = new FileOutputStream(filename)) {    
    for (int b : bytes) {
        out.write(b);
    }
}
~~~

## Sockets

Los _sockets_ permiten una conexión entre dos aplicaciones
para intercambiar _streams_. El servidor se dedica a escuchar cada cliente
y puede acceder al _inputstream_ y al _outputstream_ de cada cliente conectado.
Los clientes también pueden recuperar sus propios _inputstream_ y al _outputstream_
para intercambiar datos con el servidor.

> Leer el contenido de una _URL_

~~~java
URL u = new URL("http://www.google.com");
           
try (Scanner in = new Scanner(new BufferedInputStream(u.openStream()))) {
    System.out.println(in.nextLine());
}
~~~

> Crear un Servidor Socket que proporcione la hora

~~~java
try (ServerSocket server = new ServerSocket(2121)) {
    while (true) {
        try (Socket connection = server.accept()) {
            Writer out = new OutputStreamWriter(connection.getOutputStream());
            Date now = new Date();
            out.write(now.toString() +"\r\n");
            out.flush();
            connection.close();
        }
    }
}
~~~

> Conectarse a un Servidor Socket y leer el flujo escrito por el servidor

~~~java
try (Socket socket = new Socket("127.0.0.1", 2121)) {
    socket.setSoTimeout(1000);
    Scanner in = new Scanner(socket.getInputStream());
    System.out.println(in.nextLine());
}
~~~

## Threads

Los _threads_ (hilos) son procesos que se ejecutan en paralelo
de forma que se pueden lanzar muchos procesos que se ejecuten al mismo
tiempo en paralelo sin bloquear el hilo principal del programa. Existen
dos formas de implementar los _threads_, la primera es derivar una clase
de la clase `Thread` y sobreescribir el método `run` con el proceso que
queremos que se realize en paralelo. La segunda es crear una clase que
implemente la interfaz `Runnable` y sobreescribir el método `run`. En ambos
casos creamos una instancia de la clase y llamamos al método `start` para
iniciar el hilo.

> Crear un hilo anónimo

~~~java
Thread t = new Thread() {
    @Override
    public void run() {
        // TODO: Colocar aquí el proceso que se realizará en el hilo
    }
};

t.start();
~~~

## RMI (Remote Method Invocation)

Los RMI (Invocación a Métodos Remotos) permiten utilizar objetos y llamar a sus
métodos como si se encontraran programados en la aplicación, pero en realidad
se encuentran programados en un servidor y son llamados de forma remota.
Los datos que toma el método se serializan y se envían por la red para ser
recibidos del lado del servidor y ejecutados, el resultado se serializa nuevamente
y es devuelto al cliente, el cliente utiliza el método como si llamará a cualquier
método de un objeto. Sin embargo, sólo posee una _interfaz_ de la clase del objeto
y todos los métodos están implementados en el servidor.

La interfaz tiene que derivar de `java.rmi.Remote` y la clase que implementa
dicha interfaz debe extender de `java.rmi.UnicastRemoteObject` además de 
poseer un constructor vació.

> 1. Creamos una interfaz de una clase que será utilizada en la aplicación
de forma remota

~~~java
public interface IPersona extends Remote {
    String getNombre();
    void setNombre(String valor);
}
~~~

> 2. Implementamos la interfaz de lado del servidor

~~~java
public class Persona extends UnicastRemoteObject implements IPersona {
    private String nombre = "ninguno";

    public Persona() {}

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
~~~

> 3. Crear el servidor

~~~java
// Registramos el servidor
LocateRegistry.createRegistry(1099);

// Creamos el objeto a transportar            
Persona p = new Persona("ash");

// Publicamos el objeto con el nombre publico "Persona"
Naming.rebind("Persona", p);
~~~

> 4. Creamos el cliente

~~~java
// Recuperamos el objeto mediante el nombre público
Persona p = (Persona)Naming.lookup("Persona");

// Accedemos a los métodos de la persona
System.out.printf("Nombre: %s\r\n", p.getNombre());
p.setNombre("Bruno");
System.out.printf("Nombre: %s\r\n", p.getNombre());
~~~

## JMX (Java Management Extensions)

El _JMX_ (Administrador de Extensiones de Java) permite monitorear y administrar
extensiones de java, mejor conocidos como _MBeans_ los cuales son objetos
de clases derivados de una interface bien conocida. Lo interesante de los _MBeans_
es que podemos acceder a los métodos especificados en la interfaz dede la _JConsole_
la cual es una consola genérica que proporciona _Java_ y nos ahorra construir
interfaces para cambiar los valores de nuestros objetos en tiempo de ejecución.

> 1. Crear una interfaz para un objeto al que le queramos modificar atributos
o monitorearlo

~~~java
public interface CanastaMBean {
    
    int getNumeroFrutas();
    
    String getNombreFrutas();
    
    void agregarFruta(String fruta);
    
    void vaciarFrutas();
    
} 
~~~

> 2. Implementar la interfaz

~~~java
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
~~~

> 3. Crear una instancia de la clase implementada y publicar el _MBean_ en el
servidor

~~~java
// Creamos un objeto de la clase que implementa la interfaz
Canasta obj = new Canasta();
        
// Recuperamos el servidor de los `beans`
MBeanServer server = ManagementFactory.getPlatformMBeanServer();

// Le asignamos un nombre público a nuestro `bean`
ObjectName name = new ObjectName("badillosoft:type=Canasta");

// Registramos el `bean` en el servidor
server.registerMBean(obj, name);
~~~

> 4. Abrimos la consola desde una terminal, donde `JAVA_HOME` es el path
hasta donde está instalado _Java_, por ejemplo, `C:/Archivos de Programa/Java/sdk`
o `/usr/bin/java`

~~~bash
$ cd JAVA_HOME
$ jconsole
~~~

> 5. Nos conectamos a la aplicación en ejecución que instancia nuestro servidor

## JAXB (JAVA ARQUITECTURE FOR XML BINDING)

El _JAXB_ o (Arquitectura para Enlazar XML en Java) es la forma en la que
serializamos objetos de _Java_ a archivos _XML_ y al revés.

Lo primero que tenemos que hacer es marcar una clase con decoradores para
que pueda ser serialiable. Tenemos que colocar el marcador `@XmlRootElement`
a la clase y `@XmlElement` o `@XmlAttibute` a las propiedades que queramos
serializar.

Tenemos que marcar un constructor vacío.

> Marcar serializable la clase Persona

~~~java
@RootElement
class Persona {
    @XmlElement
    String Nombre = "Ash";
    @XmlAttibute
    int Edad = 18; 

    public Persona() {}

    public Persona(String nombre, int edad) {
        Nombre = nombre;
        Edad = edad;
    }
}
~~~

> Serializar un objeto y guardarlo en un archivo

~~~java
Persona ash = new Persona("Ash", 10);

JAXBContext context = JAXBContext.newInstance(Persona.class);
Marshaller marshaller = context.createMarshaller();
marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
marshaller.marshal(ash, new File("...path/ash.xml"));
~~~

> Deserializar un objeto desde un archivo

~~~java
JAXBContext context = JAXBContext.newInstance(Persona.class);
Unmarshaller unmarshaller = context.createUnmarshaller();
Persona ash = (Persona)unmarshaller.unmarshal(new File("...path/ash.xml"));
System.out.printf("Nombre: %s Edad: %s\r\n", ash.Nombre, ash.Edad);
~~~