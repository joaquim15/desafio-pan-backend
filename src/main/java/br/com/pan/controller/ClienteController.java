package br.com.pan.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pan.domain.entity.Cliente;
import br.com.pan.dto.ClienteDTO;
import br.com.pan.exceptions.ObjectNotFoundExeption;
import br.com.pan.repositories.ClienteRepository;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	ClienteRepository clienteRepository;

	@GetMapping(value = "consulta-cpf/{cpf}")
	public ResponseEntity<ClienteDTO> obterClientePorCpf(@PathVariable final String cpf) {

		ClienteDTO dto = null;

		Optional<Cliente> obj = this.clienteRepository.findClienteByCpf(cpf);

		if (obj.isPresent()) {
			dto = new ClienteDTO(obj.get());
		} else {
			throw new ObjectNotFoundExeption("CPF não encontrado: " + cpf + ", Tipo: " + ClienteDTO.class.getName());
		}
		return ResponseEntity.ok(dto);
	}

}
