package br.com.pan.dto;

import java.io.Serializable;

public class MicrorRegiaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	public UfDTO UF;

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

	public UfDTO getUF() {
		return UF;
	}

	public void setUF(UfDTO uF) {
		UF = uF;
	}

}
