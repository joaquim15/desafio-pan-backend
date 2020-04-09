package br.com.pan.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pan.domain.Cliente;
import br.com.pan.dto.ClienteDTO;
import br.com.pan.repositories.ClienteRepository;
import br.com.pan.service.exceptions.ObjectNotFoundExeption;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public ClienteDTO obterClientePorCpf(final String cpf) {

		ClienteDTO dto = null;

		Optional<Cliente> obj = this.clienteRepository.findClienteByCpf(cpf);

		if (obj.isPresent()) {
			dto = new ClienteDTO(obj.get());
		} else {
			throw new ObjectNotFoundExeption("CPF não encontrado: " + cpf + ", Tipo: " + ClienteDTO.class.getName());
		}
		return dto;
	}
}
