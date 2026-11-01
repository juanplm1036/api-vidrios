# API REST de inventario de vidrios – Actividad #2

## 1. Descripción del proyecto

Para esta segunda actividad decidí continuar trabajando con el proyecto **api-vidrios**, que había desarrollado en la actividad anterior.

La idea es llevarlo un poco más allá y construir una API REST que permita administrar un inventario de vidrios, como los que se manejan normalmente en una distribuidora.

En esta oportunidad incorporé una base de datos utilizando Spring Data JPA, Hibernate y H2. Esto permite que la información de los productos no se maneje solamente desde listas en el código, sino que pueda guardarse y consultarse desde una base de datos.

Con este ejercicio busco comprender mejor cómo se conectan las diferentes partes de una aplicación y cómo se realizan las operaciones para crear, consultar, actualizar y eliminar información.

## 2. Tecnologías utilizadas

Para desarrollar el proyecto utilicé las siguientes herramientas:

- Java 24 instalado en el equipo. El proyecto está configurado para compilar con Java 21.
- Spring Boot 4.1.1.
- Spring Web MVC para construir los servicios REST.
- Spring Data JPA para trabajar con la información.
- Hibernate como herramienta de persistencia.
- H2 como base de datos.
- Maven para administrar las dependencias y compilar el proyecto.
- Visual Studio Code como entorno de desarrollo.
- PowerShell para realizar las pruebas de las solicitudes HTTP.

## 3. Organización del proyecto

El proyecto está organizado en diferentes paquetes para mantener el código más ordenado y facilitar su comprensión.

- **controller:** recibe las solicitudes HTTP y devuelve las respuestas de la API.
- **entity:** contiene la clase Vidrio, que representa la información que se almacena en la base de datos.
- **repository:** permite realizar las operaciones de consulta, almacenamiento, actualización y eliminación.
- **service:** contiene la lógica para administrar los registros de vidrios.
- **resources:** contiene el archivo de configuración de la base de datos.

## 4. Información que se almacena

La entidad principal del proyecto es `Vidrio`, que contiene los siguientes campos:

| Campo | Descripción |
|---|---|
| id | Identificador único del vidrio |
| referencia | Referencia comercial del producto |
| tipo | Tipo de vidrio |
| espesor | Espesor en milímetros |
| precio | Precio del producto |
| stock | Cantidad disponible |

El identificador se genera automáticamente cuando se registra un nuevo producto.

## 5. Operaciones disponibles

La API permite realizar las siguientes operaciones:

| Método | Endpoint | Función |
|---|---|---|
| POST | /api/vidrios | Registrar un vidrio |
| GET | /api/vidrios | Consultar todos los vidrios |
| GET | /api/vidrios/{id} | Consultar un vidrio por su ID |
| PUT | /api/vidrios/{id} | Actualizar un vidrio |
| DELETE | /api/vidrios/{id} | Eliminar un vidrio |
| GET | /api/vidrios/buscar?tipo=INCOLORO | Buscar por tipo de vidrio |

También se manejan respuestas HTTP para indicar el resultado de las operaciones, como 200, 201, 204 y 404.

## 6. Base de datos y persistencia

Para esta actividad utilicé H2, una base de datos que permite realizar las pruebas sin necesidad de instalar un servidor de base de datos adicional.

La conexión y configuración se encuentran en el archivo `application.properties`.

Hibernate se encarga de crear la tabla `vidrios` a partir de la entidad definida en Java.

Es importante tener presente que la base de datos está configurada en memoria. Por esta razón, los registros permanecen disponibles mientras la aplicación está ejecutándose y se reinician cuando se vuelve a iniciar.

## 7. Cómo ejecutar el proyecto

Para ejecutar la aplicación se deben seguir estos pasos:

1. Abrir el proyecto en Visual Studio Code.
2. Abrir una terminal en la carpeta principal, donde se encuentra el archivo `pom.xml`.
3. Ejecutar el siguiente comando para compilar:

   `.\mvnw.cmd clean compile`

4. Para iniciar la aplicación ejecutar:

   `.\mvnw.cmd spring-boot:run`

5. La API estará disponible en:

   `http://localhost:8080`

## 8. Pruebas realizadas

Durante el desarrollo realicé pruebas desde PowerShell para comprobar el funcionamiento de las diferentes operaciones.

Como prueba inicial registré un vidrio con la referencia INCOLORO-6MM, espesor de 6 mm, precio de $110.000 y stock de 50 unidades.

Después consulté el registro mediante GET y comprobé que la información se había guardado correctamente en H2.

También realicé una búsqueda por identificador y otra por tipo de vidrio. Posteriormente actualicé el precio a $125.000 y el stock a 45 unidades. Finalmente, probé la operación DELETE y confirmé que el registro ya no aparecía al consultar el inventario.

Estas pruebas me permitieron comprobar que las operaciones de la API funcionan y que la información se está gestionando mediante JPA y Hibernate.

## 9. Uso de inteligencia artificial

Durante el desarrollo de esta actividad utilicé ChatGPT como herramienta de apoyo para comprender algunos conceptos, organizar la estructura del proyecto, revisar el código y solucionar errores que fueron apareciendo durante la implementación.

Los ejemplos y orientaciones recibidos fueron revisados, adaptados al proyecto y probados en mi entorno de desarrollo.

Considero que esta herramienta fue un apoyo importante para el aprendizaje, especialmente porque algunos de estos temas representan un reto para mí y debo distribuir el tiempo entre mis responsabilidades laborales y académicas.

## 10. Reflexión final

Con esta actividad pude avanzar en la comprensión de cómo funciona una API REST cuando se conecta con una base de datos.

Uno de los aprendizajes más importantes fue entender la función de cada componente: la entidad, el repositorio, el servicio y el controlador, y cómo trabajan conjuntamente para administrar la información.

Reconozco que durante el desarrollo se presentaron algunas dificultades, especialmente con la configuración de las dependencias y los errores de compilación. Sin embargo, fui solucionándolos paso a paso, realizando pruebas hasta conseguir que la aplicación funcionara correctamente.

Me queda mucho por aprender, pero considero que este ejercicio me permitió fortalecer mis conocimientos y acercarme un poco más a la forma en que se desarrollan aplicaciones que pueden tener utilidad en un entorno real.

---

**Proyecto:** api-vidrios  
**Actividad:** Colaborativa #2 – API REST con persistencia y operaciones CRUD.
