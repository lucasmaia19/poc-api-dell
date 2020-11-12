package com.example.pocapi.exemplos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConversaoDataMain {

	public static void main(String[] args) {

		// string para data
		String dataString = "19/03/2001";
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");		
		LocalDate dataLocalDate = LocalDate.parse(dataString, formatador);
		
		System.out.println(dataLocalDate.getDayOfWeek());
		
		// string para data USA
		DateTimeFormatter formatadorInverso = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String dataFormatadaInversa = dataLocalDate.format(formatadorInverso);
		
		System.out.println(dataFormatadaInversa);
		
	}

}
