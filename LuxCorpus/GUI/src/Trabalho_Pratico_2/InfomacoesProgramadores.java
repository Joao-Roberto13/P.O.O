package Trabalho_Pratico_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InfomacoesProgramadores extends JFrame {

	private Container contain;
	private String tabDados[][], titulo[] = {"Nome","Codigo","Email"};
	private JTable table;
	private JScrollPane scrl;
	private Boolean passou = true;
	
	public InfomacoesProgramadores() {
		super("Dados dos Programadores");
		contain = getContentPane();
		contain.setLayout(new FlowLayout());
		contain.setBackground(Color.WHITE);
		contain.setLayout(null);
		
		tabDados = criarTabela();
		
		table = new JTable(tabDados, titulo);
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
        		new MouseAdapter() { //O mouselistener tem muitos metodos.Mais so iremos precisar de 1 entao pode-se usar mouse adapter...
        			public void mouseMoved(MouseEvent e) {
        				if(passou)//para mostrar a mensagem somente 1 vez ao abrir os dados do programador...
        					JOptionPane.showMessageDialog(null, "Pode fazer 2 clicks nos dados dos programadores para abrir o perfil do Programador selecionado.");
        				// Obtenha a linha do evento do mouse
        				int row = table.rowAtPoint(e.getPoint());

        				//Cor de fundo quando mouse estiver a passar nas linhas...
        				table.setSelectionBackground(new Color(232, 57, 95));
        				table.setSelectionForeground(Color.BLACK);
        				table.setRowSelectionInterval(row, row);
        				passou = false;//para não mostrar mais quando mover o mouse na table....
        			}
        			
        			
        		});

        table.addMouseListener(
        		new MouseAdapter() {
        			public void mouseClicked(MouseEvent e) {
        				int row = table.rowAtPoint(e.getPoint());
        				
        				if(e.getClickCount() == 2)
        				{
        					if (row == 0)
        						new ClickMichelleProfile();
            				else
            					if (row == 1)
            						new ClickKenyProfile();
            					else
        							new ClickJoaoProfile();
        					dispose();
        				}
        			}
        		});
        
		setSize(1050,200);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public String [][]criarTabela()
	{
		String [][] x = new String[3][titulo.length];
			x[0][0] = "Michelle Boane";
			x[0][1] = "20200266";
			x[0][2] = "boanemichelle@gmail.com";
		
			x[1][0] = "Keny Muchanga";
			x[1][1] = "20210410";
			x[1][2] = "kenymuch@gmail.com";
			
			x[2][0] = "João Roberto";
			x[2][1] = "20220852";
			x[2][2] = "jringuane24@gmail.com";
			
		return x;
	}
}