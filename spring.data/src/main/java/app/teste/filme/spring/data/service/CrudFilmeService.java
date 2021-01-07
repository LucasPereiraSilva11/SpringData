package app.teste.filme.spring.data.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import app.teste.filme.spring.data.orm.Categoria;
import app.teste.filme.spring.data.orm.Filme;
import app.teste.filme.spring.data.repository.CategoriaRepository;
import app.teste.filme.spring.data.repository.FilmeRepository;

@Service
public class CrudFilmeService {

	private Boolean system = true;
	private final FilmeRepository filmeRepository;
	private final CategoriaRepository categoriaRepository;

	public CrudFilmeService(FilmeRepository filmeRepository, CategoriaRepository categoriaRepository) {
		this.filmeRepository = filmeRepository;
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
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(scanner);
				break;

			default:
				system = false;
				break;
			}
		}
	}

	private void salvar(Scanner scanner) {
		System.out.println("Digite o nome do Filme: ");
		String nomeFilme = scanner.next();

		System.out.println("Digite o ano de lançamento: ");
		String anoLancamento = scanner.next();

		System.out.println("Escreva um breve resumo do filme: ");
		String sinopse = scanner.next();

		System.out.println("Qual a nota do filme (0 - 5) ?");
		Double nota = scanner.nextDouble();
		Boolean flagNota = true;
		while (flagNota) {
			if (nota < 0 || nota > 5) {
				System.out.println("Nota inválida");
			} else {
				flagNota = false;
			}
		}

		System.out.println("Digite a categoria_Id");
		Integer categoriaId = scanner.nextInt();

		Filme filme = new Filme();
		filme.setNome(nomeFilme);
		filme.setAnoLancamento(anoLancamento);
		filme.setSinopse(sinopse);
		filme.setNota(nota);
		
		Optional<Categoria> categoria = categoriaRepository.findById(categoriaId);
		filme.setCategoria(categoria.get());
		filmeRepository.save(filme);

		System.out.println("Salvo");
	}

	private void atualizar(Scanner scanner) {

	}

	private void visualizar() {

	}

	private void deletar(Scanner scanner) {

	}

}
