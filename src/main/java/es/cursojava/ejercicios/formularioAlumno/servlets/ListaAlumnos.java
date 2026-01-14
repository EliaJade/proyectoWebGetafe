package es.cursojava.ejercicios.formularioAlumno.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import es.cursojava.ejercicios.formularioAlumno.dao.AlumnoDAO;
import es.cursojava.ejercicios.formularioAlumno.dto.AlumnoDTOResponse;
import es.cursojava.ejercicios.formularioAlumno.service.AlumnoService;
import es.cursojava.hibernate.ejercicios.ejercicio1.entities.Alumno;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

////@WebServlet("/alumnosLista")
//public class ListaAlumnos extends HttpServlet{
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		try {
//			System.out.println("Entro al listaAlumnos servlet");
//			AlumnoService service = new AlumnoService(new AlumnoDAO());
//			List<AlumnoDTOResponse> alumnos = service.getTodosLosAlumnosDTO();
//			
//			req.setAttribute("alumnos", alumnos);
//			req.getRequestDispatcher("/ejercicios/formularioAlumnos/listadoAlumnos.jsp").forward(req, resp);
//			}catch(Exception e){
//				resp.sendError(500, "No se pudo obtener la lista de alumnos");
//			}
//			
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(req, resp);
//	}

//}
