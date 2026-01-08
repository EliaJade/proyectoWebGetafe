package es.cursojava.service;

import es.cursojava.dto.calculadora.CalculadoraDTO;

public class CalculadoraService {

	public String calcular(CalculadoraDTO dto) {
		String resultado = "";
		switch(dto.getOperacion()) {
		case "suma":
			resultado = "Resultado suma: " + (dto.getNum1() + dto.getNum2());
			break;
		case "resta":
			resultado = "Resultado resta: " + (dto.getNum1() - dto.getNum2());
			break;
		case "multiplicacion":
			resultado = "Resultado multiplicacion: " + (dto.getNum1() * dto.getNum2());
			break;
		default:
			resultado = "Opercaion no valida";
		}
		
		
		return resultado;
		
	}
}
