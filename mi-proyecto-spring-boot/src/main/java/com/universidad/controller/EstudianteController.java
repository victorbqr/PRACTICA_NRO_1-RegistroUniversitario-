package com.universidad.controller; // Define el paquete al que pertenece esta clase

import java.util.List; // Importa la interfaz List para manejar listas

import org.springframework.beans.factory.annotation.Autowired; // Importa la anotación Autowired de Spring
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity; // Importa la clase ResponseEntity de Spring para manejar respuestas HTTP
import org.springframework.web.bind.annotation.*;
import com.universidad.dto.EstudianteDTO; // Importa la clase EstudianteDTO del paquete dto
import com.universidad.service.IEstudianteService; // Importa la interfaz IEstudianteService del paquete service


@RestController // Anotación que indica que esta clase es un controlador REST de Spring
@RequestMapping("/api") // Define la ruta base para las solicitudes HTTP a este controlador
public class EstudianteController { // Define la clase EstudianteController
    private final IEstudianteService estudianteService; // Declara una variable final para el servicio de estudiantes

    @Autowired // Anotación que indica que el constructor debe ser usado para inyección de dependencias
    public EstudianteController(IEstudianteService estudianteService) { // Constructor que recibe el servicio de estudiantes
        this.estudianteService = estudianteService; // Asigna el servicio de estudiantes a la variable de instancia
    }

    @GetMapping("/estudiantes") // Anotación que indica que este método maneja solicitudes GET
    public ResponseEntity<List<EstudianteDTO>> obtenerTodosLosEstudiantes() { // Método para obtener una lista de todos los EstudianteDTO
        List<EstudianteDTO> estudiantes = estudianteService.obtenerTodosLosEstudiantes(); // Llama al servicio para obtener todos los estudiantes
        return ResponseEntity.ok(estudiantes); // Retorna una respuesta HTTP 200 OK con la lista de estudiantes
    }
    
    //obtener estudiante por su ID
    @GetMapping("/estudiantes/{id}") // Anotación que indica que este método maneja solicitudes GET
    public ResponseEntity<EstudianteDTO> obtenerEstudiantePorId(@PathVariable Long id){ // Método para obtener una lista de un EstudianteDTO por su ID
        EstudianteDTO estudiante = estudianteService.obtenerEstudiantePorId(id); // Llama al servicio para obtener un estudiante por su ID
        return ResponseEntity.ok(estudiante); // Retorna una respuesta HTTP 200 OK con la lista del estudiante por su ID
    }
    //actualizar estudiante
    @PutMapping("/estudiantes/{id}") // Anotación que indica que este método maneja solicitudes PUT
    public ResponseEntity<EstudianteDTO> actualizarEstudiante( 
        @PathVariable Long id, 
        @RequestBody EstudianteDTO estudianteDTO){ // Método para actualizar los datos de un EstudianteDTO
            EstudianteDTO estudianteActualizado = estudianteService.actualizarEstudiante(id, estudianteDTO); // Llama al servicio para actualizar datos de un estudiante por su ID
            return ResponseEntity.ok(estudianteActualizado); // Retorna una respuesta HTTP 200 OK con datos acutalizados del estudiante 
        }

    //registrar un nuevo estudiante
    @PostMapping("/estudiantes") // Anotación que indica que este método maneja solicitudes POST
    public ResponseEntity<EstudianteDTO> registrarEstudiante(@RequestBody EstudianteDTO estudianteDTO){ // Método para registrar nuevos datos de un EstudianteDTO
        EstudianteDTO estudianteRegistrado = estudianteService.registrarEstudiante(estudianteDTO); // Llama al servicio para registrar los datos nuevo de un estudiante
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteRegistrado); // Retorna una respuesta HTTP 201 CREATED con datos nuevos del estudiante 
    }

    //eliminar un estudiante por Id
    @DeleteMapping("/estudiantes/{id}") // Anotación que indica que este método maneja solicitudes DELETE
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) { // Método para eliminar los datos de un EstudianteDTO por su ID
        estudianteService.eliminarEstudiante(id); // Llama al servicio para eliminar los datos de un estudiante mediante su ID
        return ResponseEntity.noContent().build();// Retorna una respuesta HTTP 204 No Content con la eliminacion de los datos del estudiante
    }
}
