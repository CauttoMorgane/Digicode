import java.awt.Color;
import java.awt.Container;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

/* Interface d'affichage de la Connexion */

public class Authentification extends JFrame {

	private JLabel login,mdp;
	private JTextField login1;
	private JPasswordField mdp1;
	private JButton valider;
	
	public Authentification (){
		
		super();
		
		// Recuperation du contentPane
		Container contenu = this.getContentPane();
				
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Connexion");
		setBounds(400, 200, 400, 200);
		
		// Ajout du texte
		login = new JLabel("Login");
		login1 = new JTextField();		
		mdp = new JLabel("Mot de passe");
		mdp1 = new JPasswordField();		
		valider = new JButton("Valider");
	
		
		// Ajout des infos au ContentPane
		contenu.setLayout(null);		
		contenu.add(login);
		login.setBounds(20, 20, 100, 20);		
		contenu.add(login1);
		login1.setBounds(150, 20, 150, 20);	
		contenu.add(mdp); 
		mdp.setBounds(22, 55, 100, 20);		
		contenu.add(mdp1);
		mdp1.setBounds(150, 55, 150, 20);	
		
		contenu.add(valider);
		valider.setBounds(125, 100, 77, 20);		
		valider.addActionListener(new ValiderListener());
		this.setVisible(true);
		}	
	class ValiderListener extends JFrame implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				char[] pass = Authentification.this.mdp1.getPassword();
				String user = Authentification.this.login1.getText();
				AuthentificationUtil.login(pass, user);
				
			} catch (Exception ex){
				ex.printStackTrace();
			}
			
		}	
		}
	
}