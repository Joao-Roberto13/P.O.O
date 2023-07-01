package Trabalho_Pratico_2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.*;
import javax.swing.filechooser.*;

public class FileChooser 
{
	private JFileChooser fileChooser;
	private String filePath;
	private File selectedFile;
	private FileNameExtensionFilter filter;
	private int result;
	
    public FileChooser(String fileType,String extensao)
    {
    	fileChooser = new JFileChooser();
    	try
    	{
        	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    	}
    	catch(Exception e) {System.out.println(e.getMessage());}
        
        fileChooser.updateUI();

        filter = new FileNameExtensionFilter(fileType,extensao);
        fileChooser.setFileFilter(filter);
    }
    
    public File openFileChooser()
    {
    	fileChooser.setDialogTitle("Abrir arquivo");
    	//mostra o FileChosserDialog...
        result = fileChooser.showOpenDialog(null);
        
        if (result == JFileChooser.APPROVE_OPTION) {
        	
            //retorna o file selecionado...
            selectedFile = fileChooser.getSelectedFile();

            // retorna o filePath...
            return selectedFile;
        }
        else
        	if(result == JFileChooser.CANCEL_OPTION)
        		JOptionPane.showMessageDialog(null, "Nenhum Ficheiro selecionado");
        return null;
    }
    
    public void saveFileChooser(Vector vetor)
    {
         fileChooser.setDialogTitle("Salvar arquivo");

         // Mostrar o seletor de arquivos....
         int userSelection = fileChooser.showSaveDialog(null);

         if (userSelection == JFileChooser.APPROVE_OPTION) {
             // Obter o arquivo selecionado
             File file = fileChooser.getSelectedFile();
             
            try 
     		{
     			ObjectOutputStream x = new ObjectOutputStream(new FileOutputStream(file));

     			x.writeObject(vetor);
     			x.close();
     		} 
     		catch (IOException e) {JOptionPane.showMessageDialog(null, "ERRO: Ao escrever o ficheiro de objecto:(","Erro escrever Objecto",JOptionPane.ERROR_MESSAGE);}
     		JOptionPane.showMessageDialog(null, "Ficheiro de Objecto salvo com Sucesso:)","Ficheiro Objecto",JOptionPane.INFORMATION_MESSAGE);
         }
         else
         	JOptionPane.showMessageDialog(null, "Nenhum Ficheiro selecionado");
    }
}
