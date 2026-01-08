package es.cursojava.servlets.calculadora;

import java.io.IOException;

import es.cursojava.dto.calculadora.CalculadoraDTO;
import es.cursojava.service.CalculadoraService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculadoraCorregido")
public class CalculadoraCorregido extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operacion");
		int num1 = Integer.parseInt(req.getParameter("num1"));
		int num2 = Integer.parseInt(req.getParameter("num2"));
		System.out.println("Operacion: " + op);
		System.out.println("Num1: " + num1);

		System.out.println("Num1: " + num2);
		
		CalculadoraDTO calculadoraDTO = new CalculadoraDTO(op, num1, num2);
		CalculadoraService service = new CalculadoraService();
		String resultado = service.calcular(calculadoraDTO);
		
		resp.getWriter().append("<h1>"+resultado+"</h1>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		// TODO Auto-generated method stub
//		super.init(config);
//	}
//
//	@Override
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.service(arg0, arg1);
//	}
//
//	@Override
//	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.service(arg0, arg1);
//	}
//
//	
//}
