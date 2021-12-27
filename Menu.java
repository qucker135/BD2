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

public class Menu {
	static JButton laptopy;
	static JButton smartfony;
	static JButton gaming;
	static JButton up;
	static JButton tv;

	katalog katalog;
	public void function(){
		JFrame fM = new JFrame();

    	try {
    	
        	fM.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("menu.jpg")))));
    	} catch (IOException e) {
    	e.printStackTrace();
    	}
    	
    	laptopy = new JButton("");
    	smartfony= new JButton("");
    	gaming = new JButton("");
    	up = new JButton("");
    	tv = new JButton("");
    	
    	laptopy.setBounds(94, 330, 130, 92);
    	smartfony.setBounds(234, 330, 130, 92);
    	gaming.setBounds(374, 330, 130, 92);
    	up.setBounds(94, 438, 130, 92);
    	tv.setBounds(234, 438, 130, 92);

	    laptopy.setOpaque(false);
	    laptopy.setContentAreaFilled(false);
	    laptopy.setBorderPainted(false);
	    smartfony.setOpaque(false);
	    smartfony.setContentAreaFilled(false);
	    smartfony.setBorderPainted(false);
	    gaming.setOpaque(false);
	    gaming.setContentAreaFilled(false);
	    gaming.setBorderPainted(false);
	    up.setOpaque(false);
	    up.setContentAreaFilled(false);
	    up.setBorderPainted(false);
	    tv.setOpaque(false);
	    tv.setContentAreaFilled(false);
	    tv.setBorderPainted(false);
    	
	    laptopy.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
        		katalog = new katalog();
        		katalog.function("laptopy");
        		fM.setVisible(false); //you can't see me!
        		fM.dispose(); //Destroy the JFrame object
	        }
	    });
	    smartfony.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
        		katalog = new katalog();
        		katalog.function("smartfony");
        		fM.setVisible(false); //you can't see me!
        		fM.dispose(); //Destroy the JFrame object
	        }
	    });
	    gaming.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
        		katalog = new katalog();
        		katalog.function("gaming");
        		fM.setVisible(false); //you can't see me!
        		fM.dispose(); //Destroy the JFrame object
	        }
	    });
	    up.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
        		katalog = new katalog();
        		katalog.function("up");
        		fM.setVisible(false); //you can't see me!
        		fM.dispose(); //Destroy the JFrame object
	        }
	    });
	    tv.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
        		katalog = new katalog();
        		katalog.function("tv");
        		fM.setVisible(false); //you can't see me!
        		fM.dispose(); //Destroy the JFrame object
	        }
	    });
	    
    	fM.add(laptopy);
    	fM.add(smartfony);
    	fM.add(gaming);
    	fM.add(up);
    	fM.add(tv);
    	
	    fM.pack();
	    fM.setVisible(true);
	}
}
