package Trabalho_Pratico_1;
import java.io.*;
import java.util.*;
public class Ficheiro 
{
	public Ficheiro() {}
	
	//Esse método cria um ficheiro de obkecto e escreve os dados que estão no vector...
	public void escreverNoFicheiroObj(Vector vetor)
	{
		try 
		{
			ObjectOutputStream x = new ObjectOutputStream(new FileOutputStream("DadosTPr_1.dat"));
			
			x.writeObject(vetor);
			x.close();
		} 
		catch (FileNotFoundException e) {System.out.println(e.getMessage());}
		catch (IOException e) {System.out.println(e.getMessage());}
		System.out.println("|-------------------------------------------------|");
		System.out.println("|\033[32mFicheiro de Objecto escrito com Sucesso :)\033[0m       |");
		System.out.println("|-------------------------------------------------|");
	}
	
	//Esse método lê os dados do ficheiro de  objecto para o vector...
	public void lerDoFicheiroObj(Vector v)
	{
		try 
		{
			ObjectInputStream x = new ObjectInputStream(new FileInputStream("DadosTPr_1.dat"));
			
			v.addElement(x.readObject());
			x.close();
		}
		catch (ClassNotFoundException c) {System.out.println(c.getMessage());}
		catch (FileNotFoundException e) {System.out.println(e.getMessage());}
		catch (IOException e) {System.out.println(e.getMessage());}
		System.out.println("|-------------------------------------------------|");
		System.out.println("|     \033[32mFicheiro de Objecto lido com Sucesso :)   \033[0m  |");
		System.out.println("|-------------------------------------------------|");
	}
	
	//Esse método adiciona um novo socio ao ficheiro de texto normal...
	//Recebendo por parametro a String registro que os dados foram mandados de forma concatenada...
	public void adicionarNoFicheiro(String registro)
	{
		String file = "DadosTPr_1.txt";
		
		try
		{
			//Abrir o ficheiro para a escrita...
			//true nos possibilita adicionar novo socio no ficheiro de texto ja existente com dados, sem remove-los(Append Mode)...
			FileWriter fw = new FileWriter(file, true); 
			BufferedWriter  x = new BufferedWriter(fw);
			
			//Nova linha do ficheiro de texto e escreve o registro(que é o novo dado do socio)...
			x.write("\n"+registro);
			x.close();
			System.out.println("|------------------------------------------|");
			System.out.println("|     \033[32mRegistro adicionado com Sucesso:) \033[0m   |");
			System.out.println("|------------------------------------------|");
		}
		catch(FileNotFoundException f) {System.out.println(f.getMessage());}
		catch(IOException i) {System.out.println(i.getMessage());}
	}
}
