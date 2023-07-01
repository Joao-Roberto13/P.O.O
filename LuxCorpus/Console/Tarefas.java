package Trabalho_Pratico_1;

import java.io.*;
import java.util.*;

public class Tarefas
{
	private Vector socio;
	private Visualizacoes v;
	private Calculos c;
	private Pesquisa p;
	private Ficheiro f;
	private Validacoes val;
	private char criterio2;
	
	public Tarefas()
	{
		socio = new Vector();
		v = new Visualizacoes();
		c = new Calculos();
		p = new Pesquisa();
		f = new Ficheiro();
		val = new Validacoes();
	}
	
	public void lerDoFicheiro()
	{
		float peso;
		StringTokenizer umaCadeia;
		int codigo, idade, numeroQuarto, numeroDias, codigoReserva = 0;
		String nome, data, sexo, objectivo,nutricionista,hidroginastica, hora, dataReserva, tipoPacote, codigoNome, 
		nomePersonalTrainer, horario, umaLinha, file = "DadosTPr_1.txt";
		char criterio1, criterio3;
		
		
		//É importanate ter essa intstrução porque o método é chamado mais de 1 vez....
		//Sendo assim deve remover todos elementos do vetor para quando ler os dados mais de 1 vez não duplicar os dados lido anteriormente...
		socio.removeAllElements();
	
		//também para não duplicar a quantidade dos socios lidos...
		Socio.contS = 0;
		Gold.contG = 0;
		Silver.contS = 0;
		Normal.contN = 0;
		Premium.contP = 0;
		Standard.contStandard = 0;
		
		try
		{
			BufferedReader x = new BufferedReader(new FileReader(file));
			
			umaLinha = x.readLine();
			while(umaLinha != null)
			{
				umaCadeia = new StringTokenizer(umaLinha, ";");
				codigo = Integer.parseInt(umaCadeia.nextToken());
				nome = umaCadeia.nextToken();
				data = umaCadeia.nextToken();
				idade = Integer.parseInt(umaCadeia.nextToken());
				peso = Float.parseFloat(umaCadeia.nextToken());
				sexo = umaCadeia.nextToken();
				objectivo = umaCadeia.nextToken();
				
				criterio1 = umaCadeia.nextToken().charAt(0);
				
				switch(criterio1)
				{
					case 'G': case 'g':
						nutricionista = umaCadeia.nextToken();
						numeroQuarto = Integer.parseInt(umaCadeia.nextToken());
						
						criterio2 = umaCadeia.nextToken().charAt(0);
						
						if(criterio2 == 'R' || criterio2 == 'r')
						{
							codigoReserva = Integer.parseInt(umaCadeia.nextToken());
							hora = umaCadeia.nextToken();
							dataReserva = umaCadeia.nextToken();
							tipoPacote = umaCadeia.nextToken();
							codigoNome = umaCadeia.nextToken();
						}
						else
						{
							codigoReserva  = 0;
							hora = "  N/A";
							dataReserva = "N/A";
							tipoPacote = "N/A";
							codigoNome = "N/A";
						}
						
						criarObjGold(codigo, nome, data, idade, peso, sexo, objectivo,
								nutricionista, numeroQuarto, codigoReserva, hora, dataReserva, tipoPacote, codigoNome);
						break;
						
					case 'S': case 's':
						hidroginastica = umaCadeia.nextToken();
						
						criterio2 = umaCadeia.nextToken().charAt(0);
						
						if(criterio2 == 'R' || criterio2 == 'r')
						{
							codigoReserva  = Integer.parseInt(umaCadeia.nextToken());
							hora = umaCadeia.nextToken();
							dataReserva = umaCadeia.nextToken();
							tipoPacote = umaCadeia.nextToken();
							codigoNome = umaCadeia.nextToken();
						}
						else //caso de estar a ler dados de um socio sem reserva...
						{
							codigoReserva  = 0;
							hora = "  N/A";
							dataReserva = "N/A";
							tipoPacote = "N/A";
							codigoNome = "N/A";
						}
						
						criarObjSilver(codigo, nome, data, idade, peso, sexo, objectivo,
								hidroginastica, codigoReserva, hora, dataReserva, tipoPacote, codigoNome);
						break;
						
					case 'N': case 'n':
						numeroDias = Integer.parseInt(umaCadeia.nextToken());
						criterio3 = umaCadeia.nextToken().charAt(0);
						switch(criterio3)
						{
							case 'S': case 's':
								horario = umaCadeia.nextToken();
								
								criarObjStandard(codigo, nome, data, idade, peso, sexo, objectivo,
										numeroDias, horario);
								break;
							case 'P': case 'p':
								nomePersonalTrainer = umaCadeia.nextToken();
								
								criarObjPremium(codigo, nome, data, idade, peso, sexo, objectivo,
										numeroDias, nomePersonalTrainer);
						}
				}
				umaLinha = x.readLine();	
			}
		}
		catch(FileNotFoundException f) {System.out.println("\033[31mFicheiro "+file+" não encontrado :(\033[0m");}
		catch(NumberFormatException n) {System.out.println(n.getMessage());}
		catch(IOException i) {System.out.println(i.getMessage());}
	}
	
