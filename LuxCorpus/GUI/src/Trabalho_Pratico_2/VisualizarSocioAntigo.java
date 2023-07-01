package Trabalho_Pratico_2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;


import java.text.DecimalFormat;

public class VisualizarSocioAntigo extends JFrame
{
	private JScrollPane scrl;
	private String titulos[] = {"Codigo", "Nome", "Data de Inscrição", "Idade", "Peso","Sexo","Objectivo"};
	private String [][] tabDados;
	private Container contain;
	private JTable table;
	private DecimalFormat df;
	
	public VisualizarSocioAntigo(Vector vetor, int i)
	{
		setTitle("Sócio mais Antigo");
		df = new DecimalFormat("###,###,###.00 MZN");
		contain = getContentPane();
		
		tabDados = criarTabela(vetor, i);
		
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
		setSize(800,300);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public String [][]criarTabela(Vector vetor, int i)
	{
		String [][] x = new String[1][titulos.length];
		
		Socio g = (Socio) vetor.elementAt(i);
		
		x[0][0] = g.getCodigo()+"";
		x[0][1] = g.getNome();
		x[0][2] = g.getData();
		x[0][3] = g.getIdade()+"";
		x[0][4] = g.getPeso()+"";
		x[0][5] = g.getSexo();
		x[0][6] = g.getObjectivo();
		
		return x;
	}
}