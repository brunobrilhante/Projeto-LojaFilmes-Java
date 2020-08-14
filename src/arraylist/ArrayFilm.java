package arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Client;
import entities.Film;
import interface_film.Interface;

public class ArrayFilm implements Interface{
	
	private int indice;	
	private List<Film> list = new ArrayList<>();
	
	Scanner sc = new Scanner(System.in);
	
	public ArrayFilm() {		
		indice = 0;
	}
	
	@Override
	public void add(Film film) {		
		list.add(film);
		indice++;					
	}

	@Override
	public void update(int codigo) {
		for(Film f : list) {
			if(f.getCodigo() == codigo) {
				System.out.println("\n---DADOS---");
				System.out.println("T�tulo: " + f.getNome() + "\nC�digo: " + f.getCodigo()
						   + "\nG�nero: " + f.getGenero() + String.format("\nPre�o: R$ %.2f", f.getPreco())
						   + "\nAno de Lan�amento: " + f.getAno());
				System.out.println("\n[1] Alterar t�tulo \n[2] Alterar g�nero \n[3] Alterar pre�o \n[4] Alterar ano de lan�amento");				
				int op = sc.nextInt();
				switch(op) {
				case 1:
					sc.nextLine();
					System.out.println("---ALTERAR-T�TULO---");
					System.out.print("\nT�tulo: ");
					String nome = sc.nextLine();
					f.setNome(nome);
					break;
				case 2:
					System.out.println("---ALTERAR-G�NERO---");
					System.out.print("\nG�nero: ");
					String genero = sc.nextLine();
					f.setGenero(genero);
					break;
				case 3:
					System.out.println("---ALTERAR-PRE�O---");
					System.out.print("\nPre�o: ");
					double preco = sc.nextDouble();
					f.setPreco(preco);
					break;
				case 4:
					System.out.println("---ALTERAR-ANO---");
					System.out.print("\nAno: ");
					int ano = sc.nextInt();
					f.setAno(ano);
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
		for(Film f : list) {			
			if(f.getCodigo() == codigo) {				
				System.out.print("Remover " + f.getNome() + "[s/n]? ");
				char resp = sc.next().charAt(0);
				if(resp == 's' || resp == 'S') {
					System.out.println("Filme " + f.getNome() + " removido!");
					list.remove(f);
				}
			}
		}
	}

	@Override
	public String listAll() {
		String dados = "";
		for(Film f : list) {
			dados += "Situa��o: " + f.getSituacao() + "\nT�tulo: " + f.getNome() + "\nC�digo: " + f.getCodigo()
						   + "\nG�nero: " + f.getGenero() + String.format("\nPre�o: R$ %.2f", f.getPreco())
						   + "\nAno de Lan�amento: " + f.getAno() + "\n\n";
		}
		return dados;
	}
	
	@Override
	public String list() {
		String dados = "";
		for(Film f : list) {
			dados += "T�tulo: " + f.getNome() + "\n";
		}
		return dados;
	}
	
	public int getIndice() {
		return indice;
	}
	
	public void alugar(int codigo) {
		for(Film f : list) {		
			if(f.getCodigo() == codigo && f.getSituacao().equalsIgnoreCase("Dispon�vel")) {
				f.setSituacao("Alugado");
				System.out.println("\n---FORMUL�RIO---");
				System.out.print("Nome do cliente: ");
				String nomeClient = sc.nextLine();
				Client cl = new Client(nomeClient);					
				System.out.println(cl);
				System.out.println("\nFilme " + f.getNome() + " alugado com sucesso!");				
				continue;
			} 
			else if (f.getCodigo() == codigo && f.getSituacao().equalsIgnoreCase("Alugado")){
				System.out.println("\nFilme " + f.getNome() + " j� est� alugado!");
				continue;
			}
		}	
	}
	
	public void devolver(int codigo) {
		for(Film f : list) {
			if(f.getCodigo() == codigo && f.getSituacao().equalsIgnoreCase("Alugado")) {
				f.setSituacao("Dispon�vel");
				System.out.println("\nFilme " + f.getNome() + " devolvido com sucesso!");
				continue;
			}
			else if(f.getCodigo() == codigo && f.getSituacao().equalsIgnoreCase("Dispon�vel")) {
				System.out.println("N�o h� filmes para devolver");
				continue;
			}
		}
	}
	
	public boolean verificar(int codigo) {
		for(Film f : list) {
			if(getIndice() > 0 && f.getCodigo() == codigo) {											
				return false;
			}
		}
		return true;
	}
}