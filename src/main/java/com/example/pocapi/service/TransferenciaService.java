package com.example.pocapi.service;

import java.awt.AWTException;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.stereotype.Service;
import com.example.pocapi.model.Formulario;

import io.github.bonigarcia.wdm.WebDriverManager;

@Service
public class TransferenciaService {

//	private WebDriver driver;
	private RemoteWebDriver driver;

	public void transferenciaPdf(Formulario formulario) throws Exception {
		System.out.println("Transferencia PDF executada");

		setUp();

		teste(formulario);

		closeAba();
	}

	private void setUp() throws Exception {

//		System.setProperty("webdriver.chrome.driver", "C:\\drives\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();

//		String downloadFilePath = "C:\\Users\\Developer\\Downloads\\selenium";

		String tmpDirectory = System.getProperty("java.io.tmpdir");
		System.out.println("tmpDirectory: " + tmpDirectory);
//		C:\Users\DEVELO~1\AppData\Local\Temp\
		String downloadFilePath = tmpDirectory;
		System.out.println("downloadFilePath: " + downloadFilePath);

		// Download pdf
		HashMap<String, Object> chromePref = new HashMap<String, Object>();
		chromePref.put("download.prompt_for_download", false);
		chromePref.put("download.default_directory", downloadFilePath);
		chromePref.put("plugins.always_open_pdf_externally", true);

		// Compilar sem abrir janela
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		options.setExperimentalOption("prefs", chromePref);

		driver = new ChromeDriver(options);

	}

	private void closeAba() {
//		driver.quit();
	}

