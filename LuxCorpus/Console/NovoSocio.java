package Trabalho_Pratico_1;

import java.util.Vector;

public class NovoSocio
{
	private Validacoes val;
	private Pesquisa p;
	private Tarefas t;
	private Ficheiro f;
	
	
	public NovoSocio()
	{
		val = new Validacoes();
		p = new Pesquisa();
		t = new Tarefas();
		f = new Ficheiro();
	}
	
	/*esse método é semelhante ao método de lerDoFicheiro, a diferença é que invez de lerDoFicheiro lê-se do teclado e valida-se cada entrada,
	  e no final depois de ler todos os dados do teclado manda-se por parametro todos os dados concatenados por ';' e 
	   adiciona-se ao ficheiro como se estivessemos a criar o objecto...*/
	public void addNovoSocio(Vector socio)
	{
		char criterio1, criterio2;
		int codigo, idade, numeroQuarto, numeroDias, peso;
		String nome, data, sexo, objectivo,nutricionista,hidroginastica, nomePersonalTrainer, horario;
		Validacoes val = new Validacoes();
		
		codigo =  p.pesquisarMaiorCodigoSocio(socio) + 1; //o método irá devolver o maior código e depois acrescentar 1 para ter o código do socio, isso ira evitar repetição de codigos dos socios.
		nome = val.validarString("Introduza o seu nome: ");
		data = val.validarData("Introduza a data (DD/MM/YYYY): ");
		idade = val.validarInt("Introduza a Idade: ", 13, 100);
		peso = val.validarInt("Introduza o Peso: ", 30, 500);
		sexo = val.validarSexo("Introduza o sexo (Masculino ou Feminino): ");
		objectivo = val.validarObjectivo("Introduza o objectivo(Emagrecer/Musculacao/Resistencia): ");//ver se existe um metodo para ignorar acentuações...
		
		criterio1 = val.validarTipoSocio("Introduza o tipo de socio(Gold/Silver/Normal): ").charAt(0);
		
		//Só le-se os dados do socio e não da reserva...
		switch(criterio1)
		{
			case 'G': case 'g':
				nutricionista = val.validarNutricionista("Introduza se deseja nutricionista(Sim ou Nao): ");
				numeroQuarto = val.validarInt("Introduza o numero de quarto: ", 1, 100);
				
				//manda por parametro todos dados concatenados e separalos com ';'.... 
				f.adicionarNoFicheiro(codigo+";"+nome+";"+data+";"+idade+";"+peso+";"+sexo+";"+objectivo+";G;"+nutricionista+";"+numeroQuarto+";t;");//O criterio para verificar se a reserva...
				break;
			
			case 'S': case 's':
				hidroginastica = val.validarHidroginastica("Introduza o tipo de hidroginastica(Guiada ou Livre): ");
				
				f.adicionarNoFicheiro(codigo+";"+nome+";"+data+";"+idade+";"+peso+";"+sexo+";"+objectivo+";S;"+hidroginastica+";t;");//Criterio t significa que não tem reserva...
				break;
			
			case 'N': case 'n':
				numeroDias = val.validarInt("Introduza o numero de dias (1-12):", 1, 12);
				
				criterio2 = val.validarTipoNormal("Introduza o tipo (Premium ou Standard): ").charAt(0);	
				switch(criterio2)
				{
					case 'S': case 's':
						horario = val.validarString("Introduza o horario que irá frequentar (Ex: 12-15)");
						f.adicionarNoFicheiro(codigo+";"+nome+";"+data+";"+idade+";"+peso+";"+sexo+";"+objectivo+";N;"+numeroDias+";S;"+horario+";");
						break;
					case 'P': case 'p':
						nomePersonalTrainer = val.validarString("Introduza o nome do Personal Trainer: ");
						f.adicionarNoFicheiro(codigo+";"+nome+";"+data+";"+idade+";"+peso+";"+sexo+";"+objectivo+";N;"+numeroDias+";P;"+nomePersonalTrainer+";");
				}
		}
		//lê os dados do ficheiro para manter atualizado, com os ultimos dados...
		t.lerDoFicheiro();
	}
}
