package com.example.pocapi.exemplos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter @Setter @ToString
class Cliente {

	private String apiPatrimonio;

	private String uiPatrimonio;

}

public class ConversaoBigDecimalMain {

	public static void main(String[] args) {

//		string2BigDecimalMoedaBR("123.45");

//		String valorFinal = stringValorMonetarioBR2BigDecimalFormatBancoDeDados("7.633,53");
		
//		System.out.println(valorFinal);

//		Cliente lucas = new Cliente();
//
//		String valorFormatoApi = "500000.50";
//		lucas.setApiPatrimonio(valorFormatoApi);
//		
//		String valorFormatoUi = string2BigDecimalMoedaBR(lucas.getApiPatrimonio());
//		lucas.setUiPatrimonio(valorFormatoUi);
//
//		System.out.println(lucas);


		Cliente joao = new Cliente();

		String uiPatrimonio = "1.500,00";

		joao.setUiPatrimonio(uiPatrimonio);

		String valorFormatoApi2 = stringValorMonetarioBR2BigDecimalFormatBancoDeDados(joao.getUiPatrimonio());
		joao.setApiPatrimonio(valorFormatoApi2);

		System.out.println(joao);
		
	}

	private static String string2BigDecimalMoedaBR(String string) {

		BigDecimal num = new BigDecimal(string);

		NumberFormat nf = NumberFormat.getCurrencyInstance();

		String bidDecimalFormatado = nf.format(num);

		return bidDecimalFormatado;
	}

	private static String stringValorMonetarioBR2BigDecimalFormatBancoDeDados (String string) {

		DecimalFormat valorMonetarioDecimal = (DecimalFormat) NumberFormat.getInstance();
		valorMonetarioDecimal.setParseBigDecimal(true);

		BigDecimal valorMonetarioFormat = (BigDecimal)valorMonetarioDecimal.parse(string, new ParsePosition(0));
		
	 	return valorMonetarioFormat.toString();
	}

}
