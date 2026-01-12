package es.cursojava.ejercicios.formularioAlumno.dto;

public class AlumnoDTORequest {
	private String nombre;
	private String email;
	private Integer edad;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public AlumnoDTORequest(String nombre, String email, Integer edad) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.edad = edad;
	}
	
	
	
	
	
	
	
	
	
	
}
