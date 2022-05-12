package tests.pcc;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.jupiter.api.Test;

import graphe.AlgoPlusCourt;
//import graphe.ihm.GraphImporter;
import graphe.GrapheImporter;
import pcc.PCCDijkstra;

class PlusCourtTest {
	@Test
	void testDijkstra() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCDijkstra();
		assertTrue(GrapheImporter.comparer("graphes\\ac\\g-1000-1.txt", "reponses\\ac\\r-1000-1.txt", algo));	
	}

}
