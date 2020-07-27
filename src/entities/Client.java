package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
	
	private String nome;
	private Date data = new Date();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Client(String nome) {		
		this.nome = nome;		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData() {
		return sdf.format(data);
	}
	
	public String toString() {
		return "\n---DADOS---\n" + "Cliente: " + getNome() + "\nData de locação: " + getData();				
	}
}
