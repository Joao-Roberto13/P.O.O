//Keny Muchanga| Michelle Boane| Joao Roberto... 
package Trabalho_Pratico_2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.io.*;
import java.util.*;

public class Login extends JFrame implements MouseListener, MouseMotionListener{

	private int x, y;
	private JPanel  panel;
	private JComboBox boxUser;
	private JPopupMenu popup;
	private JMenuItem refreshItem, mudarCor, item;
	private JButton buttonEntrar, buttonRegistrar;
	private JLabel labelUser, labelPassword, labelSair, labelIcon,labelUserRe,labelNovoUser,labelPasswordRe;
	private JPasswordField fieldPassword,fieldPasswordRe, fieldConfirmarPassword;
	private Container contain;
	
	private String nome, password, nomes[];
	private Vector vetor;
	private Password p;
	private JTextField fieldUserRe;
	private JLabel lblConfirmeOPassword;
	private boolean passou = true; //inicializz o passou a true
	
	public Login() {
		super("Login");
		vetor = new Vector();
		p = new Password();
		
		contain = getContentPane();
		contain.setLayout(null);// Definindo o layout como null (AbsoluteLayout)
		setIconImage(new ImageIcon("login.png").getImage());

		popup = new JPopupMenu();
		refreshItem = new JMenuItem("Refresh");
		refreshItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//Cria uma novo instancia do programa...
				//Ao criar esse novo processo a acumulo de processos entao...
				SwingUtilities.invokeLater(() -> { //para evitar criar varias instancia sem utilizacao é recomendado usar o swingUtilities...
		            dispose(); // Descarta a janela atual
		            new Login(); // Cria uma nova instância da janela de login
		        });
			}
		});	
		
		popup.add(refreshItem);
		
		mudarCor = new JMenuItem("Inverter Background");
		mudarCor.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						inverterCor();
					}
				});
		popup.add(mudarCor);
		
		item = new JMenuItem("Funcionamento");
		popup.add(item);
		item.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Tela de Login: Ao iniciar o programa, você é apresentado a uma tela de login. "
								+ "\nDo lado esquerdo, você tem a opção de se registrar, e do lado direito, pode fazer login. "
								+ "\nApós se registrar, é necessário atualizar clicando com o botão direito e selecionando \"Refresh\" e tem a opção \"inverter cores\".\n", "Funcionamento da Tela Login",JOptionPane.INFORMATION_MESSAGE);
					}
				});
		
		panel = new JPanel();
		panel.setBackground(new Color(94, 94, 94));
		panel.setBounds(0, -12, 417, 448);//ver bem o -12
		contain.add(panel);
		panel.setLayout(null);
		
		labelIcon = new JLabel("     LuxCorpus");
		labelIcon.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 35));
		labelIcon.setBounds(75, 52, 241, 45);
		panel.add(labelIcon);
		
		fieldUserRe = new JTextField();
		fieldUserRe.setBounds(54, 209, 316, 29);
		panel.add(fieldUserRe);
		fieldUserRe.setColumns(10);
		
		buttonRegistrar = new JButton("Sign In");
		buttonRegistrar.setBounds(75, 358, 267, 36);
		buttonRegistrar.setForeground(new Color(255, 255, 255));
		buttonRegistrar.setBackground(new Color(220, 70, 100));
		buttonRegistrar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						adicionarNovoUser();
						resetSignIn();
					}
				});
		
		buttonRegistrar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				buttonRegistrar.setBackground(new Color(241, 57, 83));
			}

			public void mouseExited(MouseEvent evt) {
				buttonRegistrar.setBackground(new Color(220, 70, 100));
			}
		});
		
		panel.add(buttonRegistrar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 126, 397, 2);
		panel.add(separator);
		
		labelUserRe = new JLabel("USERNAME");
		labelUserRe.setForeground(new Color(255, 255, 255));
		labelUserRe.setFont(new Font("Times New Roman", Font.BOLD, 12));
		labelUserRe.setBounds(54, 182, 194, 25);
		panel.add(labelUserRe);
		
		labelPasswordRe = new JLabel("Password");
		labelPasswordRe.setForeground(new Color(255, 255, 255));
		labelPasswordRe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		labelPasswordRe.setBounds(54, 241, 194, 25);
		panel.add(labelPasswordRe);
		
		labelNovoUser = new JLabel("Registrar novo user");
		labelNovoUser.setFont(new Font("Times New Roman", Font.BOLD, 15));
		labelNovoUser.setForeground(new Color(255, 255, 255));
		labelNovoUser.setBounds(141, 140, 162, 27);
		panel.add(labelNovoUser);
		
		lblConfirmeOPassword = new JLabel("Confirme o Password");
		lblConfirmeOPassword.setForeground(Color.WHITE);
		lblConfirmeOPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblConfirmeOPassword.setBounds(55, 297, 194, 25);
		panel.add(lblConfirmeOPassword);
		
		fieldPasswordRe = new JPasswordField();
		fieldPasswordRe.setBounds(54, 264, 316, 29);
		panel.add(fieldPasswordRe);
		
		fieldConfirmarPassword = new JPasswordField();
		fieldConfirmarPassword.setBounds(54, 316, 316, 29);
		panel.add(fieldConfirmarPassword);
		
		buttonEntrar = new JButton("Log In");
		buttonEntrar.setForeground(new Color(255, 255, 255));
		buttonEntrar.setBackground(new Color(220, 70, 100));
		buttonEntrar.setBounds(439, 311, 352, 43);
		buttonEntrar.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				buttonEntrar.setBackground(new Color(241, 57, 83));
			}

			public void mouseExited(MouseEvent evt) {
				buttonEntrar.setBackground(new Color(220, 70, 100));
			}
		});
		
		buttonEntrar.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int i = boxUser.getSelectedIndex();
						String pass = fieldPassword.getText();
						
						if(isPasswordCorrect(i,pass)) {
							new Tela_Menu();
							dispose();
						}
					}
				});
		contain.add(buttonEntrar);

		lerCredenciais();
		criarListaNome();
		
		boxUser = new JComboBox(nomes);
		boxUser.setFocusable(false);
		boxUser.setSelectedIndex(-1);
		boxUser.setMaximumRowCount(5);
		boxUser.setBounds(458, 113, 314, 40);
		contain.add(boxUser);
		
		labelUser = new JLabel("USERNAME");
		labelUser.setFont(new Font("Times New Roman", Font.BOLD, 12));
		labelUser.setBounds(458, 78, 194, 25);
		contain.add(labelUser);
		
		labelPassword = new JLabel("Password");
		labelPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		labelPassword.setBounds(458, 189, 194, 25);
		contain.add(labelPassword);
		
		fieldPassword = new JPasswordField();
		fieldPassword.setBounds(458, 214, 314, 40);
		contain.add(fieldPassword);
		
		labelSair = new JLabel("       X");
		labelSair.setBounds(745, 10, 70, 43);
		labelSair.setForeground(Color.GRAY);
		labelSair.setFont(new Font("Times New Roman", Font.BOLD, 20));
		contain.add(labelSair);
		labelSair.addMouseListener(
				new MouseAdapter()
				{
					public void mouseClicked(MouseEvent m)
					{
						System.exit(0);
					}
				});
		
		labelSair.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				labelSair.setForeground(new Color(241, 57, 83));
			}

			public void mouseExited(MouseEvent evt) {
				labelSair.setForeground(Color.GRAY);
			}
		});
		
		contain.setBackground(new Color(255, 255, 255));
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		setUndecorated(true);
		setVisible(true);
		setSize(815,421);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	
	public void inverterCor() {
		
		if(passou) //na primeira vez que o metodo for chamada muda de cor...
		{
			labelUser.setForeground(Color.white);
			labelPassword.setForeground(Color.white);
			
			labelNovoUser.setForeground(Color.black);
			labelUserRe.setForeground(Color.black);
			labelPasswordRe.setForeground(Color.BLACK);
			lblConfirmeOPassword.setForeground(Color.black);
			
			panel.setBackground(Color.white);
			contain.setBackground(new Color(94, 94, 94));
		}
		else //na segunda vez devolve par aas cores que ja tinham no inicio do program...
		{
			labelUser.setForeground(Color.black);
			labelPassword.setForeground(Color.black);
			
			labelNovoUser.setForeground(Color.WHITE);
			labelUserRe.setForeground(Color.WHITE);
			labelPasswordRe.setForeground(Color.WHITE);
			lblConfirmeOPassword.setForeground(Color.WHITE);
			
			panel.setBackground(new Color(94, 94, 94));
			contain.setBackground(Color.WHITE);
		}
		passou = !passou; //depois muda o resultado passou para o contrario...Se na primeira vez é true executa o if, na segunda é false logo executa o else assim sucessivamente...
	}
	
	public void criarListaNome()
	{
		nomes = new String[vetor.size()];
		
		for(int i = 0; i<vetor.size(); i++)
		{
			p = new Password();
			p = (Password) vetor.elementAt(i);
			
			nomes[i] = p.getNome()+"";
		}
	}
	
	public void resetLogIn() {
		boxUser.setSelectedIndex(-1);
		fieldPassword.setText("");
	}
	
	public void resetSignIn()
	{
		fieldUserRe.setText("");
		fieldPasswordRe.setText("");
		fieldConfirmarPassword.setText("");
	}
	
	
	public void processMouseEvent(MouseEvent e) {
		if(e.isPopupTrigger())
			popup.show(this, e.getX(), e.getY());
		else
			super.processMouseEvent(e);
	}
	
	//https://gist.github.com/k33ptoo/b2817b836665ce8207d706947516db98
	public void mousePressed(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	public void mouseDragged(MouseEvent e) {
		int xx = e.getXOnScreen();
		int yy = e.getYOnScreen();
		setLocation(xx-x, yy-y);
	}
	
	public void adicionarNovoUser()
	{
		String file = "DadosTPr-Pass_2.txt", nome, pass1, pass2, registro;
		
		nome = fieldUserRe.getText();
		pass1 = fieldPasswordRe.getText();
		pass2 = fieldConfirmarPassword.getText();
		
		if(nome.length()<6)
			JOptionPane.showMessageDialog(null, "Inválido!\nInsira o seu 1º e o 2º nome");
		else
			if(!pass1.equals(pass2))
				JOptionPane.showMessageDialog(null, "Password incorrecto :(\nCertifique-se de estar a inserir password iguais!");
			else
			{
				registro = nome+";"+pass2+";";
				try 
				{
					BufferedWriter x = new BufferedWriter(new FileWriter(file, true));
					x.write("\n"+registro);
					x.close();
				}
				catch (FileNotFoundException e) {JOptionPane.showMessageDialog(null, "Ficheiro "+file+" não encontrado :(");}
				catch (NumberFormatException f) {JOptionPane.showMessageDialog(null, f.getMessage());}
				catch (IOException i) {JOptionPane.showMessageDialog(null, i.getMessage());}
				JOptionPane.showMessageDialog(null, "User Adicionado com Sucesso :)\nFaça o Refresh de seguida poderá fazer o Login");
			}
	}
	
	public boolean isPasswordCorrect(int i, String pass)
	{
		if(i<0)
			JOptionPane.showMessageDialog(null, "Selecione o nome do Usuario"); //tratamento para ver se algo foi selecionado...
		else
		{
			p = (Password) vetor.elementAt(i);
			if(pass.isBlank() == true)
				JOptionPane.showMessageDialog(null, "Insira o Password"); //ve se foi escrito alguma coisa...
			else 
			{
				if(pass.length()<4)
					JOptionPane.showMessageDialog(null, "Password deve ter mais de 4 digitos"); 
				else
				{
					if(!p.getPassword().equals(pass))//por ser password não pode ser equalsIgnoreCase pois pass word pode conter caracteres maiusculos e minusculos e é importante a diferença...
						JOptionPane.showMessageDialog(null, "Password Incorreto :(");
					else
					{
						JOptionPane.showMessageDialog(null, "Credencias Corretas :)");
						return true;
					}
				}
			}
		}
		resetLogIn();//se um dos dados for errado, faz o reset e deve voltar a inserir os dados...
		return false;
	}
	
	public void lerCredenciais()
	{
		String umaLinha, file = "DadosTPr-Pass_2.txt";
		StringTokenizer umaCadeia;
		
		try 
		{
			BufferedReader x = new BufferedReader(new FileReader(file));
			umaLinha = x.readLine();
			
			for(int i = 0; umaLinha != null; i++)
			{
				umaCadeia = new StringTokenizer(umaLinha, ";");
				
				nome = umaCadeia.nextToken();
				password = umaCadeia.nextToken();
				
				p = new Password();
				p.setNome(nome);
				p.setPassword(password);
				vetor.add(p);
				
				umaLinha = x.readLine();
			}
			x.close();
		} 
		catch (FileNotFoundException e) {JOptionPane.showMessageDialog(null, "Ficheiro "+file+" não encontrado :(");}
		catch (NumberFormatException f) {JOptionPane.showMessageDialog(null, f.getMessage());}
		catch (IOException i) {JOptionPane.showMessageDialog(null, i.getMessage());}
	}
	
	public void mouseMoved(MouseEvent e) {}
	
	public void mouseClicked(MouseEvent e) {}
	
	public void mouseReleased(MouseEvent e) {}
	
	public void mouseEntered(MouseEvent e) {}
	
	public void mouseExited(MouseEvent e) {}
}