package Trabalho_Pratico_1;
import java.io.*;
import java.time.LocalTime;
import java.time.format.*;

public class Validacoes
{
	private BufferedReader x;
	private Visualizacoes v;
	
	public Validacoes()
	{
		x = new BufferedReader(new InputStreamReader(System.in));
		v = new Visualizacoes();
	}
	
	//método par avalidar inteiros...
	public int validarInt(String msg, int a, int b)
	{
		int val = 0;
		
		do
		{
			System.out.println(msg);
			
			try
			{
				val = Integer.parseInt(x.readLine());
			}
			catch(NumberFormatException n) {System.out.println(n.getMessage());}
			catch(IOException i) {System.out.println(i.getMessage());}
			if(val<a || val>b)
				v.erro();
		}while(val<a || val>b);
		
		return val;
	}
	
	//método para validar byte...
	public byte validarByte(String msg, byte a, byte b)
	{
		byte op = 0;
		
		do
		{
			System.out.println(msg);
			
			try
			{
				op = Byte.parseByte(x.readLine());
			}
			catch(NumberFormatException n) {n.getMessage();}
			catch(IOException i) {i.getMessage();}
			
			if(op<a || op>b)
				v.erro();
		}while(op<a || op>b);	
	   return op;
	}
	
	//Método generalizado para validar strings....
		public String validarString(String msg)
		{
			String num = "";

			do
			{
				System.out.println(msg);
				try
				{
					num = x.readLine();
				}
				catch(NumberFormatException n){System.out.println(n.getMessage());}
				catch(IOException i) {System.out.println(i.getMessage());}
				
				if(num.length()<3)
					v.erro();
			}while(num.length()<3);
			return num;
		}
	
	//valida a hora...
	//Fonte: https://stackoverflow.com/questions/61159012/how-to-parse-time-in-any-format-with-localtime-parse
	public String validarHora()
	{
		String hora;
		int  h;
		
		do
		{
			hora = validarString("Introduza a hora formato HH:MM (9:00 as 15:00): "); 
			
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
				v.erroHora();
		}while(h<9 || h>15);
		return hora; 
	}
	
	//Método para validar a data, formato DD/MM/YYYY....
	public String validarData(String msg)
	{
		String data;
		final int ANO = 2023;
		boolean passou = false;
		int cadeia1, cadeia2, cadeia3;//cadeia1 terá DD, cadeia2 terá MM e cadeia3 terá YYYY
		
		do
		{
			data = validarString(msg);		

			if (data.length() == 10) //vê se o tamanho da string é 10...
			{
			    //Se for obedece o formado logo pega os primeiros 2 carateres...
			    cadeia1 = Integer.parseInt(data.substring(0,2));;
			    
			    if (cadeia1 >= 1 && cadeia1 <= 31)  //vê se está de 1 a 31 por ser dia....                       
			    {
			        //Se for pega os proximos 2 carateres que é de mes...
			        cadeia2 = Integer.parseInt(data.substring(3,5));  
			        
			        if (cadeia2 >= 1 && cadeia2 <= 12) //vê se esta entre 1 a 12...                         
			        {
			            //se estiver pega a ultima cadeia de carateres...
			            cadeia3 = Integer.parseInt(data.substring(6));
			            
			            if (cadeia3 >= 2000 && cadeia3 <= ANO)//vê se estão entre 2000 e o ano presente que é 2023...
			            {
			               passou = true; //se todas as opções acima forem validadas corretamente o verifica fica a true...
			            }
			            
			            //Caso contrário dá print de erro e uso o codigo ANSI para colocar o texto a vermelho...
			            else
			            {
				        	System.out.println("\033[31m------------------------------------------");
			            	System.out.println(" Ano: `"+data.substring(6)+"´ Invalidos:( ");
			            	System.out.println(" Tente Novamente (Ano Presente "+ANO+") :)");
			            	System.out.println("------------------------------------------\033[0m");
			            }
			        } 
			        
			        else 
			        {
			        	System.out.println("\033[31m---------------------------------------");
		            	System.out.println(" Mes: `"+data.substring(3, 5)+"´ Invalidos :(");
		            	System.out.println(" Tente Novamente (1-12):)");
		            	System.out.println("---------------------------------------\033[0m");
			        }
			    } 
			    
			    else 
			    {
		        	System.out.println("\033[31m-------------------------------------------|");
	            	System.out.println(" Dia: `"+data.substring(0, 2)+"´ Invalidos:( ");
	            	System.out.println(" Tente Novamente (1-31) :)         ");
	            	System.out.println("-------------------------------------------\033[0m|");
			    	
			    }
			} 
			
			else
			{
				System.out.println("\033[31m-----------------------------");
	        	System.out.println(" Tamanho: "+data.length()+" Invalido :(");
	        	System.out.println(" Tente Novamente:)     ");
	        	System.out.println("-----------------------------\033[0m");
			}
		}while(passou == false);
		
		return data;
	}
	
