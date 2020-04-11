package br.com.pan.dto;

import java.io.Serializable;

public class UfDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String sigla;
	private String nome;
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

	public RegiaoDTO getRegiao() {
		return regiao;
	}

	public void setRegiao(RegiaoDTO regiao) {
		this.regiao = regiao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
