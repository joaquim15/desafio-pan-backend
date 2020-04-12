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
import br.com.pan.domain.entity.Endereco;
import br.com.pan.dto.CepDTO;
import br.com.pan.dto.ClienteDTO;
import br.com.pan.dto.EnderecoDTO;
import br.com.pan.exceptions.ObjectNotFoundExeption;
import br.com.pan.repositories.EnderecoRepository;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

	private Logger LOG = LoggerFactory.getLogger(CepDTO.class);

	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	ClienteController clienteRepository;

	@GetMapping(value = "/endereco-cliente/{id}")
	public ResponseEntity<EnderecoDTO> consultaEnderecoClienteId(@PathVariable final Long id) {

		EnderecoDTO enderecoDTO = null;

		Optional<Endereco> endereco = enderecoRepository.findEnderecoByClienteId(id);
		LOG.info("Response CONSULTA-ENDERECO-CLIENTE: " + endereco.toString());
		if (endereco.isPresent()) {
			enderecoDTO = new EnderecoDTO(endereco.get());
		} else {
			throw new ObjectNotFoundExeption(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + EnderecoDTO.class.getName());
		}
		return ResponseEntity.ok(enderecoDTO);
	}

	@PutMapping(value = "/endereco-cliente/{id}")
	public ResponseEntity<EnderecoDTO> alteraEndereco(@PathVariable(value = "id") Long id,
			@Valid @RequestBody EnderecoDTO requestDto) {

		Optional<Endereco> objEndereco = enderecoRepository.findEnderecoByClienteId(id);
		LOG.info("Response CONSULTA-ENDERECO-CLIENTE: " + objEndereco.toString());
		Endereco endereco = new Endereco();
		if (objEndereco.isPresent()) {
			endereco.setId(requestDto.getId());
			endereco.setCep(requestDto.getCep());
			endereco.setLogradouro(requestDto.getLogradouro());
			endereco.setComplemento(requestDto.getComplemento());
			endereco.setBairro(requestDto.getBairro());
			endereco.setLocalidade(requestDto.getLocalidade());
			endereco.setUf(requestDto.getUf());

			if (requestDto.getClienteId() >= 0) {
				final Cliente cliente = new Cliente();
				cliente.setId(requestDto.getClienteId());
				endereco.setCliente(cliente);
			} else {
				throw new ObjectNotFoundExeption(
						"Objeto não encontrado! Id: " + id + ", Tipo: " + EnderecoDTO.class.getName());
			}

			endereco = this.enderecoRepository.save(endereco);
		} else {
			throw new ObjectNotFoundExeption(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + EnderecoDTO.class.getName());
		}
		EnderecoDTO enderecoDTO = new EnderecoDTO(endereco);

		return ResponseEntity.ok(enderecoDTO);
	}
}
