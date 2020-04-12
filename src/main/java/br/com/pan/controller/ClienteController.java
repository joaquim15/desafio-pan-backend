package br.com.pan.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pan.domain.entity.Cliente;
import br.com.pan.dto.ClienteDTO;
import br.com.pan.exceptions.ObjectNotFoundExeption;
import br.com.pan.repositories.ClienteRepository;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
	
	private Logger LOG = LoggerFactory.getLogger(ClienteDTO.class);

	@Autowired
	ClienteRepository clienteRepository;

	@GetMapping("/{id}")
	public ClienteDTO obterClientePorId(@PathVariable(value = "id") Long id) {

		Optional<Cliente> objCliente = this.clienteRepository.findById(id);

		ClienteDTO objDto = null;

		if (objCliente.isPresent()) {
			LOG.info("Response OBTER-CLIENTE: " + objCliente.toString());
			objDto = new ClienteDTO(objCliente.get());
		} else {
			throw new ObjectNotFoundExeption(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + ClienteDTO.class.getName());
		}

		return objDto;
	}

	@PutMapping("/{id}")
	public ResponseEntity<ClienteDTO> alteraCliente(@PathVariable(value = "id") Long id,
			@Valid @RequestBody ClienteDTO clienteDTO) {

		Optional<Cliente> objCliente = this.clienteRepository.findById(id);

		if (objCliente.isPresent()) {
			LOG.info("Response ALTERAR-CLIENTE: " + objCliente.toString());
			final Cliente cliente = fronCliente(clienteDTO);
			this.clienteRepository.save(cliente);
		}

		return ResponseEntity.ok(clienteDTO);
	}

	@GetMapping(value = "consulta-cpf/{cpf}")
	public ResponseEntity<ClienteDTO> obterClientePorCpf(@PathVariable final String cpf) {

		final Optional<Cliente> objCliente = this.clienteRepository.findClienteByCpf(cpf);

		ClienteDTO dto = null;

		if (objCliente.isPresent()) {
			LOG.info("Response OBTER-CPF-CLIENTE: " + objCliente.toString());
			dto = new ClienteDTO(objCliente.get());
		} else {
			throw new ObjectNotFoundExeption("CPF não encontrado: " + cpf + ", Tipo: " + ClienteDTO.class.getName());
		}
		return ResponseEntity.ok(dto);
	}

	public Cliente fronCliente(final ClienteDTO dto) {

		final Cliente cliente = new Cliente(dto.getId(), dto.getCpf(), dto.getNome(), dto.getProfissao());

		return cliente;

	}

}
