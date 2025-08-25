# 📘 Foro Hub

_Challenge del curso Oracle ONE G8 con Alura Latam: API REST protegida con Spring Security_

Foro Hub es una API REST desarrollada con Spring Boot y MySQL Workbench, pensada como un foro de Legal Tech donde abogados y estudiantes pueden preguntar, opinar, intercambiar dudas y subir cursos gratuitos de Legal Tech. Documentación disponible con Swagger.

Es el cuartyo y último proyecto del programa One G8 de Oracle Next Education en colaboración con Alura Latam. 

## 🚀 Cómo ejecutar

1. Crear base de datos MySQL llamada `foro_hub`.
2. Configurar credenciales en `application.properties`.
3. Ejecutar `ForoHubApplication.java` en IntelliJ para iniciar el contexto de Spring.
4. Abrir la url http://localhost:8080/api/swagger-ui/index.html#/ para navegar en el proyecto con Swagger UI.
5. Como alternativa, puede probarse en un cliente REST como Insomnia. 

## 📚 Funcionalidades principales

- Registro y autenticación de usuarios con JWT.
- Endpoints protegidos: solo usuarios autenticados pueden acceder.
- Crear y consultar posts y comentarios.
- Filtrado de contenido por categoría o autor. (Pendiente)
- Excepciones y validaciones agregadas y en desarrollo.
- Tests para probar el funcionamiento de la aplicación (Pendiente).
- Aplicación disponible para subirse a la nube (Pendiente). 

## 🛠️ Tecnologías y librerías usadas

- Java 17  
- MySQL  
- Spring Boot 3.x (Data JPA, Security)  
- JWT para autenticación  
- Swagger con springdoc-openapi
- IntelliJ IDEA como IDE

## 🧑‍💻 Autor

**Lic. Guillermo Dardón**  
Abogado con experiencia en dercho migratorio, derecho comercial internacional, derecho aduanero, derecho mercantil, cobranza judicial, extrajudicial y negociación.  
Entusiasta de la programación y la IA aplicada al derecho mexicano  
GitHub: [@Attorneyguillermodardon](https://github.com/Attorneyguillermodardon)  

![Mi Foto de Perfil](https://avatars.githubusercontent.com/u/196573116?s=400&u=ddd3ae9a0263d494b7ecb6b0db3dfed8ce292dee&v=4)

---

## 📌 Notas finales

Este README es provisional; se seguirá desarrollando el manejo de excepciones, se añadirán tests automatizados (Jackson Tester) e implementaremos mejoras de seguridad y se configurarán las variables de ambiente.  
También se agregarán entidades como Usuario y Respuesta con sus endpoints correspondientes. 
Además, se habilitará para realizar el deploy de la app en la nube.

## 📌 Otros pasos siguientes: 
Haseo de contraseña de los usuarios para guardarla en la base de datos 
Otros pasos siguientes: 
Acceder a las direcciones que disponibilizan la documentación de la API en los formatos yaml y html;
Escribir tests automatizados en una aplicación con Spring Boot;
Escribir tests automatizados de una interfaz Repository, siguiendo la estrategia de usar la misma base de datos que la aplicación utiliza;
Sobrescribir propiedades del archivo application.properties, creando otro archivo llamado application-test.properties que sea cargado solo al ejecutar los tests, utilizando para ello la anotación @ActiveProfiles;
Escribir tests automatizados de una clase Controller, utilizando la clase MockMvc para simular requests en la API;
Testar escenarios de error 400 y código 200 en el test de una clase Controller.

Utilizar archivos de propiedades específicos para cada profile, modificando en cada archivo las propiedades que necesitan ser modificadas;
Configurar informaciones sensibles de la aplicación, como datos de acceso a la base de datos, a través de variables de ambiente;
Realizar el build del proyecto a través de Maven;
Ejecutar la aplicación vía terminal, con el comando java -jar, pasando las variables de ambiente como parámetro.


Para generar un build de nuestra aplicación, ejecutamos Maven, específicamente el package de Maven, dentro del ciclo de vida de nuestra aplicación, lo que nos generó un archivo API 0.0.1, en este caso nuestro archivo YAR. También vimos cómo generar otros archivos de producción para tener un perfil de producción totalmente aislado de los otros perfiles, ya que es el que utilizaremos en producción.

Utilizamos variables de entorno para configurar nuestra aplicación con ciertas URLs, nombres de usuario y contraseñas, asegurando que no sean visibles para posibles atacantes. Simulamos ese entorno de producción a través de la línea de comandos, pasando el perfil y las variables.


