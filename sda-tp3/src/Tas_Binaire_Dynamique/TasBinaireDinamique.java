package Tas_Binaire_Dynamique;

import java.util.ArrayList;

public class TasBinaireDinamique {

	public ArrayList<Integer> tab = new ArrayList<Integer>();
	public int nbPermutation;
	
	public TasBinaireDinamique() {
	}

	public int pere(int i) {
		return i / 2;
	}

	public int gauche(int i) {
		return 2 * i;
	}

	public int droite(int i) {
		return (2 * i) + 1;
	}
	
	public int Size(){
		return tab.size();
	}
	
	public void entasser(int i) {
		int g = gauche(i);
		int d = droite(i);
		int min;

		if ((g <= this.tab.size()) && (this.tab.get(g) > this.tab.get(i)))
			min = g;
		else
			min = i;

		if ((d <= this.tab.size()) && (this.tab.get(d) > this.tab.get(i)))
			min = d;
		else
			min = i;

		if (min != i) {
			this.permuter(i, min);
			entasser(min);
		}
	}

	public void permuter(int x, int y) {
		nbPermutation = nbPermutation + 1;
		int tmp = tab.get(x);
		this.tab.set(x, tab.get(y));
		this.tab.set(y, tmp);
	}

	public int minimum(int[] tab) {
		return this.tab.get(0);
	}

	public int extraire_Min(int tab[]) throws DisplayException {

		if (this.tab.size() == 0)
			throw new DisplayException("la file est vide");

		int min = this.tab.get(0);
		this.tab.set(0, this.tab.get(this.tab.size() - 1));

		entasser(0);
		return min;
	}

	public void diminuerCle(int i, int k) throws DisplayException {

		this.tab.add(k);

		while ((i > 0) && (this.tab.get(this.pere(i)) > this.tab.get(i))) {
			this.permuter(i, pere(i));
			i = pere(i);
		}
	}

	public void inserer(int k) throws DisplayException {

		diminuerCle(this.tab.size(), k);
	}	

	public void afficheTab() {
		String tab_string = "le Tas binaire est Dynamique est : \n\n [ " + this.tab.get(0);
		for (int i = 1; i < this.tab.size(); i++)
			tab_string = tab_string + " ,  " + this.tab.get(i) + " ";
		tab_string = tab_string + " ]";
		System.out.println(tab_string);
	}

	public static void main(String[] args) throws DisplayException {

		TasBinaireDinamique tas_binaire = new TasBinaireDinamique();

		tas_binaire.inserer(9);
		tas_binaire.inserer(16);
		tas_binaire.inserer(11);
		tas_binaire.inserer(4);

		tas_binaire.inserer(1);
		tas_binaire.inserer(7);
		tas_binaire.inserer(3);
		tas_binaire.inserer(5);
		
		tas_binaire.inserer(8);
		tas_binaire.inserer(6);
		tas_binaire.inserer(14);
		tas_binaire.inserer(2);

		tas_binaire.afficheTab();
	}
}
