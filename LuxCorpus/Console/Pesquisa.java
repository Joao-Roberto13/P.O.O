package Trabalho_Pratico_1;
import java.util.Vector;

public class Pesquisa
{
	public Pesquisa() {}
	
	//O método retorna o indice do sócios mais antigo...
	public int pesquisarSocioAntigo(Vector vetor)
	{
		Socio s;
		int indice = 0, ano, menor = 11111;
		
		
		for(int i = 0; i<vetor.size(); i++)
		{
			s = (Socio) vetor.elementAt(i);
			ano = Integer.parseInt(s.getData().substring(6));
			
			//se o menor ano for maior que o outro ano no vector ele ira guardar o outro ano...
			if(ano<menor)
			{
				indice = i;
				menor = ano;
			}
		}
		return indice;
	}
	
	//Pesquisa o indice do socio pelo codigo dele... 
	public int pesquisarSocioCodigo(Vector vetor, int codigo)
	{
		Socio s;
		
		for(int i = 0; i<vetor.size(); i++)
		{
			s = (Socio) vetor.elementAt(i);
			if(s.getCodigo() == codigo)
				return i;
		}
		return -1;
	}
	
	/*Esse método pesquisa o maior codigo do socio e retorna o codigo para que ao adicionar um 
	  novo socio ele não introduza o codigo, o programa simplesmente ira adicionar um ao maior codigo
	  e esse será o codigo do novo socio...*/
	public int pesquisarMaiorCodigoSocio(Vector vetor)
	{
		Socio s;
		int maior = 0;
		
		for(int i = 0; i<vetor.size(); i++)
		{
			s = (Socio) vetor.elementAt(i);
			if(s.getCodigo() > maior)
			{
				maior = s.getCodigo();
			}
		}
		return maior;
	}
}
