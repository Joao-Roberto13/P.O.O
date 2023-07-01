package Trabalho_Pratico_2;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ClickMichelleProfile extends JFrame {
	private JPanel panel, panel_1;
	private JLabel labelBackground, labelFoto, labelHabilidades, labelHabil1, labelNome, labelHabil2, labelGoal;
	private JTextArea textArea, textAreaGoal;
	private Container contain;
	private JTextArea textArea_1;
	
	public ClickMichelleProfile()
	{
		super("Profile");
		ImageIcon iiBackground = new ImageIcon("McBackground.png");
		ImageIcon iiJr = new ImageIcon("Michelle.png");
		setIconImage(new ImageIcon("luffyMini.png").getImage());

		contain = getContentPane();
		contain.setLayout(null); // Definindo o layout como null (AbsoluteLayout)...
		contain.setBackground(new Color(0,204,136));

		labelFoto = new JLabel();
		labelFoto.setBounds(124, 97, 150, 118);
		labelFoto.setIcon(iiJr);
		contain.add(labelFoto);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 6, 376, 145);
		contain.add(panel);

		labelBackground = new JLabel();
		labelBackground.setBounds(0, 0, 376, 145);
		labelBackground.setIcon(iiBackground);
		panel.add(labelBackground);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 155, 376, 349);
		panel_1.setBackground(new Color(255,230,234));

		contain.add(panel_1);
		panel_1.setLayout(null);

		labelNome = new JLabel("Michelle Boane");
		labelNome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelNome.setBounds(10, 70, 216, 23);
		panel_1.add(labelNome);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 134, 346, 2);
		panel_1.add(separator);

		textArea = new JTextArea();
		textArea.setFont(new Font("SansSerif", Font.ITALIC, 13));
		textArea.setText("Um programa de computador nunca pode fazer algo inesperado. É o programador que falhou em prever todas as possibilidades.");
		textArea.setBounds(10, 150, 346, 58);
		textArea.setBackground(new Color(255, 230, 234));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true); // Definir wrapStyleWord como true para que as palavras sejam quebradas corretamente...
		textArea.setEditable(false);
		panel_1.add(textArea);

		labelHabilidades = new JLabel("Habilidades");
		labelHabilidades.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelHabilidades.setBounds(11, 214, 138, 13);
		panel_1.add(labelHabilidades);

		labelHabil1 = new JLabel("> Front-End");
		labelHabil1.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		labelHabil1.setBounds(11, 232, 110, 13);
		panel_1.add(labelHabil1);

		labelHabil2 = new JLabel("> Back-End");
		labelHabil2.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		labelHabil2.setBounds(10, 252, 81, 13);
		panel_1.add(labelHabil2);

		labelGoal = new JLabel("Goal");
		labelGoal.setFont(new Font("Times New Roman", Font.BOLD, 15));
		labelGoal.setBounds(10, 280, 45, 13);
		panel_1.add(labelGoal);

		textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setEditable(false);
		textArea_1.setBackground(new Color(255,230,234));
		textArea_1.setFont(new Font("SansSerif", Font.ITALIC, 12));
		textArea_1.setText("Seguindo os passos de Ada Lovelace, programando com visão e inovação do front-end ao back-end.");
		textArea_1.setBounds(10, 93, 346, 65);
		panel_1.add(textArea_1);
		
		textAreaGoal = new JTextArea("Me aperfeiçoar na área de base de dados, criando soluções lógicas e cada vez mais eficazes para as demandas do dia a dia");
		textAreaGoal.setFont(new Font("SansSerif", Font.ITALIC, 12));
		textAreaGoal.setEditable(false);
		textAreaGoal.setLineWrap(true);
		textAreaGoal.setWrapStyleWord(true);
		textAreaGoal.setBounds(10, 292, 356, 47);
		textAreaGoal.setBackground(new Color(255,230,234));
		panel_1.add(textAreaGoal);

		addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent ev) 
					{
						new InfomacoesProgramadores();
					}
				});

		setVisible(true);
		setSize(388, 549);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
