package modello;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Mano {
	
	private int id;
	private  Set <Carta> insieme = new HashSet <Carta> ();
	private ArrayList <int []> lista = new ArrayList <int []>();


	public Mano (int id) {
		this.id=id;
	}
	
	public Mano () {
		
	}
	
	
	public void setInsieme(Set<Carta> insieme) {
		this.insieme = insieme;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Carta> getInsieme() {
		return insieme;
	}

	public void aggiungiCarta (Carta Carta) {
		insieme.add(Carta);
	}
	
	
	
}
