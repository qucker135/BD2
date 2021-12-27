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
import javax.swing.JTextField;


public class koszyk {

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

    MenuKlient menu;

	public void function() {
		JFrame fK = new JFrame();

	    try {
	    	
	        fK.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("koszyk.jpg")))));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    usun = new JButton("");
	    kup = new JButton("");
	    back = new JButton("");

	    
	    usun.setBounds(340, 220, 100, 20);
	    kup.setBounds(580, 170, 120, 20);
	    back.setBounds(20, 60, 70, 10);

	    
	    imie = new JTextField();
	    imie2 = new JTextField();
	    nazwisko = new JTextField();
	    kod = new JTextField();
	    miasto = new JTextField();
	    ulica = new JTextField();
	    lokal = new JTextField();
	    tel = new JTextField();
	    email = new JTextField();

	    
	    imie.setBounds(210, 280, 200, 10);
	    imie2.setBounds(210, 300, 200, 10);
	    nazwisko.setBounds(210, 320, 200, 10);
	    kod.setBounds(210, 340, 200, 10);
	    miasto.setBounds(210, 360, 200, 10);
	    ulica.setBounds(210, 380, 200, 10);
	    lokal.setBounds(210, 400, 200, 10);
	    tel.setBounds(210, 420, 200, 10);
	    email.setBounds(210, 440, 200, 10);

	    usun.setOpaque(false);
	    usun.setContentAreaFilled(false);
	    usun.setBorderPainted(false);
	    kup.setOpaque(false);
	    kup.setContentAreaFilled(false);
	    kup.setBorderPainted(false);
	    back.setOpaque(false);
	    back.setContentAreaFilled(false);
	    back.setBorderPainted(false);
	    
	    usun.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(fK, "Eggs are not supposed to be green.");

	        }
	    });
	    kup.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(fK, "Eggs are not supposed to be green.");

	        }
	    });
	    back.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
        		menu = new MenuKlient();
        		menu.function();
        		fK.setVisible(false); //you can't see me!
        		fK.dispose(); //Destroy the JFrame object
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
	    
	    fK.pack();
	    fK.setVisible(true);
	}
}
