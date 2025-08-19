# 📘 Foro Hub

_Challenge del curso Oracle ONE G8 con Alura Latam: API REST protegida con Spring Security_

Foro Hub es una API REST desarrollada con Spring Boot y MySQL Workbench, pensada como un foro de Legal Tech donde abogados y estudiantes pueden preguntar, opinar, intercambiar dudas y subir cursos gratuitos de Legal Tech. Documentación disponible con Swagger.

## 🚀 Cómo ejecutar

1. Crear base de datos MySQL llamada `foro_hub`.
2. Configurar credenciales en `application.properties`.
3. Ejecutar `ForoHubApplication.java` en IntelliJ para iniciar el contexto de Spring.

## 📚 Funcionalidades principales

- Registro y autenticación de usuarios con JWT.
- Endpoints protegidos: solo usuarios autenticados pueden acceder.
- Crear y consultar posts y comentarios.
- Filtrado de contenido por categoría o autor.
- Preparado para agregar manejo de excepciones y validaciones.

## 🛠️ Tecnologías y librerías usadas

- Java 17  
- MySQL  
- Spring Boot 3.x (Data JPA, Security)  
- JWT para autenticación  
- Swagger para documentación de API  
- IntelliJ IDEA como IDE

## 🧑‍💻 Autor

**Lic. Guillermo Dardón**  
Abogado en Derecho Internacional y Mercantil  
Entusiasta de la programación y la IA aplicada al derecho mexicano  
GitHub: [@Attorneyguillermodardon](https://github.com/Attorneyguillermodardon)  

![Mi Foto de Perfil](https://avatars.githubusercontent.com/u/196573116?s=400&u=ddd3ae9a0263d494b7ecb6b0db3dfed8ce292dee&v=4)

---

## 📌 Notas finales

Este README es provisional; en próximas actualizaciones se documentarán todos los endpoints, se agregará manejo de excepciones, tests y mejoras de seguridad.  
El proyecto funciona iniciando `ForoHubApplication.java` y probando los endpoints desde un cliente REST como Insomnia.
