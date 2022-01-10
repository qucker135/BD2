import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import java.awt.image.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.*;


import java.awt.event.*;


public class SecondLogin {
	
    static JTextField login;
    static JTextField passwd;
    
    static JButton zaloguj;
    
    MenuKlient MK;
    MenuPracownik MP;
    
    
    //private int idKlienta=-1;
    private int idPracownika=-1;
    
    private String loginData;
    private String passwdData;
    
	public void run(int whoIsThere){
		JFrame fSL = new JFrame();

	    try {
	    	
	        fSL.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("logowanie1.jpg")))));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    login = new JTextField();
	    login.setBounds(392, 270, 420, 65);
	    
	    //login.setOpaque(false);
	    passwd = new JTextField();
	    passwd.setBounds(392, 350, 420, 65);
	    
	    zaloguj = new JButton("");
	    zaloguj.setBounds(392, 480, 420, 65);
	    //zaloguj.setOpaque(false);
	    zaloguj.setContentAreaFilled(false);
	    zaloguj.setBorderPainted(false);
	    
	    zaloguj.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	loginData = login.getText();
	        	passwdData = passwd.getText();
	        	/*
	        	 * Tutaj trzeba doda� kod, kt�ry b�dzie sprawdza� passy z baz� danych
	        	 * pracownik, albo klient po zmiennej whoIsThere
	        	 * Nale�y te� zapewni�, aby znalezione id klient / pracownik zosta�o przypisane do odpowiedniej zmiennej
	        	 * 
	        	 */
				String PESEL = "41"; //roboczo - TODO - BM
	        	if(whoIsThere==1) {
	        		MK = new MenuKlient();

	        		MK.function(PESEL, null);
	        		fSL.setVisible(false); //you can't see me!
	        		fSL.dispose(); //Destroy the JFrame object
	        		return;
	        	}
	        	if(whoIsThere==2) {
	        		MP=new MenuPracownik();
	        		MP.function(idPracownika);
	        		fSL.setVisible(false); //you can't see me!
	        		fSL.dispose(); //Destroy the JFrame object
	        		return;
	        	}
	        	
	        }
	    });
	    
	    fSL.add(zaloguj);
	    fSL.add(login);
	    fSL.add(passwd);

	    fSL.pack();
	    fSL.setVisible(true);
	}
}
