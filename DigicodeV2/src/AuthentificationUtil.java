import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.FieldPosition;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
public abstract class AuthentificationUtil {
    // Methode
public static void login(char[] pass, String user) {
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
	       //Class.forName ("com.mysql.jdbc.Driver").newInstance ();
	       conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/digicode","root","");
	       
	       statement = conn.prepareStatement("SELECT mdp_user FROM user WHERE login_user='"+ user + "'");
	       
	       resultat = statement.executeQuery();
           if(resultat.next())
           {
        	   
            	String mdp = resultat.getString(1);
                String passString = "";
                //workaround gg Java
                for (int i = 0; i < pass.length; i++) {
					passString += pass[i];
				}
            		
            	if(mdp.equals(passString))
            	{
            		JOptionPane.showMessageDialog(null,"Connexion réussie ! ","Success",JOptionPane.PLAIN_MESSAGE);  
            			
            			ChoixSalle fun = new ChoixSalle();
            	}
            	else 
            	{                   
                    JOptionPane.showMessageDialog(null,"Mot de passe incorrect ! ","Error",1);
            	}
           }
           else 
           {                
        	   JOptionPane.showMessageDialog(null,"Login incorrect ! ","Error",1);
           }
            	
            	// Recup requete dans une variable
            	resultat = statement.executeQuery();
            	conn.close();
    	}
    	catch (SQLException e1) 
        {        
    		System.out.println(e1.getMessage());
        }
    }
}