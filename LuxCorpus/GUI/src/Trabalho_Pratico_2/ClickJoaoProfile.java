package Trabalho_Pratico_2;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import org.jdesktop.swingx.JXLabel;

public class ClickJoaoProfile extends JFrame {
	private JPanel panel, panel_1;
	private JLabel labelBackground, labelFoto, labelHabilidades, labelHabil1, labelNome, labelSlogan, labelHabil2, labelGoal;
	private JTextArea textArea, textAreaGoal;
	private Container contain;

	public ClickJoaoProfile() {
		super("Profile");
		ImageIcon iiBackground = new ImageIcon("jrBackground.png");
		ImageIcon iiJr = new ImageIcon("Joao.png");
		setIconImage(new ImageIcon("luffyMini.png").getImage());
		
		contain = getContentPane();
		contain.setLayout(null);// Definindo o layout como null (AbsoluteLayout)
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
		panel_1.setBounds(0, 155, 376, 342);
		panel_1.setBackground(new Color(255,230,234));
		
		contain.add(panel_1);
		panel_1.setLayout(null);
		
		labelNome = new JLabel("João Roberto L. Inguane");
		labelNome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		labelNome.setBounds(10, 71, 216, 23);
		panel_1.add(labelNome);
		
		labelSlogan = new JLabel("No código e na quadra, sempre em busca da perfeição.");
		labelSlogan.setFont(new Font("Tahoma", Font.ITALIC, 13));
		labelSlogan.setBounds(10, 93, 320, 23);
		panel_1.add(labelSlogan);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 114, 320, 2);
		panel_1.add(separator);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("SansSerif", Font.ITALIC, 13));
		textArea.setText("Movido pela curiosidade, transformo ideias em realidade digital. Combinando criatividade e lógica, construo o futuro, linha por linha.");
		textArea.setBounds(10, 126, 346, 67);
		textArea.setBackground(new Color(255, 230, 234));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true); // Definir wrapStyleWord como true para que as palavras sejam quebradas corretamente...
		textArea.setEditable(false);
		panel_1.add(textArea);
		
		labelHabilidades = new JLabel("Habilidades");
		labelHabilidades.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelHabilidades.setBounds(11, 196, 138, 13);
		panel_1.add(labelHabilidades);
		
		labelHabil1 = new JLabel("> Front-End");
		labelHabil1.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		labelHabil1.setBounds(11, 214, 110, 13);
		panel_1.add(labelHabil1);
		
		labelHabil2 = new JLabel("> Back-End");
		labelHabil2.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		labelHabil2.setBounds(10, 234, 81, 13);
		panel_1.add(labelHabil2);
		
		labelGoal = new JLabel("Goal");
		labelGoal.setFont(new Font("Times New Roman", Font.BOLD, 15));
		labelGoal.setBounds(10, 257, 45, 13);
		panel_1.add(labelGoal);
		
		textAreaGoal = new JTextArea("Tornar-me um Full-Stack Developer, dominando tanto o Front-End, quanto o Back-End para criar soluções completas e versáteis.");
		textAreaGoal.setFont(new Font("SansSerif", Font.ITALIC, 13));
		textAreaGoal.setEditable(false);
		textAreaGoal.setLineWrap(true);
		textAreaGoal.setWrapStyleWord(true);
		textAreaGoal.setBounds(10, 280, 356, 62);
		textAreaGoal.setBackground(new Color(255,230,234));
		panel_1.add(textAreaGoal);
		
		addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent ev) {
						new InfomacoesProgramadores();
					}
				});
		
		setVisible(true);
		setSize(388, 541);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}