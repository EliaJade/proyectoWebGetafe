package es.cursojava.ejercicios.calculadora.servlets.calculadora;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Calculadora1")
public class CalculadoraServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	//puts numbers into the session
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
	Random r = new Random();
	int num1 = r.nextInt(100)+1;
	int num2 = r.nextInt(100)+1;
		
	//saves numbers in session
	HttpSession session = request.getSession();
	session.setAttribute("num1", num1);
	session.setAttribute("num2", num2);
	
	//Go to HTML page, so it calculates the numbers before showing the page
	request.getRequestDispatcher("Calculadora1.jsp").forward(request, response);
	}
	
	
	//takes numbers from session and puts them on page
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		//Gets numbers from session
		HttpSession session = request.getSession();
		int num1 =(int) session.getAttribute("num1");
		int num2 =(int) session.getAttribute("num2");
		
		//Get selected operation
		String operation = request.getParameter("operacion");
		int result = 0;
		
		if (operation.equals("suma")) {
			result = num1 + num2;
		}
		if(operation.equals("resta")) {
			result = num1 - num2;
		}
		if(operation.equals("multiplicacion")) {
			result = num1*num2;
		}
		
		// Send result to HTML
		request.setAttribute("resultado", result); //Stores the calculation result in the request so another page can read it. only 1 use
		request.getRequestDispatcher("");
	}
	
}
