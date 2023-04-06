package produit;

public interface IProduit {

	String getNom();

	Unite getUnite();

	String description();

	double calculerPrix(int prix);

}