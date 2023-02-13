package modello;

import java.util.ArrayList;

public class Archivio {

	private ArrayList <Mano> lista = new ArrayList <Mano> ();
	
	
	public void aggiungiMano (Mano mano) {
		lista.add(mano);
	}


	public ArrayList<Mano> getLista() {
		return lista;
	}


	public void setLista(ArrayList<Mano> lista) {
		this.lista = lista;
	}
	
	
}
