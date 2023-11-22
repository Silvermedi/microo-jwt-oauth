"# microo-jwt-oauth" 

# Microservicio de Generación de JWT y OAuth2

Este microservicio, implementado en Java Spring Boot y compatible con Java 17, proporciona funcionalidades para generar y autenticar tokens JWT. Actualmente, cuenta con implementación para JWT, con planes de expansión hacia OAuth2.

## Requisitos Previos

- Java 17
- Spring Boot 2.7.17
- Dependencias en el POM.XML

## Instalación y Configuración

Instrucciones paso a paso para clonar el repositorio, instalar dependencias y configurar el entorno de desarrollo necesario para el microservicio.

## Uso

### Endpoints Disponibles

1. **Chequeo de Salud**
   - **URL**: `localhost:8081/jwtfilter/health`
   - **Método**: GET
   - **Descripción**: Verifica la salud del microservicio.
   - ```json
     {
         {
             "operacion": "Operacion Exitosa",
             "resultado": null
         }
     }
     ```

2. **Obtener Token**
   - **URL**: `localhost:8081/GetToken`
   - **Método**: POST
   - **Descripción**: Genera un token JWT para acceder a endpoints protegidos.
   - **Respuesta de Ejemplo**:
     ```json
     {
          "operacion": "Operacion Exitosa",
          "resultado": {
              "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJHaWJyYW4iLCJpYXQiOjE3MDA2MDYzMTZ9.gqTvgSjdmfxFJei6yx87ezO74G2vggoKgnROlB_7ojzcdKkho6Mso0vO1wiNUaj5i-0k4sp2LsN5lD0StIjonw",
              "msj": "Token para testing"
          }
      }
     ```

3. **Autenticación con JWT**
   - **URL**: `localhost:8081/jwtfilter/autentificacion`
   - **Método**: POST
   - **Descripción**: Autentica utilizando el token JWT obtenido.
   - **Requiere**: Bearer Token
   - **Respuesta de Ejemplo**:
     ```json
     {
          "operacion": "Operacion Exitosa",
          "resultado": {
              "username": "usuario1",
              "password": "clave1"
          }
      }
     ```

    4. **TokenExpires con JWT**
   - **URL**: `localhost:8081/jwtfilter/TokenExpires`
   - **Método**: POST
   - **Descripción**: Obtener nuevos token que expiren
   - **Requiere**: Bearer Token
   - **Respuesta de Ejemplo**:
     ```json
       {
          "operacion": "Operacion Exitosa",
          "resultado": {
              "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJnaWJyYW4yIiwiaWF0IjoxNzAwNjA2MzI0LCJleHAiOjE3MDA2MDcyMjR9.YzR9aHvg8WA1bKhZtYuJ5vctvMtF1FFXp6IzhO476w0w_I_8mlLJeszc9PrDaZX1IYSKZiuPMji7NBdA6z40Iw",
              "msj": "Token que expira en 15 minutos"
          }
      }
     ```
