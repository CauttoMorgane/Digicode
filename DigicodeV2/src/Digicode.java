import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class Digicode extends JFrame {

	String nomS; 
	
	private JLabel name, digi, bat, jour, num ;
	private JLabel name1, digi1, bat1, jour1, num1 ;
	
	public Digicode (String info[]){
		
		super();
		
		// Recuperation du contentPane
		Container contenu = this.getContentPane();
				
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Information Salle");
		setBounds(400, 200, 400, 200);
		
		// Ajout du texte
		name = new JLabel("Salle de : ");
		name1 = new JLabel(info[0]);
		digi = new JLabel("Digicode : ");
		digi1 = new JLabel(info[1]);
		bat = new JLabel("Batiment : ");
		bat1 = new JLabel(info[2]);
		jour = new JLabel("Jours disponible : ");
		jour1 = new JLabel(info[3]);
		num = new JLabel("Salle Numero : ");
		num1 = new JLabel(info[4]);
		
	
		
		// Ajout des infos au ContentPane
		contenu.setLayout(null);
		
		name.setBounds(14, 5, 74, 14);
		contenu.add(name);
		name1.setBounds(129, 5, 123, 14);
		contenu.add(name1);
		
		digi.setBounds(14, 30, 74, 14);
		contenu.add(digi);
		digi1.setBounds(129, 30, 135, 14);
		contenu.add(digi1);
		
		bat.setBounds(14, 55, 74, 14);
		contenu.add(bat);
		bat1.setBounds(129, 55, 283, 14);
		contenu.add(bat1);
		
		jour.setBounds(14, 80, 74, 14);
		contenu.add(jour);
		jour1.setBounds(129, 80, 177, 14);
		contenu.add(jour1);
		
		num.setBounds(14, 105, 90, 14);
		contenu.add(num);
		num1.setBounds(129, 105, 123, 14);
		contenu.add(num1);
		
		
		this.setVisible(true);
		}	
}
