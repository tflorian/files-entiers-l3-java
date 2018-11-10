/**
 * @author florian trebes
 * @version 1.0
 * EXERCICE 2.3 DU TP DE PROGRAMMATION CONCURRENTE
 * 
 * UI
 */

package trebes.fenetre;

import javax.swing.*;

import trebes.files.*;

import java.awt.*;

public class Fenetre extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JLabel ecran = new JLabel("0");
	private static JLabel prod = new JLabel();
	private static JPanel container = new JPanel();
	
	private Button bouton = new Button();
	
	public Fenetre(Liste liste) {
		this.setTitle("Files d'attente");
		this.setSize(800, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		initComposant();
		this.setContentPane(container);
		this.setVisible(true);
		}
	
	private void initComposant(){
	    //On définit la police d'écriture à utiliser
	    Font police = new Font("Courrier New", Font.BOLD, 12);
	    //Création texte Liste
	    ecran = new JLabel();
	    ecran.setFont(police);
	    ecran.setHorizontalAlignment(JLabel.LEFT);
	    ecran.setVerticalAlignment(JLabel.CENTER);
	    ecran.setPreferredSize(new Dimension(780, 20));
	    JPanel panEcran = new JPanel();	  
	    panEcran.setPreferredSize(new Dimension(800, 30));
	    panEcran.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    panEcran.setLocation(0, 0);
	    panEcran.add(ecran);
	    
	    //Création texte Producteur
	    prod = new JLabel();
	    prod.setFont(police);
	    prod.setHorizontalAlignment(JLabel.LEFT);
	    prod.setVerticalAlignment(JLabel.CENTER);
	    prod.setPreferredSize(new Dimension(780, 20));
	    JPanel prodEcran = new JPanel();	  
	    prodEcran.setPreferredSize(new Dimension(800, 30));
	    prodEcran.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    prodEcran.setLocation(0, 0);
	    prodEcran.add(prod);
	    

	    container.add(panEcran);
	    container.add(prodEcran);
	    
	    bouton = new Button();
	    bouton.setLabel("Start");

	    
	    
	}
	public static void updateList(String str) {
		ecran.setText(str);
	}
	public static void updateProd(String str) {
		prod.setText(str);
	}
	public static void addList(JPanel p) {
		container.add(p);
	}

}