# HelloHibernate
#### Versión: 0.1
#### Últ. actualización: 15 de febrero de 2025

---

## Propósito
El propósito de este repositorio es mostrar algunos ejemplos sencillos
sobre cómo gestionar entidades con el framework Hibernate.

---

## HelloHibernateApp
Ubicación: <code>java/src/</code>

La clase principal de este proyecto.

En ella podrás encontrar 3 métodos:
- singleEntity: código de ejemplo de cómo crear un dao, una entidad, cómo se guarda en la base de datos y, finalmente, cómo 
se cierra la sesión.
- oneToOne: código de ejemplo de cómo crear un dao (UserDAO), dos entidades (User y Address), cómo se guardan en la base de datos 
y, finalmente, cómo se cierra la sesión.
- oneToMany: código de ejemplo de cómo crear dos daos (CartDAO e ItemDAO), dos entidades (Cart e Item), cómo se guardan 
en la base de datos y, finalmente, cómo se cierra la sesión.

---

## Una entidad simple

### StudentDAO

Ubicación: <code>java/src/daos/ </code>

Clase que ejecuta las operaciones CRUD con la base de datos.

### Entidad simple Student

Ubicación: <code>java/src/entities/ </code>

Representa la entidad Student. 

---

## Relación uno a uno

### UserDAO

Ubicación: <code>java/src/daos/ </code>

Clase que ejecuta las operaciones CRUD con la base de datos.

### Entidad simple User

Ubicación: <code>java/src/entities/ </code>

Representa la entidad User.

### Entidad simple Address

Ubicación: <code>java/src/entities/ </code>

Representa la entidad Address.

---

## Relación uno a muchos

### CartDAO

Ubicación: <code>java/src/daos/ </code>

Clase que ejecuta las operaciones CRUD de un carrito de compra.

### ItemDAO

Ubicación: <code>java/src/daos/ </code>

Clase que ejecuta las operaciones CRUD de una referencia.

### Entidad Cart

Ubicación: <code>java/src/entities/ </code>

Representa la entidad Cart, el carrito de la compra.

### Entidad Item

Ubicación: <code>java/src/entities/ </code>

Representa la entidad ítem, la referencia añadida al carrito de la compra.

---

## HibernateUtil

Ubicación: <code>java/src/utils/ </code>

Clase de utilidad que nos permite gestionar la creación de una sesión en Hibernate y su cierre.
Esta clase se ha creado con el fin de evitar repetir este código en cada operación CRUD de los daos.

## Fichero de configuración de Hibernate

Ubicación: <code>resources/</code>

Fichero XML en donde se guardan los siguientes bloques que Hibernate carga para conectar con la base de datos:
-  Configuración para conectar con MySQL: este proyecto está configurado para conectarse al motor de bases de datos MySQL
-  Configuración para el pool de conexiones.
-  Configuración para el dialecto a usar.
-  Configuración para mostrar las consultas por consola
-  Configuración para la política de actualización de la base de datos al iniciar la aplicación.
-  Configuración para las entidades registradas en Hibernate.

## Fichero de configuración mapeo de la entidad Student

Ubicación: <code>resources/</code>

Se proporciona un ejemplo de XML de fichero de mapeo entidad - tabla de base de datos.

Este fichero es una alternativa a las anotaciones para mapear las entidades con las tablas de la base de datos.