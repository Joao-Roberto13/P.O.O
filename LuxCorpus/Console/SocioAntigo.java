package Trabalho_Pratico_1;

import java.util.Vector;

public class SocioAntigo
{
	public SocioAntigo() {}
	
	public void visualizarSocioAntigo(Vector vetor)
	{
		Pesquisa p = new Pesquisa();
		int i = p.pesquisarSocioAntigo(vetor);
		
		Socio s = (Socio) vetor.elementAt(i);
		
		System.out.println("|----------------------------------------------------------------------------------------------------|");
		System.out.println("|                                      \033[32mSocio mais Antigo \033[0m                                            |");
		System.out.println("|----------------------------------------------------------------------------------------------------|");
		System.out.println("| Codigo |      Nome do Socio      | Data de Inscricao | Idade |  Peso  |    Sexo    |   Objectivo   |");
		System.out.println("|----------------------------------------------------------------------------------------------------|");
		System.out.printf("|%6d  |%20s     |%15s    |%5d  | %6s |%10s  | %12s  |\n",s.getCodigo(),s.getNome(),s.getData(),s.getIdade(),s.getPeso(),s.getSexo(),s.getObjectivo());
		System.out.println("|----------------------------------------------------------------------------------------------------|");
	}
}
