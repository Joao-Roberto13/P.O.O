package Trabalho_Pratico_2;

import java.awt.*;
import java.util.*;
import java.io.File;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;

public class NovoSocio extends JFrame{

	private JTabbedPane tabbedPane;
	private JButton buttonAdd, buttonSair;
	private JComboBox boxObjectivo, boxSocio;
	private JSpinner spinnerIdade, spinnerPeso, spinnerQuarto, spinnerDias;
	private ButtonGroup radioGroup, radioGroup_2, radioGroup_3;
	private JRadioButton radioMasculino, radioFeminino, radioSim, radioNao, radioLivre, radioGuiada;
	private JTextField fieldNome, fieldHorario, fieldPersonalTrainer;
	private JPanel panelTipo, panelDados, radioPanel, radioPanel_2,radioPanel_3, panelSocio, panelNorth, panelGold, cards, panelSilver, panelPremium, panelStandard, panelSalvar;
	private JLabel labelNome, labelData, labelIdade, labelSexo, labelPeso, labelObjectivo, labelSocio, labelNutricionista,labelDias, labelQuarto,labelHorario, labelPersonalTrainer, labelHidroginastica;
	private String genero,nutri, hidro,
			objectivos[] = {"Emagrecer","Musculação","Resistência"}, 
			titulosDados [] = {"Dados","Tipo","Socio","Salvar"},
			titulosSocio[] = {"Sócio Gold","Sócio Silver","Sócio Premium","Sócio Standard"};
	
	private JDateChooser dateChooser;
	private Date dataMin, dataMax;
	private Calendar min, max;
	
	private Container contain;
	
