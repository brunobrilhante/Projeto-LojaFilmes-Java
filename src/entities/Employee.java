package entities;

public class Employee {
	
	private String email, nome, senha;
	
	public Employee(String email, String nome, String senha) {
		this.email = email;
		this.nome = nome;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean login(String emailLogin, String senhaLogin) {
		if(getEmail().equals(emailLogin) && getSenha().equals(senhaLogin)) {
			return true;
		} else {
			return false;
		}		
	}
}
