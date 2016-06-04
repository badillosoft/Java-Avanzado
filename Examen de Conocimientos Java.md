<center>
# Examen de Conocimientos de Java

**Instituto Politécnico Nacional**

**Centro de Investigación en Computación**
</center>

<br><br>

Instructor: Alan Badillo Salas

Correo: badillo.soft@hotmail.com

## Introducción

Resolver los ejercicios auxiliandose de la siguiente plantilla
para construir un programa:

> `App.java`

~~~java
public class App {
	public static void main(String[] args) {
		System.out.println("Hola mundo");
	}
}
~~~

Puede compilar los archivos usando los siguientes comandos

> Comprobar la versión de `java` y `javac`

~~~bash
$ java -version
$ javac -version
~~~

> Compilar el archivo `App.java`

~~~bash
$ javac App.java
~~~

> Ejecutar el programa `App.class`

~~~bash
$ java App
~~~

# Parte I - Conocimientos básicos de Java

1. Describa en un parrafo que es la `Programación Orientada a Objetos`.
2. Describa en un parrafo que son las `Interfaces`.
3. Leer un mensaje desde el teclado y muestre el mensaje añadiendo
"Mensaje entrante: " al principio del mensaje.
4. Crear una función que reciba un arreglo de enteros y devuelva el promedio.
5. Escribir una clase llamada `Persona` que contenga _Nombre_ y _CURP_ de tipo
`String` como atributos y los reciba en el constructor y un método
llamado `descripción` que devuelva el `CURP - Nombre` según el valor de los atributos.
6. Derivar la clase Estudiante de Persona que añada el atributo Matrícula y lo reciba
en el constructor. La clase debe sobreescribir el método `descipción` para que
devuelva un `Matrícula. Nombre (CURP)` según los valores de los atributos. Agregar

# Parte II - Conocimientos medios de Java

7. Agregar una `propiedad` llamada `activo` a la clase `Estudiante`
que este asociada a un atributo _booleano_ de tipo _privado_ llamado
_estaActivo_ y sus métodos `get` y `set`.
8. Crear una _interfaz_ llamada `Descriptible` que contenga un método llamado
`descripción` que devuelva un `String` e implementar la interfaz a la clase `Persona`.
9. Crear un programa que muestre una ventana en `Swing` con una caja para
ingresar texto y un botón que al pulsarlo invierta el texto de la caja.