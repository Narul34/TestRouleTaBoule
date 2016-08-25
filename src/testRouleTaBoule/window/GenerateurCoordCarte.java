package testRouleTaBoule.window;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import testRouleTaBoule.elements.*;

public class GenerateurCoordCarte {

	public static Element[][] element = new Element[30][30];
	public static ElementBoule laBoule = null;

	public static int startX, startY;

	// ========== CONSTRUCTEUR ============

	public GenerateurCoordCarte() {
		try {
			genereMap();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// ========== Fonction qui créé un tableau d'"Element" à partir d'un fichier texte ============

	public void genereMap() throws FileNotFoundException {
		int x = 0;
		int y = 0;

		Scanner sc = new Scanner(new FileReader("map.txt"));

		while (sc.hasNextLine()) {
			String ligne = sc.nextLine();

			for (int i = 0; i < ligne.length(); i++) {
				char charLigne = ligne.charAt(i);

				if (charLigne == 'X') {
					element[x / 30][y / 30] = new ElementLimite(new Coordonnees(x, y));
					// System.out.println("");

				} else if (charLigne == 'M') {
					element[x / 30][y / 30] = new ElementMur(new Coordonnees(x, y));
					// System.out.print("M");
				} else if (charLigne == 'P') {
					element[x / 30][y / 30] = new ElementPiege(new Coordonnees(x, y));
					// System.out.print("P");
				} else if (charLigne == 'S') {
					element[x / 30][y / 30] = new ElementStart(new Coordonnees(x, y));
					startX = x;
					startY = y;

					// System.out.println(bouleX);
					// System.out.print("S");
				} else if (charLigne == ' ') {
					element[x / 30][y / 30] = new ElementVide(new Coordonnees(x, y));
					// System.out.print(" ");
				}

				x += 30;
			}
			y += 30;
			x = 0;
			// System.out.print("\r");
		}
		sc.close();
		System.out.println("fin generation coordonnees");
	}

}
