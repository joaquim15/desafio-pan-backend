package br.com.pan;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.pan.domain.entity.Cliente;
import br.com.pan.domain.entity.Endereco;
import br.com.pan.repositories.ClienteRepository;
import br.com.pan.repositories.EnderecoRepository;

@SpringBootApplication
public class PanApplication implements CommandLineRunner {
	

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	EnderecoRepository enderecoRepository;

	public static void main(String... args) {
		SpringApplication.run(PanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Cliente c1 = new Cliente(null, "11223344789", "Professor Pardal", "Inventor");
		Cliente c2 = new Cliente(null, "00000000000", "Andre Akkari", "Jogador de Poker");

		c1 = this.clienteRepository.save(c1);
		c2 = this.clienteRepository.save(c2);

		final Endereco end2 = new Endereco(null, "06268000", "Avenida Presidente Medice, 0000", null, "Jardim Aliança",
				"São Paulo", "SP", c1);
		final Endereco end1 = new Endereco(null, "07586666", "Auro Soares de Oliveira", null, "Barra Funda",
				"São Paulo", "SP", c2);

		this.enderecoRepository.saveAll(Arrays.asList(end1, end2));

	}

}
