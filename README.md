# Java-Avanzado

## Sesiones:

**4 de junio** - http://slides.com/alanbadillosalas/javaiostreams

**11 de junio** - https://slides.com/alanbadillosalas/hilos-java/ https://slides.com/alanbadillosalas/redes-java/

**25 de junio** - http://slides.com/alanbadillosalas/rmi-java

### Tarea 1 - Entrega 11 de junio de 2016

Crear una interfaz en _Swing_ que contenga dos cajas de
texto y un botón que al pulsar el botón lea el archivo
ubicado en la ruta de la primer caja de texto y copie
los _bytes_ invertidos `255 - b` en el archivo ubicado
en la ruta que dicte la segunda caja de texto.

**1 punto** - Hacer que las cajas de texto muestren un
_placeholder_, es decir, que muestre un texto con letras
grises orientando al usuario que escribir en la caja,
cuando el usuario ingrese texto que este desaparezca.

**1 punto** - Agregar un botón a lado de la caja de texto
que abra un _file dialog_ para ubicar un archivo en
específico, la ruta del archivo deberá escribirse en la
caja de texto.

### Tarea 2 - Entrega 18 de junio de 2016

Descargar el material del tema de Redes con Java [El Modelo OSI](https://github.com/badillosoft/Java-Avanzado/blob/master/Material/Redes%20con%20Java%20-%20El%20modelo%20OSI%20y%20Protocolos%20de%20Red.pdf) contenido en la carpeta material de este git. Responder brevemente las siguientes preguntas:

**¿Qué es el modelo OSI?**

**Describir brevemente cada una de las capas del modelo OSI**

**¿Qué es un protocolo de red?**

**Mencione brevemente como funcionan TCP y UDP**

**1 punto** - Mostrar el porcentaje de los _bytes_ escritos en el archivo destino. El porcentaje se puede calcular dividiendo el `número de bytes escritos` entre el `total de bytes del archivo` por _100_. Ten en cuenta que en el ciclo `while` puedes colocar un contador que cuente los _bytes_ escritos.

### Tarea 3 - Entrega 9 de julio de 2016

Agregar al archivo `biblioteca.xsd` el elemento `tesis` según el diagrama visto en clase.

### Tarea 4 - Entrega 9 de julio de 2016

Implementar un *FileDialog* al botón `Descargar` y al botón `Cargar` del proyecto de la *Sesión 4*.

### Tarea 5 - Entrega 9 de julio de 2016

Crear una clase llamada `Persona` y otra llamada `Personas` mediante un esquema *XSD* y compilarlas mediante `xjc archivo.xsd`.

## Proyecto Final

Los participantes del curso deberán entregar un proyecto en equipo a más tardar
el día ´23 de julio de 2016´. Los proyectos deberán contener un documento con
la institución, el nombre completo de los alumnos y el instructor, el mes y año
y un título que este relacionado al proyecto. El documento deberá contener una
introducción al problema que resuelve de no más de 2 parrafos (en máximo una cuartilla).
Después el algoritmo general que siguieron y los fragmentos de código más representativos
que utilizaron. Finalmente este documento debe ser adjuntado en un archivo ´zip´ junto
a la carpeta del proyecto y el ejecutable ´jar´.

### Proyecto 1 - Mezclar dos archivos binarios en uno

Se requiere un programa que solicite dos archivos cualquiera y lea cada uno de sus
´bytes´. El programa debe decidir cual es el archivo de mayor tamaño y colocar en
un tercer archivo un 1 si el primer archivo es mayor o un 0 sino. Luego en el tercer
archivo se debe escribir un byte de un archivo y uno del otro alternadamente.
Los bytes restantes serán del archivo de mayor tamaño. Intente realizar todo el
proceso usando _hilos_ y utilizando _buffers_.

> __Nota:__ Se debe utilizar una interfaz gráfica y _file dialogs_ para
ingresar las rutas de los archivos.

### Proyecto 2 - Encriptación _SHA_

Se requiere un programa que implemente el algoritmo de encriptación _SHA_ en cualquier
variante deseada. El programa debe recibir una cadena de texto y mostrar su encriptación
utilizando una clave pública. Los datos deben ser enviados a un servidor el cual
debe regresar el texto codificado.