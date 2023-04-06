package produit;

public class Poisson extends Produit {
	private String date;

	public Poisson(String date) {
		super("poisson", Unite.piece);
		this.date = date;
	}

	@Override
	public String description() {
		return ("Poisson pêchés " + date);
	}

	@Override
	public double calculerPrix(int prix) {
		return prix;
	}

}
