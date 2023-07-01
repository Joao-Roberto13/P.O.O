package Trabalho_Pratico_1;
/*
 * O LuxCorpus pretende gerir os seus clientes sócios e as reservas que são feitas. 
 * 
 * Sabe-se que cada sócio é caracterizado por um  código,  nome, data  de  inscrição (DD/MM/AAAA), idade, peso, sexo e 
 * objectivo(emagrecer/musculação/resistência).
 * 
 * Cada sócio pode ser umde três tipos: gold. silver e normal, onde:
 * o gold tem acesso a um nutricionista particular (Sim/não) e um número de quarto no hotel.
 * O silver tem acesso a hidroginástica (guiada/livre). 
 * O Normal tem a quantidade mensal de dias que irá frequentar (1-12) e pode ser um de dois tipos: standard e premium. 
 * 
 * O premium caracteriza-se pelo nome do personal trainer e o standard caracteriza-se pelo horário que irá frequentarem horas(15-18).
 *  
 * O LuxCorpus oferece a possibilidade dos sócios (excepto  o  normal)  fazerem  reservas  ao  Spa.  
 * Cada  reserva  possui  um  código de  reserva,  hora  de  entrada (HH:MM),data(DD/MM/AAAA), o código e nome do sócio, 
 * tipo de pacote (individual/casal). 
 * 
 * Através de um menu e submenu simples e amigável pretende se ler dados de um ficheiro de texto, com no mínimo 20 linhas,
 * sobre sócios e reservas e de seguida:
 * 
 * Calcule a quantidade de sócios de cada tipo e a quantidade total de sócios;
 * 
 * Visualize todos os dados de sócios, separadamente por tipos também e dados de todas as reservas.
 * 
 * Calcule  o  valor total  pago  ao  LuxCorpus,  sabendo  que  sócios  gold  pagam  15000mt  e  se  quiserem nutricionista pagam extra de 2000mt,
 * sócios silver pagam 9500mt e se quiserem fazer hidroginástica com guia devem pagar extra de 1000mt, 
 * os sócios normais premium pagam 7000mt e extra de 500mt ao  personal  trainer  e  os  normais  standard  pagam  3500mt  com  extra  de  150mt 
 * para  o  cartão  de parqueamentoe uma taxa de 5% aplicado ao valor a pagar.
 * Todos os sócios devem calcular valor final (use o conceito de classes abstractas);
 * 
 * Implemente uma interface CálculoDesconto que contém uma taxa de desconto de 20% para os sócios gold, 10% para os sócios silver. 
 * O desconto é aplicado aos valores finais dos sócios gold e silver;
 *
 * Calcule o valor total de desconto;
 * Sendo que estamos no mês da mulher, visualize a quantidade de reservas feitas para o mês de abril.
 * Visualize o sócio mais antigo ao LuxCorpus;
 * Escreva dados num ficheiro de objectos, e leia do ficheiro de objectos;
 * Altere a hora da reserva, sabendo que o spa só está disponível das 9 as 15 horas.
 * Remova um sócio pelo código.
 * Introduza dados de novos sócios pelo teclado e escreva no ficheiro de texto.
 */
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
