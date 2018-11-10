/**
 * @author florian trebes
 * @version 1.0
 * EXERCICE 2.3 DU TP DE PROGRAMMATION CONCURRENTE
 * 
 * Producteur Class / Implémente Runnable
 */

package trebes.files;

import java.util.Random;

import trebes.fenetre.Fenetre;

public class Producteur implements Runnable {
	
	private Liste liste;
	private long t;
	
	//Constructeur de la classe avec la liste en paramètre
	public Producteur(Liste liste,long t){
		this.liste=liste;
		this.t=t;
	}
	
	@Override
	public void run() {
			try {
				for(;;) {
					Random r = new Random();
					int i=r.nextInt(100);
					//La ligne ci-dessous permet de débugguer l'ajout à la liste
					String msg = "Ajout OK, new : "+i+" Taille : "+liste.taille();
					//System.out.println(msg);
					Fenetre.updateList(liste.toString());
					liste.add(i);
					Fenetre.updateProd(msg+" - Repos : "+t+" ms");
					Thread.sleep(t);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
