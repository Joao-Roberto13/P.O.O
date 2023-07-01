package Trabalho_Pratico_2;
import java.util.*;
public class Calculos
{
	public Calculos() {}
	
	
	//o método acumula o valor de descontado...
	public float valorTotalDesconto(Vector vetor)
	{
		float acum = 0;
		
		Socio so;

		//Polimorfismo...
		CalculoDesconto cd;
		
		for(int i = 0; i<vetor.size(); i++)
		{
			so = (Socio) vetor.elementAt(i);
			
			if(so instanceof Gold)
			{
				cd = (Gold) so;
				acum += cd.getDesconto();
			}
			else
			{
				if(so instanceof Silver)
				{
					cd = (Silver) so;
					acum += cd.getDesconto();
				}
			}
		}
		
		return acum;
	}

	//O metodo acumula o valor total pago...
	public float valorTotalPago(Vector vetor)
	{
		int acum = 0;
	
		Socio so;
		//Uso do polimorfismo....
		CalculoValorFinal cd;
		
		for(int i = 0; i<vetor.size(); i++)
		{
			so = (Socio) vetor.elementAt(i);
			
			if(so instanceof Gold)
			{
				cd = (Gold) so;
				acum += cd.getValorFinal();
			}
			else
			{
				if(so instanceof Silver)
				{
					cd = (Silver) so;
					acum += cd.getValorFinal();
				}
				else
				{
					if(so instanceof Premium)
					{
						cd = (Premium) so;
						acum += cd.getValorFinal();
					}
					else
					{
						cd = (Standard) so;
						acum += cd.getValorFinal();
					}
				}
			}
		}
		
		return acum;
	}
	
	public int contarReservasAbril(Vector vetor)
	{
		Socio so;
		Gold g;
		Silver s;
		
		int cont = 0;

		for(int i = 0; i<vetor.size(); i++)
		{
			so = (Socio) vetor.elementAt(i);
			
			if(so instanceof Gold)
			{
				g = (Gold) so;
				
				if(g.getCodigoReserva() != 0)
					if(g.getDataReserva().substring(3, 5).equals("04"))//faz get da data de reserva, de seguida faz substring do mes e vê se é igual a 04(abril)...
						cont++;
			}
			else
			{
				if(so instanceof Silver)
				{
					s = (Silver) so;
					if(s.getCodigoReserva() != 0)
						if(s.getDataReserva().substring(3, 5).equals("04"))//faz get da data de reserva, de seguida faz substring do mes e vê se é igual a 04(abril)...
							cont++;
				}
			}
		}
		return cont;
	}
	
	public void decrementarContador(Vector vetor, int i)
	{
		Socio so = (Socio) vetor.elementAt(i);
		
		//Depois de remover irá decrementar o contador, para que as quantidades dos socios estejam corretos...
		Socio.contS--;
		
		if(so instanceof Gold)
			Gold.contG--;
		else
		{
			if(so instanceof Silver)
				Silver.contS--;
			else		
			{
				Normal.contN--;
				if(so instanceof Standard)
					Standard.contStandard--;
				else
					Premium.contP--;
			}
			
		}
	}
	

}
