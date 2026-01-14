package es.cursojava.ejercicios.formularioAlumno.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import es.cursojava.ejercicios.formularioAlumno.dao.AlumnoDAO;
import es.cursojava.ejercicios.formularioAlumno.dto.AlumnoDTORequest;
import es.cursojava.ejercicios.formularioAlumno.dto.AlumnoDTOResponse;
import es.cursojava.ejercicios.formularioAlumno.service.AlumnoService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registrarAlumno")
public class AlumnoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entrando en doGet de AlumnoServlet");
		try {
			AlumnoService service = new AlumnoService(new AlumnoDAO()); //TODO: get rid of parameter 
			List<AlumnoDTOResponse> alumnos = service.getTodosLosAlumnosDTO();
			for (AlumnoDTOResponse a : alumnos) {
				System.out.println(a.getNombre());
			}
			
			req.setAttribute("alumnos", alumnos);
			req.getRequestDispatcher("/ejercicios/formularioAlumnos/listadoAlumnos.jsp").forward(req, resp);
			}catch(Exception e){
				resp.sendError(500, "No se pudo obtener la lista de alumnos");
			}
	}
		
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Entrando en doPost AlumnoServlet");
		AlumnoService service = new AlumnoService(new AlumnoDAO()); //TODO: get rid of parameter 
		LocalDate now = LocalDate.now();
		String nombre = req.getParameter("nombre");
		String email = req.getParameter("email");
		if(req.getParameter("fechaNacimiento").isEmpty()) {
			throw new IllegalArgumentException("El alumno debe tener la edad");
		}
		Integer edad = service.calcularEdad(LocalDate.parse(req.getParameter("fechaNacimiento")));
		
		System.out.println("Nombre: "+ nombre);
		System.out.println("Email: " + email);
		System.out.println("Edad: " + edad);
		;

		AlumnoDTORequest alumnoDTO = new AlumnoDTORequest(nombre, email, edad);
		try {

			service.verificar(alumnoDTO);
			resp.getWriter().println("Alumno dado de alta correctamente");
		} catch(IllegalArgumentException e) {
			resp.getWriter().println("Error al dar de alta el alumno");
		}
		
	
	}

	
}
