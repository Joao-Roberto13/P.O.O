package Trabalho_Pratico_2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import com.toedter.calendar.JCalendar;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.sound.sampled.*;

public class Tela_Menu extends JFrame implements MouseListener
{
	private Color cor, cor2;
	private Tarefas t;
	private JMenuBar bar;
	private JSlider slider;
	private JPopupMenu popup;
	private JLabel labelLogo, label, labelAudio, labelHora, labelData;
	private ButtonGroup radioGroup_2;
	private JPanel panel, panelPintar, panelButton, panelAux, panel2, panelCalendario;
	private JRadioButton radioDark, radioLight,radioOriginal;
	private JButton buttonLimpar,buttonCor, buttonSair, buttonRemover,buttonAlterar,buttonNovo;
	
	private JMenu menuFile,menuLer,menuVisualizacao,menuVisualizarNormal,menuHelp,menuExtra, menuTheme, menuQuantidade, menuValor, menuJogos, menuAudio;
	
	private JMenuItem itemLerTxt, itemEscrever,itemVisualizarSocioAntigo,itemVisualizarReservas,itemVisualizarDesconto,
	itemVisualizarValor,itemVisualizarStandard,itemVisualizarPremium,itemVisualizarSilver,itemVisualizarGold,itemVisualizarSocio,
	itemVisualizarQuant,itemSair,itemLerObj,itemDonate,itemAbout,itemContactos, itemCalculadora, itemPaint, itemGuessNumber, itemGuessAge, 
	itemGuessResult, itemSelect, itemReset, itemQuit, refresh, itemAboutThis, itemCalendario;
	
	private ImageIcon logoBack,logo, iiMath, menu, iiPaint, iiJogo, iiAge, iiNumero, iiResultado, iiAudioPause, iiAudioPlay, iiVisualizacao;
	
	private Clip clip;//para audio...
	private FileChooser f;
	private JSeparator separator;
	private Container contain;
	
	private int xValue = -10, yValue = -10, dia, mes, ano, diaSemana;
	private float tamanho;
	private boolean ps = true, pass = false, passouCale = true;
	private File file;
	private JLabel labelDiaSemana;
	
	public static void main(String[] args) {
		new Tela_Menu();
	}
	
