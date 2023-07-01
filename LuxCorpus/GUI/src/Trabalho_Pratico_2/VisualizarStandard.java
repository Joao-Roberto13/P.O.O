package Trabalho_Pratico_2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;
import java.text.DecimalFormat;

public class VisualizarStandard extends JFrame
{
	private JScrollPane scrl;
	private String titulos[] = {"Codigo", "Nome", "Data de Inscrição", "Idade", "Peso","Sexo","Objectivo","Dias",
			"Horario","Valor a Pagar"};
	private String [][] tabDados;
	private Container contain;
	private JTable table;
	private DecimalFormat df;
	
	public VisualizarStandard(Vector vetor)
	{
		setTitle("Sócio Standard");
		df = new DecimalFormat("###,###,###.00 MZN");
		contain = getContentPane();
		
		tabDados = criarTabela(vetor);
		
		table = new JTable(tabDados, titulos);
		//table.setEnabled(false);
		scrl = new JScrollPane(table);
		scrl.setBounds(10, 10, 1015, 374);
		contain.add(scrl);
		
        // Configuracao para o tamanho das colunas...
		table.setAutoResizeMode(table.AUTO_RESIZE_NEXT_COLUMN);
		
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
		setSize(1200,300);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public String [][]criarTabela(Vector vetor)
	{
		String [][] x = new String[Standard.contStandard][titulos.length];//tera o numero de linhas que a quantidade no contador... 
		Standard g;
		Socio s;
		int cont = 0;
		
		for(int i = 0; i<vetor.size(); i++)
		{
			s = (Socio) vetor.elementAt(i);
			
			if(s instanceof Standard)
			{
				g = (Standard) s;
				x[cont][0] = g.getCodigo()+"";
				x[cont][1] = g.getNome();
				x[cont][2] = g.getData();
				x[cont][3] = g.getIdade()+"";
				x[cont][4] = g.getPeso()+"";
				x[cont][5] = g.getSexo();
				x[cont][6] = g.getObjectivo();
				x[cont][7] = g.getNumeroDias()+"";
				x[cont][8] = g.getHorario();
				x[cont][9] = df.format(g.getValorFinal());
				cont++;//para colocar na tabela de forma consecutiva...e nao saltar linha...
			}
		}
		return x;
	}
}