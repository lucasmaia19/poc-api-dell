package com.example.pocapi.exemplos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ConversaoDataMain {

	public static void main(String[] args) {

		ConverterStringFormatDate2LocalDateBR("19/03/2001");

		ConverterStringFormatDate2LocalDateUSA("19/03/2001");

		// string para data
//		String dataString = "19/03/2001";
//		
//		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");		
//		LocalDate dataLocalDate = LocalDate.parse(dataString, formatador);
//		
//		System.out.println(dataLocalDate.getDayOfWeek());
//		
//		// string para data USA
//		DateTimeFormatter formatadorInverso = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String dataFormatadaInversa = dataLocalDate.format(formatadorInverso);
//		
//		System.out.println(dataFormatadaInversa);

	}

	private static LocalDate ConverterStringFormatDate2LocalDateBR (String string) {
		
		DateTimeFormatter formatadorBR = DateTimeFormatter.ofPattern("dd/MM/yyyy");		
		LocalDate dataLocalDate = LocalDate.parse(string, formatadorBR);
		
		System.out.println(dataLocalDate.getDayOfWeek());
		
		return dataLocalDate;

	}

	private static LocalDate ConverterStringFormatDate2LocalDateUSA (String string) {

		DateTimeFormatter formatadorInverso = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dataLocalDateUSA = LocalDate.parse(string, formatadorInverso);

//		String dataFormatadaInversa = dataLocalDateUSA.format(formatadorInverso);

		System.out.println(dataLocalDateUSA);

		return dataLocalDateUSA;
	}

}
