package br.com.pan.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.pan.domain.Endereco;
import lombok.Data;

@Data
public class ClienteDTO {
	
	private Long id;
	private String cpf;
	private String nome;
	private String profissao;
	private List<Endereco> enderecos = new ArrayList<>();

	public ClienteDTO() {
		// TODO Auto-generated constructor stub
	}

}
