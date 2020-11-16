package com.example.pocapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "formulario")
public class Formulario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String placa;
	private String chassi;
	private String renavam;
	private String valorRecebido;
	private String dataAquisicao;
	private String numeroCRV;
	private String dataLeilao;
	private String ufOrigem;
	private String nomeAdquirente;
	private String cnpj;
	private String cnpjNumero;
	private String municipioEmplacamento;
	private String cep;
	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private String enderecoCorrespondencia;
	private String cpf;
	private String cpfNumero;
	private String motivoJudicial;
	private String ordemJudicial;
	private String financiamento;
	private String categoria;
	private String cilindros;
	private String ipva;
	private String atividade;
	private String alterarCaracteristicas;

}
