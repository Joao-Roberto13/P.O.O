package Trabalho_Pratico_2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;


import java.text.DecimalFormat;

public class VisualizarGold extends JFrame
{
	private JScrollPane scrl;
	private String titulos[] = {"Codigo", "Nome", "Data de Inscrição", "Idade", "Peso","Sexo","Objectivo","Nutricionista","Nr do Quarto",
			"Codigo da Reserva","Hora","Data da Reserva","Tipo de Pacote","Codigo e Nome do Socio","Valor a Pagar"};
	private String [][] tabDados;
	private Container contain;
	private JTable table;
	private DecimalFormat df;
	
	public VisualizarGold(Vector vetor)
	{
		setTitle("Sócio Gold");
		df = new DecimalFormat("###,###,###.00 MZN");
		contain = getContentPane();
		
		tabDados = criarTabela(vetor);
		
		table = new JTable(tabDados, titulos);
		//table.setEnabled(false);
		scrl = new JScrollPane(table);
		scrl.setBounds(10, 10, 1015, 374);
		contain.add(scrl);
		
		table.setRowHeight(25);
		table.getTableHeader().setFont(new Font("Times New Roman",Font.BOLD,13));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(32, 136, 203));
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		table.setShowVerticalLines(false);
		table.setShowHorizontalLines(false);
		table.setIntercellSpacing(new Dimension(0,0));
		table.setFocusable(false);
		table.setEnabled(false);
		
		// Desabilitar reordenação das colunas...
        table.getTableHeader().setReorderingAllowed(false);
		
		table.addMouseMotionListener(
				new MouseAdapter() { //O mouselistener tem muitos metodos.Mais so iremos precisar de 2 entao pode-se usar mouse adapter...
					public void mouseMoved(MouseEvent e) {
						
						  // Obtenha a linha do evento do mouse
		                int row = table.rowAtPoint(e.getPoint());

		                //Cor de fundo quando mouse estiver a passar nas linhas...
		                table.setSelectionBackground(new Color(232, 57, 95));
		                table.setSelectionForeground(Color.BLACK);
		                table.setRowSelectionInterval(row, row);
					}
				});
		
		
		//setUndecorated(true);
		setSize(1400,300);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public String [][]criarTabela(Vector vetor)
	{
		//mudar para vetor o gold
		String [][] x = new String[Gold.contG][titulos.length];//tera o numero de linhas que a quantidade no contador... 
		Gold g;
		Socio s;
		int cont = 0;
		
		for(int i = 0; i<vetor.size(); i++)
		{
			s = (Socio) vetor.elementAt(i);
			
			if(s instanceof Gold)
			{
				g = (Gold) s;
				x[cont][0] = g.getCodigo()+"";
				x[cont][1] = g.getNome();
				x[cont][2] = g.getData();
				x[cont][3] = g.getIdade()+"";
				x[cont][4] = g.getPeso()+"";
				x[cont][5] = g.getSexo();
				x[cont][6] = g.getObjectivo();
				x[cont][7] = g.getNutricionista();
				x[cont][8] = g.getNumeroQuarto()+"";
				x[cont][9] = g.getCodigoReserva()+"";
				x[cont][10] = g.getHora();
				x[cont][11] = g.getDataReserva();
				x[cont][12] = g.getTipoPacote();
				x[cont][13] = g.getCodigoNome();
				x[cont][14] = df.format(g.getValorFinal());
				cont++;//para colocar na tabela de forma consecutiva...e nao saltar linha...
			}
		}
		return x;
	}
	
}
