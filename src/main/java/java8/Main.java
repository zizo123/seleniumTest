package java8;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		int tab[][] = new int[5][5];
		List<Integer> pivot = new ArrayList<>();
		int newTab[][] = new int[5][5];
		// Original Setting
		tab[0][3] = 1;
		tab[1][2] = 1;
		tab[2][2] = 1;
		tab[1][3] = 1;
		// tab[3][2] = 1;
		// Affichage Origin
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				System.out.print(tab[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}
		// Logic
		/*
		 * PARENT1: for (int i = 0; i < tab.length; i++) { for (int j = 0; j <
		 * tab.length; j++) { if (tab[i][j] == 1) { if (tab[i + 1][j] != 1 && tab[i +
		 * 1][j + 1] != 1 && tab[i][j + 1] != 1) { tab[i][j] = 0; break PARENT1; } } } }
		 */
		PARENT: for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				if (tab[i][j] == 1) {
					boolean cd1 = tab[i][j + 1] == 1 && tab[i][j + 2] == 1;
					boolean cd2 = tab[i + 1][j] == 1 && tab[i + 2][j] == 1;
					boolean cd3 = tab[i][j + 1] == 1 && tab[i + 1][j + 1] == 1;
					boolean cd4 = tab[i][j + 1] == 1 && tab[i + 1][j] == 1;
					boolean cd5 = tab[i + 1][j + 1] != 1 && tab[i + 1][j - 1] != 1;
					boolean cd6 = i < tab.length - 1 && j < tab.length - 1;
					if (cd1 || cd2 && cd5 && cd6) {
						newTab[i + 1][j] = 1;
						newTab[i + 1][j + 1] = 1;
						newTab[i + 1][j - 1] = 1;
						break PARENT;
					} else if (cd3 || cd4 && cd6) {
						newTab[i + 1][j + 1] = 1;
						break PARENT;
					}
				}
			}
		}
		System.out.println(pivot);

		// Affichage Origin
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab.length; j++) {
				System.out.print(tab[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}

		System.out.println("--------------------------------");

		// Affichage New
		for (int i = 0; i < newTab.length; i++) {
			for (int j = 0; j < newTab.length; j++) {
				System.out.print(newTab[i][j]);
				System.out.print("\t");
			}
			System.out.println();
		}

	}
}
