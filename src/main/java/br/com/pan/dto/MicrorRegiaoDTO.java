package br.com.pan.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MicrorRegiaoDTO {
	
	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String nome;
	
	private MesorRegiaoDTO mesorregiao;

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

	public MesorRegiaoDTO getMesorregiao() {
		return mesorregiao;
	}

	public void setMesorregiao(MesorRegiaoDTO mesorregiao) {
		this.mesorregiao = mesorregiao;
	}

}
