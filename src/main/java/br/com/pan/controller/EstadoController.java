package br.com.pan.controller;

import java.util.Arrays;
import java.util.Collections;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Lists;

import br.com.pan.dto.CepDTO;
import br.com.pan.dto.EstadoDTO;
import br.com.pan.dto.MunicipioDTO;

@RestController
@RequestMapping(value = "/estados")
public class EstadoController {

	private Logger LOG = LoggerFactory.getLogger(CepDTO.class);

	@Value("${consulta.estado}")
	private String ESTADO_URI;

	@GetMapping
	public ResponseEntity<List<EstadoDTO>> obterEstados() {

		final List<EstadoDTO> listaEstadoDto = Lists.newArrayList();

		final RestTemplate restTemplate = new RestTemplate();

		final ResponseEntity<EstadoDTO[]> objListaEstado = restTemplate.getForEntity(ESTADO_URI, EstadoDTO[].class);

		LOG.info("Status code value: " + objListaEstado.getStatusCodeValue());
		LOG.info("Response da pesquisa estado: " + objListaEstado.getBody().toString());

		final EstadoDTO[] listDto = objListaEstado.getBody();

		for (EstadoDTO estadoDTO : listDto) {
			listaEstadoDto.add(estadoDTO);
		}

		final List<EstadoDTO> listaOrdenada = listaEstadoDto.stream().sorted(Comparator.comparing(EstadoDTO::getNome))
				.collect(Collectors.toList());

		Collections.sort(listaOrdenada, new Comparator<EstadoDTO>() {

			public int compare(EstadoDTO o1, EstadoDTO o2) {

				if (o1.getId() == 35) {
					return -1;
				} else if (o1.getId() == 33) {
					return -1;
				}
				return o1.getNome().compareTo(o2.getNome());
			}

		});

		return ResponseEntity.ok(listaOrdenada);
	}

	@GetMapping(value = "/municipio/{id}")
	public ResponseEntity<List<MunicipioDTO>> obterMunicipioPorEstado(@PathVariable final Long id) {

		final List<MunicipioDTO> listaMunicipioDto = Lists.newArrayList();

		final RestTemplate restTemplate = new RestTemplate();

		final ResponseEntity<MunicipioDTO[]> objListaMunicipio = restTemplate.getForEntity(ESTADO_URI,
				MunicipioDTO[].class, id);

		LOG.info("Status code value: " + objListaMunicipio.getStatusCodeValue());
		LOG.info("Response da pesquisa estado: " + objListaMunicipio.getBody().toString());

		final MunicipioDTO[] listDto = objListaMunicipio.getBody();

		for (MunicipioDTO municipioDTO : listDto) {
			listaMunicipioDto.add(municipioDTO);
		}

		return ResponseEntity.ok(listaMunicipioDto);
	}

}
