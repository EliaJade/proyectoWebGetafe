<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.List"%>
    <%@ page import = "es.cursojava.ejercicios.formularioAlumno.dto.AlumnoDTOResponse"%>
    
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Alumnos</title>
</head>
<body>
    <h2>Lista de alumnos</h2>
    <table border="1" cellpadding="5" cellspacing="0">
        <thead>
            <tr>
                <th>Nombre</th><th>Email</th><th>Edad</th>
            </tr>
        </thead>
        <tbody id = "tablaAlumno"> 
        
            <%
            List<AlumnoDTOResponse> lista = (List<AlumnoDTOResponse>) request.getAttribute("alumnos");
            if(lista != null && !lista.isEmpty()){
            	for (AlumnoDTOResponse alumno : lista){
            %>
                <tr>
                    <td><%= alumno.getNombre() %></td>
                    <td><%= alumno.getEmail() %></td>
                    <td><%= alumno.getEdad() %></td>
                </tr>
              <%
            	} 
            } else {
            	
            
              %>  <tr>
              			<td colspan= "5" style="text-align: center; padding: 20px;">
              			No students found in database
              			</td>
              	</tr>
              	
              	<%
              	}
              	%>
           
        </tbody>
    </table>
</body>
</html>