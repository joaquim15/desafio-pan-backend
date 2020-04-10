package br.com.pan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.pan.domain.entity.Cep;

@RestController
@RequestMapping(value = "/cep")
public class CepController {

	private Logger LOG = LoggerFactory.getLogger(Cep.class);

	@Value("${consulta.cep}")
	private String REQUEST_URI;

	/**
	 * @param cep a ser consultado
	 * @return ResponseEntity que agrupa o código de status http, os cabeçalhos http
	 *         e o corpo do tipo {@link Cep}
	 */
	@GetMapping(value = "/{cep}")
	public ResponseEntity<Cep> consultaCep(@PathVariable final String cep) {

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Cep> objCep = restTemplate.getForEntity(REQUEST_URI, Cep.class, cep);

		LOG.info("Status code value: " + objCep.getStatusCodeValue());
		LOG.info("Response da pesquisa por cep: " + objCep.getBody().toString());

		return objCep;
	}
}