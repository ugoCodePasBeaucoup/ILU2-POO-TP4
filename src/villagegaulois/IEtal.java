package villagegaulois;

import personnages.Gaulois;

public interface IEtal {
	<P> void installerVendeur(Gaulois vendeur, P[] produits, int prix);

	Gaulois getVendeur();

	double donnerPrix();

	int contientProduit(String produit, int quantiteSouhaitee);

	double acheterProduit(int quantiteSouhaitee);

	String etatEtal();
}
