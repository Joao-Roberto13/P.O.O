package Trabalho_Pratico_2;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class ClickKenyProfile extends JFrame {
	private JPanel panel, panel_1;
	private JLabel labelBackground, labelFoto, labelHabilidades, labelHabil1, labelNome, labelHabil2, labelGoal;
	private JTextArea textArea, textAreaGoal;
	private Container contain;
	private JTextArea textArea_1;
	
	public ClickKenyProfile() {
		super("Profile");
		ImageIcon iiBackground = new ImageIcon("KMBackground.png");
		ImageIcon iiJr = new ImageIcon("Keny.png");
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
		panel_1.setBounds(0, 155, 376, 326);
		panel_1.setBackground(new Color(255,230,234));

		contain.add(panel_1);
		panel_1.setLayout(null);

		labelNome = new JLabel("Keny Muchanga");
		labelNome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelNome.setBounds(10, 71, 216, 23);
		panel_1.add(labelNome);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 134, 346, 2);
		panel_1.add(separator);
		
		textArea_1 = new JTextArea();
		textArea_1.setLineWrap(true);
		textArea_1.setWrapStyleWord(true);
		textArea_1.setEditable(false);
		textArea_1.setBackground(new Color(255,230,234));
		textArea_1.setText("Em cada jogo e em cada código, mostrando talento e dedicação.");
		textArea_1.setBounds(10, 93, 346, 40);
		panel_1.add(textArea_1);

		textArea = new JTextArea();
		textArea.setFont(new Font("SansSerif", Font.ITALIC, 13));
		textArea.setText("A Arte da Programação de Computadores, meu Caminho para se Tornar um Programador Profissional");
		textArea.setBounds(10, 146, 346, 38);
		textArea.setBackground(new Color(255, 230, 234));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);//Definir wrapStyleWord como true para que as palavras sejam quebradas corretamente...
		textArea.setEditable(false);
		panel_1.add(textArea);

		labelHabilidades = new JLabel("Habilidades");
		labelHabilidades.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelHabilidades.setBounds(11, 194, 138, 13);
		panel_1.add(labelHabilidades);

		labelHabil1 = new JLabel("> Front-End");
		labelHabil1.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		labelHabil1.setBounds(11, 212, 110, 13);
		panel_1.add(labelHabil1);

		labelHabil2 = new JLabel("> Back-End");
		labelHabil2.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		labelHabil2.setBounds(10, 232, 81, 13);
		panel_1.add(labelHabil2);

		labelGoal = new JLabel("Goal");
		labelGoal.setFont(new Font("Times New Roman", Font.BOLD, 15));
		labelGoal.setBounds(10, 260, 45, 13);
		panel_1.add(labelGoal);

		textAreaGoal = new JTextArea("Aprender e dominar novas linguagens de programação. Escrever código mais eficiente, limpo e de alta qualidade.");
		textAreaGoal.setFont(new Font("SansSerif", Font.ITALIC, 13));
		textAreaGoal.setEditable(false);
		textAreaGoal.setLineWrap(true);
		textAreaGoal.setWrapStyleWord(true);
		textAreaGoal.setBounds(10, 272, 356, 47);
		textAreaGoal.setBackground(new Color(255,230,234));
		panel_1.add(textAreaGoal);
		
		addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent ev) {
						new InfomacoesProgramadores();
					}
				});

		setVisible(true);
		setSize(388, 523);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
