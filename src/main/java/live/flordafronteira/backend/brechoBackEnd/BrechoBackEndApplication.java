package live.flordafronteira.backend.brechoBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class BrechoBackEndApplication {


	public static void main(String[] args) {
		SpringApplication.run(BrechoBackEndApplication.class, args);

		ArrayList<Cliente> listClientes = new ArrayList<>();
		Cliente cliente	= new Cliente();

		System.out.println("teste");


		cliente.addCliente();



	}



}
