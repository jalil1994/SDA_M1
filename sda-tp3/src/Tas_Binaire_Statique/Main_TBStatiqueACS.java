package Tas_Binaire_Statique;
import analysis.Analyzer;
import structures.ArrayList;

import java.util.Random;

public class Main_TBStatiqueACS {

	public static void main(String[] args) throws DisplayException {

		 TasBinaireStratique tas_binaire = new TasBinaireStratique(10000);
	      
	        // Analyse du temps pris par les opérations.
	        Analyzer time_analysis = new Analyzer();
	        
	        // Analyse du nombre de copies faites par les opérations.
	        Analyzer copy_analysis = new Analyzer();
	        
		    // Analyse de l'espace mémoire inutilisé.
		    Analyzer memory_analysis = new Analyzer();
		    
	        long before = 0, after = 0;
	        
		
		for(int i = 0; i < 10000; i++)
		{
			before = System.nanoTime();
			tas_binaire.inserer(i);
			after = System.nanoTime();
		
	
	    // Enregistrement du temps pris par l'opération
        time_analysis.append(after - before);
        
        // Enregistrement du nombre de copies efféctuées par l'opération.
        // S'il y a eu réallocation de mémoire, il a fallu recopier tout le tableau.
        copy_analysis.append( 1 + tas_binaire.nbPermutation * 2);
        // Enregistrement de l'espace mémoire non-utilisé.
        memory_analysis.append( tas_binaire.capacity() - tas_binaire.size() );
		}
		
        // Affichage de quelques statistiques sur l'expérience.
        System.err.println("Total cost : "+time_analysis.get_total_cost());
        System.err.println("Average cost : "+time_analysis.get_average_cost());
        System.err.println("Variance :"+time_analysis.get_variance());
        System.err.println("Standard deviation :"+time_analysis.get_standard_deviation());

        
        // Sauvegarde les données de l'expérience: temps et nombre de copies effectuées par opération.
        time_analysis.save_values("Tas_Binaire_statique_time_java_croissant.plot");
        copy_analysis.save_values("Tas_Binaire_statique_copy_java_croissant.plot");
        memory_analysis.save_values("Tas_Binaire_statique_memory_java_croissant.plot");
	
	
		tas_binaire.afficheTab();
	}
}
