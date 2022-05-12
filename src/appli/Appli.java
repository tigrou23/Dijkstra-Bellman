package appli;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exception.ArcNegatifNulException;
import exception.CircuitEx;
import exception.NoPathEx;
import graphe.AlgoPlusCourt;
import graphe.Arc;
import graphe.GrapheLA;
import graphe.IGraphe;
import graphe.PCCBellman;
import graphe.PCCDijkstra;

public class Appli {
	public static void main(String[] args) throws NumberFormatException, FileNotFoundException, IOException {
		Arc df = new Arc();
		IGraphe g = importer(System.getProperty("user.dir")+ "/graphes/ac/g-100000-2.txt", df);
		int debut = 1;
		int fin = 194;
		AlgoPlusCourt a;
		List<Integer> liste = new ArrayList<>();
		try {
			a = new PCCBellman(g);
			a.cycle();
			try {
				System.out.println("Bellman sans circuit");
				liste = a.resoudre(debut, fin);
				System.out.println(a.getPoids());
				for(int i : liste)
					System.out.print(i + " ");
			}catch(NoPathEx p) {
				System.out.println("pas de chemin entre " + debut + " et " + fin);
			}
		}catch(CircuitEx c) {
			try {
				a = new PCCDijkstra(g);
				System.out.println("Dijkstra");
				liste = a.resoudre(debut, fin);
				System.out.println(a.getPoids());
				for(int i : liste)
					System.out.print(i + " ");
			}catch(NoPathEx p) {
				System.out.println("pas de chemin entre " + debut + " et " + fin);
			}catch(ArcNegatifNulException n) {
				System.out.println("Il existe des arcs nuls ou négatifs sur le graphe.");
			}
		}
		
		//System.out.print(g);
		//System.out.println("debut fin : "+ df.getSommet1() + " ==> "+ df.getSommet2());
		verifierGraphes();
	}

	public static void verifierGraphes() throws FileNotFoundException {
		IGraphe g;
		Arc df = new Arc(); 
		String dirStr = System.getProperty("user.dir")+ "/graphes/ac";
		//System.out.println("Working Directory = " + dirStr);
		File dir = new File(dirStr);
		  File[] directoryListing = dir.listFiles();
		  if (directoryListing != null) {
		    for (File child : directoryListing) {
		      //System.out.println(child);
		      g = importer(child, df);
		      //System.out.println(g.getNbNoeuds() + " sommets");
		      //System.out.println("debut et fin du chemin à trouver : "+ df.getSommet1()+ " ==> "+ df.getSommet2()+"\n");
		    }
		  } else {
		    //System.out.println("Erreur : "+ dirStr + " n'est pas un réperoire");
		  }
	}

	public static Arc parse(String string) {
		String[] parts = string.split(" ");
		int source, valuation, destination;
		try {  
			source = Integer.parseInt(parts[0]);
			valuation = Integer.valueOf(parts[1]);
			destination = Integer.parseInt(parts[2]);
		} catch (Exception e) {
			throw new IllegalArgumentException(string + " n'est pas un arc");
		}
		Arc a = new Arc(source, destination, valuation);
		return a;
	}
	
	private static IGraphe importer(File file, Arc df) throws FileNotFoundException {
		
		Scanner sc = new Scanner(file);
		String line;
		IGraphe g;
		if (! sc.hasNextLine()) {
			sc.close();
    		throw new IllegalArgumentException("Pas de graphe dans "+ file);
		}
		line = sc.nextLine();
		int nbNodes = Integer.parseInt(line.trim());
		g = new GrapheLA(nbNodes);
		Arc a;
		while (sc.hasNextLine()) {
			line = sc.nextLine();
			a = parse(line);
			if (sc.hasNextLine())
				g.ajouterArc(a.getSommet1(),  a.getSommet2(), a.getPoids());
			else {// la derniere ligne n'est pas un arc mais le debut et la fin du chemin à trouver
				df.set(a);
			}
		}
		sc.close();
		return g;		
	}
	
	private static IGraphe importer(String filepath, Arc df) 
								throws  NumberFormatException, IOException, FileNotFoundException {
		File file = new File(filepath);
		return importer(file, df);
      }
}
