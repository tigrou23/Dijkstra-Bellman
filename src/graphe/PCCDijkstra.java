package graphe;

import java.util.ArrayList;

public class PCCDijkstra {

    private ArrayList<Integer> chemin;
    private int debut;
    private int fin;
    private IGraph graphe;


    public PCCDijkstra(IGraph g, int debut, int fin){
        chemin = new ArrayList<>();
        graphe = g;
        this.debut = debut;
        this.fin = fin;
    }

    public ArrayList<Integer> resoudre(){ 
        int pointSuivant = 0;   
        while(debut != fin){     
            Arc a = null;
            for(int i = 0; i<graphe.getNbNoeuds(); i++){
                if(a == null && graphe.aArc(debut, i))
                {
                    a= graphe.getArc(debut, i);
                    pointSuivant = i;
                }
                else if(graphe.aArc(debut, i) && graphe.getArc(debut, i).getPoids() < a.getPoids())
                {
                    a = graphe.getArc(debut, i);
                    pointSuivant = i;
                }
            }
            if(a == null)
            {
                chemin.remove(chemin.size()-1);
                debut = chemin.get(chemin.size()-1);
            }
            else{
                chemin.add(pointSuivant);
                debut = pointSuivant;
            }
            
            

        }

        return chemin;

        
    }
}
