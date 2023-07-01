package Trabalho_Pratico_2;

import javax.swing.*;
import java.awt.*;

public class AlterarHora extends JFrame {

	private Container contain;
	private JTextField textField, textField_1;
	private JLabel labelCodigo, labelHora;
	private JButton buttonAlterar;
	
	public static void main(String[] args) {
		new AlterarHora();
	}

	public AlterarHora() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 191, 576, 63);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		Button button = new Button("New button");
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 10, 576, 171);
		getContentPane().add(panel_1);
		contain = getContentPane();
		//contain.setLayout(new );
		
		labelCodigo = new JLabel("Codigo do Socio");
		labelCodigo.setBounds(24, 42, 168, 37);
		labelCodigo.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contain.add(labelCodigo);
		
		textField = new JTextField();
		textField.setBounds(295, 42, 231, 37);
		contain.add(textField);
		textField.setColumns(10);
		
		labelHora = new JLabel("Hora a Alterar");
		labelHora.setFont(new Font("Times New Roman", Font.BOLD, 15));
		labelHora.setBounds(24, 115, 168, 28);
		contain.add(labelHora);
		
		textField_1 = new JTextField();
		textField_1.setBounds(295, 108, 231, 37);
		contain.add(textField_1);
		textField_1.setColumns(10);
		
		buttonAlterar = new JButton("Alterar");
		buttonAlterar.setFocusable(false);
		contain.add(buttonAlterar, BorderLayout.SOUTH);
		
		setSize(600,262);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
