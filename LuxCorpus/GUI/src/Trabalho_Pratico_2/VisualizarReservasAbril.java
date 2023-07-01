package Trabalho_Pratico_2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;
import java.util.Vector;


import java.text.DecimalFormat;

public class VisualizarReservasAbril extends JFrame
{
	private JScrollPane scrl;
	private String titulos[] = {"Codigo", "Hora", "Data de Reserva", "Tipo de Pacote", "Codigo e Nome do Socio"};
	private String [][] tabDados;
	private Container contain;
	private JTable table;
	
	public VisualizarReservasAbril(Vector vetor)
	{
		setTitle("Reservas Abril");
		contain = getContentPane();
		
		Calculos c = new Calculos();
		int cont = c.contarReservasAbril(vetor);
		tabDados = criarTabela(vetor,cont);
		
		table = new JTable(tabDados, titulos);
		//table.setEnabled(false);
		scrl = new JScrollPane(table);
		scrl.setBounds(10, 10, 1015, 374);
		contain.add(scrl);
		
		String opcoes [] = {"OK","Visualizar Reservas"};
		
		int op = JOptionPane.showOptionDialog(null, "Existem "+cont+" reservas para ao mês de Abril","Reservas",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,opcoes,opcoes[0]);

		if(op==1)
		{
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
			setSize(800,300);
			setVisible(true);
			setResizable(false);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
	}
	
	public String [][]criarTabela(Vector vetor, int contR)
	{
		String [][] x = new String[contR][titulos.length];//tera o numero de linhas que a quantidade no contador... 
		Gold g;
		Silver s;
		Socio so;
		int cont = 0;

		for(int i = 0; i<vetor.size(); i++)
		{
			so = (Socio) vetor.elementAt(i);

			if(so instanceof Gold)
			{
				g = (Gold) so;
				if(g.getCodigoReserva() != 0)
					if(g.getDataReserva().substring(3, 5).equals("04"))//faz get da data de reserva, de seguida faz substring do mes e vê se é igual a 04(abril)...
					{
						x[cont][0] = g.getCodigoReserva()+"";
						x[cont][1] = g.getHora();
						x[cont][2] = g.getDataReserva();
						x[cont][3] = g.getTipoPacote();
						x[cont][4] = g.getCodigoNome();
						cont++;
					}
			}
			else
			{
				if(so instanceof Silver)
				{
					s = (Silver) so;
					if(s.getCodigoReserva() != 0)
						if(s.getDataReserva().substring(3, 5).equals("04"))//faz get da data de reserva, de seguida faz substring do mes e vê se é igual a 04(abril)...
						{
							x[cont][0] = s.getCodigoReserva()+"";
							x[cont][1] = s.getHora();
							x[cont][2] = s.getDataReserva();
							x[cont][3] = s.getTipoPacote();
							x[cont][4] = s.getCodigoNome();
							cont++;
						}
				}
			}
		}
		return x;
	}
}