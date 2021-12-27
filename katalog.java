import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class katalog {
	
	JTextField kategoria;
	
	public void function(String name) {
		JFrame fKA = new JFrame();

			
	    try {
	    	
	        fKA.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("katalog.jpg")))));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    kategoria = new JTextField();
	    kategoria.setBounds(300, 340, 200, 70);
	    kategoria.setText(name);
	    
	    kategoria.setOpaque(false);
	    
	    fKA.add(kategoria);
	    
	    fKA.pack();
	    fKA.setVisible(true);
	}
}
