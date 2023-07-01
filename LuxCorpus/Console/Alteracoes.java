package Trabalho_Pratico_1;
import java.util.*;
public class Alteracoes
{
	public Alteracoes() {}
	
	
	/*O método irá alterar a hora, recebendo o vector , a posição onde 
	 * deseja alterar a hora e a hora que deseja alterar....*/
	public void alterarHoraReserva(Vector vetor, int i, String hora)
	{
		Socio so;
		Gold g;
		Silver s;
		
		so = (Socio) vetor.elementAt(i);
		
		if(so instanceof Gold)
		{
			g = (Gold) so;
			g.setHora(hora);
		}
		else
		{
			if(so instanceof Silver)
			{
				s = (Silver) so;
				s.setHora(hora);
			}
		}
			
		System.out.println("\033[32m---------------------------------------");
		System.out.println("Hora alterada com Sucesso :(");
		System.out.println("---------------------------------------\033[0m");
	}
	
	
	
	
	
}
