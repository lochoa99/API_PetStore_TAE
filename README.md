# 🐾 Automatización de API - PetStore (PerfDog)

Este repositorio contiene la resolución de la prueba técnica de automatización de APIs para el flujo de negocio de la tienda de mascotas "PerfDog".

## 📖 Descripción del Proyecto
[cite_start]Dado que el *front-end* de la tienda aún se encuentra en desarrollo [cite: 8, 9][cite_start], este proyecto automatiza la validación del *back-end* consumiendo la API pública documentada en [Swagger Petstore](https://petstore.swagger.io)[cite: 10]. 

[cite_start]Se ha automatizado el siguiente flujo transaccional continuo [cite: 14-20]:
1. Crear un usuario.
2. Hacer login con el usuario creado.
3. Listar todas las mascotas con estatus "disponible".
4. Consultar los datos de una mascota en específico.
5. Crear una orden (compra) para una mascota.
6. Hacer logout de la aplicación.

## 🛠️ Stack Tecnológico
[cite_start]Para cumplir estrictamente con los requerimientos técnicos del proyecto [cite: 22, 25-28], se utilizaron las siguientes herramientas:
* **Lenguaje:** Java 8+
* **Gestor de Dependencias:** Maven
* **Librería de API Testing:** REST Assured (v5.4.0)
* **Test Runner:** TestNG (v7.4.0)
* **Manejo de JSON:** Jackson Databind

## 🏗️ Arquitectura del Proyecto
El framework fue diseñado utilizando el patrón **API Object Model** para garantizar la mantenibilidad y escalabilidad del código. La estructura se divide en:
* `api.endpoints`: Contiene las clases que construyen las URLs y ejecutan las peticiones HTTP (GET, POST).
* `api.payloads`: Contiene las clases POJO (Plain Old Java Objects) que representan el cuerpo de las peticiones (JSON) como `User` y `Order`.
* `api.tests`: Contiene las clases de TestNG con las aserciones.

[cite_start]**Nota sobre la Independencia de Pruebas:** Cumpliendo con la regla de negocio, **cada prueba es 100% independiente**[cite: 25]. Las pruebas no dependen del orden de ejecución, ya que cada método `@Test` (o su `@BeforeMethod`) se encarga de instanciar y preparar su propia data fresca antes de ejecutarse.

## 🚀 Cómo ejecutar las pruebas
Existen dos formas de ejecutar la suite de pruebas:

**Opción 1: Desde el IDE (IntelliJ / Eclipse)**
1. Clonar el repositorio.
2. Sincronizar las dependencias de Maven.
3. Clic derecho en el archivo `testng.xml` en la raíz del proyecto.
4. Seleccionar `Run '...\testng.xml'`.

**Opción 2: Desde la consola (Maven)**
Ejecutar el siguiente comando en la terminal desde la raíz del proyecto:
```bash
mvn clean test
