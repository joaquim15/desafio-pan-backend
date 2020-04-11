package br.com.pan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MesorRegiaoDTO {

	@JsonProperty
	private Long id;

	@JsonProperty
	private String nome;

	@JsonProperty
	private UfDTO UF;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
