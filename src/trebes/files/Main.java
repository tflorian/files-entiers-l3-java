package trebes.files;


/**
 * @author florian trebes
 * @version 1.0
 * EXERCICE 2.3 DU TP DE PROGRAMMATION CONCURRENTE
 * 
 * MAIN
 */

import trebes.fenetre.*;

public class Main {
		
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Liste liste = new Liste();
		
		Fenetre fen = new Fenetre(liste);
		
		//Création  du Thread de la Classe Producteur et lancement
		///Producteur(Liste liste,long repos)///
		Producteur producteur = new Producteur(liste,200);
		Thread thProducteur = new Thread(producteur);
		thProducteur.start();
				
		//Création des Threads de la Classe Consommateur avec définition du temps de repos
		///Consommateur(Liste liste,long repos)///
		Consommateur con = new Consommateur(liste,1000);
		Consommateur con1 = new Consommateur(liste,1000);
		Consommateur con2 = new Consommateur(liste,1000);
		Consommateur con3 = new Consommateur(liste,1000);
		Thread thCon = new Thread(con);
		Thread thCon1 = new Thread(con1);
		Thread thCon2 = new Thread(con2);
		Thread thCon3 = new Thread(con3);
				
		//Lancement des 4 Threads Consommateurs
		thCon.start();		
		thCon1.start();
		thCon2.start();
		thCon3.start();
		
	}

}
