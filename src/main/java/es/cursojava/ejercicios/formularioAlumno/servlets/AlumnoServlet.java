package es.cursojava.ejercicios.formularioAlumno.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import es.cursojava.ejercicios.formularioAlumno.dao.AlumnoDAO;
import es.cursojava.ejercicios.formularioAlumno.dto.AlumnoDTORequest;
import es.cursojava.ejercicios.formularioAlumno.service.AlumnoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registrarAlumno")
public class AlumnoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LocalDate now = LocalDate.now();
		String nombre = req.getParameter("nombre");
		String email = req.getParameter("email");
		Integer edad = Period.between(LocalDate.parse(req.getParameter("fechaNacimiento")), now).getYears();
		
		System.out.println("Nombre: "+ nombre);
		System.out.println("Email: " + email);
		System.out.println("Edad: " + edad);
		
		AlumnoDAO dao = new AlumnoDAO();
		AlumnoService service = new AlumnoService(dao);

		AlumnoDTORequest alumnoDTO = new AlumnoDTORequest(nombre, email, edad);
		service.verificar(alumnoDTO);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

	
}
