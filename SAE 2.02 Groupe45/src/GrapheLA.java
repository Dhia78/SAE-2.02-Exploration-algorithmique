import java.util.ArrayList;

public class GrapheLA {
	private int nbNoeuds;
	private ArrayList<ArrayList<Integer>> matrice;
	
	//Constructeur
	public GrapheLA(int noeuds) {
		this.nbNoeuds = noeuds;
		this.matrice = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i<nbNoeuds; i++) {
			matrice.add(new ArrayList<Integer>());
		}
	}
	
	/* 
	 * @return - renvoie le nb de sommet du graphe
	 */
	public int getNbNoeuds() {
		return nbNoeuds;
	}
	
	/*
	 * @summary - ajoute un are dans la matrice
	 * @param s1 - sommet de départ
	 * @param s2 - successeur de s1
	 */
	public void ajouterArc(int s1, int s2) {
		matrice.get(s1-1).add(s2);
	}
	
	/*
	 * @summary - savoir si un arc est dans la matrice
	 * @param s1 - sommet de départ
	 * @param s2 - successeur de s1
	 * @return - vrai ou faux 
	 */
	public boolean aArc(int s1, int s2) {
		for( int sommet : matrice.get(s1-1)) {
			if(sommet == s2) {
				return true; 
			}
		}
		return false;
	}
	
	/*
	 * @summary - donne le nombre de successeurs d'un sommet
	 * @param sommet - le sommet en question
	 * @return - le nb de succeseeurs 
	 */
	public int dOut(int sommet) {
		return matrice.get(sommet-1).size();
	}
	
	/*
	 * @summary - donne le nombre de prédecesseurs d'un sommet
	 * @param sommet - le sommet en question
	 * @return - le nb de prédecesseurs 
	 */
	public int dIn(int sommet) {
		int compteur = 0;
		for(int i = 0; i < nbNoeuds; i++) {
			for(int predecesseurs : matrice.get(i)) {
				if(predecesseurs == sommet) 
					compteur++;
			}
		}
		return compteur;
	}
	
	/*
	 * @summary - fonction toString pour la matrice
	 */
	public String toString() {
		String strMatrice = ""; 
		for( int i = 0; i < nbNoeuds; i++) {
			String strLigne = i+1 +" -> ";
			for(int predecesseurs : matrice.get(i)) {
				strLigne += predecesseurs + " ";
			}
			strMatrice+= strLigne+"\n";
		}
		return strMatrice;
	}
}
