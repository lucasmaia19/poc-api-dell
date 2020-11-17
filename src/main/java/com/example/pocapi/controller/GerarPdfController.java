package com.example.pocapi.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pocapi.model.Formulario;
import com.example.pocapi.repository.TransferenciaRepository;
import com.example.pocapi.service.TransferenciaService;

@RestController
@RequestMapping("api")
public class GerarPdfController {
	
	void ConversaoDate2String(@RequestBody Formulario formulario, @PathVariable Long id) {
		
		// Recebe data string com formato instant dataAquisicao
		Instant dataAquisicaoInstant = Instant.parse(formulario.getDataAquisicao());
		OffsetDateTime dataAquisicaoOffSet = dataAquisicaoInstant.atOffset(ZoneOffset.UTC); 

		DateTimeFormatter formatadorAquisicao = DateTimeFormatter.ofPattern("ddMMyyyy");
		String dataAquisicaoString = dataAquisicaoOffSet.format(formatadorAquisicao);

		// Recebe data string com formato instant dataLeilao
		Instant dataLeilaoInstant = Instant.parse(formulario.getDataLeilao());
		OffsetDateTime dataLeilaoOffSet = dataLeilaoInstant.atOffset(ZoneOffset.UTC); 

		DateTimeFormatter formatadorLeilao = DateTimeFormatter.ofPattern("ddMMyyyy");
		String dataLeilaoString = dataLeilaoOffSet.format(formatadorLeilao);

		// ...
		formulario.setDataAquisicao(dataAquisicaoString);

		formulario.setDataLeilao(dataLeilaoString);
        
	}
	
	String acrescentar00(@RequestBody Formulario formulario) {
		
		String valorRecebidoui = formulario.getValorRecebido();
		
		Pattern p = Pattern.compile(".*[.]..");
		Matcher m = p.matcher(formulario.getValorRecebido());
		boolean b = m.matches();
		
		if(b) {
			return formulario.getValorRecebido();
		} else {
			
		String valorRecebido = formulario.getValorRecebido() + ".00";
		formulario.setValorRecebido(valorRecebido);
		System.out.println(valorRecebido);
		return valorRecebido;
		
		}
		
	}
		
	
	private static String stringValorMonetarioBR2BigDecimalFormatBancoDeDados (@RequestBody Formulario formulario ,String string) {

//		String valorRecebido = string + ".00";

		DecimalFormat valorMonetarioDecimal = (DecimalFormat) NumberFormat.getInstance();
		valorMonetarioDecimal.setParseBigDecimal(true);

		BigDecimal valorMonetarioFormat = (BigDecimal)valorMonetarioDecimal.parse(string, new ParsePosition(0));
		
		formulario.setValorRecebido(string);
		
	 	return valorMonetarioFormat.toString();
	}

	@Autowired
	TransferenciaService transferenciaService;

	@Autowired
	private TransferenciaRepository transferenciaRepository;

	@GetMapping(value = "/image", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Object> PegarPDF() throws IOException, InterruptedException {
		
		System.out.println("Espera 5 segundos");
        Thread.sleep(3000);

		String tmpDirectory = System.getProperty("java.io.tmpdir");
		
		String filename = (tmpDirectory + "//servicosDetran.pdf");
//		String filename = "C:\\Users\\Developer\\Downloads\\selenium\\servicosDetran.pdf";
		
		File file = new File(filename);
		   InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		headers.add("Content-Disposition", "filename=" + "transferencia.pdf");

		 ResponseEntity<Object> 
		   responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(
		      MediaType.parseMediaType("application/pdf")).body(resource);

		   return responseEntity;
	}


	@GetMapping
	public List<Formulario> ListaPlaca() {
		return transferenciaRepository.findAll();
	}

	@GetMapping("/{id}")
	public java.util.Optional<Formulario> consultar(@PathVariable Long id) {

		String tmpDirectory = System.getProperty("java.io.tmpdir");
		System.out.println("tmpDirectory: " + tmpDirectory);

		return transferenciaRepository.findById(id);

	}

	@DeleteMapping("/{id}")
	public Map<String, Object> deletar(@PathVariable Long id) {
		transferenciaRepository.deleteById(id);
		
		Map<String, Object> responseMap = new HashMap<>();
		responseMap.put("TestoDaResposta", "O cadastro com Id: " + id + " Foi deletado com sucesso");
		return responseMap;

	}

	@PutMapping("/{id}")
	public Formulario atualizar(@RequestBody Formulario formulario, @PathVariable Long id) {

		Formulario formularioSaved = transferenciaRepository.findById(id).get();

		ConversaoDate2String(formulario, id);
		
		acrescentar00(formulario);
//		stringValorMonetarioBR2BigDecimalFormatBancoDeDados(formulario, formulario.getValorRecebido());
		
//		stringValorMonetarioBR2BigDecimalFormatBancoDeDados(formularioSaved, formulario.getValorRecebido());
		
		
		BeanUtils.copyProperties(formulario, formularioSaved, "id");

		return transferenciaRepository.save(formularioSaved);
	}

	@PostMapping
	public Formulario cadastrar(@RequestBody Formulario formulario) {
		
		ConversaoDate2String(formulario, null);
		
		
//		acrescentar00(formulario);
		
		return transferenciaRepository.save(formulario);
	}

	@PostMapping("transferencia-pdf")
	public Formulario transferenciaPdf(@RequestBody Formulario formulario) throws Exception {

		transferenciaService.transferenciaPdf(formulario);

		return transferenciaRepository.save(formulario);

	}

	@GetMapping("/debug")
	public String debug() throws InterruptedException {
		Thread.sleep(3000);

		if (Math.random() > 0.5) 
			throw new RuntimeException("Deu ruim aqui :(");
		else
			return "debug";
	}

}
