import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class KatalogPracownik {
	
    ImageIcon bBG = new ImageIcon("buttonBG.png");
    ImageIcon bBGd = new ImageIcon("buttonBGdel.png");
    ImageIcon bBGe = new ImageIcon("buttonBGedit.png");

	
	JTextField kategoria;
    JScrollPane scrollPane;
    JTable table;
    JButton dodaj;
    JButton back;
    JSpinner spinner;
    JButton edit;
    JButton delete;
    
    int amountOfData=100;
    String prod=" ";
    int prom=-1;
    int cena=-1;
    
    int min=0;
    int max=10;
	
	public void function(int idKlienta) {
		JFrame fKA = new JFrame();

			
	    try {
	    	
	        fKA.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("menuV2.jpg")))));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    kategoria = new JTextField();
	    kategoria.setBounds(300, 30, 200, 70);
	    
	    kategoria.setOpaque(false);
	    
	    String column[]={"Nazwa", "Cena", "Promocja", "Dostêpne sztuki", "Kategoria"};         
	    DefaultTableModel dtm=new DefaultTableModel(column,0);

	    JTable jt=new JTable(dtm);    
	    
	    ////////////////////////////////////////////////
	    //dane do wypisania w tabeli
	    //wszystko podobnie jak w koszyku
	    //TODO BM

	    String[] item={"A","B","C","D"};
	    dtm.addRow(item);

	    for(int i=0; i<amountOfData; i++) {
	    	//tutaj trzeba wklepaæ w zmienne te 3 co s¹ poni¿ej nazwê produktu, iloœæ do kupienia i cenê
	        Object[] row = { prod, prom, cena, "myk", "dupa" };
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
	    // przypisz wartoœciom min i max odpowiednie wartoœci. minimum produktów, które mo¿na kupiæ to 1, maksimum to iloœæ dostêpnych produktów
	    //min = 1;
	    //max = podepnij do bazy
	    SpinnerModel value = new SpinnerNumberModel(0, min,max,1);
	    spinner = new JSpinner(value); 
	    spinner.setBounds(500, 150, 40, 40);
	    
	    
	    back = new JButton("POWRÓT", bBG);
	    back.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    back.setBounds(500, 500, 240, 30);
	    back.setContentAreaFilled(false);
	    back.setBorderPainted(false);
	    back.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	MenuPracownik menu = new MenuPracownik();
        		menu.function(idKlienta);
        		fKA.setVisible(false); //you can't see me!
        		fKA.dispose(); //Destroy the JFrame object
        		return;
	        }
	    });
	    edit = new JButton("EDYTUJ", bBGe);
	    edit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    edit.setBounds(500, 450, 240, 30);
	    edit.setContentAreaFilled(false);
	    edit.setBorderPainted(false);
	    edit.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
		    	if(jt.getSelectedRow()== -1) {
	        		JOptionPane.showMessageDialog(fKA, "Wybierz wiersz");

	        	//System.out.println(jt.getSelectedRow());
		    	}else {
	        	JFrame tmp = new JFrame();
	            String name=JOptionPane.showInputDialog(tmp, "Zmiana nazwy", dtm.getValueAt(jt.getSelectedRow(), 0));
	           // String name=JOptionPane.showInputDialog(tmp,"Wpisz Nazwê");  
	            String amS=JOptionPane.showInputDialog(tmp, "Zmiana Iloœci", dtm.getValueAt(jt.getSelectedRow(), 2));
	            int am=-1;
	            while(am==-1) {
	            try {
	            am=Integer.parseInt(amS);
	            } catch (NumberFormatException e2) {
		            amS=JOptionPane.showInputDialog(tmp, "Zmiana Iloœci", dtm.getValueAt(jt.getSelectedRow(), 2));
	            }
	            }
	            String costS=JOptionPane.showInputDialog(tmp, "Zmiana ceny", dtm.getValueAt(jt.getSelectedRow(), 1));
	            int cost=-1;
	            while(cost==-1) {
	            try {
	            cost=Integer.parseInt(costS);
	            } catch (NumberFormatException e2) {
		            costS=JOptionPane.showInputDialog(tmp, "Zmiana ceny", dtm.getValueAt(jt.getSelectedRow(), 1));
	            }
	            }
	            System.out.print(cost);
	            String op=JOptionPane.showInputDialog(tmp, "Zmiana Opisu");
	            JComboBox kat = new JComboBox();
	            int amountOfKat=10;
	            //TODO BM czytanie iloœci kategorii
	            //amountOfKat = ...
	            for(int i=0; i<amountOfKat; i++) {
	            	kat.addItem("myk"+i);
	            }
	            
	            String[] options = { "OK"};

	            JOptionPane.showOptionDialog(null, kat, "Zmiana Kategorii",
	                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
	                    options[0]);
	            String kategoria = kat.getSelectedItem().toString();
	            System.out.print(kategoria);

	            JComboBox prom = new JComboBox();
	            int amountOfProm =10;
	            //TODO BM czytanie iloœci kategorii
	            //amountOfKat = ...
	            for(int i=0; i<amountOfProm; i++) {
	            	prom.addItem("dupa"+i);
	            }
	            JOptionPane.showOptionDialog(null, prom, "Zmiana Promocji",
	                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
	                    options[0]);
	            String promocja = prom.getSelectedItem().toString();
	            System.out.print(promocja);
	            
	            //"Nazwa", "Cena", "Promocja", "Dostêpne sztuki", "Kategoria"
	            //TODO BM edycja danych z bazy danych
	            dtm.removeRow(jt.getSelectedRow());
		        Object[] row = { name, cost, promocja, am, kategoria  };
			    dtm.addRow(row);
	        }}
	    });
	    delete = new JButton("USUÑ", bBGd);
	    delete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    delete.setBounds(500, 400, 240, 30);
	    delete.setContentAreaFilled(false);
	    delete.setBorderPainted(false);
	    delete.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	((DefaultTableModel)jt.getModel()).removeRow(jt.getSelectedRow());
	        	//TODO BM
	        	//usuwanie produktu z listy zamówieñ

	        }
	    });
	    dodaj = new JButton("DODAJ PRODUKT", bBG);
	    dodaj.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    dodaj.setBounds(500, 350, 240, 30);
	    dodaj.setContentAreaFilled(false);
	    dodaj.setBorderPainted(false);
	    dodaj.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	//kategoria, nazwa, sztuki, cena, opis
	        	JFrame tmp = new JFrame();
	            String name=JOptionPane.showInputDialog(tmp,"Wpisz Nazwê");  
	            String amS=JOptionPane.showInputDialog(tmp,"Wpisz Iloœæ");
	            int am=-1;
	            while(am==-1) {
	            try {
	            am=Integer.parseInt(amS);
	            } catch (NumberFormatException e2) {
		            amS=JOptionPane.showInputDialog(tmp,"Wpisz Iloœæ");
	            }
	            }
	            String costS=JOptionPane.showInputDialog(tmp,"Wpisz cenê");
	            int cost=-1;
	            while(cost==-1) {
	            try {
	            cost=Integer.parseInt(costS);
	            } catch (NumberFormatException e2) {
		            costS=JOptionPane.showInputDialog(tmp,"Wpisz Cenê");
	            }
	            }
	            System.out.print(cost);
	            String op=JOptionPane.showInputDialog(tmp,"Wpisz opis");
	            JComboBox kat = new JComboBox();
	            int amountOfKat=10;
	            //TODO BM czytanie iloœci kategorii
	            //amountOfKat = ...
	            for(int i=0; i<amountOfKat; i++) {
	            	kat.addItem("myk"+i);
	            }
	            
	            String[] options = { "OK"};

	            JOptionPane.showOptionDialog(null, kat, "Kategoria",
	                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
	                    options[0]);
	            String kategoria = kat.getSelectedItem().toString();
	            System.out.print(kategoria);

	            JComboBox prom = new JComboBox();
	            int amountOfProm =10;
	            //TODO BM czytanie iloœci kategorii
	            //amountOfKat = ...
	            for(int i=0; i<amountOfProm; i++) {
	            	prom.addItem("dupa"+i);
	            }
	            JOptionPane.showOptionDialog(null, prom, "Promocja",
	                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
	                    options[0]);
	            String promocja = prom.getSelectedItem().toString();
	            System.out.print(promocja);
	            
	            //"Nazwa", "Cena", "Promocja", "Dostêpne sztuki", "Kategoria"
		        Object[] row = { name, cost, promocja, am, kategoria  };
			    dtm.addRow(row);
	        }
	    });
	    
	    fKA.add(dodaj);
	    fKA.add(back);
	    fKA.add(edit);
	    fKA.add(delete);
	    fKA.add(spinner);
	    fKA.add(p);          
	    System.out.println("myk");
	    fKA.add(kategoria);
	    fKA.pack();
	    fKA.setVisible(true);
	}
}