	public Tela_Menu() {
		super("----Menu----");
		contain = getContentPane();
		contain.setLayout(null);// Definindo o layout como null (AbsoluteLayout)
		
		//Imagens......
		iiJogo = new ImageIcon("joy.png");
		
		iiAge = new ImageIcon("iconAge.png");
		iiNumero = new ImageIcon("iconNumber.png");
		iiResultado = new ImageIcon("iconResult.png");
		
		logo = new ImageIcon("logo.png");
		logoBack = new ImageIcon("logoNOBack.png");
		iiMath = new ImageIcon("math.png");
		menu = new ImageIcon("menuIcon.png");
		iiPaint = new ImageIcon("iconPaint.png");
		iiAudioPlay = new ImageIcon("play.png");
		iiAudioPause = new ImageIcon("pause.png");
		iiVisualizacao = new ImageIcon("Visual.png");
		
		t = new Tarefas();
		
		bar = new JMenuBar();
		setJMenuBar(bar);
		setIconImage(menu.getImage());
	
		//componentes...
		panel = new JPanel();
		labelLogo = new JLabel();
		separator = new JSeparator();
		menuFile = new JMenu("File");
		menuHelp = new JMenu("Help");
		menuAudio = new JMenu("Audio");
		menuExtra = new JMenu("Extra");
		menuTheme = new JMenu("Theme");
		radioGroup_2 = new ButtonGroup();
		buttonSair = new JButton("SIGN OUT");
		itemDonate = new JMenuItem("Donate");
		buttonNovo = new JButton("Novo Sócio");
		menuLer = new JMenu("Ler dados do...");
		itemContactos = new JMenuItem("Dados dos Programador");
		radioDark = new JRadioButton("Dark",false);
		itemSair = new JMenuItem("Sair do Programa");
		buttonRemover = new JButton("Remover Sócio");
		menuValor = new JMenu("Visualizar valor...");
		itemAbout = new JMenuItem("About LuxCorpus");
		radioLight = new JRadioButton("Light",false);
		menuVisualizacao = new JMenu("Visualizações");
		itemVisualizarQuant = new JMenuItem("Sócios");
		radioOriginal = new JRadioButton("Default",true);
		menuVisualizarNormal = new JMenu("Sócio Normal");
		itemVisualizarGold = new JMenuItem("Sócio Gold");
		itemLerTxt = new JMenuItem("Ficheiro de Texto");
		itemLerObj = new JMenuItem("Ficheiro de Objecto");
		buttonAlterar = new JButton("Alterar hora Reserva");
		itemVisualizarSilver = new JMenuItem("Sócio Silver");
		itemVisualizarPremium = new JMenuItem("Sócio Premium");
		itemVisualizarStandard = new JMenuItem("Sócio Standard");
		menuQuantidade = new JMenu("Visualizar quantidade de... ");
		itemVisualizarDesconto = new JMenuItem("Total de Desconto");
		itemEscrever = new JMenuItem("Salvar ficheiro de Objecto");
		itemVisualizarValor = new JMenuItem("Total pago ao LuxCorpus");
		itemVisualizarSocio = new JMenu("Visualizar Dados dos Sócios");
		itemVisualizarReservas = new JMenuItem("Reservas feitas para Abril");
		itemVisualizarSocioAntigo = new JMenuItem("Visualizar o Sócio mais antigo");
		itemCalendario = new JMenuItem("Calendario");
		panelCalendario = new JPanel();
		itemAboutThis = new JMenuItem("Funcionamento do Programa");
		labelAudio = new JLabel();
		labelAudio.setBounds(950, 350, 250, 250);
		
		panel2 = new JPanel();
		panel2.setBounds(0, 249, 289, 191);
		panel2.setLayout(new GridLayout(4, 1));
		panel.add(panel2);
		
		panel.setBounds(0, 0, 285, 542);
		contain.add(panel);
		panel.setLayout(null);
		
		labelLogo.setIcon(logo);
		labelLogo.setBounds(30, 52, 220, 110);
		panel.add(labelLogo);

		//tratamento das accoes dos butoes...
		buttonNovo.setIcon(new ImageIcon("new.png"));
		buttonNovo.setBackground(new Color(179,163,116));
		buttonNovo.setFont(new Font("Times New Roman", Font.BOLD, 13));
		buttonNovo.setBounds(37, 250, 204, 32);
		buttonNovo.setEnabled(false);
		buttonNovo.setFocusable(false);
		buttonNovo.setToolTipText("Lê os dados Do Ficheiro");
		buttonNovo.setBorderPainted(false);
		buttonNovo.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.adaptadorAdicionarSocio();
					}
				});
		panel2.add(buttonNovo);
		
		buttonAlterar.setFont(new Font("Times New Roman", Font.BOLD, 13));
		buttonAlterar.setBackground(new Color(179,163,116));
		buttonAlterar.setBounds(37, 350, 204, 32);
		buttonAlterar.setEnabled(false);
		buttonAlterar.setFocusable(false);
		buttonAlterar.setToolTipText("Lê os dados Do Ficheiro");
		buttonAlterar.setIcon(new ImageIcon("hora.png"));
		buttonAlterar.setBorderPainted(false);
		buttonAlterar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.adaptadorAlterarHoraReserva();
					}
				});
		panel2.add(buttonAlterar);
		
		buttonRemover.setFont(new Font("Times New Roman", Font.BOLD, 13));
		buttonRemover.setBackground(new Color(179,163,116));
		buttonRemover.setEnabled(false);
		buttonRemover.setFocusable(false);
		buttonRemover.setToolTipText("Lê os dados Do Ficheiro");
		buttonRemover.setIcon(new ImageIcon("remover.png"));
		buttonRemover.setBorderPainted(false);
		buttonRemover.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.adaptadorRemoverSocio();
					}
		});
		buttonRemover.setBounds(37, 300, 204, 32);
		panel2.add(buttonRemover);
		
		buttonSair.setBackground(new Color(179,163,116));
		buttonSair.setFont(new Font("Times New Roman", Font.BOLD, 13));
		buttonSair.setFocusable(false);
		buttonSair.setIcon(new ImageIcon("signOut.png"));
		buttonSair.setBorderPainted(false);
		buttonSair.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new Login();
						dispose();
					}
				});
		buttonSair.setBounds(37, 400, 204, 32);
		panel2.add(buttonSair);
		
		
		menuFile.setMnemonic('F');
		menuFile.setIcon(new ImageIcon("file.png"));
		menuFile.setFocusable(false);
		bar.add(menuFile);
		
		itemLerTxt.setMnemonic('T');
		itemLerTxt.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						f = new FileChooser("Ficheiro de Texto","txt");
						file = f.openFileChooser();
						
						if(!(file==null))
						{
							t.lerDoFicheiro(file);
							if(Tarefas.passou==true)
							{
								colocarEnabled();
							}
						}
					}
				});
		menuLer.setMnemonic('L');
		menuLer.add(itemLerTxt);
		menuFile.add(menuLer);
		
		itemEscrever.setMnemonic('E');
		itemEscrever.setEnabled(false);
		itemEscrever.setToolTipText("Save As...");
		itemEscrever.setIcon(new ImageIcon("fichObj.png"));
		itemEscrever.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.adaptadorEscreverFicheiroObjecto();
					}
				});
		menuFile.add(itemEscrever);

		itemLerObj.setMnemonic('O');
		itemLerObj.setEnabled(false);
		itemLerObj.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						f = new FileChooser("Ficheiro de Objecto","dat");
						File file = f.openFileChooser();

						if(!(file==null))
						{
							t.adaptadorLerFicheiroObjecto(file);
							if(Tarefas.passou_2==true)
							{
								colocarEnabled();
							}
						}
					}
				});
		menuLer.setIcon(new ImageIcon("FicheiroTxt.png"));
		menuLer.add(itemLerObj);
		
		itemSair.setMnemonic('S');
		itemSair.setIcon(new ImageIcon("sair.png"));
		itemSair.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
		menuFile.add(itemSair);

		menuVisualizacao.setMnemonic('V');
		menuVisualizacao.setFocusable(false);
		menuVisualizacao.setEnabled(false);
		menuVisualizacao.setToolTipText("Lê os dados Do Ficheiro");
		menuVisualizacao.setIcon(iiVisualizacao);
		bar.add(menuVisualizacao);

		itemVisualizarQuant.setMnemonic('Q');
		itemVisualizarQuant.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						new SocioQuantidade();
					}
				});
		menuQuantidade.add(itemVisualizarQuant);
		menuVisualizacao.add(menuQuantidade);

		itemVisualizarSocio.setMnemonic('S');
		menuVisualizacao.add(itemVisualizarSocio);

		itemVisualizarGold.setMnemonic('G');
		itemVisualizarGold.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.adaptadorDadosGold();
					}
				});
		itemVisualizarSocio.add(itemVisualizarGold);

		itemVisualizarSilver.setMnemonic('S');
		itemVisualizarSilver.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.adaptadorDadosSilver();
					}
				});
		itemVisualizarSocio.add(itemVisualizarSilver);

		menuVisualizarNormal.setMnemonic('N');
		itemVisualizarSocio.add(menuVisualizarNormal);

		itemVisualizarPremium.setMnemonic('P');
		itemVisualizarPremium.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.adaptadorDadosPremium();
					}
				});
		menuVisualizarNormal.add(itemVisualizarPremium);

		itemVisualizarStandard.setMnemonic('S');
		itemVisualizarStandard.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.adaptadorDadosStandard();
					}
				});
		menuVisualizarNormal.add(itemVisualizarStandard);

		itemVisualizarSocioAntigo.setMnemonic('A');
		itemVisualizarSocioAntigo.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.adaptadorVisualizarSocioAntigo();
					}
				});
		menuVisualizacao.add(itemVisualizarSocioAntigo);
		
		menuVisualizacao.add(separator);
		
		
		itemVisualizarValor.setMnemonic('V');
		itemVisualizarValor.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.adaptadorValorTotal();
					}
				});
		menuValor.add(itemVisualizarValor);
		menuVisualizacao.add(menuValor);

		
		itemVisualizarDesconto.setMnemonic('D');
		itemVisualizarDesconto.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.adaptadorDescontoTotal();
					}
				});
		menuValor.add(itemVisualizarDesconto);
		menuVisualizacao.add(menuValor);

		itemVisualizarReservas.setMnemonic('R');
		itemVisualizarReservas.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.adaptadorDadosReservas();
					}
				});
		menuQuantidade.add(itemVisualizarReservas);

		
		menuExtra.setMnemonic('E');
		menuExtra.setIcon( new ImageIcon("Extra.png"));
		menuExtra.setFocusable(false);
		bar.add(menuExtra);
		
		menuAudio.setMnemonic('A');
		menuAudio.setIcon(new ImageIcon("musica.png"));
		menuExtra.add(menuAudio);
		
		itemSelect = new JMenuItem("Selecionar audio.");
		itemSelect.setMnemonic('S');
		itemSelect.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						audioPlayer();
					}
				});
		menuAudio.add(itemSelect);
		
		itemReset = new JMenuItem("Reniciar o Audio.");
		itemReset.setMnemonic('R');
		itemReset.setEnabled(false);
		itemReset.setToolTipText("Selecione o audio...");
		itemReset.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clip.setMicrosecondPosition(0);
					}
				});
		menuAudio.add(itemReset);
		
		itemQuit = new JMenuItem("Sair do Audio Player.");
		itemQuit.setMnemonic('Q');
		itemQuit.setToolTipText("Selecione o audio...");
		itemQuit.setEnabled(false);
		itemQuit.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						itemQuit.setEnabled(false);
						itemReset.setEnabled(false);
						labelAudio.setIcon(null);
						clip.close();
						
						contain.revalidate();
						contain.repaint(950, 350, 250, 250);
					}
				});
		menuAudio.add(itemQuit);
		
		labelAudio.addMouseListener(
				new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						if(pass)
						{
							clip.start();
							labelAudio.setIcon(iiAudioPause);
						}
						else  {
							clip.stop();
							labelAudio.setIcon(iiAudioPlay);
							/*labelAudio.setToolTipText("Press ALT + P to Play");
							labelAudio.setDisplayedMnemonic('P');
							labelAudio.setLabelFor(labelAudio);*/
						}
						pass = !pass; //inverte o estado da variavel...
					}
				});
		
		menuTheme.setMnemonic('T');
		menuTheme.setIcon(new ImageIcon("theme.png"));
		menuExtra.add(menuTheme);
		
		radioOriginal.setMnemonic('F');
		radioOriginal.setIcon(new ImageIcon("originalTheme.png"));
		radioOriginal.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						originalMode();
					}
				});
		menuTheme.add(radioOriginal);
		
		
		radioLight.setMnemonic('L');
		radioLight.setIcon(new ImageIcon("LightTheme.png"));
		radioLight.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						lightMode();
					}
				});
		menuTheme.add(radioLight);
		
		
		radioDark.setMnemonic('D');
		radioDark.setIcon(new ImageIcon("darkTheme.png"));
		radioDark.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						darkMode();
					}
				});
		menuTheme.add(radioDark);
		
		radioGroup_2.add(radioOriginal);
		radioGroup_2.add(radioLight);
		radioGroup_2.add(radioDark);
		
		menuExtra.add(new JSeparator());
		
		itemCalculadora = new JMenuItem("Calculadora");
		itemCalculadora.setMnemonic('C');
		itemCalculadora.setIcon(iiMath);
		itemCalculadora.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		          new Calculadora();
		    }
		});



		menuExtra.add(itemCalculadora);
	
		itemPaint = new JMenuItem("Paint");
		itemPaint.setMnemonic('P');
		itemPaint.setIcon(iiPaint);
		itemPaint.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						paint();
					}
				});
		menuExtra.add(itemPaint);
		
		menuExtra.add(new JSeparator());
		
		menuJogos = new JMenu("Jogos");
		menuJogos.setMnemonic('J');
		menuJogos.setIcon(iiJogo);
		menuExtra.add(menuJogos);
		
		itemGuessNumber = new JMenuItem("Guess Number");
		itemGuessNumber.setMnemonic('N');
		itemGuessNumber.setIcon(iiNumero);
		itemGuessNumber.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.adaptadorGuessNumber();
					}
				});
		menuJogos.add(itemGuessNumber);
		
		itemGuessAge = new JMenuItem("Guess Age");
		itemGuessAge.setMnemonic('A');
		itemGuessAge.setIcon(iiAge);
		itemGuessAge.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.adaptadorGuessAge();
					}
				});
		menuJogos.add(itemGuessAge);
		
		itemGuessResult = new JMenuItem("Guess Result");
		itemGuessResult.setIcon(iiResultado);
		itemGuessResult.setMnemonic('R');
		itemGuessResult.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.adaptadorGuessResultado();
					}
				});
		menuJogos.add(itemGuessResult);
		
		menuHelp.setFocusable(false);
		menuHelp.setIcon(new ImageIcon("Help.png"));
		menuHelp.setMnemonic('H');
		bar.add(menuHelp);
		
		itemContactos.setMnemonic('C');
		itemContactos.setIcon(new ImageIcon("Contactos.png"));
		itemContactos.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.adaptadorVisualizarDadosProgramadador();
					}
				});
		
		menuHelp.add(itemContactos);

		itemAbout.setMnemonic('A');
		itemAbout.setIcon( new ImageIcon("about.gif"));
		itemAbout.setIcon(new ImageIcon("aboutUS.png"));
		itemAbout.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Um refúgio criado a pensar na rotina de todos os dias. O seu espaço de excelência para recuperar forças, equilibrando o corpo e a mente.\n \n"
								+ " O Luxcorpus é o maior e mais moderno Health Club & Spa da cidade de Maputo. Um espaço elegante e confortável onde pode usufruir \n"
								+ "de um leque variado de treinos e aulas no Health Club ou de momentos de total relaxamento no SPA."
								+ "As duas piscinas aquecidas,\n uma principal e uma de aprendizagem destinada aos bebés, criam um inovador espelho de água, numa experiência única em Moçambique,\n "
								+ "sempre acompanhada por profissionais altamente qualificados. Isolados ou integrados nas Experiências Exclusivas Luxcorpus,\n "
								+ "desfrute de diferentes momentos de lazer e bem-estar, cuidadosamente desenhados para potenciar o melhor de si.","About LuxCorpus",JOptionPane.INFORMATION_MESSAGE);
					}
				});
		menuHelp.add(itemAbout);
		
		itemDonate.setMnemonic('P');
		itemDonate.setIcon(new ImageIcon("donate.png"));
		itemDonate.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Se você gostou deste software,contacte-nos e considere fazer uma doação para apoiar nosso trabalho :)","Donate!!!",JOptionPane.INFORMATION_MESSAGE);
					}
				});
		menuHelp.add(itemDonate);
		
		buttonNovo.setForeground(Color.WHITE);
		buttonSair.setForeground(Color.WHITE);
		buttonRemover.setForeground(Color.WHITE);
		buttonAlterar.setForeground(Color.white);
		
		labelData = new JLabel("01/01/2000");
		labelData.setBounds(149, 31, 121, 21);
		panel.add(labelData);
		labelData.setFont(new Font("Tw Cen MT", Font.ITALIC, 20));
		labelData.setBackground(Color.LIGHT_GRAY);
		labelData.setForeground(Color.PINK);
		
		labelHora = new JLabel("00:00:00");
		labelHora.setBounds(164, 10, 111, 21);
		panel.add(labelHora);
		labelHora.setFont(new Font("Tw Cen MT", Font.ITALIC, 20));
		labelHora.setBackground(Color.LIGHT_GRAY);
		labelHora.setForeground(Color.PINK);
		
		labelDiaSemana = new JLabel("");
		labelDiaSemana.setBounds(10, 511, 208, 21);
		labelDiaSemana.setForeground(Color.PINK);
		panel.add(labelDiaSemana);
		
		buttonSair.addMouseListener(
				new MouseAdapter() {
					public void mouseExited(MouseEvent e) {
						buttonSair.setBackground(cor2);
					}
					
					public void mouseEntered(MouseEvent e) {
						buttonSair.setBackground(new Color(229,43,80));
					}
				});
		
		buttonNovo.addMouseListener(
				new MouseAdapter() {
				public void mouseExited(MouseEvent e) {
					buttonNovo.setBackground(cor2);
				}
				
				public void mouseEntered(MouseEvent e) {
					buttonNovo.setBackground(new Color(59,122,87));
				}
		});
		
		buttonRemover.addMouseListener(
				new MouseAdapter() {
				public void mouseExited(MouseEvent e) {
					buttonRemover.setBackground(cor2);
				}
				
				public void mouseEntered(MouseEvent e) {
					buttonRemover.setBackground(new Color(59,122,87));
				}
		});
		
		buttonAlterar.addMouseListener(
				new MouseAdapter() {
				public void mouseExited(MouseEvent e) {
					buttonAlterar.setBackground(cor2);
				}
				
				public void mouseEntered(MouseEvent e) {
					buttonAlterar.setBackground(new Color(59,122,87));
				}
		});
		
		bar.addMouseListener(
				new MouseAdapter() {
				public void mouseExited(MouseEvent e) {
					bar.setBackground(new Color(0, 150, 150));
				}
				
				public void mouseEntered(MouseEvent e) {
					bar.setBackground(new Color(179,163,116));
				}
		});
		bar.setForeground(Color.WHITE);

		refresh = new JMenuItem("Refresh");
		refresh.setEnabled(false);
		refresh.setIcon(new ImageIcon("refresh.png"));
		refresh.setToolTipText("Lê os dados do ficheiro...");
		refresh.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						originalMode();
						t.lerDoFicheiro(file);
					}
				});
		
		itemCalendario.setIcon(new ImageIcon("calendar.png"));
		itemCalendario.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						calendario();
					}
				});
		
		popup = new JPopupMenu();
		popup.add(refresh);
		popup.add(itemCalendario);
		popup.add(itemAboutThis);
		
		
		itemAboutThis.setIcon(new ImageIcon("popupAbout.png"));
		itemAboutThis.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null,
								"Tela Principal: Após fazer login com sucesso, você é redirecionado para a tela principal do programa. Aqui, você encontrará vários componentes e recursos divertidos.\n" +
								"Barra de Menu: A barra de menu no topo da tela principal contém diferentes opções. Essas opções incluem \"File\", \"Visualizacoes\", \"Extra\" e \"Help\".\n" +
								"No menu \"File\", você encontra a opção \"Ler do Ficheiro\", que permite ler os dados de um arquivo específico. Além disso, também existe a opção \"Sair do Programa\", que permite encerrar o programa completamente.\n" +
								"No menu \"Extra\", além das opções mencionadas anteriormente (Calculadora, Jogos, Paint e Temas), há também a opção \"Escutar Música\", que permite reproduzir músicas dentro do programa.\n" +
								"No menu \"Help\", você encontrará informações sobre os programadores, informações da Luxcorpus e a opção de fazer uma doação.\n" +
								"Na opção do programador pode dar dois clicks para abrir o perfil do Programador\n"+
								"No menu \"Visualizacoes\", você encontrará opções para visualizar informações dos sócios, como dados, estatísticas ou detalhes relacionados aos membros.\n" +
								"Botões na Tela Principal: Na tela principal, existem quatro botões principais:\n" +
								"\"Adicionar Novo Sócio\": Esse botão permite adicionar um novo membro ou participante ao programa ou sistema.\n" +
								"\"Remover Sócio\": Esse botão permite remover um membro ou participante do programa ou sistema.\n" +
								"\"Alterar Hora\": Esse botão permite realizar uma alteração na hora de reserva.\n" +
								"\"Fazer Sign Out\": Esse botão permite fazer logout do programa, encerrando a sessão atual.",
								"Funcionamento do Programa",
								JOptionPane.INFORMATION_MESSAGE);
					}
				});
		
		relogio();
		originalMode();//para comecar com o tema default...
		addMouseListener(this);
		setSize(1100,600);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//tratamento do popup menu...
	public void processMouseEvent(MouseEvent e) {
		if(e.isPopupTrigger())
			popup.show(this, e.getX(), e.getY());
		else
			super.processMouseEvent(e);
	}
	
	//tema default...
	public void originalMode() {
		panel.setBackground(new Color(179,163,116));
		panel2.setBackground(new Color(179,163,116));
		labelLogo.setIcon(logo);
		cor2 = new Color(179,163,116);
		bar.setBackground(new Color(0, 150, 150));
		contain.setBackground(new Color(225,220,187,255));
		buttonNovo.setBackground(new Color(179,163,116));
		buttonSair.setBackground(new Color(179,163,116));
		buttonRemover.setBackground(new Color(179,163,116));
		buttonAlterar.setBackground(new Color(179,163,116));
		labelData.setForeground(Color.PINK);
		labelHora.setForeground(Color.PINK);
		labelDiaSemana.setForeground(Color.PINK);
		
	}
	//tema claro...
	public void lightMode() {
		bar.setBackground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel2.setBackground(Color.WHITE);
		labelLogo.setIcon(null);//faz set o icon a null para tirar a imagem anterior e aparecer LUXCORPUS...
		labelLogo.setText("    LUXCORPUS");
		labelLogo.setFont(new Font("Times New Roman", Font.BOLD|Font.PLAIN, 28));
		contain.setBackground(new Color(230,230,230));
		cor2 = Color.WHITE;
		
		labelData.setForeground(Color.black);
		labelHora.setForeground(Color.black);
		labelDiaSemana.setForeground(Color.black);
		
		buttonNovo.setBackground(Color.WHITE);
		buttonSair.setBackground(Color.WHITE);
		buttonAlterar.setBackground(Color.WHITE);
		buttonRemover.setBackground(Color.WHITE);
		
		buttonNovo.setForeground(Color.BLACK);
		buttonSair.setForeground(Color.BLACK);
		buttonAlterar.setForeground(Color.BLACK);
		buttonRemover.setForeground(Color.BLACK);
	}
	//tema escuro....
	public void darkMode() {
		bar.setBackground(Color.BLACK);
		panel.setBackground(Color.black);
		panel2.setBackground(Color.black);
		cor2 = Color.GRAY;
		buttonNovo.setBackground(Color.GRAY);
		buttonSair.setBackground(Color.GRAY);
		buttonRemover.setBackground(Color.GRAY);
		buttonAlterar.setBackground(Color.GRAY);
		labelLogo.setIcon(logoBack);
		
		labelData.setForeground(Color.white);
		labelHora.setForeground(Color.white);
		labelDiaSemana.setForeground(Color.white);
		contain.setBackground(new Color(30, 30, 30));
	}
	
	//depois de ler coloca os botoes ativos...
	public void colocarEnabled()
	{
		menuVisualizacao.setEnabled(true);
		itemEscrever.setEnabled(true);
		itemLerObj.setEnabled(true);
		
		buttonNovo.setEnabled(true);
		buttonAlterar.setEnabled(true);
		buttonRemover.setEnabled(true);
		refresh.setEnabled(true);
		
		menuVisualizacao.setToolTipText("");
		itemEscrever.setToolTipText("");
		
		buttonNovo.setToolTipText("");
		buttonAlterar.setToolTipText("");
		buttonRemover.setToolTipText("");
		refresh.setToolTipText("");
	}

	//quando o paint é chamado, ira aparece na tela menu ao lado, por isso esta nessa classe...
	public void paint()
	{
		if(ps)//ao dar o primeiro click no item paint ira abrir o paint...
		{
			cor = Color.BLACK;
			tamanho = 1f;
			
			panelPintar = new JPanel() {
				protected void paintComponent(Graphics g)
				{
					super.paintComponent(g);
					
					Graphics2D d = (Graphics2D) g;
					
					d.setColor(cor);
					d.setStroke(new BasicStroke(tamanho));
					d.drawLine(xValue, yValue, getX(), getY());
				}
			};
			
			panelPintar.addMouseListener(
					new MouseAdapter() {
						public void mousePressed(MouseEvent e)
						{
							xValue = e.getX();
							yValue = e.getY();
						}
					});
			
			panelPintar.addMouseMotionListener(
					new MouseMotionAdapter() {
						public void mouseDragged(MouseEvent e) {
							Graphics g = panelPintar.getGraphics();
							Graphics g2 = (Graphics2D) g;
							g2.setColor(cor);
							((Graphics2D) g2).setStroke(new BasicStroke(tamanho));
							g2.drawLine(xValue, yValue, e.getX(), e.getY());
							
							xValue = e.getX();
							yValue = e.getY();
						}
					});
			
			buttonCor = new JButton("Escolher Cor");
			buttonCor.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Color corSel = JColorChooser.showDialog(Tela_Menu.this, "Escolher Cor", cor);
							if(corSel != null)
							{
								cor = corSel;
							}
						}
					});
			
			label = new JLabel("Espessura: ");
			slider = new JSlider(JSlider.HORIZONTAL, 1, 50, 1); //O primeiro 1 indica o minimo do slider, o 50 indica o maximo e o ultimo 1 indica onde começa o slider...
			slider.setPaintTicks(true);
			slider.setMajorTickSpacing(1);
			slider.setSnapToTicks(true);
			slider.addChangeListener(
					new ChangeListener() {
						public void stateChanged(ChangeEvent e) {
							tamanho = slider.getValue();
						}
					});
			
			buttonLimpar = new JButton("Limpar Tudo");
			buttonLimpar.addActionListener(
					new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Graphics g = panelPintar.getGraphics();
							g.setColor(panelPintar.getBackground());
							g.fillRect(0, 0, panelPintar.getWidth(), panelPintar.getHeight());
						}
					});
			
			panelButton = new JPanel();
			panelButton.add(buttonCor);
			panelButton.add(label);
			panelButton.add(slider);
			panelButton.add(buttonLimpar);

			panelAux = new JPanel();
			panelAux.setLayout(new BorderLayout());
			panelAux.add(panelPintar, BorderLayout.CENTER);
			panelAux.add(panelButton, BorderLayout.SOUTH);
			panelAux.setBounds(293, 5, 785, 521);
			contain.add(panelAux);
			
			contain.revalidate();//atualiza o container...
			contain.repaint();//para redesenha corretamente com as alterações feitas
		}
		else //ño segundo click o estado da variavel `ps´ mudou para false entao fecha o paint...
		{
		    contain.remove(panelAux);//para remover o panel que pinta...
		    contain.revalidate();//atualiza o container...
		    contain.repaint();//para redesenha corretamente com as alterações feitas
		}
		ps = !ps;//muda o estado da variavel
	}
	
	public void audioPlayer() {
		try
		{
			FileChooser f = new FileChooser("Audio","wav");
			File file = f.openFileChooser();
			
			if(file != null)
			{
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
				clip = AudioSystem.getClip();
				clip.open(audioStream);
				clip.start();
				
				contain.add(labelAudio);
				labelAudio.setIcon(iiAudioPause);
				
				itemReset.setEnabled(true);
				itemQuit.setEnabled(true);
			}
		}
		catch(UnsupportedAudioFileException u) {JOptionPane.showMessageDialog(null, "O arquivo fornecido não é suportado :(\n "
				+ "Verifique se o formato do arquivo está correto e tente novamente","Audio Unsupported",JOptionPane.ERROR_MESSAGE);}
		catch(LineUnavailableException l) {JOptionPane.showMessageDialog(null, "A linha de áudio necessária não está disponível no momento.\n"
				+ " Verifique se não há outras aplicações utilizando a linha de áudio e tente novamente","Erro na saida do Audio",JOptionPane.ERROR_MESSAGE);}
		catch(IOException i) {JOptionPane.showMessageDialog(null, i.getMessage(),"Error!!!",JOptionPane.ERROR_MESSAGE);}
	}
	
	public void calendario()
	{
		if(passouCale)
		{
			JCalendar calendar = new JCalendar();
			panelCalendario.setBounds(434, 45, 240, 160);
			panelCalendario.add(calendar);
			contain.add(panelCalendario);
		}
		else
		{
			contain.remove(panelCalendario);
		}
		revalidate();
		repaint();
		passouCale = !passouCale;
	}
	
	public void relogio() {
		//Array com os meses, por que ao fazer o get do mes retorna o numero que representa o mes...
		String [] semana = {"Sabado", "Domingo", "Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira"};
		
		//essa thread para executar o programa e essa parte da hora em threads separadas sem interroper um ao outro...
	    Thread threadRelogio = new Thread(() -> {
	        while (true) {
	            Calendar cal = Calendar.getInstance();//Pega a data e hora atual

	            dia = cal.get(Calendar.DAY_OF_MONTH);
	            mes = cal.get(Calendar.MONTH);
	            ano = cal.get(Calendar.YEAR);
	            diaSemana = cal.get(Calendar.DAY_OF_WEEK);

	            //Formatação da hora 24h....
	            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	            Date hora = cal.getTime();
	            String time = sdf.format(hora);
	            
	            labelHora.setText(time);
	            labelData.setText( dia+"/"+mes+"/"+ano);
	            labelDiaSemana.setText("Dia da Semana: "+semana[diaSemana]);
	            
	            try
	            {
	                Thread.sleep(1000); // Aguarda 1 segundo antes de atualizar novamente...A cada 1000 milisegundo atualiza...
	            } catch (InterruptedException e) {JOptionPane.showMessageDialog(null, e.getMessage());}
	        }
	    });
	    threadRelogio.start();
	}

	public void mouseClicked(MouseEvent e) {}

	public void mouseDragged(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
}