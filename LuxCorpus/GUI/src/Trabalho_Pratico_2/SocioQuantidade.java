package Trabalho_Pratico_2;
import java.awt.*;
import javax.swing.*;

import Trabalho_Pratico_2.Gold;
import Trabalho_Pratico_2.Premium;
import Trabalho_Pratico_2.Silver;
import Trabalho_Pratico_2.Socio;
import Trabalho_Pratico_2.Standard;


public class SocioQuantidade extends JFrame {

	private JScrollPane scrl;
	private String titulos[] = {"Gold", "Silver", "Premium", "Standard", "Total"};
	private String [][] tabDados;
	private JPanel contentPane;
	private Container contain;
	private JTable table;
	
	public SocioQuantidade() {
		super("Quantidade dos Sócios");
		contain = getContentPane();
		contain.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		

		tabDados = criarTabela();
		
		table = new JTable(tabDados, titulos);
		table.setEnabled(false);
		// Desabilitar reordenação das colunas...
        table.getTableHeader().setReorderingAllowed(false);
		scrl = new JScrollPane(table);
		contain.add(scrl);
		
		setVisible(true);
		setSize(500,100);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public String [][]criarTabela()
	{
		String [][] x = new String[1][titulos.length];
		
		//for(int i = 0; i<1; i++)
		//{
			x[0][0] = Gold.contG+"";
			x[0][1] = Silver.contS+"";
			x[0][2] = Premium.contP+"";
			x[0][3] = Standard.contStandard+"";
			x[0][4] = Socio.contS+"";
		//}
		return x;
	}
		
}
