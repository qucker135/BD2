import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


//historia zam�wie� 


public class ListaPracownik {
	
	JTable table;
	
	JTextField nrZam;
	
	JButton back;
	
	JComboBox paragony;
	
    ImageIcon bBG = new ImageIcon("buttonBG.png");
	
	int amountOfData=10;
	int amountOfPar=10;
	
	String prod;
	int il;
	int cena;
	String prod2 = "zmiana";
	int il2 =99;
	int cena2 = 981;
	String numerZBD;
	
	public void function(int idKlienta) {
		JFrame fLK = new JFrame();

	    try {
	    	
	        fLK.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("menuV2.jpg")))));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		fLK.setSize(751, 650);
		fLK.setResizable(false);
	    
	    System.out.println("tralalala");
	    String column[]={"Produkt","Ilo��","Cena"};         
	    DefaultTableModel dtm=new DefaultTableModel(column,0);

	    JTable jt=new JTable(dtm);    
	    
	    paragony = new JComboBox();
	    
	    /*
	     * do comboboxa nale�y wpisa� wszystkie paragony TODO BM
	    */
	    for(int i=0; i<amountOfPar; i++) {
	    	paragony.addItem("myk");
	    }
	    
	    
	    ////////////////////////////////////////////////
	    //dane do wypisania w tabeli
	    //wszystko podobnie jak w koszyku
	    //TODO BM

	    String[] item={"A","B","C","D"};
	    dtm.addRow(item);
    	paragony.getSelectedItem(); //nrParagonu

	    for(int i=0; i<amountOfData; i++) {
	    	//tutaj trzeba wklepa� w zmienne te 3 co s� poni�ej nazw� produktu, ilo�� do kupienia i cen� dla ka�dego paragonu
	        Object[] row = { prod, il, cena };
		    dtm.addRow(row);

	    } 
	    jt.setBounds(0,0,200,100);      
	    jt.setBackground(Color.blue);
	    JScrollPane sp=new JScrollPane(jt);    
	    
	    JPanel p = new JPanel();
	    p.setBounds(0, 100, 500, 425);
	    p.setBackground(Color.white);
	    p.add(sp);
	    
	    
	    
	    //TODO BM
	    //ustaw numerZBD na numer  1 zam�wienia danego klienta
	    //numerZBD = ...
	    nrZam = new JTextField();
	    nrZam.setText(numerZBD);
	    
	    back = new JButton("POWR�T", bBG);
	    back.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    back.setBounds(500, 400, 240, 30);
	    back.setContentAreaFilled(false);
	    back.setBorderPainted(false);
	    back.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	MenuPracownik menu = new MenuPracownik();
        		menu.function(idKlienta);
        		fLK.setVisible(false); //you can't see me!
        		fLK.dispose(); //Destroy the JFrame object
        		return;
	        }
	    });
	    paragony.setBounds(500, 100, 240, 30);
	    
	    paragony.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	paragony.getSelectedItem();
	        	dtm.getDataVector().removeAllElements();
	    	    for(int i=0; i<amountOfData; i++) {
	    	    	//tutaj trzeba wklepa� w zmienne te 3 co s� poni�ej nazw� produktu, ilo�� do kupienia i cen�
	    	        Object[] row = { prod2, il2, cena2 };
	    		    dtm.addRow(row);

	    	    } 
	        }
	    });
	    
	    fLK.add(paragony);
	    fLK.add(back);
	    fLK.add(nrZam);
	    fLK.add(p);
	    fLK.pack();
	    fLK.setVisible(true);
	}
}
