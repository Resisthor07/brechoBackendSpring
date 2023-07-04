package live.flordafronteira.backend.brechoBackEnd;

import live.flordafronteira.backend.brechoBackEnd.entity.Administrador;
import live.flordafronteira.backend.brechoBackEnd.repository.AdministradorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BrechoBackEndApplication {
	public static void main(String[] args) {
		SpringApplication.run(BrechoBackEndApplication.class, args);
	}
	@Bean
	public CommandLineRunner inicializacao(AdministradorRepository administradorRepository) {
		return args -> {
			String login = "yaneadmin";
			String senha = "Brecho@2023";

			// Verifica se já existe um administrador cadastrado
			if (administradorRepository.count() == 0) {
				// Cria um novo administrador com o login e senha fixos
				Administrador administrador = new Administrador();
				administrador.setLogin(login);
				administrador.setSenha(senha);

				// Salva o administrador no banco de dados
				administradorRepository.save(administrador);
			}
		};
}
}
