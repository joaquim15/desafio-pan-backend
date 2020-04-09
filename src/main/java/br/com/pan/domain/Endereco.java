package br.com.pan.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String cep;

	@Column
	private String logradouro;

	@Column
	private String compremento;

	@Column
	private String bairro;

	@Column
	private String localidade;

	@Column
	private String uf;

	@Column
	private String unidade;

	@Column
	private String ibge;

	@Column
	private String gia;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Endereco() {
		// TODO Auto-generated constructor stub
	}

}
