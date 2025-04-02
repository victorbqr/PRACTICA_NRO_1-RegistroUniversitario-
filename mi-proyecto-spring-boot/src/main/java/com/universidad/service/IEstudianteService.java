package com.universidad.service;

import java.util.List;
import com.universidad.dto.EstudianteDTO;

public interface IEstudianteService {

    List<EstudianteDTO> obtenerTodosLosEstudiantes();
    // a)
    //Metodo para obtener un estudiante por su ID
    EstudianteDTO obtenerEstudiantePorId(Long id);
    //Metodo para actualizar datos de un estudiante por su ID
    EstudianteDTO actualizarEstudiante(Long id, EstudianteDTO estudianteDTO);
    // b)
    //Metodo para registrar un nuevo estudiante
    EstudianteDTO registrarEstudiante(EstudianteDTO estudianteDTO);
    // c)
    //Metodo para eliminar un estudiante por ID
    void eliminarEstudiante(Long id);
}