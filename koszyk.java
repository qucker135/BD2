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
    ArrayList <String []>rows = new ArrayList<>();


	public void function(String PESEL, koszyk koszykObj) {
		JFrame fK = new JFrame();

	    try {
	    	
	        fK.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("menuV2.jpg")))));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }    
	    
		fK.setSize(751, 650);
		fK.setResizable(false);
	    
	    String column[]={"Produkt","Iloï¿½ï¿½","Cena", "idProduktu"};      
	    DefaultTableModel dtm=new DefaultTableModel(column,0);

	    JTable jt=new JTable(dtm);    
	    
	    ////////////////////////////////////////////////
	    //dane do wypisania w tabeli
	    //Do zmiennej amount of data wpisaï¿½ iloï¿½ï¿½ produktï¿½w
	    //coï¿½ mï¿½wiliï¿½my o tym, ï¿½eby byï¿½y domyï¿½lne wartoï¿½ci, to w pole imie, imie2 itd. trzeba by wstawiï¿½ domyï¿½lny tekst. zostawiam do przemyï¿½lenia
	    //w idKlienta jest id klienta, ktï¿½ry teraz pracuje na aplikacji
	    //TODO BM + Franciszek
		//"SELECT "

        int iterator = 0;
        System.out.println(rows.size());

        while (iterator < rows.size()) {
            System.out.println(rows.get(iterator));
            dtm.addRow(rows.get(iterator));
            iterator++;
        }


	    //////////////////////////////////////
	    jt.setBounds(0,0,200,100);      
	    jt.setBackground(Color.blue);
	    JScrollPane sp=new JScrollPane(jt);    
	    
	    JPanel p = new JPanel();
	    p.setBounds(210, 50, 600, 425);
	    p.setBackground(Color.white);
	    p.add(sp);
	    
	    
	    
	    
	    
	    usun = new JButton("USUï¿½", bBG);
	    kup = new JButton("KUP", bBG);
	    back = new JButton("POWRï¿½T", bBG);

	    usun.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    kup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    back.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    
	    usun.setBounds(410, 500, 240, 30);
	    kup.setBounds(5, 500, 240, 30);
	    back.setBounds(5, 50, 240, 30);

	    
	    imie = new JTextField("imiï¿½");
	    imie2 = new JTextField("drugie imiï¿½");
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
	        	//powyï¿½ej czyta dane z pï¿½l tekstowych, zajmij sie tym, ï¿½eby zostaï¿½y one odpowiednio 
	        	//przetworzone przez bazï¿½
	        	//TODO BM + Franciszek
	     	    //nowy wpis do tabeli transakcje, zawiera dane zebrane wy¿ej, do tego potrzebny nowy wpis w tabelach 
	     	    //nr egzemplarza w transakcji, który zawiera po jedyn konkretnym przedmiocie z danego typu
	     	    //w tabeli Produkty zmniejszamy iloœæ dostêpnych o iloœæ kupionych
	        }
	    });
	    back.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
        		menu = new MenuKlient();
        		menu.function(PESEL, koszykObj);
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
	public void addToBasket(String[] row) {
		rows.add(row);
		System.out.println("Dodano");
		return;
	}


}
