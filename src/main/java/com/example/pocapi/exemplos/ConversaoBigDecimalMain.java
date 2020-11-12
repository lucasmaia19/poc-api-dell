package com.example.pocapi.exemplos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;

public class ConversaoBigDecimalMain {

	public static void main(String[] args) {
		
		// string para int
		String a = "10";
		int b = 20;
		Integer valueOf = Integer.valueOf(a);
		
		System.out.println(valueOf + b);
		
		// string para bigdecimal

		//	String str = "1.500,00";

		// Converte string formato decimal para objeto BigDecimal e depois para string formato moeda pt-BR
		String str = "123.45";
		BigDecimal num = new BigDecimal(str);
		System.out.println(num);
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		System.out.println(nf.format(num));

		
//		String num2 = "1.500,00";
//					
//		DecimalFormat num1 = (DecimalFormat) NumberFormat.getInstance();
//		num1.setParseBigDecimal(true);
//	
//		BigDecimal bd = (BigDecimal)num1.parse(num2, new ParsePosition(0));
//	
//	 	System.out.println(bd);


	}

}
