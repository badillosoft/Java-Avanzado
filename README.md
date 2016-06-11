# Java-Avanzado

## Sesiones:

**4 de junio** - http://slides.com/alanbadillosalas/javaiostreams

**11 de junio** - https://slides.com/alanbadillosalas/hilos-java/ https://slides.com/alanbadillosalas/redes-java/

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
