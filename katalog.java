import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class katalog {
	
    ImageIcon bBG = new ImageIcon("buttonBG.png");
	
	JTextField kategoria;
    JScrollPane scrollPane;
    JTable table;
    JButton dodaj;
    JButton back;
    JSpinner spinner;
    
    int amountOfData=100;
    String prod=" ";
    int prom=-1;
    int cena=-1;
    
    int min=0;
    int max=10;
	
	public void function(String name, int idKlienta) {
		JFrame fKA = new JFrame();

			
	    try {
	    	
	        fKA.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("menuV2.jpg")))));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    kategoria = new JTextField();
	    kategoria.setBounds(300, 30, 200, 70);
	    kategoria.setText(name);
	    
	    kategoria.setOpaque(false);
	    
	    String column[]={"Nazwa", "Cena", "Promocja", "Dost�pne sztuki"};         
	    DefaultTableModel dtm=new DefaultTableModel(column,0);

	    JTable jt=new JTable(dtm);    
	    
	    ////////////////////////////////////////////////
	    //dane do wypisania w tabeli
	    //wszystko podobnie jak w koszyku
	    //TODO BM

	    String[] item={"A","B","C","D"};
	    dtm.addRow(item);

	    for(int i=0; i<amountOfData; i++) {
	    	//tutaj trzeba wklepa� w zmienne te 3 co s� poni�ej nazw� produktu, ilo�� do kupienia i cen�
	        Object[] row = { prod, prom, cena, "9" };
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
	    // przypisz warto�ciom min i max odpowiednie warto�ci. minimum produkt�w, kt�re mo�na kupi� to 1, maksimum to ilo�� dost�pnych produkt�w
	    //min = 1;
	    //max = podepnij do bazy
	    SpinnerModel value = new SpinnerNumberModel(0, min,max,1);
	    spinner = new JSpinner(value); 
	    spinner.setBounds(500, 150, 40, 40);
	    
	    dodaj = new JButton("DODAJ DO KOSZYKA", bBG);
	    dodaj.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    dodaj.setBounds(500, 100, 240, 30);
	    dodaj.setContentAreaFilled(false);
	    dodaj.setBorderPainted(false);
	    dodaj.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
        		jt.getSelectedRow();
        		spinner.getValue();
        		//TODO BM
        		//dodanie zaznaczonego produktu do koszyka w warto�ci spinner
	        }
	    });
	    
	    back = new JButton("POWR�T", bBG);
	    back.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    back.setBounds(500, 400, 240, 30);
	    back.setContentAreaFilled(false);
	    back.setBorderPainted(false);
	    back.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	MenuKlient menu = new MenuKlient();
        		menu.function(idKlienta);
        		fKA.setVisible(false); //you can't see me!
        		fKA.dispose(); //Destroy the JFrame object
        		return;
	        }
	    });
	    
	    fKA.add(back);
	    fKA.add(spinner);
	    fKA.add(dodaj);
	    fKA.add(p);          
	    System.out.println("myk");
	    fKA.add(kategoria);
	    fKA.pack();
	    fKA.setVisible(true);
	}
}
