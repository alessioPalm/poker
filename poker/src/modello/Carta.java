package modello;

public class Carta {

	private int id;
	private int idMano;
	private String valore;
	private String seme;
	
	
	public Carta () {
		
	}
	
	public Carta (String valore, String seme) {
		this.valore = valore;
		this.seme = seme;
	}


	public String getValore() {
		return valore;
	}

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdMano() {
		return idMano;
	}


	public void setIdMano(int idMano) {
		this.idMano = idMano;
	}


	public void setValore(String valore) {
		this.valore = valore;
	}


	public void setSeme(String seme) {
		this.seme = seme;
	}


	public String getSeme() {
		return seme;
	}
	
	@Override
	public boolean equals(Object o) {
		Carta carta = (Carta)o;
		return carta.getValore() == this.valore && carta.getSeme() == this.seme;
	}
	@Override
	public int hashCode() {
		
		int codeValore = valore.hashCode();
		int codeSeme = seme.hashCode();
		
		return codeValore + codeSeme;
	}

	@Override
	public String toString() {
		return "Carta [valore=" + valore + ", seme=" + seme + "]";
	}
	
	
}
