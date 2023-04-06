package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
	private Gaulois chasseur;
	private int poids;

	public Sanglier(int poids, Gaulois chasseur) {
		super("sanglier", Unite.kilogramme);
		this.chasseur = chasseur;
		this.poids = poids;
	}

	@Override
	public String description() {
		return ("sanglier de " + poids + getUnite().getsigle() + " chassé par " + chasseur.getNom());
	}

	@Override
	public double calculerPrix(int prix) {
		return (prix * poids / 1000);
	}

}
