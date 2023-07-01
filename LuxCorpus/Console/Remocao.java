package Trabalho_Pratico_1;

import java.util.Vector;

public class Remocao
{
	public Remocao() {}
	
	//Recebe o vector e o indice onde se encontra o socio a remover...
	public void removerSocio(Vector vetor, int i)
	{
			vetor.remove(i);
			System.out.println("\033[32m-----------------------------------------");
			System.out.println("	Socio removido com sucesso :)");
			System.out.println("-----------------------------------------\033[0m");
	}
}
