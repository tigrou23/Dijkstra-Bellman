package tests.pcc;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.jupiter.api.Test;

import graphe.AlgoPlusCourt;
import graphe.ihm.GrapheImporter;
import pcc.PCCBellman;
import pcc.PCCDijkstra;

class PlusCourtTest {
	@Test
	void testDijkstra1() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCDijkstra();
		assertTrue(GrapheImporter.comparer("graphes\\ac\\g-10-1.txt", "reponses\\ac\\r-10-1.txt", algo));
	}

	@Test
	void testDijkstra2() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCDijkstra();
		assertTrue(GrapheImporter.comparer("graphes\\ac\\g-10-2.txt", "reponses\\ac\\r-10-2.txt", algo));
	}

	@Test
	void testDijkstra3() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCDijkstra();
		assertTrue(GrapheImporter.comparer("graphes\\ac\\g-10-3.txt", "reponses\\ac\\r-10-3.txt", algo));
	}

	@Test
	void testDijkstra4() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCDijkstra();
		assertTrue(GrapheImporter.comparer("graphes\\ac\\g-10-4.txt", "reponses\\ac\\r-10-4.txt", algo));
	}

	@Test
	void testDijkstra5() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCDijkstra();
		assertTrue(GrapheImporter.comparer("graphes\\ac\\g-10-5.txt", "reponses\\ac\\r-10-5.txt", algo));
	}

	@Test
	void testDijkstra6() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCDijkstra();
		assertTrue(GrapheImporter.comparer("graphes\\ac\\g-10-6.txt", "reponses\\ac\\r-10-6.txt", algo));
	}

	@Test
	void testDijkstra7() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCDijkstra();
		assertTrue(GrapheImporter.comparer("graphes\\ac\\g-10-7.txt", "reponses\\ac\\r-10-7.txt", algo));
	}

	@Test
	void testDijkstra8() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCDijkstra();
		assertTrue(GrapheImporter.comparer("graphes\\ac\\g-10-8.txt", "reponses\\ac\\r-10-8.txt", algo));
	}

	@Test
	void testDijkstra9() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCDijkstra();
		assertTrue(GrapheImporter.comparer("graphes\\ac\\g-10-9.txt", "reponses\\ac\\r-10-9.txt", algo));
	}

	@Test
	void testDijkstra10() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCDijkstra();
		assertTrue(GrapheImporter.comparer("graphes\\ac\\g-10-10.txt", "reponses\\ac\\r-10-10.txt", algo));
	}

	@Test
	void testBellman1() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCBellman();
		assertTrue(GrapheImporter.comparer("graphes\\sc\\g-10-1.txt", "reponses\\sc\\r-10-1.txt", algo));
	}

	@Test
	void testBellman2() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCBellman();
		assertTrue(GrapheImporter.comparer("graphes\\sc\\g-10-2.txt", "reponses\\sc\\r-10-2.txt", algo));
	}

	@Test
	void testBellman3() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCBellman();
		assertTrue(GrapheImporter.comparer("graphes\\sc\\g-10-3.txt", "reponses\\sc\\r-10-3.txt", algo));
	}

	@Test
	void testBellman4() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCBellman();
		assertTrue(GrapheImporter.comparer("graphes\\sc\\g-10-4.txt", "reponses\\sc\\r-10-4.txt", algo));
	}

	@Test
	void testBellman5() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCBellman();
		assertTrue(GrapheImporter.comparer("graphes\\sc\\g-10-5.txt", "reponses\\sc\\r-10-5.txt", algo));
	}

	@Test
	void testBellman6() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCBellman();
		assertTrue(GrapheImporter.comparer("graphes\\sc\\g-10-6.txt", "reponses\\sc\\r-10-6.txt", algo));
	}

	@Test
	void testBellman7() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCBellman();
		assertTrue(GrapheImporter.comparer("graphes\\sc\\g-10-7.txt", "reponses\\sc\\r-10-7.txt", algo));
	}

	@Test
	void testBellman8() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCBellman();
		assertTrue(GrapheImporter.comparer("graphes\\sc\\g-10-8.txt", "reponses\\sc\\r-10-8.txt", algo));
	}

	@Test
	void testBellman9() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCBellman();
		assertTrue(GrapheImporter.comparer("graphes\\sc\\g-10-9.txt", "reponses\\sc\\r-10-9.txt", algo));
	}

	@Test
	void testBellman10() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCBellman();
		assertTrue(GrapheImporter.comparer("graphes\\sc\\g-10-10.txt", "reponses\\sc\\r-10-10.txt", algo));
	}

	@Test
	void testDijkstra100() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCDijkstra();
		assertTrue(GrapheImporter.comparer("graphes\\ac\\g-100-1.txt", "reponses\\ac\\r-100-1.txt", algo));
	}

	@Test
	void testDijkstra1000() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCDijkstra();
		assertTrue(GrapheImporter.comparer("graphes\\ac\\g-1000-1.txt", "reponses\\ac\\r-1000-1.txt", algo));
	}

	@Test
	void testBellman100() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCBellman();
		assertTrue(GrapheImporter.comparer("graphes\\sc\\g-100-1.txt", "reponses\\sc\\r-100-1.txt", algo));
	}

	@Test
	void testBellman1000() throws NumberFormatException, FileNotFoundException, IOException {
		AlgoPlusCourt algo = new PCCBellman();
		assertTrue(GrapheImporter.comparer("graphes\\sc\\g-1000-1.txt", "reponses\\sc\\r-1000-1.txt", algo));
	}
}
