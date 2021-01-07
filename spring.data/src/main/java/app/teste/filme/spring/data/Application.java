package app.teste.filme.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import app.teste.filme.spring.data.service.CrudCategoriaService;
import app.teste.filme.spring.data.service.CrudFilmeService;

@EnableJpaRepositories
@SpringBootApplication
public class Application implements CommandLineRunner {

	private Boolean system = true;
	private final CrudFilmeService filmeService;
	private final CrudCategoriaService categoriaService;

	public Application(CrudFilmeService filmeService, CrudCategoriaService categoriaService) {
		this.filmeService = filmeService;
		this.categoriaService = categoriaService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual função deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Filme");
			System.out.println("2 - Categoria");

			Integer numero = scanner.nextInt();

			switch (numero) {
			case 1:
				filmeService.menu(scanner);
				break;
				
			case 2:
				categoriaService.menu(scanner);
				break;

			default:
				System.out.println("Finalizando");
				system = false;
				break;
			}
		}
	}

}