	public String validarSexo(String msg)
	{
		String num = "";

		do
		{
			System.out.println(msg);
			try
			{
				num = x.readLine();
			}
			catch(NumberFormatException n){System.out.println(n.getMessage());}
			catch(IOException i) {System.out.println(i.getMessage());}
			if(!num.equalsIgnoreCase("Masculino") && !num.equalsIgnoreCase("Feminino"))
			   v.erro();
		}while(!num.equalsIgnoreCase("Masculino") && !num.equalsIgnoreCase("Feminino"));
			
		return num;
	}
	
	public String validarObjectivo(String msg)
	{
		String num = "";

		do
		{
			System.out.println(msg);
			try
			{
				num = x.readLine();
			}
			catch(NumberFormatException n){System.out.println(n.getMessage());}
			catch(IOException i) {System.out.println(i.getMessage());}
			
			if(!num.equalsIgnoreCase("Emagrecer") && !num.equalsIgnoreCase("Musculação") && !num.equalsIgnoreCase("Resistência") 
					&& !num.equalsIgnoreCase("Musculacao") && !num.equalsIgnoreCase("Resistencia"))
				v.erro();
		}while(!num.equalsIgnoreCase("Emagrecer") && !num.equalsIgnoreCase("Musculação") && !num.equalsIgnoreCase("Resistência") 
				&& !num.equalsIgnoreCase("Musculacao") && !num.equalsIgnoreCase("Resistencia"));
			
		return num;
	}
	
	public String validarTipoSocio(String msg)
	{
		String num = "";

		do
		{
			System.out.println(msg);
			try
			{
				num = x.readLine();
			}
			catch(NumberFormatException n){System.out.println(n.getMessage());}
			catch(IOException i) {System.out.println(i.getMessage());}
			if(!num.equalsIgnoreCase("Gold") && !num.equalsIgnoreCase("Silver") && !num.equalsIgnoreCase("Normal"))
				v.erro();
		}while(!num.equalsIgnoreCase("Gold") && !num.equalsIgnoreCase("Silver") && !num.equalsIgnoreCase("Normal"));
			
		return num;
	}

	public String validarNutricionista(String msg)
	{
		String num = "";

		do
		{
			System.out.println(msg);
			try
			{
				num = x.readLine();
			}
			catch(NumberFormatException n){System.out.println(n.getMessage());}
			catch(IOException i) {System.out.println(i.getMessage());}
			if(!num.equalsIgnoreCase("Sim") && !num.equalsIgnoreCase("Nao") && !num.equalsIgnoreCase("Não"))
				v.erro();
		}while(!num.equalsIgnoreCase("Sim") && !num.equalsIgnoreCase("Nao") && !num.equalsIgnoreCase("Não"));
			
		return num;
	}
	
	public String validarHidroginastica(String msg)
	{
		String num = "";

		do
		{
			System.out.println(msg);
			try
			{
				num = x.readLine();
			}
			catch(NumberFormatException n){System.out.println(n.getMessage());}
			catch(IOException i) {System.out.println(i.getMessage());}
			if(!num.equalsIgnoreCase("Guiada") && !num.equalsIgnoreCase("Livre"))
				v.erro();
		}while(!num.equalsIgnoreCase("Guiada") && !num.equalsIgnoreCase("Livre"));
			
		return num;
	}
	
	public String validarTipoPacote(String msg)
	{
		String num = "";

		do
		{
			System.out.println(msg);
			try
			{
				num = x.readLine();
			}
			catch(NumberFormatException n){System.out.println(n.getMessage());}
			catch(IOException i) {System.out.println(i.getMessage());}
			if(!num.equalsIgnoreCase("Casal") && !num.equalsIgnoreCase("Individual"))
				v.erro();
		}while(!num.equalsIgnoreCase("Casal") && !num.equalsIgnoreCase("Individual"));
			
		return num;
	}
	
	public String validarTipoNormal(String msg)
	{
		String num = "";

		do
		{
			System.out.println(msg);
			try
			{
				num = x.readLine();
			}
			catch(NumberFormatException n){System.out.println(n.getMessage());}
			catch(IOException i) {System.out.println(i.getMessage());}
			if(!num.equalsIgnoreCase("Premium") && !num.equalsIgnoreCase("Standard"))
				v.erro();
		}while(!num.equalsIgnoreCase("Premium") && !num.equalsIgnoreCase("Standard"));
			
		return num;
	}
	
}
