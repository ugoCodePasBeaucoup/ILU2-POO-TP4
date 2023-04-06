package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;

public class ScenarioTest {
	public static void main(String[] args) {
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Asterix", 6);

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		IEtal marche[] = new IEtal[3];
		Etal<Sanglier> etal1 = new Etal<>();
		Etal<Sanglier> etal2 = new Etal<>();
		Etal<Poisson> etal3 = new Etal<>();

		marche[0] = etal1;
		marche[1] = etal2;
		marche[2] = etal3;

		etal1.installerVendeur(asterix, sangliersAsterix, 10);
		etal2.installerVendeur(obelix, sangliersObelix, 8);
		etal3.installerVendeur(ordralfabetix, poissons, 7);

		System.out.println("\n==== ETAT MARCHE DEBUT ====\n");

		System.out.println(etal1.etatEtal());
		System.out.println(etal2.etatEtal());
		System.out.println(etal3.etatEtal());

		int nbSanglier = 3;
		int nbSanglierAchete = 0;
		while (nbSanglier > 0) {
			if (0 < (nbSanglierAchete = etal1.contientProduit("sanglier", nbSanglier))) {
				System.out.println("A l'étal 0 je paye " + etal1.acheterProduit(nbSanglierAchete) + " sous");
				nbSanglier -= nbSanglierAchete;
			} else if (0 < (nbSanglierAchete = etal2.contientProduit("sanglier", nbSanglier))) {
				System.out.println("A l'étal 1 je paye " + etal2.acheterProduit(nbSanglierAchete) + " sous");
				nbSanglier -= nbSanglierAchete;
			} else if (0 < (nbSanglierAchete = etal3.contientProduit("sanglier", nbSanglier))) {
				System.out.println("A l'étal 2 je paye " + etal3.acheterProduit(nbSanglierAchete) + " sous");
				nbSanglier -= nbSanglierAchete;
			}
		}

		System.out.println("\n==== ETAT MARCHE FIN ====\n");

		System.out.println(etal1.etatEtal());
		System.out.println(etal2.etatEtal());
		System.out.println(etal3.etatEtal());

	}

}