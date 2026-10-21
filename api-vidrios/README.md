# API REST de Vidrios

## 1. Descripción del proyecto

API REST básica desarrollada con Java y Spring Boot para consultar y registrar información de productos de vidrio.

El proyecto permite consultar un listado de vidrios, buscar un vidrio por identificador, filtrar productos por tipo y registrar nuevos vidrios mediante solicitudes HTTP.

## 2. Tecnologías utilizadas

- Java 24
- Spring Boot 4.1.1
- Maven
- Spring Web
- JSON
- Visual Studio Code

## 3. Endpoints disponibles

| Método HTTP | Endpoint | Descripción |
|---|---|---|
| GET | `/api/vidrios` | Consultar todos los vidrios de prueba |
| GET | `/api/vidrios/{id}` | Consultar un vidrio por identificador |
| GET | `/api/vidrios/buscar?tipo=INCOLORO` | Filtrar vidrios por tipo |
| POST | `/api/vidrios` | Registrar un vidrio mediante JSON |

## 4. Ejemplo de solicitud POST

**URL:** `http://localhost:8080/api/vidrios`

**Método:** `POST`

**Cuerpo JSON:**

```json
{
  "referencia": "INCOLORO-6MM",
  "tipo": "INCOLORO",
  "espesor": 6,
  "precio": 110000
}
```

La API responde con el código HTTP `201 Created` y devuelve los datos recibidos.

## 5. Estructura del proyecto

```text
api-vidrios/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/ejemplo/apividrios/
│   │           ├── ApiVidriosApplication.java
│   │           ├── controller/
│   │           │   └── VidrioController.java
│   │           └── dto/
│   │               └── VidrioRequest.java
│   └── test/
├── mvnw
├── mvnw.cmd
├── pom.xml
└── README.md
```

## 6. Requisitos previos

- Tener instalado Java JDK 24.
- Disponer de una terminal para ejecutar los comandos de Maven.

## 7. Instrucciones de ejecución

1. Descargar o clonar el repositorio.
2. Abrir la carpeta del proyecto en Visual Studio Code.
3. Abrir una terminal en la raíz del proyecto.
4. Ejecutar el siguiente comando en Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

5. Esperar hasta que aparezca el mensaje `Started ApiVidriosApplication`.
6. Abrir `http://localhost:8080/api/vidrios` en el navegador.

## 8. Uso de inteligencia artificial

Se utilizó ChatGPT como herramienta de apoyo para comprender los conceptos de API REST, revisar el código, resolver errores de ejecución y orientar las pruebas de los endpoints. El código se fue implementando y probando en el entorno local del estudiante.

## 9. Autor

Juan Pablo Londoño Meneses

Proyecto académico desarrollado para la actividad colaborativa de construcción y explicación de una API REST básica.
