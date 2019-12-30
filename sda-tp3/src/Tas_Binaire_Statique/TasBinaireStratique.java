package Tas_Binaire_Statique;

public class TasBinaireStratique {

	private int tab[];
	private int nb_Element; /* Size */
	private int capacitie;  /* Tab.length */
	public int nbPermutation ;
	
	public TasBinaireStratique(int taille_Fixe) {
		tab = new int[taille_Fixe];
		capacitie = taille_Fixe;
		nb_Element = 0;
	}

	public int size(){
		return this.nb_Element;
	}
	
	public int capacity(){
		return this.capacitie;
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

	public void entasser(int i) {
		int g = gauche(i);
		int d = droite(i);
		int min;

		if ((g <= this.nb_Element) && (this.tab[g] > this.tab[i]))
			min = g;
		else
			min = i;

		if ((d <= this.nb_Element) && (this.tab[d] > this.tab[i]))
			min = d;
		else
			min = i;

		if (min != i) {
			this.permuter(i, min);
			entasser(min);
		}
	}

	public void permuter(int x, int y) {
		nbPermutation = nbPermutation + 1 ;
		int tmp = this.tab[x];
		this.tab[x] = this.tab[y];
		this.tab[y] = tmp;
	}

	public int minimum(int[] tab) {
		return this.tab[0];
	}

	public int extraire_Min(int tab[]) throws DisplayException {

		if (this.nb_Element < 1)
			throw new DisplayException("la file est vide");

		int min = this.tab[0];
		this.tab[0] = this.tab[this.nb_Element - 1];
		this.nb_Element = this.nb_Element - 1;
		entasser(0);
		return min;
	}

	public void diminuerCle(int i, int k) throws DisplayException {
		// if(k > this.tab[i] )
		// throw new DisplayException("nouvelle valeur plus grande que la valeur actuelle");

		this.tab[i] = k;

		while ((i > 0) && (this.tab[this.pere(i)] > this.tab[i])) {
			this.permuter(i, pere(i));
			i = pere(i);
		}
	}

	public void inserer(int k) throws DisplayException {
		if (this.nb_Element == this.tab.length)
			throw new DisplayException("Impossible de dépasser la taille maximale du tableau");

		this.nb_Element = this.nb_Element + 1;
		diminuerCle(nb_Element - 1, k);
	}

	public void afficheTab() {
		String tab_string = "le Tas binaire Statique est : \n\n [ " + this.tab[0];
		for (int i = 1; i < nb_Element; i++)
			tab_string = tab_string + " ,  " + this.tab[i] + " ";
		tab_string = tab_string + " ]";
		System.out.println(tab_string);
	}

	public static void main(String[] args) throws DisplayException {

		TasBinaireStratique tas_binaire = new TasBinaireStratique(12);

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