	private void teste(Formulario formulario) throws InterruptedException, IOException, AWTException {

		// Config web ...
		String link = ("https://www.detran.mg.gov.br/veiculos/transferencia-de-propriedade/transferencia-de-propriedade");
		driver.get(link);

//		String placa = "HOC9880";
//		String chassi = "9C6KE1500B0001618";
//		String renavam = "00255123361";
//		String valorRecibo = "1000,00";
//		String dataAquisicao = "15012020";
//		String numeroCRV = "123456789101112";
//		String dataLeilao = "01022019";
//		String ufDeOrigem = "Minas Gerais";
//		String NomeAdquirente = "Vicente Leonardo Drumond";
//		String cnpj = "CNPJ";
//		String cnpjNumero = "91098219000120";
//		String cep = "30668171";
//		String endereco = "Beco N";
//		String numero = "838";
//		String complemento = "Casa";
//		String bairro = "Vila Formosa Vale do";
//		String cpf = "CPF";
//		String cpfNumero = "19650069062";
//		String motivoJudicial = "Formal de partilha";
//		String ordemJudicial = "23423";
//		String financiamento = "Sem Financiamento";
//		String categoria = "PARTIC";
//		String cilindros = "5";
//		String ipva = "Não";
//		String atividade = "Escolar";

//		 Dados do clientes
		String placa = formulario.getPlaca();
		String chassi = formulario.getChassi();
		String renavam = formulario.getRenavam();
		String valorRecibo = formulario.getValorRecebido();
		String dataAquisicao = formulario.getDataAquisicao();
		String numeroCRV = formulario.getNumeroCRV();
		String dataLeilao = formulario.getDataLeilao();
		String ufDeOrigem = formulario.getUfOrigem();
		String NomeAdquirente = formulario.getNomeAdquirente();
		String cnpj = formulario.getCnpj();
		String cnpjNumero = formulario.getCnpjNumero();
		String cep = formulario.getCep();
		String endereco = formulario.getEndereco();
		String numero = formulario.getNumero();
		String complemento = formulario.getComplemento();
		String bairro = formulario.getBairro();
		String cpf = formulario.getCpf();
		String cpfNumero = formulario.getCpfNumero();
		String motivoJudicial = formulario.getMotivoJudicial();
		String ordemJudicial = formulario.getOrdemJudicial();
		String financiamento = formulario.getFinanciamento();
		String categoria = formulario.getCategoria();
		String cilindros = formulario.getCilindros();
		String ipva = formulario.getIpva();
		String atividade = formulario.getAtividade();

		// Preechimento transg
		
		System.out.println("Começado preenchimento de dados");

		WebElement searchBoxPlaca = driver.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosPlaca"));
		searchBoxPlaca.sendKeys(placa);

		WebElement searchBoxChassi = driver.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosChassi"));
		searchBoxChassi.sendKeys(chassi);

		WebElement searchBoxRenavam = driver.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosRenavam"));
		searchBoxRenavam.sendKeys(renavam);

		WebElement searchBoxValorRecebido = driver
				.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosValorRecibo"));
		searchBoxValorRecebido.sendKeys(valorRecibo);

		WebElement searchBoxDataAquisicao = driver
				.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosDataAquisicao"));
		searchBoxDataAquisicao.click();
		searchBoxDataAquisicao.sendKeys(dataAquisicao);

		WebElement searchBoxNumeroCRV = driver.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosNumeroCrv"));
		searchBoxNumeroCRV.sendKeys(numeroCRV);

		WebElement searchBoxDataLeilao = driver
				.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosDataLeilao"));
		searchBoxDataLeilao.click();
		searchBoxDataLeilao.sendKeys(dataLeilao);

		WebElement searchBoxUFDeOrigem = driver
				.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosSiglaUfOrigem"));
		searchBoxUFDeOrigem.click();
		searchBoxUFDeOrigem.sendKeys(ufDeOrigem);

		WebElement searchBoxAdquirente = driver
				.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosNomeProprietario"));
		searchBoxAdquirente.sendKeys(NomeAdquirente);

		WebElement searchBoxCPNJ = driver
				.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosTipoDocumentoProprietario"));
		searchBoxCPNJ.click();
		searchBoxCPNJ.sendKeys(cnpj);

		WebElement searchBoxCNPJNumero = driver
				.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosCpfCnpjProprietario"));
		searchBoxCNPJNumero.sendKeys(cnpjNumero);

		WebElement searchBoxCep = driver.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosNumeroCep"));
		searchBoxCep.sendKeys(cep);

		WebElement searchBoxEndereco = driver.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosEndereco"));
		searchBoxEndereco.sendKeys(endereco);

		WebElement searchBoxNumeroEndereco = driver
				.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosNumeroEndereco"));
		searchBoxNumeroEndereco.sendKeys(numero);

		WebElement searchBoxComplementoEndereco = driver
				.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosComplemento"));
		searchBoxComplementoEndereco.sendKeys(complemento);

		WebElement searchBoxBairroEndereco = driver
				.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosBairro"));
		searchBoxBairroEndereco.sendKeys(bairro);

		WebElement searchEnderecoIgual = driver.findElement(
				By.id("CadastrarPreRegistroParaAquisicaoVeiculosEnderecoCorrespondenciaAdquirenteIgualResidenciaSim"));
		searchEnderecoIgual.click();

		WebElement searchBoxCPFProprietario = driver
				.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosTipoCpfCnpjProprietarioAnterior"));
		searchBoxCPFProprietario.click();
		searchBoxCPFProprietario.sendKeys(cpf);

		WebElement searchBoxCPFNumeroProprietario = driver
				.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosCpfCnpjProprietarioAnterior"));
		searchBoxCPFNumeroProprietario.sendKeys(cpfNumero);

		WebElement searchBoxPerdimento = driver
				.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosCodigoMotivoJudicial"));
		searchBoxPerdimento.sendKeys(motivoJudicial);

		WebElement searchBoxOrdemJudicial = driver
				.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosNumeroOrdemJudicial"));
		searchBoxOrdemJudicial.sendKeys(ordemJudicial);

		WebElement searchBoxFinanciamento = driver
				.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosCodigoRestricaoFinanceira"));
		searchBoxFinanciamento.click();
		searchBoxFinanciamento.sendKeys(financiamento);

		WebElement searchBoxCategotia = driver
				.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosCodigoCategoriaVeiculo"));
		searchBoxCategotia.click();
		searchBoxCategotia.sendKeys(categoria);

		WebElement searchBoxCilindros = driver
				.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosNumeroCilindrosProprietarioAnterior"));
		searchBoxCilindros.sendKeys(cilindros);

		WebElement searchBoxIPVA = driver.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosIsentoIpva"));
		searchBoxIPVA.click();
		searchBoxIPVA.sendKeys(ipva);

		WebElement searchBoxAtividade = driver
				.findElement(By.id("CadastrarPreRegistroParaAquisicaoVeiculosIndicaTipoRemunerada"));
		searchBoxAtividade.click();
		searchBoxAtividade.sendKeys(atividade);

		WebElement searchBoxCaracteristicas = driver.findElement(
				By.id("CadastrarPreRegistroParaAquisicaoVeiculosAlterarCaracteristicaVeiculoProprietarioAnteriorNao"));
		searchBoxCaracteristicas.click();

		WebElement buttonProximo = driver.findElement(By.xpath("(//button)[.='Próximo']"));
		buttonProximo.click();

		WebElement searchBoxConfirmarPreCadastro = driver.findElement(By.id("btnConfirmarDadosAquisicaoVeiculo"));
		searchBoxConfirmarPreCadastro.click();

		driver.switchTo().alert().accept();

		System.out.println("Finalizado transferencia");

//		getClass().getResourceAsStream("C:\\Users\\Developer\\Downloads\\selenium");
		
//		String path = new File("C:\\Users\\Developer\\Downloads\\selenium").getCanonicalPath();
		
//		upload.sendKeys("C:\\Users\\Developer\\Downloads\\selenium");
//		webDriver.findElement(By.id("add")).click();
		
	}

}
