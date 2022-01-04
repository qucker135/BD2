import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;




public class koszyk {

    ImageIcon bBG = new ImageIcon("buttonBG.png");
	
    static JButton usun;
    static JButton kup;
    static JButton back;

    
    static JTextField imie;
    static JTextField nazwisko;
    static JTextField imie2;
    static JTextField kod;
    static JTextField miasto;
    static JTextField ulica;
    static JTextField lokal;
    static JTextField tel;
    static JTextField email;
    
    JTable jt;

    String data[][];
    int amountOfData=20;
    String prod= "test";
    int il = -1;
    int cena = -1;
    
    MenuKlient menu;
    

	public void function(int idKlienta) {
		JFrame fK = new JFrame();

	    try {
	    	
	        fK.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("menuV2.jpg")))));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }    
	    
	    String column[]={"Produkt","Iloœæ","Cena"};      
	    DefaultTableModel dtm=new DefaultTableModel(column,0);

	    JTable jt=new JTable(dtm);    
	    
	    ////////////////////////////////////////////////
	    //dane do wypisania w tabeli
	    //Do zmiennej amount of data wpisaæ iloœæ produktów
	    //coœ mówiliœmy o tym, ¿eby by³y domyœlne wartoœci, to w pole imie, imie2 itd. trzeba by wstawiæ domyœlny tekst. zostawiam do przemyœlenia
	    //w idKlienta jest id klienta, który teraz pracuje na aplikacji
	    //TODO BM

	    String[] item={"A","B","C","D"};
	    dtm.addRow(item);

	    for(int i=0; i<amountOfData; i++) {
	    	//tutaj trzeba wklepaæ w zmienne te 3 co s¹ poni¿ej nazwê produktu, iloœæ do kupienia i cenê
	        Object[] row = { prod, il, cena };
		    dtm.addRow(row);

	    }
	    

	    //////////////////////////////////////
	    jt.setBounds(0,0,200,100);      
	    jt.setBackground(Color.blue);
	    JScrollPane sp=new JScrollPane(jt);    
	    
	    JPanel p = new JPanel();
	    p.setBounds(210, 50, 600, 425);
	    p.setBackground(Color.white);
	    p.add(sp);
	    
	    
	    
	    
	    
	    usun = new JButton("USUÑ", bBG);
	    kup = new JButton("KUP", bBG);
	    back = new JButton("POWRÓT", bBG);

	    usun.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    kup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    back.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    
	    usun.setBounds(410, 500, 240, 30);
	    kup.setBounds(5, 500, 240, 30);
	    back.setBounds(5, 50, 240, 30);

	    
	    imie = new JTextField("imiê");
	    imie2 = new JTextField("drugie imiê");
	    nazwisko = new JTextField("nazwisko");
	    kod = new JTextField("kod pocztowy");
	    miasto = new JTextField("miasto");
	    ulica = new JTextField("ulica");
	    lokal = new JTextField("numer lokalu");
	    tel = new JTextField("telefon");
	    email = new JTextField("email");

	    
	    imie.setBounds(10, 280, 200, 20);
	    imie2.setBounds(10, 300, 200, 20);
	    nazwisko.setBounds(10, 320, 200, 20);
	    kod.setBounds(10, 340, 200, 20);
	    miasto.setBounds(10, 360, 200, 20);
	    ulica.setBounds(10, 380, 200, 20);
	    lokal.setBounds(10, 400, 200, 20);
	    tel.setBounds(10, 420, 200, 20);
	    email.setBounds(10, 440, 200, 20);

	    usun.setContentAreaFilled(false);
	    usun.setBorderPainted(false);
	    kup.setContentAreaFilled(false);
	    kup.setBorderPainted(false);
	    back.setContentAreaFilled(false);
	    back.setBorderPainted(false);
	    
	    usun.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	((DefaultTableModel)jt.getModel()).removeRow(jt.getSelectedRow());
	        	//Twoja w tym g³owa, ¿eby w tym miejscu by³ kod, który usuwa element z tabeli
	        	//TODO BM
	        }
	    });
	    kup.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	
	        	imie.getText();
	        	imie2.getText();
	     	    nazwisko.getText();
	     	    kod.getText();
	     	    miasto.getText();
	     	    ulica.getText();
	     	    lokal.getText();
	     	    tel.getText();
	     	    email.getText();
	        	//powy¿ej czyta dane z pól tekstowych, zajmij sie tym, ¿eby zosta³y one odpowiednio 
	        	//przetworzone przez bazê
	        	//TODO BM
	        }
	    });
	    back.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
        		menu = new MenuKlient();
        		menu.function(idKlienta);
        		fK.setVisible(false); //you can't see me!
        		fK.dispose(); //Destroy the JFrame object
        		return;
	        }
	    });
	    
	    fK.add(imie);
	    fK.add(imie2);
	    fK.add(nazwisko);
	    fK.add(kod);
	    fK.add(miasto);
	    fK.add(ulica);
	    fK.add(lokal);
	    fK.add(tel);
	    fK.add(email);

	    fK.add(usun);
	    fK.add(kup);
	    fK.add(back);
	    
	    fK.add(p); 

	    
	    fK.pack();
	    fK.setVisible(true);
	}

}
