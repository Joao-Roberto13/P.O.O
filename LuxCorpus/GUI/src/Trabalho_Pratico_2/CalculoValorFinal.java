package Trabalho_Pratico_2;

public interface  CalculoValorFinal
{
	public static final  int GOLD = 15000;
	public static final int EXTRA_GOLD = 2000;
	public static final float DESCONTO_GOLD = 20/100f;
	
	public static final int SILVER = 9500;
	public static final int EXTRA_SILVER = 1000;
	public static final float DESCONTO_SILVER = 10/100f;
	
	public static final int PREMIUM = 7000;
	public static final int EXTRA_PREMIUM = 500;
	
	public static final int STANDARD = 3500;
	public static final int EXTRA_STANDARD = 150;
	public static final float TAXA = 5/100f;
	
	//Todas classes fazem o uso desse metodo...
	public abstract float getValorFinal();
}
