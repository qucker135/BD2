import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import static java.lang.Integer.parseInt;


public class katalog {
	
    ImageIcon bBG = new ImageIcon("buttonBG.png");
	
	JTextField kategoria;
    JScrollPane scrollPane;
    JTable table;
    JButton dodaj;
    JButton back;
    JSpinner spinner;
    
    //int amountOfData=100;
    //String prod=" ";
	//int cena=-1;
    //int prom=-1;

    
    int min=0;
    int max=10;
	
	public void function(Integer idKategorii, String PESEL, koszyk koszykObj) {
		JFrame fKA = new JFrame();
		fKA.setSize(751, 650);
		fKA.setResizable(false);


		//global connection to db
		Connection connection = connection = DbConnector.connect();

	    try {
	    	
	        fKA.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("menuV2.jpg")))));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    kategoria = new JTextField();
	    kategoria.setBounds(300, 30, 200, 70);

		String name = "";
		try{
			ResultSet resultSet = DbConnector.executeSelectQueryToConnection(connection, "SELECT Nazwa FROM Kategoria WHERE IDKategorii="+idKategorii.toString()+";");
			resultSet.next();
			name = resultSet.getString("Nazwa");
		}catch(SQLException e){
			e.printStackTrace();
		}
	    kategoria.setText(name);
	    
	    kategoria.setOpaque(false);
	    
	    String column[]={"ID Produktu", "Nazwa", "Cena", "Promocja", "Dostï¿½pne sztuki"};
	    DefaultTableModel dtm=new DefaultTableModel(column,0);

	    JTable jt=new JTable(dtm);    

		try{
			ResultSet resultSet = DbConnector.executeSelectQueryToConnection(connection, "SELECT Produkt.IDProduktu AS IDProduktu, Produkt.Nazwa AS Nazwa, Produkt.Cena AS Cena, Produkt.DostepneSztuki AS Sztuki, Promocja.Wartosc AS Promocja FROM Produkt, Promocja, PromocjeNaProdukty WHERE Promocja.IDPromocji=PromocjeNaProdukty.PromocjaIDPromocji AND Produkt.IDProduktu=PromocjeNaProdukty.ProduktIDProduktu AND KategoriaIDKategorii="+idKategorii+";");
			while(resultSet.next()){
				String idProduktu = resultSet.getString("IDProduktu");
				String nazwa = resultSet.getString("Nazwa");
				String cena = resultSet.getString("Cena");
				String sztukiBefore = resultSet.getString("Sztuki");
				//sekcja zabezpieczaj¹ca przed prze³adowaniem koszyka
				Integer sztukiTMP = 0;
				  try {
						sztukiTMP = Integer.parseInt(sztukiBefore);
					  } catch (NumberFormatException e) {
					    System.out.println("sztuki z bazy danych to nie integer");
					  }
				  Integer takenProducts = 0;
				 ArrayList<String[]> tmp = koszykObj.getKoszyk(); //id, nazwa, iloœæ, cena
				for(int iterator =0; iterator < tmp.size(); iterator++) {
					if(tmp.get(iterator)[0]==idProduktu) {
						try {
						takenProducts = Integer.parseInt(tmp.get(iterator)[2]);
						  } catch (NumberFormatException e) {
							    System.out.println("sztuki z koszyka to nie integer");
						}
					}
				}
				
				//sekcja - end
				Integer sztukiEnd = sztukiTMP-takenProducts;
				String sztuki = sztukiEnd.toString();
				String promocja = resultSet.getString("Promocja");
				String[] row = {idProduktu, nazwa, cena, promocja, sztuki};
				dtm.addRow(row);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}

	    jt.setBounds(0,0,200,100);      
	    jt.setBackground(Color.blue);
	    JScrollPane sp=new JScrollPane(jt);    
	    
	    JPanel p = new JPanel();
	    p.setBounds(0, 100, 500, 425);
	    p.setBackground(Color.white);
	    p.add(sp);

	    // BM - DONE
	    // przypisz wartoï¿½ciom min i max odpowiednie wartoï¿½ci. minimum produktï¿½w, ktï¿½re moï¿½na kupiï¿½ to 1, maksimum to iloï¿½ï¿½ dostï¿½pnych produktï¿½w
	    min = 0;
	    max = 10;//podepnij do bazy

		try{
			ResultSet resultSet = DbConnector.executeSelectQueryToConnection(connection, "SELECT COUNT(*) AS Liczba FROM Produkt;");//TODO BM, chyba zasn¹³em, SELECT dostepne sztuki ... where idProduktu = get value At(get selected row, 0)
			resultSet.next();
			String maxAsText = resultSet.getString("Liczba");
			max = parseInt(maxAsText);
		}catch(SQLException e){
			e.printStackTrace();
		}

		SpinnerModel value = new SpinnerNumberModel(0, min,max,1);
	    spinner = new JSpinner(value); 
	    spinner.setBounds(500, 150, 40, 40);
	    
	    dodaj = new JButton("DODAJ DO KOSZYKA", bBG);
	    dodaj.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    dodaj.setBounds(500, 100, 240, 30);
	    dodaj.setContentAreaFilled(false);
	    dodaj.setBorderPainted(false);
	    dodaj.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	if(spinner.getValue().toString()=="0") {
	        		JOptionPane.showMessageDialog(fKA, "Nie moï¿½esz dodaï¿½ 0 produktï¿½w!");
	        	}else {
        		jt.getSelectedRow();
        		spinner.getValue();
        		int row = jt.getSelectedRow();
        		String nazwaWybranego = jt.getModel().getValueAt(row, 1).toString();
        		String cenaWybranego = jt.getModel().getValueAt(row, 3).toString();
       		 String idWybranegoProduktu = jt.getModel().getValueAt(row, 0).toString(); // moï¿½e 4, jeï¿½li liczy od 0, nie mam czasu na testy

        		 String[] row1={idWybranegoProduktu, nazwaWybranego,spinner.getValue().toString(),cenaWybranego};
        		koszykObj.addToBasket(row1);
        		
	        	}
	        	}
	    });
	    
	    back = new JButton("POWRï¿½T", bBG);
	    back.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    back.setBounds(500, 400, 240, 30);
	    back.setContentAreaFilled(false);
	    back.setBorderPainted(false);
	    back.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	MenuKlient menu = new MenuKlient();
        		menu.function(PESEL, koszykObj);
        		fKA.setVisible(false); //you can't see me!
        		fKA.dispose(); //Destroy the JFrame object
        		return;
	        }
	    });
	    
	    fKA.add(back);
	    fKA.add(spinner);
	    fKA.add(dodaj);
	    fKA.add(p);          
	    System.out.println("myk");
	    fKA.add(kategoria);
	    fKA.pack();
	    fKA.setVisible(true);
	}
}
