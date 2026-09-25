/* =========================================================================
   MAILLON 2 — JAVA : le moteur de calcul
   Complétez les quatre méthodes. Les classes Ligne, Resultat et Chargeur
   sont fournies : ne les modifiez pas.
       javac -encoding UTF-8 -d out src/*.java
       java -Dstdout.encoding=UTF-8 -cp out Tests     (les tests)
       java -Dstdout.encoding=UTF-8 -cp out Main      (la production)
   ========================================================================= */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Classement {

    /** Barème officiel des dix premiers. FOURNI — NE PAS MODIFIER. */
    public static final int[] BAREME = {25, 18, 15, 12, 10, 8, 6, 4, 2, 1};

    // 1. pointsPourPosition(position) : points marqués pour cette position.
    //    1 -> 25, 2 -> 18, ..., 10 -> 1. Au-delà de la 10e place : 0.
    //    Un abandon vaut la position 0, donc 0 point.
    public static int pointsPourPosition(int position) {
        // À COMPLÉTER
    	if (position == 1) return 25;
    	if (position == 2) return 18;
    	if (position == 3) return 15;
    	if (position == 4) return 12;
    	if (position == 5) return 10;
    	if (position == 6) return 8;
    	if (position == 7) return 6;
    	if (position == 8) return 4;
    	if (position == 9) return 2;
    	if (position == 10) return 1;
        return 0;
    }

    // 2. classementPilotes(lignes) : un Resultat par pilote, avec ses points,
    //    ses victoires (position 1) et ses 2e places, trié par :
    //    points décroissants, puis victoires, puis 2e places, puis nom (A→Z).
  public static List<Resultat> classementPilotes(List<Ligne> lignes) {
    
   
    Map<String, Resultat> parPilote = new HashMap<>();
    
    
    for (Ligne ligne : lignes) {
        
        // On récupère les infos de la ligne
        String nom = ligne.pilote();
        String ecurie = ligne.ecurie();
        int position = ligne.position();
        
        Resultat r = parPilote.get(nom);
        
        
        if (r == null) {
            r = new Resultat(nom, ecurie);   
            parPilote.put(nom, r);
        }
        
       
        r.points = r.points + pointsPourPosition(position);
        
        
        if (position == 1) {
            r.victoires = r.victoires + 1;
        }
        
        
        if (position == 2) {
            r.deuxiemes = r.deuxiemes + 1;
        }
    }
    
    
    List<Resultat> resultats = new ArrayList<>(parPilote.values());
    
    //  On trie la liste
    resultats.sort((a, b) -> {
      
        if (a.points != b.points) {
            return b.points - a.points;
        }
        
        if (a.victoires != b.victoires) {
            return b.victoires - a.victoires;
        }
        
        if (a.deuxiemes != b.deuxiemes) {
            return b.deuxiemes - a.deuxiemes;
        }
       
        return a.nom.compareTo(b.nom);  
    });
    
    
    return resultats;
}

    // 3. classementEcuries(pilotes) : additionne les points, victoires et
    //    2e places des pilotes de chaque écurie. Même ordre de tri.
    public static List<Resultat> classementEcuries(List<Resultat> pilotes) {
    
        // 1) Dictionnaire : nom de l'écurie → Resultat
        Map<String, Resultat> parEcurie = new HashMap<>();
        
        // 2) On parcourt chaque pilote
        for (Resultat p : pilotes) {
            
            // 3) On récupère l'écurie du pilote, ou on la crée
            Resultat r = parEcurie.get(p.ecurie);
            if (r == null) {
                r = new Resultat(p.ecurie, "");
                parEcurie.put(p.ecurie, r);
            }
            
            // 4) On additionne les stats du pilote à celles de l'écurie
            r.points    += p.points;
            r.victoires += p.victoires;
            r.deuxiemes += p.deuxiemes;
        }
        
        // 5) On convertit le dictionnaire en liste
        List<Resultat> resultats = new ArrayList<>(parEcurie.values());
        
        // 6) On trie (mêmes critères que les pilotes)
        resultats.sort((a, b) -> {
            if (a.points != b.points) return b.points - a.points;
            if (a.victoires != b.victoires) return b.victoires - a.victoires;
            if (a.deuxiemes != b.deuxiemes) return b.deuxiemes - a.deuxiemes;
            return a.nom.compareTo(b.nom);
        });
        
        // 7) On renvoie la liste triée
        return resultats;
    }

    // 4. positionMoyenne(lignes, pilote) : moyenne des positions de ce pilote,
    //    ABANDONS EXCLUS, arrondie à 2 décimales. 0 s'il n'a jamais terminé.
    //    Ex. positions 1, 2 et un abandon -> 1.5
    public static double positionMoyenne(List<Ligne> lignes, String pilote) {
        // À COMPLÉTER
       
    
    // 1) Accumulateurs : somme des positions, et nombre de courses terminées
    int somme = 0;
    int nbCourses = 0;
    
    // 2) On parcourt chaque ligne (course)
    for (Ligne ligne : lignes) {
        
        // 3) On ne garde que les courses de CE pilote
        if (ligne.pilote().equals(pilote)) {
            
            // 4) On ignore les abandons (position 0)
            if (ligne.position() != 0) {
                somme += ligne.position();
                nbCourses++;
            }
        }
    }
    
    // 5) Si aucune course terminée → 0
    if (nbCourses == 0) {
        return 0;
    }
    
    // 6) Moyenne arrondie à 2 décimales
    double moyenne = (double) somme / nbCourses;
    return Math.round(moyenne * 100.0) / 100.0;
}
}
