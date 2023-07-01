package Trabalho_Pratico_2;
import java.util.*;
import javax.swing.*;
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
		JOptionPane.showMessageDialog(null, "Hora Alterada com Sucesso :)","Alteração Sucessida...",JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	
	
	
}
