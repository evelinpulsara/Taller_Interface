package com.universidad.api_sistema.service;

import com.universidad.api_sistema.model.Estudiante;
import com.universidad.api_sistema.model.Notificable;
import com.universidad.api_sistema.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistroService implements Notificable { 
    private final EstudianteRepository repository;

    public RegistroService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public Estudiante guardarEstudiante(Estudiante estudiante) {
        Estudiante guardado = repository.save(estudiante);
        System.out.println(enviarCorreo(guardado.getNombre())); 
        return guardado;
    }

    @Override
    public String enviarCorreo(String nombre) {
        return "Correo enviado con éxito a: " + nombre;
    }
}