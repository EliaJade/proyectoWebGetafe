package es.cursojava.ejercicios.formularioAlumno.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.cursojava.ejercicios.formularioAlumno.dao.AlumnoDAO;
import es.cursojava.ejercicios.formularioAlumno.dto.AlumnoDTOResponse;
import es.cursojava.ejercicios.formularioAlumno.service.AlumnoService;
import es.cursojava.hibernate.ejercicios.ejercicio1.entities.Alumno;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/alumnosLista")
public class ListaAlumnos extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AlumnoDAO dao = new AlumnoDAO();
		AlumnoService service = new AlumnoService(dao);
		List<AlumnoDTOResponse> alumnos = service.getTodosLosAlumnosDTO();
		
		req.setAttribute("alumnos", alumnos);
		req.getRequestDispatcher("/listaDeAlumnos.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
