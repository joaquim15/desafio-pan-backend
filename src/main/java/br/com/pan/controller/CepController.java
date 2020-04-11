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

import br.com.pan.dto.CepDTO;

@RestController
@RequestMapping(value = "/cep")
public class CepController {

	private Logger LOG = LoggerFactory.getLogger(CepDTO.class);

	@Value("${consulta.cep}")
	private String CEP_URI;

	/**
	 * @param cep a ser consultado
	 * @return ResponseEntity que agrupa o código de status http, os cabeçalhos http
	 *         e o corpo do tipo {@link CepDTO}
	 */
	@GetMapping(value = "/{cep}")
	public ResponseEntity<CepDTO> consultaCep(@PathVariable final String cep) {

		final RestTemplate restTemplate = new RestTemplate();

		final ResponseEntity<CepDTO> objCep = restTemplate.getForEntity(CEP_URI, CepDTO.class, cep);

		LOG.info("Status code value: " + objCep.getStatusCodeValue());
		LOG.info("Response da pesquisa por cep: " + objCep.getBody().toString());

		return objCep;
	}
}