	//Cria o objecto Gold com os dados do socio gold....
	public void criarObjGold (int Cod, String nome, String data, int idade, float peso, String Sexo, String obj, String nutri, int numeroQuarto,
			int codigoReserva, String hora, String dataReserva, String tipoPacote, String codigoNome)
	{
		Gold g = new Gold();
		
		g.setCodigo(Cod);
		g.setNome(nome);
		g.setData(data);
		g.setIdade(idade);
		g.setPeso(peso);
		g.setSexo(Sexo);
		g.setObjectivo(obj);
		g.setNutricionista(nutri);
		g.setNumeroQuarto(numeroQuarto);

		//parte das reservas...
		g.setCodigoReserva(codigoReserva);
		g.setHora(hora);
		g.setDataReserva(dataReserva);
		g.setTipoPacote(tipoPacote);
		g.setCodigoNome(codigoNome);
		
		
		socio.addElement(g);
		socio.trimToSize();
	}
	
	//Cria objecto Silver com os dados do Silver...
	public void criarObjSilver(int Cod, String nome, String dat, int idade, float peso, String Sexo, String obj, String hidro,
			int codigoReserva, String hora, String dataReserva, String tipoPacote, String codigoNome)
	{
		Silver s = new Silver();
		
		s.setCodigo(Cod);
		s.setNome(nome);
		s.setData(dat);
		s.setIdade(idade);
		s.setPeso(peso);
		s.setSexo(Sexo);
		s.setObjectivo(obj);
		s.setHidroginastica(hidro);
		
		//parte das reservas...
		s.setCodigoReserva(codigoReserva);
		s.setHora(hora);
		s.setDataReserva(dataReserva);
		s.setTipoPacote(tipoPacote);
		s.setCodigoNome(codigoNome);
		
		socio.addElement(s);
		socio.trimToSize();
	}
	
	public void criarObjStandard(int Cod, String nome, String data, int idade, float peso, String Sexo, String obj, int dia, String horario)
	{
		Standard s = new Standard();
		
		//Dados do socio standard...
		s.setCodigo(Cod);
		s.setNome(nome);
		s.setData(data);
		s.setIdade(idade);
		s.setPeso(peso);
		s.setSexo(Sexo);
		s.setObjectivo(obj);
		s.setNumeroDias(dia);
		s.setHorario(horario);
		
		socio.addElement(s);
		socio.trimToSize();
	}

	public void criarObjPremium(int Cod, String nome, String data, int idade, float peso, String Sexo, String obj,int dia, String nomeP)
	{
		Premium p = new Premium();
		
		//parte dos socios...
		p.setCodigo(Cod);
		p.setNome(nome);
		p.setData(data);
		p.setIdade(idade);
		p.setPeso(peso);
		p.setSexo(Sexo);
		p.setObjectivo(obj);
		p.setNumeroDias(dia);
		p.setNomePersonalTrainer(nomeP);
		
		socio.addElement(p);
		socio.trimToSize();
	}

	public void adaptadorQuantidadeSocio()
	{
		v.visualizarQuantidadeSocio();
	}
	
	public void adaptadorVisualizarDados()
	{
		Menu m = new Menu();
		byte op;
		
		do
		{
			op = m.subMenu();
			switch(op)
			{
				case 1:
					v.visualizarGold(socio);
					break;
					
				case 2:
					v.visualizarSilver(socio);
					break;
				
				case 3:
					v.visualizarPremium(socio);
					break;
					
				case 4:
					v.visualizarStandard(socio);
					break;
			
				case 5:
					v.sairMenu();
			}
		}while(op!=5);
	}
	
	public void adaptadorValorTotalDesconto()
	{
		float acum = c.valorTotalDesconto(socio);
		v.visualizarDescontoTotal(acum);
	}
	
	public void adaptadorValorTotal()
	{
		float acum = c.valorTotalPago(socio);
		v.visualizarValorTotal(acum);
	}
	
	public void adaptadorVisualizarReservaAbril()
	{
		int cont =  c.contarReservasAbril(socio);
		v.visualizarReservasAbril(socio, cont);
	}

	public void adaptadorVisualizarSocioAntigo()
	{
		SocioAntigo sa = new SocioAntigo();
		sa.visualizarSocioAntigo(socio);
	}

	public void adaptadorEscreverFicheiroObjecto()
	{
		f.escreverNoFicheiroObj(socio);
	}

	public void adaptadorLerFicheiroObjecto()
	{
		f.lerDoFicheiroObj(socio);
	}

	public void adaptadorAlterarHoraReserva()
	{
		int i, codigo;
		String hora;
		Alteracoes a = new Alteracoes();
		
		codigo = val.validarInt("Introduza o codigo do Socio: ",10000,100000);
		i = p.pesquisarSocioCodigo(socio, codigo);
		
		if(i<0)
		{
			v.erroCodigoReserva();
		}
		else
		{
			hora = val.validarHora();
			a.alterarHoraReserva(socio, i, hora);
		}
	}
	
	public void adaptadorRemoverSocio()
	{
		int i, codigo;
		Remocao r = new Remocao();
		
		codigo = val.validarInt("Introduza o codigo do Socio: ",10000,100000);
		i = p.pesquisarSocioCodigo(socio, codigo);
		
		if(i<0)
		{
			v.erroCodidoSocio();
		}
		else
		{
			r.removerSocio(socio, i);
			//Removeu um socio, logo deve decrementar a quantidade de socios;
			c.decrementarContador(socio, i);
		}
	}
	
	public void adaptadorAdicionarSocio()
	{
		NovoSocio ns = new NovoSocio();
		ns.addNovoSocio(socio);
	}
}