	public NovoSocio(Vector socio, File filePath) {
		super("Adicionar novo Sócio");
		contain = getContentPane();
		contain.setLayout(new GridLayout(0, 1));
		
		panelDados = new JPanel();
		panelDados.setBackground(new Color(225,220,187,255));
		panelDados.setLayout(new GridLayout(4, 2));
		
		panelTipo = new JPanel();
		panelTipo.setBackground(new Color(225,220,187,255));
		panelTipo.setLayout(new GridLayout(3, 2));
		
		panelSocio = new JPanel();
		panelSocio.setBackground(new Color(225,220,187,255));
		panelSocio.setLayout(new BorderLayout());
		
		labelNome= new JLabel("Nome do Socio");
		panelDados.add(labelNome);
		
		fieldNome = new JTextField();
		panelDados.add(fieldNome);
		
		labelData = new JLabel("Data de Incrição: ");
		panelDados.add(labelData);
		
		dateChooser = new JDateChooser();
		panelDados.add(dateChooser);
		
		min = Calendar.getInstance();//retorna a data e hora atual com base nas configurações local do sistema. 
		max = Calendar.getInstance();
		
		min.set(2000, Calendar.JANUARY, 1); // Defina o ano, mês e dia desejados
		max.set(2023, Calendar.DECEMBER, 31);
		
		dateChooser.setMinSelectableDate(dataMin);
		dateChooser.setMaxSelectableDate(dataMax);
		
		labelIdade = new JLabel("Idade do Socio:");
		panelDados.add(labelIdade);
		
		spinnerIdade = new JSpinner(new SpinnerNumberModel(14, 13, 100, 1));// Valor inicial = 14, mínimo = 13, máximo = 100, incremento = 1
		spinnerIdade.setBackground(new Color(225,220,187,255));
		panelDados.add(spinnerIdade);
		
		labelPeso = new JLabel("Peso do Socio: ");
		panelDados.add(labelPeso);
		
		spinnerPeso = new JSpinner(new SpinnerNumberModel(44.0, 40.0, 700.0, 0.1));// Valor inicial = 44.0, mínimo = 40.0, máximo = 700.0, incremento = 0.1
		spinnerPeso.setBackground(new Color(225,220,187,255));
		panelDados.add(spinnerPeso);
		
		labelSexo = new JLabel("Gênero: ");
		panelTipo.add(labelSexo);

		radioPanel = new JPanel();
		radioPanel.setBackground(new Color(225,220,187,255));
		radioPanel.setLayout(new GridLayout(1, 2));
		panelTipo.add(radioPanel);

		radioMasculino = new JRadioButton("Masculino");
		radioMasculino.setBackground(new Color(225,220,187,255));
		radioMasculino.setFocusable(false);
		radioMasculino.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						genero = "Masculino";
					}
				});
		radioPanel.add(radioMasculino);

		radioFeminino = new JRadioButton("Feminino");
		radioFeminino.setBackground(new Color(225,220,187,255));
		radioFeminino.setFocusable(false);
		radioFeminino.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						genero = "Feminino";
					}
				});
		radioPanel.add(radioFeminino);

		radioGroup = new ButtonGroup();
		radioGroup.add(radioFeminino);
		radioGroup.add(radioMasculino);

		labelObjectivo = new JLabel("Objetivo do Sócio: ");
		panelTipo.add(labelObjectivo);

		boxObjectivo = new JComboBox(objectivos);
		boxObjectivo.setSelectedIndex(-1);
		boxObjectivo.setBackground(new Color(225,220,187,255));
		boxObjectivo.setFocusable(false);
		panelTipo.add(boxObjectivo);
		
		panelNorth = new JPanel();
		panelNorth.setBackground(new Color(225,220,187,255));
		panelNorth.setLayout(new GridLayout(0, 2, 0, 0));
		
		labelSocio = new JLabel("Tipo de Socio: ");
		labelSocio.setBackground(new Color(225,220,187,255));
		panelNorth.add(labelSocio);
		
		boxSocio = new JComboBox(titulosSocio);
		boxSocio.setFocusable(false);
		boxSocio.setSelectedIndex(-1);
		boxSocio.setBackground(new Color(225,220,187,255));
		boxSocio.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						CardLayout cl = (CardLayout) (cards.getLayout());
						cl.show(cards, (String) e.getItem());
					}
				});
		panelNorth.add(boxSocio);
		panelSocio.add(panelNorth, BorderLayout.NORTH);
		
		panelGold = new JPanel(new GridLayout(2, 2));
		panelGold.setBackground(new Color(225,220,187,255));
		
		labelQuarto = new JLabel("Numero de Quarto: ");
		panelGold.add(labelQuarto);
		
		spinnerQuarto = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));// Valor inicial = 1, mínimo = 1, máximo = 100, incremento = 1
		panelGold.add(spinnerQuarto);
		
		labelNutricionista = new JLabel("Nutricionista: ");
		panelGold.add(labelNutricionista);
		
		radioPanel_2 = new JPanel();
		radioPanel_2.setLayout(new GridLayout(1,2));
		
		radioSim = new JRadioButton("Sim",false);
		radioSim.setBackground(new Color(225,220,187,255));
		radioSim.setFocusable(false);
		radioSim.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						nutri = "Sim";
					}
				});
		radioPanel_2.add(radioSim);
		
		radioNao = new JRadioButton("Não",false);
		radioNao.setBackground(new Color(225,220,187,255));
		radioNao.setFocusable(false);
		radioNao.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						nutri = "Não";
					}
				});
		radioPanel_2.add(radioNao);
		panelGold.add(radioPanel_2);
		
		radioGroup_2 = new ButtonGroup();
		radioGroup_2.add(radioSim);
		radioGroup_2.add(radioNao);
		
		panelSilver = new JPanel(null); //sem layout para poder redimensionar o panel bem...
		panelSilver.setBackground(new Color(225,220,187,255));

		labelHidroginastica = new JLabel("Hidroginastica");
		labelHidroginastica.setBounds(10, 10, 119, 25);
		panelSilver.add(labelHidroginastica);
		
		radioPanel_3 = new JPanel(new GridLayout(1,2));
		radioPanel_3.setBackground(new Color(225,220,187,255));
		
		radioGuiada = new JRadioButton("Guiada",false);
		radioGuiada.setBackground(new Color(225,220,187,255));
		radioGuiada.setFocusable(false);
		radioGuiada.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						hidro = "Guiada";
					}
				});
		radioPanel_3.add(radioGuiada);
		
		radioLivre = new JRadioButton("Livre",false);
		radioLivre.setBackground(new Color(225,220,187,255));
		radioLivre.setFocusable(false);
		radioLivre.addItemListener(
				new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						hidro = "Livre";
					}
				});
		radioPanel_3.add(radioLivre);
		
		radioPanel_3.setBounds(335, 10, 325, 43);
		panelSilver.add(radioPanel_3);
		
		radioGroup_3 = new ButtonGroup();
		radioGroup_3.add(radioGuiada);
		radioGroup_3.add(radioLivre);
		
		panelPremium = new JPanel(new GridLayout(2,2));
		panelPremium.setBackground(new Color(225,220,187,255));
		
		labelDias = new JLabel("Numero de Dias:");
		panelPremium.add(labelDias);
		
		spinnerDias = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));// Valor inicial = 1, mínimo = 1, máximo = 12, incremento = 1
		panelPremium.add(spinnerDias);
		
		labelPersonalTrainer = new JLabel("Nome do Personal Trainer");
		panelPremium.add(labelPersonalTrainer);
		
		fieldPersonalTrainer = new JTextField();
		panelPremium.add(fieldPersonalTrainer);
		
		panelStandard = new JPanel(new GridLayout(2,2));
		panelStandard.setBackground(new Color(225,220,187,255));
		
		labelDias = new JLabel("Numero de Dias:");
		panelStandard.add(labelDias);
		
		spinnerDias = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));// Valor inicial = 1, mínimo = 1, máximo = 12, incremento = 1
		panelStandard.add(spinnerDias);
		
		labelHorario = new JLabel("Horario");
		panelStandard.add(labelHorario);
		
		fieldHorario = new JTextField("Ex: 12-14 ou 14-15...");
		panelStandard.add(fieldHorario);
		
		panelSalvar = new JPanel();
		panelSalvar.setBackground(new Color(225,220,187,255));
		panelSalvar.setLayout(null); //para poder-se usa o setbounds e redimensionar o tamanho dos botoes
		
		buttonAdd = new JButton("Adicionar Sócio");
		buttonAdd.setBounds(37, 51, 297, 43);
		buttonAdd.setFocusable(false);
		buttonAdd.setBackground(new Color(229,43,80));
		buttonAdd.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						adicionarNovoSocio(socio, filePath);
					}
				});
		panelSalvar.add(buttonAdd);
		
		buttonSair = new JButton("Sair");
		buttonSair.setBounds(344, 51, 286, 43);
		buttonSair.setFocusable(false);
		buttonSair.setBackground(new Color(229,43,80));
		buttonSair.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
		panelSalvar.add(buttonSair);
		
		cards = new JPanel(new CardLayout());
		cards.add(panelGold, titulosSocio[0]); //Adiciona-se o componente e
		cards.add(panelSilver, titulosSocio[1]); //associa-se a um titulo para
		cards.add(panelPremium, titulosSocio[2]); //facilitar na busca da carta
		cards.add(panelStandard, titulosSocio[3]); 
		panelSocio.add(cards,BorderLayout.CENTER);
		
		tabbedPane = new JTabbedPane();
		tabbedPane.setBackground(new Color(255, 20, 147));
		tabbedPane.setFocusable(false);
		tabbedPane.add(titulosDados[0], panelDados);
		tabbedPane.add(titulosDados[1], panelTipo);
		tabbedPane.add(titulosDados[2], panelSocio);
		tabbedPane.add(titulosDados[3], panelSalvar);
		
		contain.setBackground(new Color(230,230,190,250));
		contain.add(tabbedPane);
		
		setVisible(true);
		setSize(689,249);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	/*esse método é semelhante ao método de lerDoFicheiro, a diferença é que invez de lerDoFicheiro lê-se do teclado e valida-se cada entrada,
	  e no final depois de ler todos os dados do teclado manda-se por parametro todos os dados concatenados por ';' e 
	   adiciona-se ao ficheiro como se estivessemos a criar o objecto...*/
	public void adicionarNovoSocio(Vector socio, File filePath) {
		int codigo, idade, numeroQuarto, numeroDias, op;
		float peso;
		String nome, data, sexo, objectivo,nutricionista,hidroginastica, nomePersonalTrainer, horario, criterio;
		
		Pesquisa p = new Pesquisa();
		Validacoes val = new Validacoes();
		Ficheiro f = new Ficheiro();
		
		// Formatar a data no formato "DD/MM/YYYY":
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		codigo =  p.pesquisarMaiorCodigoSocio(socio) + 1; //o método irá devolver o maior código e depois acrescentar 1 para ter o código do socio, isso ira evitar repetição de codigos dos socios.
		nome = val.validarString(fieldNome.getText());
		data = sdf.format(dateChooser.getDate());
		idade = Integer.parseInt(spinnerIdade.getValue()+""); 
		peso = Float.parseFloat(spinnerPeso.getValue()+"");
		sexo = genero;
		objectivo = boxObjectivo.getSelectedItem()+"";//ver se existe um metodo para ignorar acentuações...
		criterio =  boxSocio.getSelectedItem()+"";
		
		//Só le-se os dados do socio e não da reserva...
		if(criterio.equalsIgnoreCase("Sócio Gold"))
		{
			nutricionista = nutri;
			numeroQuarto = Integer.parseInt(spinnerQuarto.getValue()+"");
			
			op = JOptionPane.showConfirmDialog(null,
					  "\n Tipo de Sócio: Gold"
					+ "\n Codigo: "+codigo
					+ "\n Nome: "+nome
					+ "\n Data: "+data
					+ "\n Idade: "+idade
					+ "\n Peso: "+peso
					+ "\n Sexo: "+sexo
					+ "\n Objectivo: "+objectivo
					+ "\n Nutricionista: "+nutricionista
					+ "\n NumeroQuarto: "+numeroQuarto
					+ "\n\n Deseja continuar com os dados do sócio???");
			if(op==JOptionPane.OK_OPTION) {
				//manda por parametro todos dados concatenados e separalos com ';'.... 
				f.adicionarNoFicheiro(codigo+";"+nome+";"+data+";"+idade+";"+peso+";"+sexo+";"+objectivo+";G;"+nutricionista+";"+numeroQuarto+";t;");//O criterio para verificar se a reserva...
				reset();
			}
		    else
		    	JOptionPane.showMessageDialog(null, "Certifique-se que toda informação está correta...");
		}
		else
		{
			if(criterio.equalsIgnoreCase("Sócio Silver"))
			{
				hidroginastica = hidro;
				op = JOptionPane.showConfirmDialog(null,
						  "\n Tipo de Sócio: Silver"
						+ "\n Codigo: "+codigo
						+ "\n Nome: "+nome
						+ "\n Data: "+data
						+ "\n Idade: "+idade
						+ "\n Peso: "+peso
						+ "\n Sexo: "+sexo
						+ "\n Objectivo: "+objectivo
						+ "\n Hidroginastica: "+hidroginastica
						+ "\n\n Deseja continuar com os dados do sócio???");
				if(op==JOptionPane.OK_OPTION) {
					f.adicionarNoFicheiro(codigo+";"+nome+";"+data+";"+idade+";"+peso+";"+sexo+";"+objectivo+";S;"+hidroginastica+";t;");//Criterio t significa que não tem reserva...
					reset();
				}
				else
			    	JOptionPane.showMessageDialog(null, "Certifique-se que toda informação está correta...");
			}
			else
			{
				numeroDias = Integer.parseInt(spinnerDias.getValue()+"");
				if(criterio.equalsIgnoreCase("Sócio Standard"))
				{
					horario = val.validarString(fieldHorario.getText());
					op = JOptionPane.showConfirmDialog(null,
							  "\n Tipo de Sócio: Silver"
							+ "\n Codigo: "+codigo
							+ "\n Nome: "+nome
							+ "\n Data: "+data
							+ "\n Idade: "+idade
							+ "\n Peso: "+peso
							+ "\n Sexo: "+sexo
							+ "\n Objectivo: "+objectivo
							+ "\n Numero de Dias: "+numeroDias
							+ "\n Horario: "+horario
							+ "\n\n Deseja continuar com os dados do sócio???");
					if(op==JOptionPane.OK_OPTION) {
						f.adicionarNoFicheiro(codigo+";"+nome+";"+data+";"+idade+";"+peso+";"+sexo+";"+objectivo+";N;"+numeroDias+";S;"+horario+";");
						reset();
					}
					else
						JOptionPane.showMessageDialog(null, "Certifique-se que toda informação está correta...");
				}
				else 
				{
					nomePersonalTrainer = val.validarString(fieldPersonalTrainer.getText());
					op = JOptionPane.showConfirmDialog(null,
							  "\n Tipo de Sócio: Silver"
							+ "\n Codigo: "+codigo
							+ "\n Nome: "+nome
							+ "\n Data: "+data
							+ "\n Idade: "+idade
							+ "\n Peso: "+peso
							+ "\n Sexo: "+sexo
							+ "\n Objectivo: "+objectivo
							+ "\n Numero de Dias: "+numeroDias
							+ "\n Nome do Personal Trainer: "+nomePersonalTrainer
							+ "\n\n Deseja continuar com os dados do sócio???");
					if(op==JOptionPane.OK_OPTION) {
						f.adicionarNoFicheiro(codigo+";"+nome+";"+data+";"+idade+";"+peso+";"+sexo+";"+objectivo+";N;"+numeroDias+";P;"+nomePersonalTrainer+";");
						reset();
					}
					else
						JOptionPane.showMessageDialog(null, "Certifique-se que toda informação está correta...");
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Faça o Refresh de seguida poderá fazer visualizações","Message",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void reset() {
		fieldNome.setText("");
		fieldHorario.setText("");
		fieldPersonalTrainer.setText("");
		
		boxObjectivo.setSelectedIndex(-1);
		boxSocio.setSelectedIndex(-1);
		
		radioFeminino.setSelected(false);
		radioMasculino.setSelected(false);
		radioLivre.setSelected(false);
		radioGuiada.setSelected(false);
		radioNao.setSelected(false);
		radioSim.setSelected(false);
		
		spinnerDias.setValue(1);
		spinnerIdade.setValue(14);
		spinnerPeso.setValue(44);
		spinnerQuarto.setValue(1);
	}
} 