"# microo-jwt-oauth" 

# Microservicio de Generación de JWT y OAuth2

Este microservicio, implementado en Java Spring Boot y compatible con Java 17, proporciona funcionalidades para generar y autenticar tokens JWT. Actualmente, cuenta con implementación para JWT, con planes de expansión hacia OAuth2.

## Requisitos Previos

- Java 17
- Spring Boot (especificar versión)
- Cualquier otra dependencia específica del proyecto

## Instalación y Configuración

Instrucciones paso a paso para clonar el repositorio, instalar dependencias y configurar el entorno de desarrollo necesario para el microservicio.

## Uso

### Endpoints Disponibles

1. **Chequeo de Salud**
   - **URL**: `localhost:8081/jwtfilter/health`
   - **Método**: GET
   - **Descripción**: Verifica la salud del microservicio.

2. **Obtener Token**
   - **URL**: `localhost:8081/GetToken`
   - **Método**: GET
   - **Descripción**: Genera un token JWT para acceder a endpoints protegidos.
   - **Respuesta de Ejemplo**:
     ```json
     {
         "operacion": "Operacion Exitosa",
         "resultado": {
             "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJHaWJyYW4iLCJpYXQiOjE3MDA1OTk1NzZ9.6iSpha1OIxdW1sAPEdoLgwtx0FMTYR-oVQuqvB5mGTj315rYqNm1M2l-ys9ZRAh4Bo9mY03RtOkSwfhEk_6VyA"
         }
     }
     ```

3. **Autenticación con JWT**
   - **URL**: `localhost:8081/jwtfilter/autentificacion`
   - **Método**: GET
   - **Descripción**: Autentica utilizando el token JWT obtenido.
   - **Requiere**: Bearer Token
   - **Respuesta de Ejemplo**:
     ```json
     {
         "operacion": "Operacion Exitosa",
         "resultado": {
             "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJnaWJyYW4yIiwiaWF0IjoxNzAwNTk5NTk5LCJleHAiOjE3MDA2MDA0OTl9.eofBXJe5TrLXe2NdgpDlvYglTKKhES5JaSBD3CCeawjqdOu8KfMZOEf6gGQ9tfBbeaey07gpamZlz4IbiQ7rAQ"
         }
     }
     ```
