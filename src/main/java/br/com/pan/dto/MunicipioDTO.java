package br.com.pan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MunicipioDTO {
	
	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String nome;
	
	@JsonProperty
	public MicrorRegiaoDTO microrregiao;

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

	public MicrorRegiaoDTO getMicrorregiao() {
		return microrregiao;
	}

	public void setMicrorregiao(MicrorRegiaoDTO microrregiao) {
		this.microrregiao = microrregiao;
	}

}