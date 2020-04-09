package br.com.pan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.pan.domain.Cliente;
import br.com.pan.repositories.ClienteRepository;

@SpringBootApplication
public class PanApplication implements CommandLineRunner {

	@Autowired
	ClienteRepository clienteRepository;

	public static void main(String... args) {
		SpringApplication.run(PanApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		final Cliente c1 = new Cliente(null, "11223344789", "Professor Pardal", "Inventor", null);
		
		this.clienteRepository.save(c1);

	}

}
