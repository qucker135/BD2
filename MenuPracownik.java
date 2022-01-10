import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuPracownik {

    ImageIcon bBG = new ImageIcon("buttonBG.png");
	
    static JButton katalog;
    static JButton noweKonto;
    static JButton lista;
    static JButton mojeKonto;
    static JButton wyloguj;

    Menu menu;
	ListaKlient listaObj;
    

	public void function(int idPracownika) {
		JFrame fMP = new JFrame();

	    try {
	    	
	        fMP.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("menuV2.jpg")))));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
		fMP.setSize(751, 650);
		fMP.setResizable(false);
	    
	    katalog = new JButton("KATALOG", bBG);
	    noweKonto = new JButton("NOWE KONTO", bBG);
	    lista = new JButton("LISTA", bBG);
	    mojeKonto = new JButton("MOJE KONTO", bBG);
	    wyloguj = new JButton("WYLOGUJ", bBG);

	    katalog.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    noweKonto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    lista.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    mojeKonto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    wyloguj.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    
	    
	    katalog.setBounds(470, 184, 240, 30);
	    noweKonto.setBounds(470, 233, 240, 30);
	    lista.setBounds(470, 282, 240, 30);
	    mojeKonto.setBounds(470, 331, 240, 30);
	    wyloguj.setBounds(470, 380, 240, 30);
	    
	    katalog.setContentAreaFilled(false);
	    katalog.setBorderPainted(false);
	    noweKonto.setContentAreaFilled(false);
	    noweKonto.setBorderPainted(false);
	    lista.setContentAreaFilled(false);
	    lista.setBorderPainted(false);
	    mojeKonto.setContentAreaFilled(false);
	    mojeKonto.setBorderPainted(false);
	    wyloguj.setContentAreaFilled(false);
	    wyloguj.setBorderPainted(false);

	    
	    katalog.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
        		KatalogPracownik katalog = new KatalogPracownik();
        		katalog.function(idPracownika);
        		fMP.setVisible(false); //you can't see me!
        		fMP.dispose(); //Destroy the JFrame object
        		return;
	        }
	    });
	    noweKonto.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            
	            JTextField peselInput = new JTextField(11);
	            JTextField adresInput = new JTextField(5);
	            JTextField emailInput = new JTextField(5);
	            JTextField telefonInput = new JTextField(5);
	            JTextField hasloInput = new JTextField(5); //rozmiary??? TODO BM
	            JTextField imieInput = new JTextField(15);
	            JTextField imie2Input = new JTextField(15);
	            JTextField nazwiskoInput = new JTextField(25);

	            JPanel myPanel = new JPanel();
	            myPanel.add(new JLabel("PESEL:"));
	            myPanel.add(peselInput);
	            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	            myPanel.add(new JLabel("Adres:"));
	            myPanel.add(adresInput);
	            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	            myPanel.add(new JLabel("e-mail:"));
	            myPanel.add(emailInput);
	            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	            myPanel.add(new JLabel("telefon:"));
	            myPanel.add(telefonInput);
	            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	            myPanel.add(new JLabel("has³o:"));
	            myPanel.add(hasloInput);
	            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	            myPanel.add(new JLabel("imiê:"));
	            myPanel.add(imieInput);
	            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	            myPanel.add(new JLabel("drugie imiê:"));
	            myPanel.add(imie2Input);
	            myPanel.add(Box.createHorizontalStrut(15)); // a spacer
	            myPanel.add(new JLabel("nazwisko:"));
	            myPanel.add(nazwiskoInput);
	            myPanel.add(Box.createHorizontalStrut(15)); // a spacer

	            int result = JOptionPane.showConfirmDialog(null, myPanel, 
	                     "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
	            if (result == JOptionPane.OK_OPTION) {
	               // nowy wpis do klientów, getTextField
	            	//TODO BM
	            }
	        }
	    });
	    lista.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
        		ListaPracownik l = new ListaPracownik();
        		l.function(idPracownika);
	            fMP.setVisible(false); //you can't see me!
        		fMP.dispose(); //Destroy the JFrame object
        		return;
	        }
	    });
	   mojeKonto.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	//TODO BM zapisaæ dane pracownika do zmiennych ni¿ej SELECT na pracownikach
	        	String imie = "SampleName";
	        	String nazwisko = "SampleSurname";
	        	String imie2 = "Andrzej";
	        	
	        	String toSee = "ID Pracownika "+idPracownika  + " Imiê " + imie + " Drugie Imiê " + imie2 + " Nazwisko " + nazwisko;
        		JOptionPane.showMessageDialog(fMP, toSee);

	        }
	    });
	    wyloguj.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            introLogin login = new introLogin();
	            login.function();
	            fMP.setVisible(false); //you can't see me!
        		fMP.dispose(); //Destroy the JFrame object
        		return;
	        }
	    });

	    fMP.add(katalog);
	    fMP.add(noweKonto);
	    fMP.add(lista);
	    fMP.add(wyloguj);
	    fMP.add(mojeKonto);


	    fMP.pack();
	    fMP.setVisible(true);
	}
}
