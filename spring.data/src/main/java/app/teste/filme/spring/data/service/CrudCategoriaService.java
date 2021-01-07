package app.teste.filme.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import app.teste.filme.spring.data.orm.Categoria;
import app.teste.filme.spring.data.repository.CategoriaRepository;

@Service
public class CrudCategoriaService {

	private Boolean system = true;
	private final CategoriaRepository categoriaRepository;
	
	public CrudCategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	public void menu(Scanner scanner) {
		while (system) {
			System.out.println("Escolha uma opção abaixo");
			System.out.println("0 - Sair");
			System.out.println("1 - Adicionar novo filme");
			System.out.println("2 - Atualizar filme");
			System.out.println("3 - Mostrar filmes cadastrados");
			System.out.println("4 - Deletar filme");

			int numero = scanner.nextInt();

			switch (numero) {
			case 1:
				salvar(scanner);
				break;

			default:
				system = false;
				break;
			}
		}
	}
	
	private void salvar(Scanner scanner) {
		System.out.println("Digite o nome da categoria: ");
		String nomeCategoria = scanner.next();
		
		Categoria categoria = new Categoria();
		categoria.setNomeCategoria(nomeCategoria);
		
		categoriaRepository.save(categoria);
		
		System.out.println("Salvo");
	}

}
