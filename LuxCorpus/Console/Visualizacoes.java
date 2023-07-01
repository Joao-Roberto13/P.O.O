package Trabalho_Pratico_1;
import java.util.*;
import java.text.DecimalFormat;
public class Visualizacoes 
{
	private DecimalFormat kg, df;
	
	public  Visualizacoes()
	{
		kg = new DecimalFormat("###.0 Kg");
		df = new DecimalFormat("\033[32m ###,###,###.0 MZN\033[0m"); //Codigo ANSI - Fonte: https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	}
		
	public void menu() {
		System.out.println("     |----------------------------###############---------------------------|");
		System.out.println("     |                            ##    \033[32mMENU\033[0m   ##                           |");
		System.out.println("     |----------------------------###############---------------------------|");
		System.out.println("     | 1. Ler os Dados do Ficheiro.                                         |");
		System.out.println("     | 2. Visualizar a quantidade total de socios de cada tipo e o total.   |");
		System.out.println("     | 3. Visualizar todos os dados de sócios separadamente.                |");
		System.out.println("     | 4. Calcule  o  valor total  pago  ao  LuxCorpus.                     |");
		System.out.println("     | 5. Calcular valor Total Desconto.                                    |");
		System.out.println("     | 6. Visualizar a quantidade de reservas feitas para o mês de abril.   |");
		System.out.println("     | 7. Visualize o sócio mais antigo ao LuxCorpus.                       |");
		System.out.println("     | 8. Escreva dados num ficheiro de objectos.                           |");
		System.out.println("     | 9. Ler do ficheiro de objectos.                                      |");
		System.out.println("     | 10. Alterar a hora da reserva.                                       |");
		System.out.println("     | 11. Remova um sócio pelo código.                                     |");
		System.out.println("     | 12. Introduzir dados de novo sócio.                                  |");
		System.out.println("     | 13. Informação do Programador.                                       |");
		System.out.println("     | 14. Sair.                                                            |");
		System.out.println("     |----------------------------------------------------------------------|");
		System.out.println("     |          \033[32mMade & Assembled By: (Keny,Michelle,João).Investment\033[0m        |");
		System.out.println("     |----------------------------------------------------------------------|");
	}
	
	public void subMenuV() {
		System.out.println("|----------------------------------------------------|");
		System.out.println("|                     \033[32mSUB-MENU\033[0m                       |");
		System.out.println("|----------------------------------------------------|");
		System.out.println("|             1. Visualizar Gold                     |");
		System.out.println("|             2. Visualizar Silver                   |");
		System.out.println("|             3. Visualizar premium                  |");
		System.out.println("|             4. Visualizar Standard                 |");
		System.out.println("|             5. Sair                                |");
		System.out.println("|----------------------------------------------------|");
	}
	
	public void visualizarQuantidadeSocio()
	{
		System.out.println("|----------------------------------------|");
		System.out.println("|         \033[32m Quantidade dos Socios \033[0m        |");
		System.out.println("|----------------------------------------|");
		System.out.println("|  Gold  |  Silver  |  Normal  |  Total  |");
		System.out.println("|----------------------------------------|");
		System.out.printf("|%8d|%10d|%10d|%9d|", Gold.contG, Silver.contS, Normal.contN, Socio.contS);
		System.out.println("\n|----------------------------------------|");
		System.out.println();
		System.out.println("|-------------------------------|");
		System.out.println("|           \033[32m Normal \033[0m            |");
		System.out.println("|-------------------------------|");
		System.out.println("|    Premium    |    Standard   |");
		System.out.println("|-------------------------------|");
		System.out.printf("| %12d  | %13d |",Premium.contP,Standard.contStandard);
		System.out.println("\n|-------------------------------|");
		System.out.println();
		
	}
	
	//Os metodos abaixo visualizam os dados dos socios separadamente...
	public void visualizarGold(Vector vetor)
	{
		Socio o;
		Gold g;
		
		System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
		System.out.println("|                                                                                          \033[32m   Socio Gold   \033[0m                                                                                                                                           |");
		System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
		System.out.println("| Codigo |      Nome do Socio      | Data de Inscricao | Idade |  Peso  |    Sexo    |   Objectivo   | Nutricionista |  Nrº do Quarto | Codigo da Reserva |  Hora  | Data da Reserva | Tipo de Pacote |    Codigo e Nome do Socio    | Valor a Pagar  |");
		System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
		for(int i = 0; i<vetor.size(); i++)
		{
			o = (Socio) vetor.elementAt(i);
			
			if(o instanceof Gold)
			{
				g = (Gold) o;
				System.out.printf("|%6d  |%20s     |%15s    |%5d  | %6s|%10s  | %12s  |%9s      |%10d      | %11d       | %4s  |  %12s   |  %12s  | %27s  | %22s |\n",g.getCodigo(),g.getNome(),g.getData(),g.getIdade(),kg.format(g.getPeso()),
						g.getSexo(),g.getObjectivo(),g.getNutricionista(),g.getNumeroQuarto(),g.getCodigoReserva(),g.getHora(),g.getDataReserva(),g.getTipoPacote(),g.getCodigoNome(),df.format(g.getValorFinal()));
			}
		}
		System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
	}
	
	public void visualizarSilver(Vector vetor)
	{
		Socio o;
		Silver g;
		
		System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
		System.out.println("|                                                                                                   \033[32m Socio Silver \033[0m                                                                                                                    |");
		System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
		System.out.println("| Codigo |      Nome do Socio      | Data de Inscricao | Idade |  Peso  |    Sexo    |   Objectivo   | Hidroginastica | Codigo da Reserva |  Hora  | Data da Reserva | Tipo de Pacote |    Codigo e Nome do Socio    | Valor a Pagar  |");
		System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
		for(int i = 0; i<vetor.size(); i++)
		{
			o = (Socio) vetor.elementAt(i);
			
			if(o instanceof Silver)
			{
				g = (Silver) o;
				System.out.printf("|%6d  |%20s     |%15s    |%5d  | %6s|%10s  | %12s  |  %10s    | %11d       | %4s  |  %12s   |  %12s  | %27s  | %22s |\n",g.getCodigo(),g.getNome(),g.getData(),g.getIdade(),kg.format(g.getPeso()),g.getSexo(),
						g.getObjectivo(),g.getHidroginastica(),g.getCodigoReserva(),g.getHora(),g.getDataReserva(),g.getTipoPacote(),g.getCodigoNome(),df.format(g.getValorFinal()));
			}
		}
		System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
	}

	public void visualizarPremium(Vector vetor)
	{
		Socio o;
		Premium g;
		
		System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------|");
		System.out.println("|                                              \033[32m    Socio Premium \033[0m                                                                           |");
		System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------|");
		System.out.println("| Codigo |    Nome do Socio    | Data de Inscricao | Idade |  Peso  |    Sexo    |   Objectivo   | Dias | Personal Trainer | Valor a Pagar  |");
		System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------|");
		for(int i = 0; i<vetor.size(); i++)
		{
			o = (Socio) vetor.elementAt(i);
			
			if(o instanceof Premium)
			{
				g = (Premium) o;
				System.out.printf("|%6d  |%18s   |%15s    |%5d  | %6s|%10s  | %12s  | %3d  | %16s | %22s |\n",g.getCodigo(),g.getNome(),g.getData(),g.getIdade(),kg.format(g.getPeso()),
						g.getSexo(),g.getObjectivo(),g.getNumeroDias(),g.getNomePersonalTrainer(),df.format(g.getValorFinal()));
			}
		}
		System.out.println("|-------------------------------------------------------------------------------------------------------------------------------------------|");
	}

	public void visualizarStandard(Vector vetor)
	{
		Socio o;
		Standard g;
		
		System.out.println("|----------------------------------------------------------------------------------------------------------------------------------|");
		System.out.println("|                                    \033[32m  Socio Standard   \033[0m                                                                           |");
		System.out.println("|----------------------------------------------------------------------------------------------------------------------------------|");
		System.out.println("| Codigo |    Nome do Socio    | Data de Inscricao | Idade |  Peso  |    Sexo    |   Objectivo   | Dias | Horario | Valor a Pagar  |");
		System.out.println("|----------------------------------------------------------------------------------------------------------------------------------|");
		for(int i = 0; i<vetor.size(); i++)
		{
			o = (Socio) vetor.elementAt(i);
			
			if(o instanceof Standard)
			{
				g = (Standard) o;
				System.out.printf("|%6d  |%16s     |%15s    |%5d  | %6s|%10s  | %12s  | %3d  | %7s | %22s |\n",g.getCodigo(),g.getNome(),g.getData(),g.getIdade(),kg.format(g.getPeso()),
						g.getSexo(),g.getObjectivo(),g.getNumeroDias(),g.getHorario(),df.format(g.getValorFinal()));
			}
		}
		System.out.println("|----------------------------------------------------------------------------------------------------------------------------------|");
	}
	
	//O metodo visualiza todas reservas do mes de abril...
	public void visualizarReservasAbril(Vector vetor, int contR)
	{
		Socio so;
		Gold n;
		Silver s;

		System.out.println("|-----------------------------------------------------------------------------------|");
		System.out.println("|                           \033[32m Reservas do Mes de Abril   \033[0m                            |");
		System.out.println("|-----------------------------------------------------------------------------------|");
		System.out.println("|  Codigo  |  Hora  | Data de Reserva | Tipo Pacote  |    Codigo e Nome do Socio    |");
		System.out.println("|-----------------------------------------------------------------------------------|");
		for(int i = 0; i<vetor.size(); i++)
		{
			so = (Socio) vetor.elementAt(i);

			if(so instanceof Gold)
			{
				n = (Gold) so;
				if(n.getCodigoReserva() != 0)
					if(n.getDataReserva().substring(3, 5).equals("04"))//faz get da data de reserva, de seguida faz substring do mes e vê se é igual a 04(abril)...
						System.out.printf("| %6d   | %5s  |  %11s    |  %10s  | %26s   |\n",n.getCodigoReserva(),n.getHora(),n.getDataReserva(),n.getTipoPacote(),n.getCodigoNome());
			}
			else
			{
				if(so instanceof Silver)
				{
					s = (Silver) so;
					if(s.getCodigoReserva() != 0)
						if(s.getDataReserva().substring(3, 5).equals("04"))//faz get da data de reserva, de seguida faz substring do mes e vê se é igual a 04(abril)...
							System.out.printf("| %6d   | %5s  |  %11s    |  %10s  | %26s   |\n",s.getCodigoReserva(),s.getHora(),s.getDataReserva(),s.getTipoPacote(),s.getCodigoNome());
				}
			}
		}
		System.out.println("|-----------------------------------------------------------------------------------|");
		System.out.printf("|                  \033[32m Quantidades de Reservas para o Mes de Abril:\033[0m%3d                 |\n",contR);
		System.out.println("|-----------------------------------------------------------------------------------|");
	}
	
	public void visualizarDescontoTotal(float val)
	{
		System.out.println("----------------------------------------------------------");
		System.out.println(" Valor Total de Desconto e de: "+df.format(val));
		System.out.println("----------------------------------------------------------");
	}
	
	public void visualizarValorTotal(float val)
	{
		System.out.println("----------------------------------------------------------");
		System.out.println(" Valor Total Pago a LuxCorp e de: "+df.format(val));
		System.out.println("----------------------------------------------------------");
	}
	
	public void welcome() //Uso do código ANSI para colorir texto na console... Fonte: https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	{
		//\033[32m - \033[0m
		
		//o código "\033[32m" define que o texto a partir desse ponto será Verde, e
		//"\033[0m" define que a formatação deve ser resetada, para que o restante do texto seja impresso normalmente.
		System.out.println("\033[32m###################################################################################");
		System.out.println("##                                   LUXCORPUS                                   ##");
		System.out.println("###################################################################################\033[0m");
		System.out.println("     |                                                                      |");
	}
	
