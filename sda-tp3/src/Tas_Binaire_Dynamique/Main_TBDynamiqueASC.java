package Tas_Binaire_Dynamique;
import analysis.Analyzer;

public class Main_TBDynamiqueASC {

	public static void main(String[] args) throws DisplayException {

		TasBinaireDinamique tasBinaireDynamique = new TasBinaireDinamique();

		// Analyse du temps pris par les opérations.
		Analyzer time_analysis = new Analyzer();
		// Analyse du nombre de copies faites par les opérations.
		Analyzer copy_analysis = new Analyzer();

		// Analyse de l'espace mémoire inutilisé.
		Analyzer memory_analysis = new Analyzer();
		long before, after;
	
		
		// insert number increased
		for (int i = 0; i < 10000; i++) {
			before = System.nanoTime();
			tasBinaireDynamique.inserer(i);
			after = System.nanoTime();

			// Enregistrement du temps pris par l'opération
			time_analysis.append(after - before);
										
			// Enregistrement du nombre de copies efféctuées par l'opération.
			// S'il y a eu réallocation de mémoire, il a fallu recopier tout le tableau.
			
			copy_analysis.append(tasBinaireDynamique.nbPermutation * 2 + tasBinaireDynamique.Size());
	
			
			// Enregistrement de l'espace mémoire non-utilisé.
			memory_analysis.append(	tasBinaireDynamique.Size()	);
		}

		
        // Affichage de quelques statistiques sur l'expérience.
        System.err.println("Total cost : "+time_analysis.get_total_cost());
        System.err.println("Average cost : "+time_analysis.get_average_cost());
        System.err.println("Variance :"+time_analysis.get_variance());
        System.err.println("Standard deviation :"+time_analysis.get_standard_deviation());
        
        
        // Sauvegarde les données de l'expérience: temps et nombre de copies effectuées par opération.
        time_analysis.save_values("Tas_Binaire_Dynamique_time_java_croissant.plot");
        copy_analysis.save_values("Tas_Binaire_Dynamique_copy_java_croissant.plot");
        memory_analysis.save_values("Tas_Binaire_Dynamique_memory_java_croissant.plot");
	
		tasBinaireDynamique.afficheTab();
	}

}
