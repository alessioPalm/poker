package controllo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import interfaccia.InterfacciaConsoleUtente;
import modello.Archivio;
import modello.Carta;
import modello.Mano;
import persistenza.DataBase;

public class Controllo {

	Archivio archivio;
	
	public Controllo (Archivio archivio) {
		this.archivio=archivio;
	}
	
	
	
	public int [] valida (String s1, String s2) {
		int [] p = {0, 0};
		switch (s1) {
		
		case "asso" : p[0] = 1;
		break;
		case "2" : p[0] = 2;
		break;
		case "3" : p[0] = 3;
		break;
		case "4" : p[0] = 4;
		break;
		case "5" : p[0] = 5;
		break;
		case "6" : p[0] = 6;
		break;
		case "7" : p[0] = 7;
		break;
		case "8" : p[0] = 8;
		break;
		case "9" : p[0] = 9;
		break;
		case "10" : p[0] = 10;
		break;
		case "jack" : p[0] = 11;
		break;
		case "regina" : p[0] = 12;
		break;
		case "re" : p[0] = 13;
		break;
		}
		
		switch (s2) {
		case "cuori" : p[1] = 0;
		break;
		case "picche" : p[1] = 1;
		break;
		case "fiori" : p[1] = 2;
		break;
		case "quadri" : p[1] = 3;
		break;
		}
		return p;
	}
	
	public ArrayList <Carta> getListaCarteVerificaCoppiaTrisPoker (Mano mano){
		ArrayList <Carta> listaCarteUguali1 = new ArrayList <Carta> ();
		
		for(Carta c1 : mano.getInsieme()) {
			for(Carta c2 : mano.getInsieme()) {
				if(c1 != c2) {
					if(c1.getValore().equals(c2.getValore())) {
						if(!listaCarteUguali1.contains(c2)) {
							if(containsCartaValore(c2.getValore(), listaCarteUguali1) || listaCarteUguali1.size() == 0) {
								listaCarteUguali1.add(c2);
							}
						}
					}
				}
			}
		}
		return listaCarteUguali1;
	}
	
	public boolean containsCartaValore (String valore, ArrayList <Carta> lista ) {
		
		for(Carta carta : lista) {
			if(carta.getValore().equals(valore)) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList <Carta> getListDoppiaCoppia (Mano mano){
		ArrayList <Carta> listaCarteUguali1 = getListaCarteVerificaCoppiaTrisPoker (mano);
		ArrayList <Carta> listaCarteUguali2 = new ArrayList <Carta> ();
		
		for(Carta c1 : mano.getInsieme()){
			for(Carta c2 : mano.getInsieme()){
				if(c1 != c2) {
					if(c1.getValore().equals(c2.getValore())) {
						if(!listaCarteUguali2.contains(c2)) {
							if(!containsCartaValore(c2.getValore(), listaCarteUguali1)) {
								listaCarteUguali2.add(c2);
							}
						}
					}
				}
			}
		}
		return listaCarteUguali2;
	}
	
	public ArrayList <Carta> getListaColore (Mano mano){
		ArrayList <Carta> listaCarteColoriUguali = new ArrayList <Carta> ();
		
		for(Carta c1 : mano.getInsieme()) {
			for(Carta c2 : mano.getInsieme()) {
				if(c1 != c2) {
					if(c1.getSeme().equals(c2.getSeme())) {
						if(!listaCarteColoriUguali.contains(c2)) {
							listaCarteColoriUguali.add(c2);
						}
					}
				}
			}
		}
		return listaCarteColoriUguali;
	}
	
	public ArrayList <int []> convalidaMano (Mano mano){
		ArrayList <int []> listaManoConvalidata = new ArrayList <int []>();
		
		for(Carta carta : mano.getInsieme()) {
			int [] CartaConvalidata = valida(carta.getValore(), carta.getSeme());
			
			listaManoConvalidata.add(CartaConvalidata);
		}
		
		return listaManoConvalidata;
	}
	
	public ArrayList <Integer> getListaValoriOrdinata (Mano mano){
		ArrayList <int []> listaManoConvalidata = convalidaMano (mano);
		ArrayList <Integer> listaOrdinata = new ArrayList <Integer> ();
		
		for(int [] carta : listaManoConvalidata) {
			
			listaOrdinata.add(carta[0]);
		}
		
		Collections.sort(listaOrdinata);
		
		return listaOrdinata;
	}
	
	public ArrayList <Integer> getListaScalaVerificata (Mano mano){
		ArrayList <Integer> listaOrdinata = getListaValoriOrdinata(mano);
		ArrayList <Integer> listaScala = new ArrayList <Integer>();
		
		Integer valoreMomentaneo = listaOrdinata.get(0);
		for(Integer valore : listaOrdinata) {
			if(valoreMomentaneo == valore) {
				listaScala.add(valoreMomentaneo);
			}
			valoreMomentaneo++;
		}
		return listaScala;
	}
	
	public int getPunteggio (Mano mano){
		
       	int punteggio = 0;
       	
       	if(getListaColore(mano).size() == 5 && getListaScalaVerificata(mano).size() == 5) {
       		punteggio = 8;
       	}else if(getListaColore(mano).size() != 5 && getListaCarteVerificaCoppiaTrisPoker(mano).size() == 4) {
       		punteggio = 7;
       	}else if(getListaColore(mano).size() == 5) {
       		punteggio = 6;
       	}else if(getListaCarteVerificaCoppiaTrisPoker(mano).size() == 3 && getListDoppiaCoppia(mano).size() == 2) {
       		punteggio = 5;
       	}else if(getListaCarteVerificaCoppiaTrisPoker(mano).size() == 2 && getListDoppiaCoppia(mano).size() == 3) {
       		punteggio = 5;
       	}else if(getListaScalaVerificata(mano).size() == 5) {
       		punteggio = 4;
       	}else if(getListaCarteVerificaCoppiaTrisPoker(mano).size() ==3 && getListDoppiaCoppia(mano).size() == 0) {
       		punteggio = 3;
       	}else if(getListaCarteVerificaCoppiaTrisPoker(mano).size() ==2 && getListDoppiaCoppia(mano).size() == 2) {
       		punteggio = 2;
       	}else if(getListaCarteVerificaCoppiaTrisPoker(mano).size() ==2 && getListDoppiaCoppia(mano).size() == 0) {
       		punteggio = 1;
       	}
        return punteggio;
	}
	
	
}