	public void erroMenu()
	{
		//\033[31m - \033[0m Codigo ANSI (Vermelho)...
		System.out.println("\033[31m|------------------------------|");
		System.out.println("| Invalido! Execute a opccao 1 |");
		System.out.println("|------------------------------|\033[0m");
	}
	
	public void erro()
	{
		//\033[31m - \033[0m Codigo ANSI (Vermelho)...
		System.out.println("\033[31m|------------------------------|");
		System.out.println("| Invalido! Tente Novamente    |");
		System.out.println("|------------------------------|\033[0m");
	}
	
	public void erroHora()
	{
		System.out.println("\033[31m|-----------------------------------------------------------|");
		System.out.println("| Invalido Tente novamente:(                                |");
		System.out.println("| Certifiqui-se que a hora obedece o seguinte formato HH:MM |");
		System.out.println("|-----------------------------------------------------------|\033[0m");
	}
	
	public void erroCodigoReserva()
	{
		
		System.out.println("\033[31m-----------------------------------------------------");
		System.out.println("	Socio não existe :(");
		System.out.println("Certifique-se de estar a inserir o codigo de reserva.");
		System.out.println("-----------------------------------------------------\033[0m");
	}
	
	public void erroCodidoSocio()
	{
		System.out.println("\033[31m-----------------------------------------");
		System.out.println("	Codigo inexistente :(");
		System.out.println("-----------------------------------------\033[0m");
	}
	
