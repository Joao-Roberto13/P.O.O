package Trabalho_Pratico_1;

public final class Silver extends Socio implements CalculoDesconto, CalculoValorFinal
{
	private int codigoReserva;
	private String hidroginastica, tipoPacote, codigoNome, hora, dataReserva;
	public static int contS = 0;
	
	public Silver(int codigo, String nome, String data, int idade, float peso, String sexo, String objectivo, String hidro,
			 int cod, String hora, String dataReserva, String tipo, String codNome)
	{
		super(codigo, nome, data, idade, peso, sexo, objectivo);
		
		hidroginastica = hidro;
		
		codigoReserva  = cod;
		tipoPacote = tipo;
		codigoNome = codNome;
		this.hora = hora;
		this.dataReserva = dataReserva;
		
		contS++;
	}
	public Silver()
	{
		this(0,"","",0,0,"","","",0,"","","","");
	}
	
	//Metodos de acesso..
	public String getHidroginastica() {
		return hidroginastica;
	}

	public String getHora() {
		return hora;
	}

	public String getDataReserva() {
		return dataReserva;
	}
	
	public int getCodigoReserva() {
		return codigoReserva;
	}
	public String getTipoPacote() {
		return tipoPacote;
	}
	public String getCodigoNome() {
		return codigoNome;
	}
	//Métodos de modificação...
	public void setHidroginastica(String hidroginastica) {
		this.hidroginastica = hidroginastica;
	}
	
	public void setCodigoReserva(int codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public void setTipoPacote(String tipoPacote) {
		this.tipoPacote = tipoPacote;
	}

	public void setCodigoNome(String codigoNome) {
		this.codigoNome = codigoNome;
	}
	
	public void setHora(String hora) {
		this.hora = hora;
	}

	public void setDataReserva(String dataReserva) {
		this.dataReserva = dataReserva;
	}
	
	public int valorPagar()
	{
		if(hidroginastica.equalsIgnoreCase("Guiada"))
			return SILVER + EXTRA_SILVER;
		return SILVER;
	}
	
	public float getDesconto() {
		return valorPagar()*DESCONTO_SILVER;
	}
	
	public float getValorFinal() {
		return valorPagar()-getDesconto();
	}

	public String toString() {
		return "Silver [codigoReserva=" + codigoReserva + ", hidroginastica=" + hidroginastica + ", tipoPacote="
				+ tipoPacote + ", codigoNome=" + codigoNome + ", hora=" + hora + ", dataReserva=" + dataReserva + "]";
	}
}