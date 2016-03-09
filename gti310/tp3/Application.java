package gti310.tp3;

import gti310.tp3.parser.Chemin;
import gti310.tp3.parser.FichierParser;

/**
 * The Application class defines a template method to call the elements to
 * solve the problem Unreal-Networks is façing.
 * 
 * @author François Caron <francois.caron.7@ens.etsmtl.ca>
 */
public class Application {

	/**
	 * The Application's entry point.
	 * 
	 * The main method makes a series of calls to find a solution to the
	 * problem. The program awaits two arguments, the complete path to the
	 * input file, and the complete path to the output file.
	 * 
	 * @param args The array containing the arguments to the files.
	 */
	public static void main(String args[]) {
		System.out.println("Unreal Networks Solver !");
		
		//instancier le parser
		FichierParser myParser = new FichierParser();
		Chemin chemin = (Chemin) myParser.parse(args[0]);
		
		//TEST
		System.out.println("nb de sommet : "+chemin.getNbDeSommet());
		System.out.println("sommet de départ : "+chemin.getSommetDepart());
		String tab[][]=chemin.getTableau();
		int i =0;
		while(tab[i][0] !=null)
		{
				String source = tab[i][0];
				String desti = tab[i][1];
				System.out.println(i+"   source : "+source+" dest. : "+desti);
			i++;
		}
		
	}
}
