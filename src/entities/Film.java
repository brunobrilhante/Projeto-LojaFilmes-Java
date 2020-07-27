package entities;

public class Film {
	
	private String nome, genero, situacao;
	private int codigo, ano;
	private double preco;
	
	public Film(String nome, String genero, int codigo, int ano, double preco) {	
		this.nome = nome;
		this.genero = genero;
		this.codigo = codigo;
		this.ano = ano;
		this.preco = preco;
	}

	public String getNome() {		
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public String getSituacao() {
		return situacao;
	}
}
