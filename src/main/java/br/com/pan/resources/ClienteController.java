package br.com.pan.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pan.dto.ClienteDTO;
import br.com.pan.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@RequestMapping(value = "obter-clinte-cpf/{cpf}", method = RequestMethod.GET)
	public ResponseEntity<ClienteDTO> obterClientePorCpf(@PathVariable String cpf) {
		ClienteDTO obj = this.clienteService.obterClientePorCpf(cpf);
		return ResponseEntity.ok().body(obj);
	}

}
