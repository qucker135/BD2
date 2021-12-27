import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MenuPracownik {

    static JButton katalog;
    static JButton noweKonto;
    static JButton lista;
    static JButton mojeKonto;
    static JButton wyloguj;

    Menu menu;
	ListaKlient listaObj;
    
	public void function() {
		JFrame fMP = new JFrame();

	    try {
	    	
	        fMP.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("menuPracownik.jpg")))));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    katalog = new JButton("");
	    noweKonto = new JButton("");
	    lista = new JButton("");
	    mojeKonto = new JButton("");
	    wyloguj = new JButton("");

	    
	    katalog.setBounds(470, 184, 240, 30);
	    noweKonto.setBounds(470, 233, 240, 30);
	    lista.setBounds(470, 282, 240, 30);
	    mojeKonto.setBounds(470, 331, 240, 30);
	    wyloguj.setBounds(470, 380, 240, 30);
	    
	    katalog.setOpaque(false);
	    katalog.setContentAreaFilled(false);
	    katalog.setBorderPainted(false);
	    noweKonto.setOpaque(false);
	    noweKonto.setContentAreaFilled(false);
	    noweKonto.setBorderPainted(false);
	    lista.setOpaque(false);
	    lista.setContentAreaFilled(false);
	    lista.setBorderPainted(false);
	    mojeKonto.setOpaque(false);
	    mojeKonto.setContentAreaFilled(false);
	    mojeKonto.setBorderPainted(false);
	    wyloguj.setOpaque(false);
	    wyloguj.setContentAreaFilled(false);
	    wyloguj.setBorderPainted(false);
;
	    
	    katalog.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
        		menu = new Menu();
        		menu.function();
        		fMP.setVisible(false); //you can't see me!
        		fMP.dispose(); //Destroy the JFrame object
	        }
	    });
	    noweKonto.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(fMP, "Eggs are not supposed to be green.");

	        }
	    });
	    lista.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
        		listaObj = new ListaKlient();
        		listaObj.function();
	            fMP.setVisible(false); //you can't see me!
        		fMP.dispose(); //Destroy the JFrame object
	        }
	    });
	   mojeKonto.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(fMP, "Eggs are not supposed to be green.");

	        }
	    });
	    wyloguj.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            introLogin login = new introLogin();
	            login.function();
	            fMP.setVisible(false); //you can't see me!
        		fMP.dispose(); //Destroy the JFrame object
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
