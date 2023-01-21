public class GrapheMA {
	private int nbNoeuds;
	private Boolean[][] matrice;
	
	//Constructeur
	public GrapheMA(int noeuds) {
		this.nbNoeuds=noeuds;
		this.matrice  = new Boolean[nbNoeuds][nbNoeuds];
		for(int i=0; i <nbNoeuds; i++) {
			for(int j=0; j <nbNoeuds; j++) {
				matrice[i][j] = false;
			}
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
		matrice[s1-1][s2-1]=true;
	}
	
	/*
	 * @summary - savoir si un arc est dans la matrice
	 * @param s1 - sommet de départ
	 * @param s2 - successeur de s1
	 * @return - vrai ou faux 
	 */
	public boolean aArc(int s1, int s2) {
		return matrice[s1-1][s2-1];
	}
	
	/*
	 * @summary - donne le nombre de successeurs d'un sommet
	 * @param sommet - le sommet en question
	 * @return - le nb de succeseeurs 
	 */
	public int dOut(int s) {
		int compteur=0;
		for(int i=0; i <nbNoeuds; i++) {
			if(matrice[s-1][i]==true) {
				compteur++;
			}
		}
		return compteur;
	}
	
	/*
	 * @summary - donne le nombre de prédecesseurs d'un sommet
	 * @param sommet - le sommet en question
	 * @return - le nb de prédecesseurs 
	 */
	public int dIn(int s) {
		int compteur=0;
		for(int i=0; i <nbNoeuds; i++) {
			if(matrice[i][s-1]==true) {
				compteur++;
			}
		}
		return compteur;
	}
	
	/*
	 * @summary - fonction toString pour la matrice
	 */
	public String toString() {
		String strMatrice= "";
		for(Boolean[] ligne : matrice) {
			String strLigne = "";
			for(Boolean arc : ligne) {		 
				if(arc == true) {
					strLigne=strLigne+"1 ";
				}
				else {
					strLigne=strLigne+"0 ";
				}
			}
			strMatrice=strMatrice+strLigne+"\n";
		}
		return strMatrice;
	}
}
