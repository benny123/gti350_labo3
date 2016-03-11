package gti310.tp3.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FichierParser implements Parser<Object>{
	
	private String temp[], line, nbSommet, sommetDepart, couranteLigne, source, destination;
	private int cptLigne = 0, index = 0;
	private BufferedReader lecteur = null;
	private Chemin chemin;

	@Override
	public Object parse(String filename) {
		
		try {
			lecteur = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try{
			try {
				// Lecture du fichier ligne par ligne. Cette boucle se termine quand la m�thode retourne la valeur null.
				while ((line = lecteur.readLine()) != null) {
					
					couranteLigne = line; //stock la ligne actuelle
					cptLigne++;	//compte le nb de lignes
					
					if(cptLigne == 1)
						nbSommet = couranteLigne;
					
					//seulement les 3 premieres lignes peuvent avoir moins de 2 caracteres (nb de sommets, valeur pour l'infini, sommet de d�part)
					if(couranteLigne.length() <= 2 && !couranteLigne.equals("$")){
						//System.out.println("First 3 : "+derniereLigne);
					}
					
					//v�rifie si le sommet de d�part est indiqu� dans le fichier
					if( cptLigne == 3 && couranteLigne.length() > 2  ){
						System.out.println("Il n'ya pas de sommet de d�part");
						sommetDepart = "0";
					}
					else
						sommetDepart = couranteLigne;
					
					//cr�e l'objet <E> qui est Chemin 
					if(cptLigne==3 )
						 chemin = new Chemin(Integer.parseInt(nbSommet),Integer.parseInt(sommetDepart));
		
					//s�pare la ligne par tabulation
					temp=line.split("\\t" );   
					if(temp.length == 3)
						separeLigneEnTabulation();
				}
			}finally {
				// dans tous les cas, on ferme nos flux
				lecteur.close();
			}
		}catch (IOException ioe){
			// erreur de fermeture des flux
			System.out.println("Fichier pas valide" );
			System.exit(0);
		}
		
		return chemin;
	}
	
	public void separeLigneEnTabulation(){
		index++;
		source = temp[0]; 
		destination = temp[1];
		chemin.addDansTableau(source, destination, index-1);
	}
}
