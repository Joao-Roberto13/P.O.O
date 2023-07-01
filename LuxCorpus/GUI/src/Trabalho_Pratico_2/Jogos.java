package Trabalho_Pratico_2;

import javax.swing.JOptionPane;

public class Jogos 
{
	public Jogos() {}

	public void guessNumber() {
		int z,a,op,num = 0;
		op = JOptionPane.showConfirmDialog(null, "Bem-Vindo ao The Guess Inator\n \n Segue as regras conforme ditas: \n Deseja Continuar?");

		if(op == JOptionPane.YES_OPTION)
		{
			JOptionPane.showMessageDialog(null, "Primeiro prepare uma calculadora\nO jogo tentará advinhar o numero que você pensou\n");
			JOptionPane.showMessageDialog(null, "Pense em um numero");
			JOptionPane.showMessageDialog(null, "Multiplica esse numero por 2 e adiciona 5");
			JOptionPane.showMessageDialog(null, "Multiplica o resultado por 5 e subtraia por 25");
			num = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o resultado aqui: "));

			z = ((num+25)/5)-5;
			a = z/2;
			JOptionPane.showMessageDialog(null, "O numero que você pensou foi "+a+" :)","",JOptionPane.QUESTION_MESSAGE);
		}
	}

	public void guessResultado() {
		int op = JOptionPane.showConfirmDialog(null, "Bem-Vindo ao The Guess Inator\n \n Segue as regras conforme ditas: \n Deseja Continuar?");

		if(op == JOptionPane.YES_OPTION)
		{
			JOptionPane.showMessageDialog(null, "Pense em um numero multiplica por 2 e adicione 6");
			JOptionPane.showMessageDialog(null, "Divida o resultado por 2 e subtraia pelo numero que você pensou.");
			JOptionPane.showMessageDialog(null, "O Resultado foi 3","Sim ou Nao", JOptionPane.QUESTION_MESSAGE);
		}
	}

	public void guessAge() {
		String txt;

		int op = JOptionPane.showConfirmDialog(null, "Bem-Vindo ao The Guess Inator\n \n Segue as regras conforme ditas: \n Deseja Continuar?");

		if(op == JOptionPane.YES_OPTION)
		{
			JOptionPane.showMessageDialog(null, "Escolhe um numero de 1 a 9");
			JOptionPane.showMessageDialog(null, "Multiplique o numero por 2 e adicione 5");
			JOptionPane.showMessageDialog(null, "Multiplique o resultado por 50");
			JOptionPane.showMessageDialog(null, "Caso ja tenha completado anos, adicione 1773\nCaso contrário adicione 1772 ");
			JOptionPane.showMessageDialog(null, "Subtraia o resultado pelo seu ano de nascimento");

			txt = JOptionPane.showInputDialog(null, "Introduza o resultado:");

			if(!(txt == null))//caso selecione cancelar ao introduzir valor retorna null, dai que vemos se e igual a null...
			{
				txt = txt.substring(1);
				JOptionPane.showMessageDialog(null, "Tem "+txt+" anos :)","",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
