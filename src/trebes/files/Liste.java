/**
 * @author florian trebes
 * @version 1.0
 * EXERCICE 2.3 DU TP DE PROGRAMMATION CONCURRENTE
 * 
 * Liste Class / Avec Methodes Synchronisées
 */

package trebes.files;

import java.util.ArrayList;

import trebes.fenetre.Fenetre;

public class Liste {
	//Création d'une liste d'entiers
	private ArrayList<Integer> liste = new ArrayList<>();
	private boolean verrou = false;
	
	//Constructeur de la liste
	public Liste() {
		this.liste = new ArrayList<>();
	}
	
	//Méthode pour Thread Producteur / Ajout à la liste avec synchronisation selon sa taille
	public synchronized void add(int t) {
		while(liste.size()>=20) {
			try {Fenetre.updateProd("Producteur en attente");wait();}
			catch(InterruptedException e) {}
		}
		this.liste.add(t);
		notifyAll();
	}
	
	//Méthode pour Thread Consommateur / Suppression à la liste avec synchronisation selon la taille
	public synchronized int delete() {
		while(liste.size()==0) {
			try {wait();}
			catch(InterruptedException e) {}
		}
		int i = this.liste.get(0);
		this.liste.remove(0);
		notifyAll();
		return i;
	}
	
	//Méthode pour taille de la liste (utilisée pour Debugage)
	public int taille() {
		return liste.size();
	}
	
	public synchronized String toString() {
		while(verrou==true) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		verrou=true;
		String str = "File = <";
		for (Integer parcours : liste) {
			str += Integer.toString(parcours)+">,<";
		}
		verrou=false;
		notifyAll();
		return str;
		
	}
}
