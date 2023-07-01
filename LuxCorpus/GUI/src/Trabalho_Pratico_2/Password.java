package Trabalho_Pratico_2;

public class Password 
{
	private String nome, password;
	
	public Password(String nome, String password)
	{
		this.nome = nome;
		this.password = password;
	}
	
	public Password() {
		this("","");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
