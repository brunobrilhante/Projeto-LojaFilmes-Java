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
				System.out.println("T�tulo: " + films[i].getNome() + "\nC�digo: " + films[i].getCodigo()
						   + "\nG�nero: " + films[i].getGenero() + String.format("\nPre�o: R$ %.2f", films[i].getPreco())
						   + "\nAno de Lan�amento: " + films[i].getAno());
				System.out.println("\n[1] Alterar t�tulo \n[2] Alterar g�nero \n[3] Alterar pre�o \n[4] Alterar ano de lan�amento");				
				int op = sc.nextInt();
				switch(op) {
				case 1:
					sc.nextLine();
					System.out.println("---ALTERAR-T�TULO---");
					System.out.print("\nT�tulo: ");
					String nome = sc.nextLine();
					films[i].setNome(nome);
					break;
				case 2:
					System.out.println("---ALTERAR-G�NERO---");
					System.out.print("\nG�nero: ");
					String genero = sc.nextLine();
					films[i].setGenero(genero);
					break;
				case 3:
					System.out.println("---ALTERAR-PRE�O---");
					System.out.print("\nPre�o: ");
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
					System.out.println("\nOp��o inv�lida\n");
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
			dados += "Situa��o: " + films[i].getSituacao() + "\nT�tulo: " + films[i].getNome() + "\nC�digo: " + films[i].getCodigo()
						   + "\nG�nero: " + films[i].getGenero() + String.format("\nPre�o: R$ %.2f", films[i].getPreco())
						   + "\nAno de Lan�amento: " + films[i].getAno() + "\n\n";
		}
		return dados;
	}
	
	@Override
	public String list() {
		String dados = "";
		for(int i = 0; i < indice; i++) {
			dados += "T�tulo: " + films[i].getNome() + "\n";
		}
		return dados;
	}
	
	public int getIndice() {
		return indice;
	}
	
	public void alugar(int codigo) {
		for(int i = 0; i < indice; i++) {			
			if(films[i].getCodigo() == codigo && films[i].getSituacao().equalsIgnoreCase("Dispon�vel")) {
				films[i].setSituacao("Alugado");
				System.out.println("\n---FORMUL�RIO---");
				System.out.print("Nome do cliente: ");
				String nomeClient = sc.nextLine();
				Client cl = new Client(nomeClient);					
				System.out.println(cl);
				System.out.println("\nFilme " + films[i].getNome() + " alugado com sucesso!");				
				continue;
			} 
			else if (films[i].getCodigo() == codigo && films[i].getSituacao().equalsIgnoreCase("Alugado")){
				System.out.println("\nFilme " + films[i].getNome() + " j� est� alugado!");
				continue;
			}
		}	
	}
	
	public void devolver(int codigo) {
		for(int i = 0; i < indice; i++) {
			if(films[i].getCodigo() == codigo && films[i].getSituacao().equalsIgnoreCase("Alugado")) {
				films[i].setSituacao("Dispon�vel");
				System.out.println("\nFilme " + films[i].getNome() + " devolvido com sucesso!");
				continue;
			}
			else if(films[i].getCodigo() == codigo && films[i].getSituacao().equalsIgnoreCase("Dispon�vel")) {
				System.out.println("N�o h� filmes para devolver");
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