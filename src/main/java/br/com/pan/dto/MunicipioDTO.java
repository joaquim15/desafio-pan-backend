package br.com.pan.dto;

import java.io.Serializable;

public class MunicipioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	public MicrorRegiaoDTO microrregiao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MicrorRegiaoDTO getMicrorregiao() {
		return microrregiao;
	}

	public void setMicrorregiao(MicrorRegiaoDTO microrregiao) {
		this.microrregiao = microrregiao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}