package Trabalho_Pratico_1;

public final class Gold extends Socio implements CalculoDesconto, CalculoValorFinal 
{
	private String nutricionista, tipoPacote, codigoNome, hora, dataReserva;
	private int numeroQuarto, codigoReserva;
	public static int contG = 0;
	
	public Gold(int codigo, String nome, String data, int idade, float peso, String sexo, String objectivo,String nutri, int numero,
			 int cod, String hora, String dataReserva, String tipo, String codNome)
	{
		super(codigo, nome, data, idade, peso, sexo, objectivo);
		
		nutricionista = nutri;
		numeroQuarto = numero;
		
		codigoReserva  = cod;
		tipoPacote = tipo;
		codigoNome = codNome;
		this.hora = hora;
		this.dataReserva = dataReserva;
		
		contG++;
	}
	
	public Gold()
	{
		this(0,"","",0,0,"","","",0,0,"","","","");
	}

	//Métodos de acesso...
	public String getNutricionista() {
		return nutricionista;
	}
	
	public int getNumeroQuarto() {
		return numeroQuarto;
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

	//Métodos de alteração...
	public void setNutricionista(String nutricionista) {
		this.nutricionista = nutricionista;
	}

	public void setNumeroQuarto(int numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	
	public void setHora(String hora) {
		this.hora = hora;
	}

	public void setDataReserva(String dataReserva) {
		this.dataReserva = dataReserva;
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
	
	//Métodos do calculo do valor e valor de desconto...
	public int valorPagar()
	{
		if(nutricionista.equalsIgnoreCase("Sim"))
			return GOLD+EXTRA_GOLD;
		return GOLD;
	}
	
	public float getDesconto() {
		return valorPagar()*DESCONTO_GOLD;
	}
	
	public float getValorFinal() {
		return valorPagar()-getDesconto();
	}
	
	public String toString() {
		return "Gold [nutricionista=" + nutricionista + ", tipoPacote=" + tipoPacote + ", codigoNome=" + codigoNome
				+ ", hora=" + hora + ", dataReserva=" + dataReserva + ", numeroQuarto=" + numeroQuarto
				+ ", codigoReserva=" + codigoReserva + "]";
	}
}
