package live.flordafronteira.backend.brechoBackEnd;

import live.flordafronteira.backend.brechoBackEnd.Entity.Cliente;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class BrechoBackEndApplication {



	public static void main(String[] args) {


		SpringApplication.run(BrechoBackEndApplication.class, args);

		ArrayList<Cliente> listClientes = new ArrayList<>();
		Cliente cliente	= new Cliente();
		System.out.println("teste");
		boolean teste = true;

		while (cliente.addCliente()){

			System.out.println("checando");

		}



		System.out.println("Encerrando");





	}



}
