**CONTENIDO: EJERCICIO JDBC**

1. En la empresa en la que trabajas te han solicitado desarrollar una aplicación de gestión de alumnos para la escuela de informática. Ejecuta el siguiente script para crear las tablas y datos necesarios:

````
CREATE DATABASE EJEMPLO;

GRANT ALL ON EJEMPLO.* TO 'EJEMPLO'@'localhost' IDENTIFIED BY 'EJEMPLO';

USE EJEMPLO;

CREATE TABLE IF NOT EXISTS departamentos (
dept_no TINYINT(2) NOT NULL,
dnombre VARCHAR(15),
loc VARCHAR(15),
PRIMARY KEY (dept_no)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS empleados (
emp_no SMALLINT(4) UNSIGNED NOT NULL,
nombre VARCHAR(10),
apellido VARCHAR(10),
oficio VARCHAR(10),
dir SMALLINT,
fecha_alt DATE,
salario FLOAT(6,2),
comision FLOAT(6,2),
dept_no TINYINT(2) NOT NULL REFERENCES departamentos (dept_no),
PRIMARY KEY (emp_no)

) ENGINE=InnoDB;


ALTER TABLE empleados ADD CONSTRAINT FK_departamento_empleado FOR-EIGN KEY (dept_no ) REFERENCES departamentos ( dept_no )

INSERT INTO departamentos VALUES (10,"CONTABILIDAD", "SEVILLA");
INSERT INTO departamentos VALUES (20,"INVESTIGACIÓN", "MADRID");
INSERT INTO departamentos VALUES (30,"VENTAS", "BARCELONA");
INSERT INTO departamentos VALUES (40,"PRODUCCIÓN", "BILBAO");

INSERT INTO empleados VALUES(7902, "LUCÍA", "GONZÁLEZ", "DIREC-TOR",7902,"1989-12-01",5040.5,NULL,20);

INSERT INTO empleados VALUES(7369, "PEDRO", "SANCHEZ", "EMPLEA-DO",7902,"1990-12-17",1040,NULL,20);

INSERT INTO empleados VALUES(7499, "JUAN", "ARROYO", "VENDE-DOR",7902,"1990-02-20",1500,390,30);



````

Una vez ejecutado mira el modelo de datos y asegúrate de entenderlo
 Sólo vamos a desarrollar algunas funciones:

1. Dar de alta un alumno: se deberán proporcionar los datos del alumno
2. Eliminar un alumno: se deberá proporcionar el id del alumno
3. Matricular a un alumno en asignaturas: se identificará al alumno y a las asignaturas
4. Ver las asignaturas asociadas a un alumno, mostrando las que ha cursado y las que no. Se mostrarán todos los datos del alumno y de las asignaturas

Debes cumplir los siguientes requisitos:

1. Estructurar la aplicación siguiendo un patrón DAO. Toma como referencia los ejercicios anteriores
2. Definir y gestionar excepciones de forma adecuada
3. Definir un fichero de propiedades adecuado para la conexión a BD
4. Piensa bien en la estructura de clases de tu aplicación y anótala. Será lo primero que corrijamos antes de implementar nada.

Desarrolla una clase de Prueba con método main para representar la lógica de la aplicación y que realice lo siguiente:

1. Crear un nuevo alumno y almacenarlo en BD
2. Busca al alumno nuevo y muestra sus datos por pantalla
3. Borrar un alumno existente
4. Matricular al alumno nuevo en varias asignaturas
5. Consultar las asignaturas para las que está matriculado el nuevo alumno y mostrarlas por pantalla

1. Crear una base de datos en MySQL con nombre EJEMPLO y un usuario con el mismo nombre.

Crea en la base de datos EJEMPLO dos tablas:

- Departamento, con los campos dept\_no, dnombre y loc
- Empleado, con los campos nombre, apellido, oficio, fecha\_alt, salario, comision y la clave foranea dept\_no de la tabla Departamento

Insertar al menos 3 filas en cada una de las filas.

Implementar un programa en Java que mediante JDBC que tenga los siguientes métodos:

- Crear un método que devuelva en todos los objetos empleados de un departamento dado.
- Crear un método que pida por al usuario un departamento e imprima el Apellido, oficio y salario de los empleados de ese departamento.
- Crear un método que devuelva el objeto empleado con el máximo salario.
- Crear un método que imprima por pantalla el nombre, apellidos y salario del empleado con máximo salario.
- Crear un método que reciba un objeto empleado y que lo añada a la base de datos.
- Crea un método que pida al usuario por los datos de un empleado, comprobando que:

- El departamento exista en la tabla DEPARTAMENTOS.
- El número de empleado no exista
- Que el salario sea mayor que cero.
- Que el director exista en la tabla de empleados.

1. Implementar el patrón MVC(Modelo Vista Controlador) que una interfaz gráfica con Swing  para manejar los métodos CRUD de Empleados y Departamentos
