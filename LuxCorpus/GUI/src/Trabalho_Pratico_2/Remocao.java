package Trabalho_Pratico_2;

import java.util.Vector;

import javax.swing.JOptionPane;

public class Remocao 
{
	public Remocao() {}
	
	public void removerSocio(Vector socio,int codigo) {
		Pesquisa p = new Pesquisa();
		Calculos c = new Calculos();
		int i;
		
		if(codigo != 0)
		{
			i = p.pesquisarSocioCodigo(socio, codigo);

			if(i<0)
			{
				JOptionPane.showMessageDialog(null, "Sócio não exsite :(\nCertifique-se de estar a introduzir o codigo do socio","Codigo Invalido!!!!",JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				//decrementa a quantidade de socios, depois remove;
				c.decrementarContador(socio, i);
				
				socio.remove(i);
				socio.trimToSize();
				JOptionPane.showMessageDialog(null, "Socio removido com Sucesso :)");
			}
		}
	}
}
