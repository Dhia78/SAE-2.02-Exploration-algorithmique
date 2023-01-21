package algo;

import java.util.ArrayList;
import java.util.Collections;

import algo.exceptions.ArcNegatifEx;
import algo.exceptions.NoPathEx;
import graphe.IGraphe;

public class Dijkstra {
	private static final int INFINI= Integer.MAX_VALUE;
	private static final int NULL=0;
		
		
	private IGraphe g;
	private int depart;
	private int arrivee;
	private ArrayList<Integer> sommetsMarques;
	private int[] distance;
	private int[] predecesseur;
	private ArrayList<Integer> chemin;
		
		public Dijkstra(IGraphe g,int depart, int arrivee) {
			this.g= g;
			this.depart= depart;
			this.arrivee= arrivee;
			this.chemin = new ArrayList<>();
			 
			distance = new int[g.getNbSommets()];//connaitre la longieur du chemin entre un sommet et le depart 
			predecesseur =new int[g.getNbSommets()];// connaitre le dernier predecesseur pour le plus court chemin 
			sommetsMarques= new ArrayList<>();
			sommetsMarques.add(depart);//mettre une valeur de depart aux sommmets marqués
			
			for (int i=1;i<=g.getNbSommets();i++) {
				if (i==depart) {
					distance[i-1]=0;
					predecesseur[i-1]=NULL;
				}
				else{
					distance[i-1]=g.getValuation(depart, i);
					if(g.aArc(depart, i)) {
						predecesseur[i-1]= depart;
					}
					else {
						predecesseur[i-1]=NULL;
					}
				}
			}
			
			
			
		}
		public int dijkstra(ArrayList<Integer> pcc) {
			while(!sommetsMarques.contains(arrivee)) {
				int nouveauSommet= NULL;
				int distanceNouveauSommet= INFINI;
				
				for (int i=0;i<g.getNbSommets();i++) {
					if (!sommetsMarques.contains(i+1) && distance[i]< distanceNouveauSommet) {
						distanceNouveauSommet= distance[i];
						nouveauSommet=i+1;
					}
				}
				if (nouveauSommet == 0)
					throw new NoPathEx();

				sommetsMarques.add(nouveauSommet);
				
				for (int i=0;i<g.getNbSommets();i++) {
					if (g.getValuation(nouveauSommet, i+1) < 0)
						throw new ArcNegatifEx();
					else if (g.aArc(nouveauSommet, i+1) && !sommetsMarques.contains(i+1) && distance[i] > distance[nouveauSommet-1] + g.getValuation(nouveauSommet, i+1)) {
						distance[i] = distance[nouveauSommet-1] + g.getValuation(nouveauSommet, i+1);
						predecesseur[i]= nouveauSommet;
					}
				}
			}
			chemin.clear();
			chemin.add(arrivee);
			while (!chemin.contains(depart)) {
				chemin.add(predecesseur[chemin.get(chemin.size()-1) - 1]);//arborescence du chemin
			}
			chemin.add(distance[arrivee-1]);//donner la taille du plus court chemin et le chemin 
			Collections.reverse(chemin);
			for (int i = 1; i < chemin.size(); i++){
				pcc.add(chemin.get(i));
			}
			return chemin.get(0);
		}
		@Override
		public String toString() {
			String renvoie;
			renvoie = "Dijkstra \r\n"+String.valueOf(chemin.get(0)+"\r\n");
			for (int i = 1; i < chemin.size(); i++) {
				renvoie += String.valueOf(chemin.get(i))+" ";
			}
			return renvoie;
		}

	}

