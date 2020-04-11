package br.com.pan.controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Lists;

import br.com.pan.domain.entity.Cep;
import br.com.pan.dto.EstadoDTO;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {

	private Logger LOG = LoggerFactory.getLogger(Cep.class);

	@Value("${consulta.estado}")
	private String ESTADO_URI;

	@GetMapping
	public ResponseEntity<List<EstadoDTO>> obterEstados() {

		final List<EstadoDTO> listaEstadoDto = Lists.newArrayList();

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<EstadoDTO[]> objListaEstado = restTemplate.getForEntity(ESTADO_URI, EstadoDTO[].class);

		LOG.info("Status code value: " + objListaEstado.getStatusCodeValue());
		LOG.info("Response da pesquisa estado: " + objListaEstado.getBody().toString());

		EstadoDTO[] listDto = objListaEstado.getBody();

		for (EstadoDTO estadoDTO : listDto) {
			listaEstadoDto.add(estadoDTO);
		}

		List<EstadoDTO> listaOrdenada = listaEstadoDto.stream().sorted(Comparator.comparing(EstadoDTO::getNome))
				.collect(Collectors.toList());

		return ResponseEntity.ok(listaOrdenada);
	}

}
