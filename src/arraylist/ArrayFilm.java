package arraylist;

import java.util.Scanner;

import entities.Client;
import entities.Film;
import interface_film.Interface;

public class ArrayFilm implements Interface{
	
	private int indice;
	private Film[] films;	
	Scanner sc = new Scanner(System.in);
	
	public ArrayFilm(int tamanho) {
		films = new Film[tamanho];
		indice = 0;
	}
	
	@Override
	public void add(Film f) {		
		films[indice] = f;
		System.out.println("\nFilme " + films[indice].getNome() + " cadastrado com sucesso!");
		indice++;					
	}

	@Override
	public void update(int codigo) {
		for(int i = 0; i < films.length; i++) {
			if(films[i].getCodigo() == codigo) {
				System.out.println("\n---DADOS---");
				System.out.println("Título: " + films[i].getNome() + "\nCódigo: " + films[i].getCodigo()
						   + "\nGênero: " + films[i].getGenero() + String.format("\nPreço: R$ %.2f", films[i].getPreco())
						   + "\nAno de Lançamento: " + films[i].getAno());
				System.out.println("\n[1] Alterar título \n[2] Alterar gênero \n[3] Alterar preço \n[4] Alterar ano de lançamento");				
				int op = sc.nextInt();
				switch(op) {
				case 1:
					sc.nextLine();
					System.out.println("---ALTERAR-TÍTULO---");
					System.out.print("\nTítulo: ");
					String nome = sc.nextLine();
					films[i].setNome(nome);
					break;
				case 2:
					System.out.println("---ALTERAR-GÊNERO---");
					System.out.print("\nGênero: ");
					String genero = sc.nextLine();
					films[i].setGenero(genero);
					break;
				case 3:
					System.out.println("---ALTERAR-PREÇO---");
					System.out.print("\nPreço: ");
					double preco = sc.nextDouble();
					films[i].setPreco(preco);
					break;
				case 4:
					System.out.println("---ALTERAR-ANO---");
					System.out.print("\nAno: ");
					int ano = sc.nextInt();
					films[i].setAno(ano);
					break;
				default:
					System.out.println("\nOpção inválida\n");
					break;
				}
			}
		}
	}

	@Override
	public void remove(int codigo) {
		for(int i = 0; i < indice; i++) {
			Film remove = films[i];
			if(remove.getCodigo() == codigo) {				
				System.out.print("Remover " + films[i].getNome() + "[s/n]? ");
				char resp = sc.next().charAt(0);
				if(resp == 's' || resp == 'S') {
					System.out.println("Filme " + films[i].getNome() + " removido!");
					films[i] = films[indice - 1];
					films[indice - 1] = null;				
					indice--;
				}
			}
		}
	}

	@Override
	public String listAll() {
		String dados = "";
		for(int i = 0; i < indice; i++) {
			dados += "Situação: " + films[i].getSituacao() + "\nTítulo: " + films[i].getNome() + "\nCódigo: " + films[i].getCodigo()
						   + "\nGênero: " + films[i].getGenero() + String.format("\nPreço: R$ %.2f", films[i].getPreco())
						   + "\nAno de Lançamento: " + films[i].getAno() + "\n\n";
		}
		return dados;
	}
	
	@Override
	public String list() {
		String dados = "";
		for(int i = 0; i < indice; i++) {
			dados += "Título: " + films[i].getNome() + "\n";
		}
		return dados;
	}
	
	public int getIndice() {
		return indice;
	}
	
	public void alugar(int codigo) {
		for(int i = 0; i < indice; i++) {			
			if(films[i].getCodigo() == codigo && films[i].getSituacao().equalsIgnoreCase("Disponível")) {
				films[i].setSituacao("Alugado");
				System.out.println("\n---FORMULÁRIO---");
				System.out.print("Nome do cliente: ");
				String nomeClient = sc.nextLine();
				Client cl = new Client(nomeClient);					
				System.out.println(cl);
				System.out.println("\nFilme " + films[i].getNome() + " alugado com sucesso!");				
				continue;
			} 
			else if (films[i].getCodigo() == codigo && films[i].getSituacao().equalsIgnoreCase("Alugado")){
				System.out.println("\nFilme " + films[i].getNome() + " já está alugado!");
				continue;
			}
		}	
	}
	
	public void devolver(int codigo) {
		for(int i = 0; i < indice; i++) {
			if(films[i].getCodigo() == codigo && films[i].getSituacao().equalsIgnoreCase("Alugado")) {
				films[i].setSituacao("Disponível");
				System.out.println("\nFilme " + films[i].getNome() + " devolvido com sucesso!");
				continue;
			}
			else if(films[i].getCodigo() == codigo && films[i].getSituacao().equalsIgnoreCase("Disponível")) {
				System.out.println("Não há filmes para devolver");
				continue;
			}
		}
	}
	
	public boolean verificar(int codigo) {
		for(int i = 0; i < getIndice(); i++) {
			if(getIndice() > 0 && films[i].getCodigo() == codigo) {											
				return false;
			}
		}
		return true;
	}
}