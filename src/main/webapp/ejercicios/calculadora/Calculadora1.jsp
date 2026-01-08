<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Calculadora 1</title>
    
<link rel="stylesheet" href="Calculadora.css">
</head>
<body>

<h1>Calculadora</h1>

<form action="CalculatorServlet" method="post">

    <h2 id="numeros">
        <!-- Aquí Java escribirá los números -->
        Números: <br>${num1} y ${num2}
    </h2>

	<fieldset>
	<legend>Lista de cálculos:</legend>
   <p>
    <select name="operacion">
        <option value="suma">Suma</option>
        <option value="resta">Resta</option>
        <option value="multiplicacion">Multiplicación</option>
    </select><br><br>

    <input type="submit" value="Enviar">
	</p>
	</fieldset>
</form>

</body>
</html>