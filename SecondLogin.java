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
	        	/*
	        	 * Tutaj trzeba dodaæ kod, który bêdzie sprawdza³ passy z baz¹ danych
	        	 * pracownik, albo klient po zmiennej whoIsThere
	        	 * 
	        	 */
	        	if(whoIsThere==1) {
	        		MK = new MenuKlient();

	        		MK.function();
	        		fSL.setVisible(false); //you can't see me!
	        		fSL.dispose(); //Destroy the JFrame object
	        	}
	        	if(whoIsThere==2) {
	        		MP=new MenuPracownik();
	        		MP.function();
	        		fSL.setVisible(false); //you can't see me!
	        		fSL.dispose(); //Destroy the JFrame object
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
