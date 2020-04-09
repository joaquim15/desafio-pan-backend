package br.com.pan.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pan.dto.ClienteDTO;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

	@RequestMapping(value = "/{cpf}", method = RequestMethod.GET)
	public ResponseEntity<String> obterClientePorCpf(@PathVariable String cpf) {
		//ClienteDTO obj = this.service.find(id);
		return ResponseEntity.ok().body(cpf);
	}

}
