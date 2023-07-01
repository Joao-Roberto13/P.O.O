package Trabalho_Pratico_2;

import java.io.*;
public class Socio implements Serializable
{
	protected float peso;
	protected int codigo, idade;
	protected String nome, data, sexo, objectivo;
	public static int contS = 0;
	
	public Socio(int codigo, String nome, String data, int idade, float peso, String sexo, String objectivo)
	{
		this.codigo = codigo;
		this.nome = nome;
		this.data = data;
		this.idade = idade;
		this.peso = peso;
		this.sexo = sexo;
		this.objectivo = objectivo;
		contS++;
	}
	
	public Socio()
	{
		this(0,"","",0,0,"","");
	}

	//Metodo de acessos...
	public float getPeso() {
		return peso;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public int getIdade() {
		return idade;
	}

	public String getNome() {
		return nome;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public String getData() {
		return data;
	}

	public String getObjectivo() {
		return objectivo;
	}
	
	//Métodos de modificação..
	public void setPeso(float peso) {
		this.peso = peso;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setObjectivo(String objectivo) {
		this.objectivo = objectivo;
	}

	public String toString() {
		return "Socio [peso=" + peso + ", codigo=" + codigo + ", idade=" + idade + ", nome=" + nome + ", data=" + data
				+ ", sexo=" + sexo + ", objectivo=" + objectivo + "]";
	}
}
