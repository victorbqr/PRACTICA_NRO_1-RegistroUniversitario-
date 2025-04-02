# 🎓 Sistema de Registro Universitario (API REST)

♨️API REST para la gestión de estudiantes universitarios, desarrollada con Spring Boot y arquitectura en capas.♨️
Permite:
✅ Registrar nuevos estudiantes
✅ Consultar, actualizar y eliminar registros
✅ Persistencia en memoria (ConcurrentHashMap)

Características:
👾 Respuestas HTTP estándar (200 OK, 201 Created, 204 No Content)
👾 Validación básica de campos
👾 Datos demo precargados (Juan Pérez y María González)

## 🚀 Tecnologías Utilizadas 💾
- **Java 23**
- **Spring Boot v3.4.3**
- **Lombok** - Para reducir código boilerplate
- **ConcurrentHashMap** - Persistencia en memoria
- **DTO Pattern** - Separación entre entidades y transferencia de datos
- **Maven 3.9.9** - Gestión de dependencias
- **Postman** - Para pruebas de los Endpoints

## 📌 Endpoints Creados

| Método | Ruta                     | Descripción                               | 
|--------|--------------------------|-------------------------------------------|
| GET    | `/api/estudiantes`       | Obtiene la lista de todos los estudiantes |
| GET    | `/api/estudiantes/{id}`  | Obtiene los datos de un estudiante por ID |
| POST   | `/api/estudiantes`       | Crea un nuevo estudiante                  |
| PUT    | `/api/estudiantes/{id}`  | Actualiza un estudiante existente por ID  |
| DELETE | `/api/estudiantes/{id}`  | Elimina un estudiante por ID              |

### ♨️ Ejemplo JSON
```json
{
    "nombre": "María",
    "apellido": "García",
    "email": "maria.garcia@example.com",
    "fechaNacimiento": "2000-05-15",
    "numeroInscripcion": "S-2023-001"
}

🛠️ Estructura del Proyecto

src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── universidad/
│   │           ├── controller/    # Lógica de endpoints
│   │           ├── dto/           # Objetos de transferencia (EstudianteDTO, DocenteDTO, MateriaDTO)
│   │           ├── model/         # Entidades (Persona, Estudiante, Docente, Materia)
│   │           ├── repository/    # Persistencia (en memoria)
│   │           └── service/       # Lógica de negocio
│   └── resources/
│       └── application.properties # Configuración

🍂Pruebas iniciales:
El sistema incluye datos demo (2 estudiantes precargados)
Accede a GET /api/estudiantes para verlos


💡Estudiante: Quispe Rojas Victor Bernardo