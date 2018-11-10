/**
 * @author florian trebes
 * @version 1.0
 * EXERCICE 2.3 DU TP DE PROGRAMMATION CONCURRENTE
 * 
 * Consommateur Class / Implémente Runnable
 */

package trebes.files;

import trebes.fenetre.*;
import javax.swing.*;
import java.awt.*;


public class Consommateur implements Runnable{

	//Variable pour liste et pour temps de repos
	private Liste liste;
	private long t;
	private JLabel label = new JLabel();
	
	//Constructeur avec la liste comme paramètre + temps de repos en ms
	public Consommateur(Liste liste,long t){
		this.liste=liste;
		this.t=t;
	}
	
	@Override
	public void run() {
		
		//CREATION D'UN JLABEL ET JPANEL POUR CHAQUE INSTANCE DE CONSOMMATEUR
		Font police = new Font("Courrier New", Font.BOLD, 12);
		label = new JLabel();
		label.setFont(police);
		label.setHorizontalAlignment(JLabel.LEFT);
		label.setVerticalAlignment(JLabel.CENTER);
		label.setPreferredSize(new Dimension(780, 20));
	    JPanel consEcran = new JPanel();	  
	    consEcran.setPreferredSize(new Dimension(800, 30));
	    consEcran.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	    consEcran.setLocation(0, 0);
	    consEcran.add(label);
	    
	    //METHODE STATIQUE DE FENETRE POUR AJOUT A LA FENETRE
	    Fenetre.addList(consEcran);
	    
	    
			try {
				for(;;) {
						int i = liste.delete();
						//Affichage de l'entier supprimé et du ID de Thread Consommateur
						String str = "("+Thread.currentThread().getId()+") - Suppression de l'entier : "+i;
						//System.out.println(str);
						Fenetre.updateList(liste.toString());
						//Repos
						label.setText(str + "- Repos "+t+" ms");
						Thread.sleep(t);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