	public void ficheiroLido()
	{
		System.out.println("\033[32m|------------------------------|");
		System.out.println("| Ficheiro lido com Sucesso :) |");
		System.out.println("|------------------------------|\033[0m");
	}
	
	//dados do programador...
	public void infoProgramador()
	{
        System.out.println("|========================================================|");
        System.out.println("|       \033[36mNome \033[0m     | \033[36m Codigo \033[0m  |     \033[36m    Email   \033[0m         |");
        System.out.println("|=================|===========|==========================|");
        System.out.println("|\033[32m Keny Muchanga\033[0m   |\033[32m 20210410\033[0m  |  \033[32m kenymuch@gmail.com\033[0m     |");
        System.out.println("|-----------------|-----------|--------------------------|");
        System.out.println("|\033[32m Michelle Boane\033[0m  |\033[32m 20200266 \033[0m |\033[32m boanemichelle@gmail.com\033[0m  |");
        System.out.println("|-----------------|-----------|--------------------------|");
        System.out.println("|\033[32m Joao Roberto \033[0m   |\033[32m 20220852 \033[0m |  \033[32m jringuane24@gmail.com\033[0m  |");
        System.out.println("|========================================================|");
        //para depois de visualizar os dados, deixar uma linha com espaço para melhor organizacao e voltar ao menu...
		System.out.println();
	}

	//para a opção sair do menu...
	public void sairMenu()
	{
		//\033[32m - \033[0m
		System.out.println("\033[32m|=====================|");
		System.out.println("|     Obrigado :)     |");
		System.out.println("|=====================|\033[0m");
	}
}
