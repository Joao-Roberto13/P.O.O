package Trabalho_Pratico_1;

public class Normal extends Socio 
{
	protected int numeroDias; 
	public static int contN = 0;
	
	public Normal(int codigo, String nome, String data, int idade, float peso, String sexo, String objectivo, int dia)
	{
		super(codigo, nome, data, idade, peso, sexo, objectivo);
		numeroDias = dia;
		
		contN++;
	}
	
	public Normal()
	{
		this(0,"","",0,0,"","",0);
	}



	public int getNumeroDias() {
		return numeroDias;
	}

	public void setNumeroDias(int numeroDias) {
		this.numeroDias = numeroDias;
	}

	public String toString() {
		return "Normal [numeroDias=" + numeroDias + "]";
	}
}