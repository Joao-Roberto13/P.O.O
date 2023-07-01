package Trabalho_Pratico_2;
import java.io.*;
import java.time.LocalTime;
import java.time.format.*;
import javax.swing.JOptionPane;

public class Validacoes
{
	private BufferedReader x;
	
	public Validacoes()
	{
		x = new BufferedReader(new InputStreamReader(System.in));
	}
	
	public int validarInt(String msg, int a, int b)
	{
		int num = 0;
		try
		{
			num = Integer.parseInt(JOptionPane.showInputDialog("Introduza o codigo do Socio a remover: "));
		}
		catch(NumberFormatException n){JOptionPane.showMessageDialog(null, "ERRO: Dados fornecidos Invalido :(","Invalido",JOptionPane.ERROR_MESSAGE);}
		
		if(num<10000 || num>100000) {
			JOptionPane.showMessageDialog(null, "Tente Novamente\nCodigo deve estar entre 10000-100000","Invalido",JOptionPane.ERROR_MESSAGE);
			return 0;
		}
		return num;
	}
	
	//Método generalizado para validar strings....
		public String validarString(String var)
		{
			String num = "";

			//do
			//{
				try
				{
					num = var;
				}
				catch(NumberFormatException n){JOptionPane.showMessageDialog(null, "ERRO: Dados fornecidos Invalido :(");}
				
				if(num.length()<3)
					JOptionPane.showMessageDialog(null, "Invalido!!!\nTente Novamente");
			//}while(num.length()<3);
			return num;
		}
	
	//valida a hora...
	//Fonte: https://stackoverflow.com/questions/61159012/how-to-parse-time-in-any-format-with-localtime-parse
	public String validarHora(String hor)
	{
		String hora;
		int  h;
		
		do
		{
			hora = validarString(hor); 
			
			//Fonte: https://stackoverflow.com/questions/33293353/how-to-check-whether-a-license-plate-is-valid-or-not-without-using-arrays
			if(!hora.substring(0, 2).matches("\\d{2}")) //verifica se os primeiros 2 caraters nao sao numeros(Ex: 9:00 - os primeiros 2 caracters sao '9:')....
				hora = "0"+hora;//se nao for coloca '0' para ter o formato correto HH:MM(9:00 passa para 09:00)
				
			try 
			{
				LocalTime.parse(hora);//Converte a hora para o formato HH:MM, Fonte: https://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html
			} 
			catch (DateTimeParseException e) {
				System.out.println("\033[31m|------------------------------------------------------------------|");
				System.out.println("| Invalido Tente novamente:(                                       |");
				System.out.println("| Verifique se o intervalor e permitido para hora ou minuto        |");
				System.out.println("|------------------------------------------------------------------|\033[0m");
			}
			
			h = Integer.parseInt(hora.substring(0, 2));
			
			if(h<9 || h>15) //Vê se estao sepados por fois pontos...
				//v.erroHora();
				System.out.println();
		}while(h<9 || h>15);
		return hora; 
	}
}
