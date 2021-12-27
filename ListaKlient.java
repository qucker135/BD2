import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class ListaKlient {
	
	JTable table;
	
	public void function() {
		JFrame fLK = new JFrame();

	    try {
	    	
	        fLK.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("listaZamowien.jpg")))));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
        JTextArea textArea = new JTextArea();

        JButton button = new JButton("New button");

        table = new JTable();

        table.setBounds(150, 200,900 , 100);
	    
	    JScrollPane scrollPane = new JScrollPane(table);
	 // Force the scrollbars to always be displayed
	 scrollPane.setHorizontalScrollBarPolicy(
	     JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	 scrollPane.setVerticalScrollBarPolicy(
	     JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 


	 GroupLayout groupLayout = new GroupLayout(fLK.getContentPane());
	 groupLayout.setHorizontalGroup(
	     groupLayout.createParallelGroup(Alignment.TRAILING)
	     .addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
	       .addContainerGap()
	       .addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	         .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE))));
	    
	 	fLK.add(scrollPane);
	 	fLK.add(button);
	 	fLK.add(table);
	 	fLK.add(textArea);
	 
	    fLK.pack();
	    fLK.setVisible(true);
	}
}
