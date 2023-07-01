package Trabalho_Pratico_2;

public final class Premium extends Normal implements CalculoValorFinal
{
	private String nomePersonalTrainer;
	
	public static int contP = 0;
	
	public Premium(int codigo, String nome, String data, int idade, float peso, String sexo, String objectivo, int dia,String nomePT)
	{
		super(codigo, nome, data, idade, peso, sexo, objectivo, dia);
		
		nomePersonalTrainer = nomePT;
		contP++;
	}
	
	public Premium()
	{
		this(0,"","",0,0,"","",0,"");
	}

	//Método de acesso...
	public String getNomePersonalTrainer() {
		return nomePersonalTrainer;
	}
	
	//Método de Modificações...
	public void setNomePersonalTrainer(String nome) {
		this.nomePersonalTrainer = nome;
	}

	public float getValorFinal()
	{
		return PREMIUM + EXTRA_PREMIUM;
	}

	public String toString() {
		return super.toString()+" Premium [Nome = " + nomePersonalTrainer + "]";
	}
}