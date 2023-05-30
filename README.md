1. Sistema de Guardado de una Librería
      El objetivo de este ejercicio es el desarrollo de un sistema de guardado de libros en JAVA 
      utilizando una base de datos MySQL y JPA como framework de persistencia. 
      Creación de la Base de Datos MySQL:
      Lo primero que se debe hacer es crear la base de datos sobre el que operará el sistema de 
      reservas de libros. Para ello, se debe abrir el IDE de base de datos que se está utilizando 
      (Workbench) y ejecutar la siguiente sentencia: 
      CREATE DATABASE libreria; 
      De esta manera se habrá creado una base de datos vacía llamada librería. 
      Paquetes del Proyecto Java:
      Los paquetes que se utilizarán para este proyecto son los siguientes: 
            • entidades: en este paquete se almacenarán aquellas clases que se quiere persistir en la 
              base de datos. 
            • servicios: en este paquete se almacenarán aquellas clases que llevarán adelante la lógica 
              del negocio. En general se crea un servicio para administrar las operaciones CRUD
              (Create, Remove, Update, Delete) cada una de las entidades y las consultas de cada 
              entidad. 
      Nota: En este proyecto vamos a eliminar entidades, pero no es considerado una buena 
      práctica. Por esto, además de eliminar nuestras entidades, vamos a practicar que nuestras 
      entidades estén dadas de alta o de baja. Por lo que las entidades tendrán un atributo “activo” 
      de tipo booleano, que estará en true al momento de crearlas y en false cuando las demos de 
      baja, para evitar eliminarlas de la base de datos
      
      a) Entidades
          Crearemos el siguiente modelo de entidades:
          
          Entidad Libro 
          
          La entidad libro modela los libros que están disponibles en la biblioteca para ser prestados. En 
          esta entidad, el atributo “ejemplares” contiene la cantidad total de ejemplares de ese libro, 
          mientras que el atributo “ejemplaresPrestados” contiene cuántos de esos ejemplares se 
          encuentran prestados en este momento y el atributo “ejemplaresRestantes” contiene cuántos 
          de esos ejemplares quedan para prestar.
          
          Entidad Autor 
          
          La entidad autor modela los autores de libros. 
          Entidad Editorial
          La entidad editorial modela las editoriales que publican libros. 
      b) Unidad de Persistencia
          Para configurar la unidad de persistencia del proyecto, se recomienda leer el Instructivo 
          Unidad de Persistencia recuerde hacer click con el botón derecho sobre el proyecto y 
          seleccionar nuevo. A continuación, se debe seleccionar la opción de Persistence Unit como se 
          indica en la siguiente imagen.
          
          Base de Datos
          
          Para este proyecto nos vamos a conectar a la base de datos Librería, que creamos 
          previamente.
          
          Generación de Tablas 
          
          La estrategia de generación de tablas define lo que hará JPA en cada ejecución, si debe crear 
          las tablas faltantes, si debe eliminar todas las tablas y volver a crearlas o no hacer nada. 
          Recomendamos en este proyecto utilizar la opción: “Create” 
          
          Librería de Persistencia 
          
          Se debe seleccionar para este proyecto la librería “EclipseLink”. 
          
      c) Servicios
      
          AutorServicio 
          
          Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para 
          administrar autores (consulta, creación, modificación y eliminación).
          
          EditorialServicio 
          
          Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para 
          administrar editoriales (consulta, creación, modificación y eliminación)
          
          LibroServicio
          
          Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para 
          administrar libros (consulta, creación, modificación y eliminación)
          
      d) Main
          Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para 
          interactuar con el usuario. En esta clase se muestra el menú de opciones con las operaciones 
          disponibles que podrá realizar el usuario.
      e) Tareas a realizar
          Al alumno le toca desarrollar, las siguientes funcionalidades: 
              1) Crear base de datos Librería
              2) Crear unidad de persistencia
              3) Crear entidades previamente mencionadas (excepto Préstamo) 
              4) Generar las tablas con JPA
              5) Crear servicios previamente mencionados.
              6) Crear los métodos para persistir entidades en la base de datos librería
              7) Crear los métodos para dar de alta/bajo o editar dichas entidades.
              8) Búsqueda de un Autor por nombre.
              9) Búsqueda de un libro por ISBN.
              10) Búsqueda de un libro por Título. 
              11) Búsqueda de un libro/s por nombre de Autor.
              12) Búsqueda de un libro/s por nombre de Editorial.
              13) Agregar las siguientes validaciones a todas las funcionalidades de la aplicación: 
                  • Validar campos obligatorios.
                  • No ingresar datos duplicados.

1. Sistema de Reservas de una Librería
      Vamos a continuar con el ejercicio anterior. Ahora el objetivo de este ejercicio es el desarrollo 
      de un sistema de reserva de libros en JAVA. Para esto vamos a tener que sumar nuevas 
      entidades a nuestro proyecto en el paquete de entidades y crearemos los servicios de esas 
      entidades. 
      Usaremos la misma base de datos y se van a crear las tablas que nos faltan. Deberemos 
      agregar las entidades a la unidad de persistencia.
      
      a) Entidades
          Crearemos el siguiente modelo de entidades:

          Entidad Cliente 
          
          La entidad cliente modela los clientes (a quienes se les presta libros) de la biblioteca. Se 
          almacenan los datos personales y de contacto de ese cliente. 
          
          Entidad Préstamo
          
          La entidad préstamo modela los datos de un préstamo de un libro. Esta entidad registra la 
          fecha en la que se efectuó el préstamo y la fecha en la que se devolvió el libro. Esta 
          entidad también registra el libro que se llevo en dicho préstamo y quien fue el cliente al 
          cual se le prestaron.
          
      b) Servicios
      
          ClienteServicio 
          
          Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para 
          administrar clientes (consulta, creación, modificación y eliminación).
          
          PrestamoServicio 
          
          Esta clase tiene la responsabilidad de llevar adelante las funcionalidades necesarias para 
          generar prestamos, va a guardar la información del cliente y del libro para persistirla en la 
          base de datos. (consulta, creación, modificación y eliminación).
          
      c) Tareas a realizar
          1) Al alumno le toca desarrollar, las siguientes funcionalidades: 
          2) Creación de un Cliente nuevo
          3) Crear entidad Préstamo
          4) Registrar el préstamo de un libro.
          5) Devolución de un libro
          6) Búsqueda de todos los préstamos de un Cliente.
              • Agregar validaciones a todas las funcionalidades de la aplicación:
              • Validar campos obligatorios.
              • No ingresar datos duplicados. 
              • No generar condiciones inválidas. Por ejemplo, no se debe permitir prestar más 
                ejemplares de los que hay, ni devolver más de los que se encuentran prestados. 
      No se podrán prestar libros con fecha anterior a la fecha actual, etc
