import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ChoixSalle extends JFrame implements ActionListener{
	
	  JLabel label;
	  JComboBox combo;
	  JButton select;
	  String liste[] = new String[3];
	  int i;
	  String info[] = new String[6];
	  String nomS;
	  
	  
	  public ChoixSalle() {
			NomSalle();
			
			Container contenu = this.getContentPane();
			
			setTitle("Choix Salle");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setLocationRelativeTo(null);
			setBounds(400, 200, 400, 200);
			
			label = new JLabel("Salle :");
			combo = new JComboBox(liste);
			select = new JButton("Selectionner");
			
			contenu.setLayout(null);		
			contenu.add(label);
			label.setBounds(20, 20, 100, 20);		
			contenu.add(combo);
			combo.setBounds(150, 20, 150, 20);
			contenu.add(select);
			select.setBounds(125, 100, 77, 20);	
			select.addActionListener(this);
			this.setVisible(true);
			
	  }		
			
	public void NomSalle() {
		
		// Objets pour se co BDD
	    Connection conn;
	    final String DB_DRIVER = "com.mysql.jdbc.Driver";
	    final String DB_CONNECTION = "jdbc:mysql://localhost:3306/digicode";
	    final String DB_USER = "root";
	    final String DB_PASSWORD = "";
	    // Objets PreparedState +Result
	    PreparedStatement statement;
	    ResultSet resultat;
	    	
	        // Manipulation
	    try
	     { 
		       // Creation de la requete
		       Class.forName ("com.mysql.jdbc.Driver").newInstance ();
		       conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/digicode","root","");
		       
		       statement = conn.prepareStatement("SELECT name_salle FROM salle");
		       
		       resultat = statement.executeQuery();
		       i=0;
	           while(resultat.next())
	           {
	        	   
	        	   liste[i]=resultat.getString(1);
					i++ ;
				}
				
			}
			
				catch (ClassNotFoundException e){
					System.out.println("Classe non trouvée");
				 }
				 catch (SQLException e){
					System.out.println("Erreur SQL " + e.getMessage());
				 }
				 catch (Exception e){
					System.out.println("Erreur");
				 }	
		}

	
	public void InfoSalle() {
		// Objets pour se co BDD
	    Connection conn;
	    final String DB_DRIVER = "com.mysql.jdbc.Driver";
	    final String DB_CONNECTION = "jdbc:mysql://localhost:3306/digicode";
	    final String DB_USER = "root";
	    final String DB_PASSWORD = "";
	    // Objets PreparedState +Result
	    PreparedStatement statement;
	    ResultSet resultat;
	    	
	        // Manipulation
	    try
	     { 
		       // Creation de la requete
		       Class.forName ("com.mysql.jdbc.Driver").newInstance ();
		       conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/digicode","root","");
		       
		       statement = conn.prepareStatement("SELECT * FROM salle WHERE name_salle = '"+ nomS +"'");
		       resultat = statement.executeQuery();
		       i=0;
	           while(resultat.next())
	           {
	        	   info[0] = resultat.getString(2);
	        	   info[1] = resultat.getString(3);
	        	   info[2] = resultat.getString(4);
	        	   info[3] = resultat.getString(5);
	        	   info[4] = resultat.getString(6);
	           }
			}
			
				catch (ClassNotFoundException e){
					System.out.println("Classe non trouvée");
				 }
				 catch (SQLException e){
					System.out.println("Erreur SQL " + e.getMessage());
				 }
				 catch (Exception e){
					System.out.println("Erreur");
				 }	
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		nomS = combo.getSelectedItem().toString();
		InfoSalle();	
		Digicode transfert = new Digicode(info);
		getContentPane().add(transfert);
		select.setEnabled(false);
		
		
	}	
}