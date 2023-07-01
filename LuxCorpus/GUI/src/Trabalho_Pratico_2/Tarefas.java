package Trabalho_Pratico_2;

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class Tarefas
{
	private Vector socio;
	private Calculos c;
	private Pesquisa p;
	public static File filePath;
	private Validacoes val;
	private Jogos j;
	private char criterio2;
	private DecimalFormat df;
	public static boolean passou = false, passou_2 = false, passou_3 = true;

	public Tarefas()
	{
		socio = new Vector();
		c = new Calculos();
		p = new Pesquisa();
		val = new Validacoes();
		j = new Jogos();
		df = new DecimalFormat("###,###,###.00 MZN");
	}
	
	public void lerDoFicheiro(File file)
	{
		float peso;
		StringTokenizer umaCadeia;
		int codigo, idade, numeroQuarto, numeroDias, codigoReserva = 0;
		String nome, data, sexo, objectivo,nutricionista,hidroginastica, hora, dataReserva, tipoPacote, codigoNome, 
		nomePersonalTrainer, horario, umaLinha;
		char criterio1, criterio3;
		
			//É importanate ter essa intstrução porque o método é chamado mais de 1 vez....
			//Sendo assim deve remover todos elementos do vetor para quando ler os dados mais de 1 vez não duplicar os dados lido anteriormente...
			socio.removeAllElements();
		
			//também para não duplicar a quantidade dos socios lidos...
			Gold.contG = 0;
			Silver.contS = 0;
			Normal.contN = 0;
			Premium.contP = 0;
			Standard.contStandard = 0;
			Socio.contS = 0;
			
			try
			{
				BufferedReader x = new BufferedReader(new FileReader(file));
				/*para quando adicionar novo socio e chamar esse metodo 
				mandar por parametro o ultimo file lido quando o programa foi aberto.
				Por que esse metodo leva por parametro o caminho do file a ser lido, entao nao ha
				como chamar esse metodo sem ter esse caminho. dai que precisamos de guardar em uma variavel*/
				filePath = file; 
				
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
				x.close();
				JOptionPane.showMessageDialog(null, "Ficheiro Lido Com Sucesso:)");
				passou = true;//usado para colocar os dados na tela menu enabled...
				
			}
			catch(FileNotFoundException f) {JOptionPane.showMessageDialog(null, "Erro: Ficheiro "+file+" não encontrado :(","Erro no Arquivo",JOptionPane.ERROR_MESSAGE);}
			catch(NumberFormatException n) {JOptionPane.showMessageDialog(null, "Erro: o arquivo contém dados incorretos :(", "Erro no arquivo", JOptionPane.ERROR_MESSAGE);}
			catch(NoSuchElementException nn) {JOptionPane.showMessageDialog(null, "Erro: Certifique-se de estar a ler o ficheiro de Texto correto","Erro no Arquivo",JOptionPane.ERROR_MESSAGE);}
			catch(IOException i) {JOptionPane.showMessageDialog(null, "ERRO: Ficheiro de Contem erro :(","Erro no Arquivo",JOptionPane.ERROR_MESSAGE);}
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
	
	public void adaptadorDadosGold() {
		new VisualizarGold(socio);
	}
	
	public void adaptadorDadosSilver() {
		new VisualizarSilver(socio);
	}
	
	public void adaptadorDadosPremium() {
		new VisualizarPremium(socio);
	}
	
	public void adaptadorDadosStandard() {
		new VisualizarStandard(socio);
	}
	
	public void adaptadorDadosReservas() {
		new VisualizarReservasAbril(socio);
	}
	
	public void adaptadorValorTotal() {
		JOptionPane.showMessageDialog(null, "O Valor total pago a LuxCorpus é de: "+df.format(c.valorTotalPago(socio)),"Valor Total LuxCorpus",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void adaptadorDescontoTotal() {
		JOptionPane.showMessageDialog(null, "O valor total de Desconto é de: "+df.format(c.valorTotalDesconto(socio)),"Desconto Total",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void adaptadorVisualizarSocioAntigo() {
		int i = p.pesquisarSocioAntigo(socio);
		new VisualizarSocioAntigo(socio, i);
	}
	
	public void adaptadorEscreverFicheiroObjecto()
	{
		new FileChooser("Ficheiro de Objecto","dat").saveFileChooser(socio);
	}

	public void adaptadorLerFicheiroObjecto(File file)
	{
		Ficheiro f = new Ficheiro();
		f.lerFicheiroObjecto(socio, file);
	}
	
	public void adaptadorVisualizarDadosProgramadador() {
		new InfomacoesProgramadores();
	}
	
	public void adaptadorRemoverSocio()
	{
		int codigo ;

		codigo = val.validarInt("Introduza o codigo de socio a remover: ", 10000, 100000);
		
		Remocao r = new Remocao();
		r.removerSocio(socio, codigo);
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
			JOptionPane.showMessageDialog(null, "Codigo Incorreto :(\nCertifique-se de estar a introduzir o codigo do socio","Codigo Invalido!!!!",JOptionPane.ERROR_MESSAGE);
		}
		else
		{

			String h = JOptionPane.showInputDialog("Introduza a hora formato HH:MM (9:00 as 15:00): ","HH:MM");
			
			hora = val.validarHora(h);
			a.alterarHoraReserva(socio, i, hora);
		}
	}
	
	public void adaptadorAdicionarSocio()
	{
		//esse foi o ultimo ficheiro de texto(filePath) lido pelo utilizador, então para ler denovo,
		//eu mando o mesmo ficheiro, dentro da classe novo socio apos a inserccao do novo socio no ficheiro le o ficheiro...
		new NovoSocio(socio, filePath); 
	}
	
	public void adaptadorGuessNumber()
	{
		j.guessNumber();
	}
	
	public void adaptadorGuessResultado() {
		j.guessResultado();
	}
	
	public void adaptadorGuessAge() {
		j.guessAge();
	}
}