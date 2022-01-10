import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
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


public class KatalogPracownik {
	
    ImageIcon bBG = new ImageIcon("buttonBG.png");
    ImageIcon bBGd = new ImageIcon("buttonBGdel.png");
    ImageIcon bBGe = new ImageIcon("buttonBGedit.png");

	
	JTextField kategoria;
    JScrollPane scrollPane;
    JTable table;
    JButton dodaj;
    JButton back;
    JSpinner spinner;
    JButton edit;
    JButton delete;

	/*
    int amountOfData=100;
    String prod=" ";
    int prom=-1;
    int cena=-1;

	 */

    int min=0;
    int max=10;
	
	public void function(int idKlienta) {
		JFrame fKA = new JFrame();

		//global connection to db
		Connection connection = connection = DbConnector.connect();

	    try {
	    	
	        fKA.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("menuV2.jpg")))));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
		fKA.setSize(751, 650);
		fKA.setResizable(false);
	    
	    kategoria = new JTextField();
	    kategoria.setBounds(300, 30, 200, 70);
	    
	    kategoria.setOpaque(false);
	    
	    String column[]={"idProduktu", "Produkt", "Cena", "Promocja", "Dost�pne sztuki", "Kategoria"};
	    DefaultTableModel dtm=new DefaultTableModel(column,0);

	    JTable jt=new JTable(dtm);

		try{
			ResultSet resultSet = DbConnector.executeSelectQueryToConnection(connection, "SELECT Produkt.IDproduktu AS IDproduktu, Produkt.Nazwa AS Produkt, Produkt.Cena, Produkt.DostepneSztuki, Kategoria.Nazwa AS Kategoria, Promocja.Wartosc AS Promocja FROM Produkt, Kategoria, Promocja, PromocjeNaProdukty WHERE Produkt.KategoriaIDkategorii=Kategoria.IDkategorii AND Produkt.IDproduktu=PromocjeNaProdukty.ProduktIDproduktu AND Promocja.IDPromocji=PromocjeNaProdukty.PromocjaIDpromocji;");
			while(resultSet.next()) {
				String IDproduktu = resultSet.getString("IDproduktu");
				String Produkt = resultSet.getString("Produkt");
				String Cena = resultSet.getString("Cena");
				String Promocja = resultSet.getString("Promocja");
				String Sztuki = resultSet.getString("DostepneSztuki");
				String Kategoria = resultSet.getString("Kategoria");

				String[] row = {IDproduktu ,Produkt, Cena, Promocja, Sztuki, Kategoria};
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

	    min = 0;
		max = 10;//podepnij do bazy // TODO Franciszek zabezpieczenie

		try{
			ResultSet resultSet = DbConnector.executeSelectQueryToConnection(connection, "SELECT COUNT(*) AS Liczba FROM Produkt;");
			resultSet.next();
			String maxAsText = resultSet.getString("Liczba");
			max = parseInt(maxAsText);
		}catch(SQLException e){
			e.printStackTrace();
		}

	    SpinnerModel value = new SpinnerNumberModel(0, min,max,1);
	    spinner = new JSpinner(value); 
	    spinner.setBounds(500, 150, 40, 40);
	    
	    
	    back = new JButton("POWR�T", bBG);
	    back.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    back.setBounds(500, 500, 240, 30);
	    back.setContentAreaFilled(false);
	    back.setBorderPainted(false);
	    back.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	MenuPracownik menu = new MenuPracownik();
        		menu.function(idKlienta);
        		fKA.setVisible(false); //you can't see me!
        		fKA.dispose(); //Destroy the JFrame object
        		return;
	        }
	    });
	    edit = new JButton("EDYTUJ", bBGe);
	    edit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    edit.setBounds(500, 450, 240, 30);
	    edit.setContentAreaFilled(false);
	    edit.setBorderPainted(false);
	    edit.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
		    	if(jt.getSelectedRow()== -1) {
	        		JOptionPane.showMessageDialog(fKA, "Wybierz wiersz");

	        	//System.out.println(jt.getSelectedRow());
		    	}else {
	        	JFrame tmp = new JFrame();
	            String name=JOptionPane.showInputDialog(tmp, "Zmiana nazwy", dtm.getValueAt(jt.getSelectedRow(), 0));
	           // String name=JOptionPane.showInputDialog(tmp,"Wpisz Nazw�");  
	            String amS=JOptionPane.showInputDialog(tmp, "Zmiana Ilo�ci", dtm.getValueAt(jt.getSelectedRow(), 2));
	            int am=-1;
	            while(am==-1) {
	            try {
	            am=Integer.parseInt(amS);
	            } catch (NumberFormatException e2) {
		            amS=JOptionPane.showInputDialog(tmp, "Zmiana Ilo�ci", dtm.getValueAt(jt.getSelectedRow(), 2));
	            }
	            }
	            String costS=JOptionPane.showInputDialog(tmp, "Zmiana ceny", dtm.getValueAt(jt.getSelectedRow(), 1));
	            int cost=-1;
	            while(cost==-1) {
	            try {
	            cost=Integer.parseInt(costS);
	            } catch (NumberFormatException e2) {
		            costS=JOptionPane.showInputDialog(tmp, "Zmiana ceny", dtm.getValueAt(jt.getSelectedRow(), 1));
	            }
	            }
	            System.out.print(cost);
	            String op=JOptionPane.showInputDialog(tmp, "Zmiana Opisu");


				JComboBox kat = new JComboBox();
				try{
					ResultSet resultSet = DbConnector.executeSelectQuery("SELECT Nazwa FROM Kategoria ORDER BY IDkategorii ASC LIMIT 5;");
					while(resultSet.next()){
						String Nazwa = resultSet.getString("Nazwa");
						kat.addItem(Nazwa);
					}
				}catch(SQLException e2){
					e2.printStackTrace();
				}

	            String[] options = { "OK"};

	            JOptionPane.showOptionDialog(null, kat, "Zmiana Kategorii",
	                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
	                    options[0]);
	            String kategoria = kat.getSelectedItem().toString();
	            System.out.print(kategoria);

	            JComboBox prom = new JComboBox();

				try{
					ResultSet resultSet = DbConnector.executeSelectQuery("SELECT IDPromocji, Nazwa FROM Promocja;");
					while(resultSet.next()){
						String IDpromocja = resultSet.getString("IDPromocji");
						String Nazwa = resultSet.getString("Nazwa");
						prom.addItem(IDpromocja+";"+Nazwa);
					}
				}catch(SQLException e2){
					e2.printStackTrace();
				}

	            JOptionPane.showOptionDialog(null, prom, "Zmiana Promocji",
	                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
	                    options[0]);
	            String promocja = prom.getSelectedItem().toString();
	            System.out.print(promocja);
	            
	            //"Nazwa", "Cena", "Promocja", "Dost�pne sztuki", "Kategoria"
	            //TODO BM edycja danych z tabeli produkty
	            jt.getModel().getValueAt(jt.getSelectedRow(), 5).toString(); // idProduktu kt�ry mamy zmienni� //mo�e by� 5, je�li liczy od 0
	            dtm.removeRow(jt.getSelectedRow());
		        Object[] row = { name, cost, promocja, am, kategoria  };
			    dtm.addRow(row);
	        }}
	    });
	    delete = new JButton("USU�", bBGd);
	    delete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    delete.setBounds(500, 400, 240, 30);
	    delete.setContentAreaFilled(false);
	    delete.setBorderPainted(false);
	    delete.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	((DefaultTableModel)jt.getModel()).removeRow(jt.getSelectedRow());
	        	//TODO BM usuwamy wybrany produkt po id
				String idproduktu = jt.getModel().getValueAt(jt.getSelectedRow(), 0).toString();// idProduktu kt�ry mamy usun�� //mo�e by� 5, je�li liczy od 0

				System.out.println(idproduktu);

				//try{
					DbConnector.executeQuery("DELETE FROM PromocjeNaProdukty WHERE ProduktIDproduktu = "+idproduktu+";");
					DbConnector.executeQuery("DELETE FROM Ocena WHERE ProduktIDproduktu = "+idproduktu+";");
					DbConnector.executeQuery("DELETE FROM Egzemplarz WHERE czyDostepne = 1 AND ProduktIDproduktu = "+idproduktu+";");
					DbConnector.executeQuery("DELETE FROM Produkt WHERE IDproduktu = "+idproduktu+";");
					/*
					while(resultSet.next()){
						String Nazwa = resultSet.getString("Nazwa");
						//kat.addItem(Nazwa);
					}
					*/
				//}catch(SQLException e2){
				//	e2.printStackTrace();
				//}
	        }
	    });
	    dodaj = new JButton("DODAJ PRODUKT", bBG);
	    dodaj.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
	    dodaj.setBounds(500, 350, 240, 30);
	    dodaj.setContentAreaFilled(false);
	    dodaj.setBorderPainted(false);
	    dodaj.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	//kategoria, nazwa, sztuki, cena, opis
	        	JFrame tmp = new JFrame();
	            String name=JOptionPane.showInputDialog(tmp,"Wpisz Nazw�");  
	            String amS=JOptionPane.showInputDialog(tmp,"Wpisz Ilo��");
	            int am=-1;
	            while(am==-1) {
	            try {
	            am=Integer.parseInt(amS);
	            } catch (NumberFormatException e2) {
		            amS=JOptionPane.showInputDialog(tmp,"Wpisz Ilo��");
	            }
	            }
	            String costS=JOptionPane.showInputDialog(tmp,"Wpisz cen�");
	            int cost=-1;
	            while(cost==-1) {
	            try {
	            cost=Integer.parseInt(costS);
	            } catch (NumberFormatException e2) {
		            costS=JOptionPane.showInputDialog(tmp,"Wpisz Cen�");
	            }
	            }
	            System.out.print(cost);
	            String op=JOptionPane.showInputDialog(tmp,"Wpisz opis");

				JComboBox kat = new JComboBox();
				try{
					ResultSet resultSet = DbConnector.executeSelectQuery("SELECT Nazwa FROM Kategoria ORDER BY IDkategorii ASC LIMIT 5;");
					while(resultSet.next()){
						String Nazwa = resultSet.getString("Nazwa");
						kat.addItem(Nazwa);
					}
				}catch(SQLException e2){
					e2.printStackTrace();
				}

	            
	            String[] options = { "OK"};

	            JOptionPane.showOptionDialog(null, kat, "Kategoria",
	                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
	                    options[0]);
	            String kategoria = kat.getSelectedItem().toString();
	            System.out.print(kategoria);

	            JComboBox prom = new JComboBox();

				try{
					ResultSet resultSet = DbConnector.executeSelectQuery("SELECT IDPromocji, Nazwa FROM Promocja;");
					while(resultSet.next()){
						String IDpromocja = resultSet.getString("IDPromocji");
						String Nazwa = resultSet.getString("Nazwa");
						prom.addItem(IDpromocja+";"+Nazwa);
					}
				}catch(SQLException e2){
					e2.printStackTrace();
				}

	            JOptionPane.showOptionDialog(null, prom, "Promocja",
	                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
	                    options[0]);
	            String promocja = prom.getSelectedItem().toString();
	            System.out.print(promocja);
	            
	            //"Nazwa", "Cena", "Promocja", "Dost�pne sztuki", "Kategoria"
		        Object[] row = { name, cost, promocja, am, kategoria  };
			    dtm.addRow(row);

				//TODO - DOdanie

	        }
	    });
	    
	    fKA.add(dodaj);
	    fKA.add(back);
	    fKA.add(edit);
	    fKA.add(delete);
	    fKA.add(spinner);
	    fKA.add(p);
	    System.out.println("myk");
	    fKA.add(kategoria);
	    fKA.pack();
	    fKA.setVisible(true);

	}
}
