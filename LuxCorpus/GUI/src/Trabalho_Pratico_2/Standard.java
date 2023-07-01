package Trabalho_Pratico_2;

public final class Standard extends Normal implements CalculoValorFinal
{
	private String horario; 
	public static int contStandard = 0;
	
	public Standard(int codigo, String nome, String data, int idade, float peso, String sexo, String objectivo, int dia, String horario)
	{
		super(codigo, nome, data, idade, peso, sexo, objectivo,dia);
		this.horario = horario;
		contStandard++;
	}
	
	public Standard()
	{
		this(0,"","",0,0,"","",0,"");
	}

	//Métodos de acesso...
	public String getHorario() {
		return horario;
	}
	
	public float getValorFinal()
	{
		return STANDARD+EXTRA_STANDARD+valorTaxa();
	}
	
	public float valorTaxa() {
		return (STANDARD+EXTRA_STANDARD)*TAXA;
	}

	//Método de modifição...
	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String toString() {
		return super.toString()+" Standard [Horario = " + horario + "]";
	}
}
