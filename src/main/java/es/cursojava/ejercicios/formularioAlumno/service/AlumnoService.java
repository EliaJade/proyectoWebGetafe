package es.cursojava.ejercicios.formularioAlumno.service;

import java.sql.SQLException;

import es.cursojava.ejercicios.formularioAlumno.dao.AlumnoDAO;
import es.cursojava.ejercicios.formularioAlumno.dto.AlumnoDTORequest;
import es.cursojava.ejercicios.formularioAlumno.dto.AlumnoDTOResponse;
import es.cursojava.hibernate.ejercicios.ejercicio1.entities.Alumno;

public class AlumnoService {
	
	private AlumnoDAO alumnoDAO;
	
	public AlumnoService(AlumnoDAO alumnoDAO) {
		super();
		this.alumnoDAO = alumnoDAO;
	}
	
	public AlumnoDTOResponse verificar(AlumnoDTORequest dto) {
		if(dto.getNombre().isEmpty()) {
			throw new IllegalArgumentException("El alumno debe tener un nombre");
		}
		if(dto.getEmail().isEmpty()) {
			throw new IllegalArgumentException("El alumno debe tener un correo");
		}
		if(dto.getEdad()<0) {
			throw new IllegalArgumentException("La edad no puede ser negativa");
		}
		if(dto.getNombre().length()>30) {
			throw new IllegalArgumentException("El nombre del alumno no debe superar 30 caracteres");
			
		}
		if(!dto.getNombre().matches("^[A-Za-zÁÉÍÓÚáéíóúÑñÜü ]+$")) {
			throw new IllegalArgumentException("El nombre del alumno no puede contener caracter especial");
		}
		if (!dto.getEmail().contains("@")||!dto.getEmail().contains(".")) {
			throw new IllegalArgumentException("El email debe contener @ y .");
		}
		try {
			if (alumnoDAO.emailExists(dto.getEmail())) {
				throw new IllegalArgumentException("This email is already asigned to an existing student");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Alumno alumno = new Alumno();
		alumno.setNombre(dto.getNombre());
		alumno.setEmail(dto.getEmail());
		alumno.setEdad(dto.getEdad());
		
		alumnoDAO.save(alumno);
		
		AlumnoDTOResponse response = new AlumnoDTOResponse();
		response.setId(alumno.getId());
		response.setEdad(alumno.getEdad());
		response.setEmail(alumno.getEmail());
		response.setNombre(alumno.getNombre());
		System.out.println("Se ha registrado correctamente el alumno");
		
		return response;
		
	}



	

}
