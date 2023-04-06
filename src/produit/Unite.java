package produit;

public enum Unite {
	litre("l"), centilitre("cl"), millilitre("ml"), kilogramme("kg"), gramme("g"), piece("");

	private String sigle;

	private Unite(String sigle) {
		this.sigle = sigle;
	}

	public String getsigle() {
		return sigle;
	}

}
