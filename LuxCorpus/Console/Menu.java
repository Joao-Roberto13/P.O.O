
package Trabalho_Pratico_1;

public class Menu
{
	private Visualizacoes v ;
	public Menu()
	{
		v = new Visualizacoes();
	}
	
	public void menu()
	{
		byte op;
		boolean passou = false;
		Validacoes val = new Validacoes();
		Tarefas t = new Tarefas();
		
		v.welcome();
		do
		{
			v.menu();
			op = val.validarByte("       Selecione uma opccao (1-14): ", (byte)1, (byte)14);
			
			switch(op)
			{
				case 1:
					t.lerDoFicheiro();
					/*Não colocou-se a mensagem no metodo ler do ficheiro por que fazemos uma chamada do metodo 
					diretamente ao inserir um novo socio para manter atualizado os registros...*/
					v.ficheiroLido();
					passou = true;
					break;
					
				case 2:
					if(passou == false)
						v.erroMenu();
					else
						t.adaptadorQuantidadeSocio();
					break;
					
				case 3:
					if(passou == false)
						v.erroMenu();
					else
						t.adaptadorVisualizarDados();
					break;
					
				case 4:
					if(passou == false)
						v.erroMenu();
					else
						t.adaptadorValorTotal();
					break;
					
				case 5:
					if(passou == false)
						v.erroMenu();
					else
						t.adaptadorValorTotalDesconto();
					break;
					
				case 6:
					if(passou == false)
						v.erroMenu();
					else
						t.adaptadorVisualizarReservaAbril();
					break;
					
				case 7:
					if(passou == false)
						v.erroMenu();
					else
						t.adaptadorVisualizarSocioAntigo();
					break;
					
				case 8:
					if(passou == false)
						v.erroMenu();
					else
						t.adaptadorEscreverFicheiroObjecto();
					break;
					
				case 9:
					if(passou == false)
						v.erroMenu();
					else
						t.adaptadorLerFicheiroObjecto();
					break;
					
				case 10:
					if(passou == false)
						v.erroMenu();
					else
						t.adaptadorAlterarHoraReserva();
					break;
					
				case 11:
					if(passou == false)
						v.erroMenu();
					else
						t.adaptadorRemoverSocio();
					break;
					
				case 12:
					if(passou == false)
						v.erroMenu();
					else
						t.adaptadorAdicionarSocio();
					break;
					
				case 13:
					v.infoProgramador();
					break;
					
				case 14:
					v.sairMenu();
					break;
			}
		}while(op!=14);
	}
	
	public byte subMenu()
	{
		byte op = 0;
		Validacoes val = new Validacoes();
		
		v.subMenuV();
		op = val.validarByte("Selecione uma opcao(1-5): ", (byte)1, (byte)5);
		
		return op;
	}
	
}
