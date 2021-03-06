package br.com.pan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UfDTO {

	@JsonProperty
	private Long id;

	@JsonProperty
	private String sigla;

	@JsonProperty
	private String nome;

	@JsonProperty
	private RegiaoDTO regiao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public RegiaoDTO getRegiao() {
		return regiao;
	}

	public void setRegiao(RegiaoDTO regiao) {
		this.regiao = regiao;
	}

}
