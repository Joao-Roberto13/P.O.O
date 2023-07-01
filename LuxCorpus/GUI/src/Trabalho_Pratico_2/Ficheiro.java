package Trabalho_Pratico_2;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
public class Ficheiro 
{

	public Ficheiro() {}

	//Esse método adiciona um novo socio ao ficheiro de texto normal...
	//Recebendo por parametro a String registro que os dados foram mandados de forma concatenada...
	public void adicionarNoFicheiro(String registro)
	{
		String file = "DadosTPr_2.txt";
		try
		{
			//Abrir o ficheiro para a escrita...
			//true nos possibilita adicionar novo socio no ficheiro de texto ja existente com dados, sem remove-los(Append Mode)...
			FileWriter fw = new FileWriter(file, true); 
			BufferedWriter  x = new BufferedWriter(fw);

			//Nova linha do ficheiro de texto e escreve o registro(que é o novo dado do socio)...
			x.write("\n"+registro);
			x.close();
			JOptionPane.showMessageDialog(null, "Registro adicionado com Sucesso:)","Dado adicionado!!!",JOptionPane.INFORMATION_MESSAGE);
		}
		catch(FileNotFoundException f) {System.out.println(f.getMessage());}
		catch(IOException i) {System.out.println(i.getMessage());}
	}
	
	public void lerFicheiroObjecto(Vector socio, File file) {
		//Esse método lê os dados do ficheiro de  objecto para o vector...
		try 
		{
			ObjectInputStream x = new ObjectInputStream(new FileInputStream(file));
			socio = (Vector) x.readObject();
			x.close();
			Tarefas.passou_2 = true;
		}
		catch (ClassNotFoundException c) {}/////ver bem a msg
		catch (FileNotFoundException e) {JOptionPane.showMessageDialog(null, "ERRO: Ficheiro de Objecto não encontrado :(","Ficheiro Objecto",JOptionPane.ERROR_MESSAGE);}
		catch (IOException e) {JOptionPane.showMessageDialog(null, "ERRO: Ao ler o ficheiro de Objectos","Ficheiro Objecto",JOptionPane.ERROR_MESSAGE);}
	}
}
