package villagegauloisold;

import personnages.Gaulois;
import produit.IProduit;

public interface IEtal<P extends IProduit> {

	boolean isEtalOccupe();

	Gaulois getVendeur();

	int getQuantite();

	P getProduit();

	void occuperEtal(Gaulois vendeur, P produit, int quantite);

	boolean contientProduit(P produit);

	int acheterProduit(int quantiteAcheter);

	void libererEtal();

	/**
	 * 
	 * @param produit
	 * @return donneesVente est un tableau de chaine contenant [0] : un boolean
	 *         indiquant si l'étal est occupé [1] : nom du vendeur [2] : produit
	 *         vendu [2] : quantité de produit à vendre au début du marché [4] :
	 *         quantité de produit vendu
	 */
	String[] etatEtal();

}