package gti310.tp3.parser;

public class Chemin {

	private int nbSommets, sommetDepart;
	private String tab[][] = new String[70][70];

	public Chemin(int nbSommets, int sommetDepart) {
		
		this.nbSommets = nbSommets;
		this.sommetDepart = sommetDepart;
	}
	
	public int getNbDeSommet (){
		return nbSommets;
	}

	public int getSommetDepart (){
		return sommetDepart;
	}

	public void addDansTableau(String source, String destination, int index){
		//insere dans le tableau la source et la destination
		tab[index][0]=source;
		tab[index][1]=destination;
	}
	
	public String[][] getTableau(){
		return tab;
	}
}