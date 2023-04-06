package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import village.IVillage;
import villagegaulois.Etal;
import villagegaulois.IEtal;
import villagegauloisold.DepenseMarchand;

public class Scenario {

	public static void main(String[] args) {

		// TODO Partie 4 : creer de la classe anonyme Village
		IVillage village = new IVillage() {
			int tailleMarche = 3;
			IEtal[] marche = new IEtal[3];
			int nbVendeurs = 0;

			@Override
			public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix) {
				if (nbVendeurs < tailleMarche) {
					etal.installerVendeur(vendeur, produit, prix);
					marche[nbVendeurs] = etal;
					nbVendeurs++;
					return true;
				}
				return false;
			}

			@Override
			public DepenseMarchand[] acheterProduit(String produit, int quantiteSouhaitee) {
				DepenseMarchand[] listeDepenseMarchands = new DepenseMarchand[tailleMarche];
				int nbAchete = 0;
				int nbVendeurs = 0;
				int i = 0;
				int dispo = 0;
				while (nbAchete < quantiteSouhaitee && i < tailleMarche) {
					if (0 < (dispo = marche[i].contientProduit(produit, quantiteSouhaitee - nbAchete))) {
						nbAchete += dispo;
						listeDepenseMarchands[nbVendeurs++] = new DepenseMarchand(marche[i].getVendeur(), dispo,
								produit, marche[i].acheterProduit(dispo));
					}
					i++;
				}
				return listeDepenseMarchands;
			}

			@Override
			public String toString() {
				StringBuilder retour = new StringBuilder();
				for (int i = 0; i < tailleMarche; i++) {
					retour.append(marche[i].etatEtal());
					retour.append('\n');
				}
				return retour.toString();
			}

		};
		// fin

		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		DepenseMarchand[] depense = village.acheterProduit("sanglier", 3);

		for (int i = 0; i < depense.length && depense[i] != null; i++) {
			System.out.println(depense[i]);
		}

		System.out.println(village);

	}

}
