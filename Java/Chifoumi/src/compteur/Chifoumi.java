package compteur;

import java.util.Scanner;
import java.util.Random;

public class Chifoumi {
	private Random randomGenerator = new Random();
	private int choixJoueur;
	private int choixMachine;
	Scanner sc;
	String list[] = { "Caillou", "Papier", "Ciseaux" };

	public Chifoumi() {
		sc = new Scanner(System.in);
	}

	public void getChoixMachine() {
		choixMachine = randomGenerator.nextInt(list.length);
	}

	public void getChoixJoueur() {
		afficheChoix();

	}

	public void afficheChoix() {
		System.out.print("Taper votre choix (0 - Caillou, 1 - Papier, 2 - Ciseaux): ");
		choixJoueur = sc.nextInt();
		while (choixJoueur != 0 && choixJoueur != 1 && choixJoueur != 2) {
			System.out.print("entre (0 - Caillou, 1 - Papier, 2 - Ciseaux): ");
			choixJoueur = sc.nextInt();
		}
	}

	public int resultatJeu() {
		getChoixMachine();
		getChoixJoueur();

		if (choixMachine == choixJoueur) {
			System.out.println("Egalité");
			return 0;
		} else if ((choixMachine == 0 && choixJoueur == 1) || (choixMachine == 1 && choixJoueur == 2)
				|| (choixMachine == 2 && choixJoueur == 0)) {
			System.out.println("Gagné");
			return 1;
		} else if ((choixMachine == 1 && choixJoueur == 0) || (choixMachine == 2 && choixJoueur == 1)
				|| (choixMachine == 0 && choixJoueur == 2)) {
			System.out.println("Perdu");
			return 2;
		} else
			return 3;
	}

	public static void main(String argv[]) {
		Chifoumi ch = new Chifoumi();
		System.out.println("Combien de parties ? ");
		Scanner sc = new Scanner(System.in);
		int nombre_de_parties = sc.nextInt();
		int compteurMachine = 0;
		int compteurJoueur = 0;

		for (int i = 0; i < nombre_de_parties; i++) {
			int res = ch.resultatJeu();
			if (res == 1) {
				compteurJoueur++;
			}
			if (res == 2) {
				compteurMachine++;

			}
		}
		System.out.println("compteurMachine : " + compteurMachine);
		System.out.println("compteurJoueur : " + compteurJoueur);

		if (compteurMachine > compteurJoueur) {
			System.out.println("-------Vous avez perdu-------");
		} else if (compteurMachine < compteurJoueur) {
			System.out.println("-------Vous avez gagné-------");
		} else {
			System.out.println("-------Egalite-------");

		}
	}
}