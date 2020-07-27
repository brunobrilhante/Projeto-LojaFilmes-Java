package application;

import java.util.Locale;
import java.util.Scanner;

import arraylist.ArrayFilm;
import entities.Employee;
import entities.Film;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);		
		ArrayFilm arrayFilm = null;
		Film film = null;
		
		System.out.println("---CADASTRO---");		
		System.out.print("Nome: ");
		String nome = sc.nextLine();		
		System.out.print("Email: ");
		String email = sc.nextLine();		
		System.out.print("Senha: ");
		String senha = sc.nextLine();
		Employee em = new Employee(email, nome, senha);
		
		boolean login = false;
		while(login == false) {
			System.out.println("\n---LOGIN---");
			System.out.print("Email: ");
			String emailLogin = sc.nextLine();			
			System.out.print("Senha: ");
			String senhaLogin = sc.nextLine();
			login = em.login(emailLogin, senhaLogin);
			if(login == true) System.out.println("\nUsuário " + em.getNome() + " logado com sucesso!");
			else System.out.println("\nUsuário ou senha incorreto(s)");
		}
				
		int op;
		do {
			System.out.println("\n---MENU-PRINCIPAL---");
			System.out.println("[1] Cadastrar filme \n[2] Listar filmes \n[3] Alterar filme");
			System.out.println("[4] Remover filme \n[5] Alugar filme \n[6] Devolver filme \n[0] Sair");
			op = sc.nextInt();
			switch(op) {
			
			case 1:
				System.out.print("\nQuantidade de filmes que serão cadastrados: ");
				int tamanho = sc.nextInt();
				arrayFilm = new ArrayFilm(tamanho);
				if(tamanho == 0) {
					continue;
				} else {					
					for(int i = 0; i < tamanho; i++) {
						sc.nextLine();
						System.out.print("\nTítulo: ");
						String nomeFilme = sc.nextLine();

						int codigo = 0;						
						boolean verifica = false;
						while(verifica == false) {														
							System.out.print("Código: ");
							codigo = sc.nextInt();
							sc.nextLine();
							verifica = arrayFilm.verificar(codigo);										
							if(verifica == false) System.out.println("\nCódigo já cadastrado\n");
						}
						
						System.out.print("Gênero: ");
						String genero = sc.nextLine();
						System.out.print("Ano: ");
						int ano = sc.nextInt();
						System.out.print("Preço: R$");
						double preco = sc.nextDouble();						
						film = new Film(nomeFilme, genero, codigo, ano, preco);
						film.setSituacao("Disponível");
						arrayFilm.add(film);
					}
					break;
				}
			
			case 2:
				if(arrayFilm == null || arrayFilm.getIndice() == 0) {
					System.out.println("\nNão há filmes cadastrados\n");
				} else {
					System.out.println("\n" + arrayFilm.list());
					System.out.print("\nVer detalhes [s/n]? ");
					char resp = sc.next().charAt(0);
					if(resp == 's' || resp == 'S') {
						System.out.println("\n" + arrayFilm.listAll());
					}
				}
				break;
			
			case 3:
				if(arrayFilm == null || arrayFilm.getIndice() == 0) {
					System.out.println("\nNão há filmes cadastrados!\n");
				}
				else {
					System.out.print("\nDigite o código do filme que deseja alterar: ");
					int codigo = sc.nextInt();
					arrayFilm.update(codigo);
				}
				break;
			
			case 4:
				if(arrayFilm == null || arrayFilm.getIndice() == 0) {
					System.out.println("\nNão há filmes cadastrados!\n");
				}
				else {
					System.out.print("\nDigite o código do filme que deseja remover: ");
					int remove = sc.nextInt();
					arrayFilm.remove(remove);
				}
				break;
				
			case 5:
				if(arrayFilm == null || arrayFilm.getIndice() == 0) {
					System.out.println("\nNão há filmes cadastrados!\n");
				} 
				else {
					System.out.print("\nDigite o código do filme que deseja alugar: ");
					int aluga = sc.nextInt();
					
					arrayFilm.alugar(aluga);										
				}
				break;
				
			case 6:
				if(arrayFilm == null || arrayFilm.getIndice() == 0) {
					System.out.println("\nNão há filmes cadastrados!\n");
				}
				else {
					System.out.print("\nDigite o código do filme que deseja devolver: ");
					int devolve = sc.nextInt();
					arrayFilm.devolver(devolve);
				}
				break;
				
			case 0:		
				System.out.println("------------------------");
				System.out.println("---PROGRAMA-ENCERRADO---");
				System.out.println("------------------------");
				break;
			default:
				System.out.println("\nOpção inválida!");
				break;
			}
			
		} while(op != 0);			
		sc.close();
	}
}