package com.example.pocapi.exemplos;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.pocapi.model.Formulario;

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

//		String valorFinal = string2BigDecimalMoedaBR("200.33");

		
		String valorFinal = acrescentar00("200.44");
		
		System.out.println(valorFinal);
		
//		String valorFinal = stringValorMonetarioBR2BigDecimalFormatBancoDeDados("200");
		

//		Cliente lucas = new Cliente();
//
//		String valorFormatoApi = "500000.50";
//		lucas.setApiPatrimonio(valorFormatoApi);
//		
//		String valorFormatoUi = string2BigDecimalMoedaBR(lucas.getApiPatrimonio());
//		lucas.setUiPatrimonio(valorFormatoUi);
//
//		System.out.println(lucas);


//		Cliente joao = new Cliente();
//
//		String uiPatrimonio = "1500";
//
//		joao.setUiPatrimonio(uiPatrimonio);
//
//		String valorFormatoApi2 = stringValorMonetarioBR2BigDecimalFormatBancoDeDados(joao.getUiPatrimonio());
//		joao.setApiPatrimonio(valorFormatoApi2);
//
//		System.out.println(joao);
		
	}

	private static String string2BigDecimalMoedaBR(String string) {

		BigDecimal num = new BigDecimal(string);

		NumberFormat nf = NumberFormat.getCurrencyInstance();

		String bidDecimalFormatado = nf.format(num);

		return bidDecimalFormatado;
	}

	private static String stringValorMonetarioBR2BigDecimalFormatBancoDeDados (String string) {
		
		String valorRecebido = string;
		
//		valorRecebido = string + ",00";
		
		System.out.println(valorRecebido);

		DecimalFormat valorMonetarioDecimal = (DecimalFormat) NumberFormat.getInstance();
		valorMonetarioDecimal.setParseBigDecimal(true);

		BigDecimal valorMonetarioFormat = (BigDecimal)valorMonetarioDecimal.parse(valorRecebido, new ParsePosition(0));
		
	 	return valorMonetarioFormat.toString();
	}
	
	static String acrescentar00(String string) {
		
		Pattern p = Pattern.compile(".*[.]..");
		Matcher m = p.matcher(string);
		boolean b = m.matches();
		
		if(b) 
			return string;
		 else {
			String valorRecebido = string + ".00";
			System.out.println(valorRecebido);
			return valorRecebido;
		
		 }
	}

}
