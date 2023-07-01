package Trabalho_Pratico_2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Calculadora extends JFrame {

	private float num1, num2, resultado;
	
	private JPanel panel, radioPanel;
	private String operador;
	private JTextField textField;
	private JTextField textField_1;
	private JRadioButton radioOn, radioOff;
	private ButtonGroup radioGroup;
	private JButton buttonB, buttonC, button0,button1, button2, button3,
	button4, button5, button6, button7, button8, button9, buttonDividir, buttonMultiplicacao, buttonMenos,
	buttonMais, buttonPonto, buttonIgual, button00;
	
	private DecimalFormat df;
	private Container contain;
	
	public Calculadora() {
		super("Calculadora");
		contain = getContentPane();
		contain.setLayout(null);
		contain.setBackground(Color.DARK_GRAY);
		
		ImageIcon ii = new ImageIcon("iconCalculator.png");
		setIconImage(ii.getImage());
		
		
		df = new DecimalFormat("### ### ###.0");
		
		textField_1 = new JTextField(10);
		
		textField_1.setForeground(Color.WHITE);
		textField_1.setBackground(Color.DARK_GRAY);
		textField_1.setBounds(10, 11, 319, 38);
		textField_1.setEditable(false);
		textField_1.setBorder(null);
		contain.add(textField_1);
		
		textField = new JTextField("0",10);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 30));
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.DARK_GRAY);
		textField.setEditable(false);
		textField.setBounds(10, 49, 319, 59);
		textField.setBorder(null);
		contain.add(textField);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(10, 118, 319, 310);
		contain.add(panel);
		panel.setLayout(new GridLayout(5, 4, 0, 0));
		
		
		buttonB = new JButton("\uF0E7");//Codido Unicode de uma seta a apontar a esqueda....
		buttonB.setForeground(new Color(52, 211, 52));
		buttonB.setBackground(Color.DARK_GRAY);
		buttonB.setFocusable(false);
		buttonB.setFont(new Font("wingdings", Font.BOLD, 34));//È necessario a fonte wingdings por que a fonte contém muitos simbolos especiais...
		buttonB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()>0)
				{
					//Ao contrário das strings normais que nao sao modificadas após a criação,
					//StringBuilder permite fazer modificações  em uma string.
					StringBuilder x = new StringBuilder(textField.getText());
					x.deleteCharAt(textField.getText().length()-1);//Obtem-se o resultado da string editada chamando o toString()...
					textField.setText(x.toString());
				}
			}
		});
		
		radioPanel = new JPanel();
		radioPanel.setBackground(new Color(255, 255, 255));
		radioPanel.setLayout(new GridLayout(2, 0, 0, 0));
		panel.add(radioPanel);
		
		radioOn = new JRadioButton("On",true);
		radioOn.setForeground(Color.WHITE);
		radioOn.setBackground(Color.DARK_GRAY);
		radioOn.setFocusable(false);
		radioOn.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textField.setText("0");
						
						button00.setEnabled(true);
						button0.setEnabled(true);
						buttonPonto.setEnabled(true);
						buttonIgual.setEnabled(true);
						button1.setEnabled(true);
						button2.setEnabled(true);
						button3.setEnabled(true);
						buttonMais.setEnabled(true);
						button4.setEnabled(true);
						button5.setEnabled(true);
						button6.setEnabled(true);
						buttonMenos.setEnabled(true);
						button7.setEnabled(true);
						button8.setEnabled(true);
						button9.setEnabled(true);
						buttonMultiplicacao.setEnabled(true);
						buttonB.setEnabled(true);
						buttonC.setEnabled(true);
						buttonDividir.setEnabled(true);
					}
				});
		radioPanel.add(radioOn);
		
		radioOff = new JRadioButton("Off",false);
		radioOff.setForeground(Color.WHITE);
		radioOff.setBackground(Color.DARK_GRAY);
		radioOff.setFocusable(false);
		radioOff.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						textField.setText("               CASIO");
						textField_1.setText("Version 1.0.0");
						
						button00.setEnabled(false);
						button0.setEnabled(false);
						buttonPonto.setEnabled(false);
						buttonIgual.setEnabled(false);
						button1.setEnabled(false);
						button2.setEnabled(false);
						button3.setEnabled(false);
						buttonMais.setEnabled(false);
						button4.setEnabled(false);
						button5.setEnabled(false);
						button6.setEnabled(false);
						buttonMenos.setEnabled(false);
						button7.setEnabled(false);
						button8.setEnabled(false);
						button9.setEnabled(false);
						buttonMultiplicacao.setEnabled(false);
						buttonB.setEnabled(false);
						buttonC.setEnabled(false);
						buttonDividir.setEnabled(false);
					}
				});
		radioPanel.add(radioOff);
		panel.add(buttonB);
		
		radioGroup = new ButtonGroup();
		radioGroup.add(radioOn);
		radioGroup.add(radioOff);
		
		buttonC = new JButton("C");
		buttonC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		buttonC.setForeground(new Color(52, 211, 52));
		buttonC.setBackground(Color.DARK_GRAY);
		buttonC.setFocusable(false);
		buttonC.setFont(new Font("Times New Roman", Font.BOLD, 34));
		panel.add(buttonC);
		
		buttonDividir = new JButton("/");
		buttonDividir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Float.parseFloat(textField.getText());
				textField_1.setText(textField_1.getText()+textField.getText()+"/");
				textField.setText("");
				operador = "/";
			}
		});
		buttonDividir.setForeground(new Color(52, 211, 52));
		buttonDividir.setFocusable(false);
		buttonDividir.setBackground(Color.DARK_GRAY);
		buttonDividir.setFont(new Font("Times New Roman", Font.BOLD, 34));
		panel.add(buttonDividir);
		
		button7 = new JButton("7");
		button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText()+button7.getText();
				textField.setText(num);
			}
		});
		button7.setForeground(Color.black);
		button7.setFocusable(false);
		button7.setBackground(Color.DARK_GRAY);
		button7.setFont(new Font("Times New Roman", Font.BOLD, 34));
		panel.add(button7);
		
		button8 = new JButton("8");
		button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText()+button8.getText();
				textField.setText(num);
			}
		});
		button8.setFocusable(false);
		button8.setForeground(Color.black);
		button8.setBackground(Color.DARK_GRAY);
		button8.setFont(new Font("Times New Roman", Font.BOLD, 34));
		panel.add(button8);
		
		button9 = new JButton("9");
		button9.setFocusable(false);
		button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText()+button9.getText();
				textField.setText(num);
			}
		});
		button9.setForeground(Color.black);
		button9.setBackground(Color.DARK_GRAY);
		button9.setFont(new Font("Times New Roman", Font.BOLD, 34));
		panel.add(button9);
		
		buttonMultiplicacao = new JButton("*");
		buttonMultiplicacao.setFocusable(false);
		buttonMultiplicacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Float.parseFloat(textField.getText());
				textField_1.setText(textField_1.getText()+textField.getText()+"*");
				textField.setText("");
				operador = "*";
			}
		});
		buttonMultiplicacao.setForeground(new Color(52, 211, 52));
		buttonMultiplicacao.setBackground(Color.DARK_GRAY);
		buttonMultiplicacao.setFont(new Font("Times New Roman", Font.BOLD, 34));
		panel.add(buttonMultiplicacao);
		
		button4 = new JButton("4");
		button4.setFocusable(false);
		button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText()+button4.getText();
				textField.setText(num);
			}
		});
		button4.setBackground(Color.DARK_GRAY);
		button4.setForeground(Color.black);
		button4.setFont(new Font("Times New Roman", Font.BOLD, 34));
		panel.add(button4);
		
		button5 = new JButton("5");
		button5.setFocusable(false);
		button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText()+button5.getText();
				textField.setText(num);
			}
		});
		button5.setForeground(Color.black);
		button5.setBackground(Color.DARK_GRAY);
		button5.setFont(new Font("Times New Roman", Font.BOLD, 34));
		panel.add(button5);
		
		button6 = new JButton("6");
		button6.setFocusable(false);
		button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText()+button6.getText();
				textField.setText(num);
			}
		});
		button6.setForeground(Color.black);
		button6.setBackground(Color.DARK_GRAY);
		button6.setFont(new Font("Times New Roman", Font.BOLD, 34));
		panel.add(button6);
		
		buttonMenos = new JButton("-");
		buttonMenos.setFocusable(false);
		buttonMenos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Float.parseFloat(textField.getText());
				textField_1.setText(textField_1.getText()+textField.getText()+"-");
				textField.setText("");
				operador = "-";
			}
		});
		buttonMenos.setForeground(new Color(52, 211, 52));
		buttonMenos.setBackground(Color.DARK_GRAY);
		buttonMenos.setFont(new Font("Times New Roman", Font.BOLD, 34));
		panel.add(buttonMenos);
		
		button1 = new JButton("1");
		button1.setFocusable(false);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText()+button1.getText();
				textField.setText(num);
			}
		});
		button1.setBackground(Color.DARK_GRAY);
		button1.setForeground(Color.black);
		button1.setFont(new Font("Times New Roman", Font.BOLD, 34));
		panel.add(button1);
		
		button2 = new JButton("2");
		button2.setFocusable(false);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText()+button2.getText();
				textField.setText(num);
			}
		});
		button2.setForeground(Color.black);
		button2.setBackground(Color.DARK_GRAY);
		button2.setFont(new Font("Times New Roman", Font.BOLD, 34));
		panel.add(button2);
		
		button3 = new JButton("3");
		button3.setFocusable(false);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText()+button3.getText();
				textField.setText(num);
			}
		});
		button3.setForeground(Color.black);
		button3.setBackground(Color.DARK_GRAY);
		button3.setFont(new Font("Times New Roman", Font.BOLD, 34));
		panel.add(button3);
		
		buttonMais = new JButton("+");
		buttonMais.setFocusable(false);
		buttonMais.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				num1 = Float.parseFloat(textField.getText());
				textField_1.setText(textField_1.getText()+textField.getText()+"+");
				textField.setText("");
				operador = "+";
			}
		});
		buttonMais.setForeground(new Color(52, 211, 52));
		buttonMais.setBackground(Color.DARK_GRAY);
		buttonMais.setFont(new Font("Times New Roman", Font.BOLD, 34));
		panel.add(buttonMais);
		
		button0 = new JButton("0");
		button0.setFocusable(false);
		button0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField.getText()+button0.getText();
				textField.setText(num);
			}
		});
		
		button00 = new JButton("00");
		button00.setForeground(Color.black);
		button00.setFont(new Font("Times New Roman", Font.BOLD, 34));
		button00.setFocusable(false);
		button00.setBackground(Color.DARK_GRAY);
		panel.add(button00);
		
		button0.setForeground(Color.black);
		button0.setBackground(Color.DARK_GRAY);
		button0.setFont(new Font("Times New Roman", Font.BOLD, 34));
		panel.add(button0);
		
		buttonPonto = new JButton(".");
		buttonPonto.setFocusable(false);
		buttonPonto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText(textField_1.getText()+textField.getText()+".");
				num1 = Float.parseFloat(textField.getText());
				textField.setText("");
				operador = ".";
			}
		});
		buttonPonto.setForeground(Color.black);
		buttonPonto.setBackground(Color.DARK_GRAY);
		buttonPonto.setFont(new Font("Times New Roman", Font.BOLD, 34));
		panel.add(buttonPonto);
		
		buttonIgual = new JButton("=");
		buttonIgual.setFocusable(false);
		buttonIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField.getText().equals("0"))
					textField_1.setText(textField_1.getText()+textField.getText()+"=");
				num2 = Float.parseFloat(textField.getText());
				
				if(operador=="+")
				{
					resultado = num1+num2;
					textField.setText(df.format(resultado));
				}
				else
				{
					if(operador=="-")
					{
						resultado = num1-num2;
						textField.setText(df.format(resultado));
					}
					else
					{
						if(operador=="*")
						{
							resultado = num1*num2;
							textField.setText(df.format(resultado));
						}
						else
						{
							if(operador=="/")
							{
								resultado = num1/num2;
								textField.setText(df.format(resultado));
							}
							else
							{
								if(operador=="%")
								{
									resultado = num1%num2;
									textField.setText(df.format(resultado));
								}
							}
						}
					}
				}
			}
		});
		buttonIgual.setForeground(new Color(52, 211, 52));
		buttonIgual.setBackground(Color.PINK);
		buttonIgual.setFont(new Font("Times New Roman", Font.BOLD, 34));
		panel.add(buttonIgual);
		
		setSize(360,490);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
