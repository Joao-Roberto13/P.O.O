//Keny Muchanga| Michelle Boane| Joao Roberto... 

package Trabalho_Pratico_2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Executavel extends JFrame {
	
	private JLabel  label, label2, label3, labelRun;
	private Container contain;
	private JProgressBar progressBar;
	private int cont = 0; //contador para a barra de progresso...
	
	public static void main(String[] args) {
		new Executavel();
	}

	public Executavel() {
		contain = getContentPane();
		contain.setLayout(null);// Definindo o layout como null (AbsoluteLayout)
		
		label2 = new JLabel("LuxCorpus");
		label2.setForeground(Color.black);
		label2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 65));
		label2.setBounds(70, 64, 350, 60);
		contain.add(label2);

		ImageIcon ii = new ImageIcon("Infinity.gif");
		
		label = new JLabel();
		label.setIcon(ii);
		label.setBounds(170, 123, 192, 101);//x, y, w and h
		contain.add(label);
		
		progressBar = new JProgressBar();
		contain.add(progressBar);

		//progressBar.setStringPainted(true); //O numero que fica dentro da barra de progresso nao fica pintada...
		progressBar.setBackground(Color.GRAY);//A cor do fundo da barra fica cizenta...
		progressBar.setBounds(28, 387, 386, 37);//Uma vez que nao usou-se layout, iremos usar o setBounds para definirmos onde deve estar exatamente a barra...
		progressBar.setForeground(new Color(220, 70, 100));// A cor da barra que enche...
		
		label3 = new JLabel("0%");
		label3.setFont(new Font("Times New Roman", Font.BOLD, 34));
		label3.setBounds(184, 330, 113, 47);
		contain.add(label3);
		
		fillProgressBar(); //metodo que preenche a barra...
		
		contain.setBackground(new Color(179, 142, 98));
		
		 labelRun = new JLabel();
		ImageIcon iii = new ImageIcon("loadingGif.gif");
		labelRun.setIcon(iii);
		labelRun.setBounds(38, 434, 88, 75);
		
		getContentPane().add(labelRun);
		
		setUndecorated(true);
		setVisible(true);
		setSize(449, 511);
		setLocationRelativeTo(null);
	}
	
	private void fillProgressBar() {
		Timer t = new Timer(50,
			new ActionListener() { //50 é o intervalo que será executado o listener...a cada 50 milissegundos
			public void actionPerformed(ActionEvent e) {
				if (cont <= 180) {//a barra de progresso vai ate 100 mais o 180 é para continuar a execução, mesmo chegar no 100 fica a executar 80 para dar impremsão de estar a carregar dados
					progressBar.setValue(cont);
					if(cont<=100)//So vai mudar a label ate 100 depois disso vai parar...
						label3.setText(cont+"%");
					cont++;
				} 
				else 
				{
					//O metodo getSource retorna o objecto que acionou o evento, o objecto é timer daí faz se o cast e para o temporizador...
					((Timer) e.getSource()).stop();
					new Login();
					dispose();
				}
			}
		});
		t.start();
	}
}