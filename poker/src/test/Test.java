package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;

import controllo.Controllo;
import junit.framework.Assert;
import modello.Archivio;
import modello.Carta;
import modello.Mano;

class Test {
	Controllo controllo ;
	Archivio archivio ;
	
	
	@BeforeEach
	void setUp () {

		archivio = new Archivio ();
		controllo = new Controllo(archivio);
		
		Mano m1 = new Mano ();
		
		archivio.getLista().add(m1);
		
		Carta c5 = new Carta ("asso", "picche");
		Carta c1 = new Carta ("asso", "fiori");
		Carta c2 = new Carta ("2", "picche");
		Carta c3 = new Carta ("2", "fiori");
		Carta c4 = new Carta ("asso", "quadri");
		
		m1.aggiungiCarta(c1);
		m1.aggiungiCarta(c2);
		m1.aggiungiCarta(c3);
		m1.aggiungiCarta(c4);
		m1.aggiungiCarta(c5);
		
		Mano m2 = new Mano ();
		archivio.getLista().add(m2);
		
		Carta c11 = new Carta ("asso", "fiori");
		Carta c22 = new Carta ("2", "picche");
		Carta c33 = new Carta ("3", "fiori");
		Carta c44 = new Carta ("asso", "quadri");
		Carta c55 = new Carta ("asso", "picche");
		
		m2.aggiungiCarta(c11);
		m2.aggiungiCarta(c22);
		m2.aggiungiCarta(c33);
		m2.aggiungiCarta(c44);
		m2.aggiungiCarta(c55);
		
		
		
	}

	@org.junit.jupiter.api.Test
	void testAggiungiMano() {
		Mano mano = new Mano ();
		mano.setId(1);
		
		Archivio a = new Archivio ();
		
		a.aggiungiMano(mano);
		Assert.assertEquals(1, a.getLista().size());
	}
	
	@org.junit.jupiter.api.Test
	void testAggiungiCarta() {
		
		Mano mano = new Mano ();
		
		Carta c5 = new Carta ("asso", "picche");
		Carta c1 = new Carta ("asso", "picche");
		Carta c2 = new Carta ("2", "picche");
		Carta c3 = new Carta ("asso", "fiori");
		Carta c4 = new Carta ("asso", "picche");
		
		mano.aggiungiCarta(c1);
		mano.aggiungiCarta(c2);
		mano.aggiungiCarta(c3);
		mano.aggiungiCarta(c4);
		mano.aggiungiCarta(c5);
		
		Assert.assertEquals(3, mano.getInsieme().size());
		
	}
	
	@org.junit.jupiter.api.Test
	void testFull() {
		
		Mano mano = archivio.getLista().get(0);
		
		
		Assert.assertEquals(3, controllo.getListaCarteVerificaCoppiaTrisPoker(mano).size());
		Assert.assertEquals(2, controllo.getListDoppiaCoppia(mano).size());
	}
	
	@org.junit.jupiter.api.Test
	void testTris() {
		Mano mano = archivio.getLista().get(1);
		
		Assert.assertEquals(3, controllo.getListaCarteVerificaCoppiaTrisPoker(mano).size());
		Assert.assertEquals(0, controllo.getListDoppiaCoppia(mano).size());
		
	}
	
	@org.junit.jupiter.api.Test
	void testColore() {
		
		Mano m1 = new Mano ();
		
		Carta c5 = new Carta ("2", "fiori");
		Carta c1 = new Carta ("asso", "fiori");
		Carta c2 = new Carta ("3", "fiori");
		Carta c3 = new Carta ("5", "fiori");
		Carta c4 = new Carta ("re", "fiori");
		
		m1.aggiungiCarta(c1);
		m1.aggiungiCarta(c2);
		m1.aggiungiCarta(c3);
		m1.aggiungiCarta(c4);
		m1.aggiungiCarta(c5);
		
		Assert.assertEquals(5, controllo.getListaColore(m1).size());
	}
	
	@org.junit.jupiter.api.Test
	void testConvalidaMano() {
		
		Mano mano = archivio.getLista().get(1);
		
		ArrayList <int []> lista = controllo.convalidaMano(mano);
		int [] c1 = lista.get(0);
		int [] c2 = lista.get(1);
		int [] c3 = lista.get(2);
		int [] c4 = lista.get(3);
		int [] c5 = lista.get(4);

		Assert.assertEquals(5, lista.size());
		Assert.assertEquals(1, c1[0]);
		Assert.assertEquals(1, c2[0]);
		Assert.assertEquals(3, c3[0]);
		Assert.assertEquals(2, c4[0]);
		Assert.assertEquals(1, c5[0]);
	}
	
	@org.junit.jupiter.api.Test
	void testGetListaValoriOrdinata() {
		
		Mano mano = archivio.getLista().get(1);
		ArrayList <Integer> lista = controllo.getListaValoriOrdinata(mano);
		
		Assert.assertEquals(new Integer (1) , lista.get(0));
		Assert.assertEquals(new Integer (1) , lista.get(1));
		Assert.assertEquals(new Integer (1) , lista.get(2));
		Assert.assertEquals(new Integer (2) , lista.get(3));
		Assert.assertEquals(new Integer (3) , lista.get(4));
	}
	
	@org.junit.jupiter.api.Test
	void testScala() {
		
		Mano m1 = new Mano ();
		
		Carta c5 = new Carta ("asso", "picche");
		Carta c1 = new Carta ("2", "fiori");
		Carta c2 = new Carta ("3", "picche");
		Carta c3 = new Carta ("4", "fiori");
		Carta c4 = new Carta ("5", "quadri");
		
		m1.aggiungiCarta(c1);
		m1.aggiungiCarta(c2);
		m1.aggiungiCarta(c3);
		m1.aggiungiCarta(c4);
		m1.aggiungiCarta(c5);
		
		Assert.assertEquals( 5 , controllo.getListaScalaVerificata(m1).size());
		Assert.assertEquals(new Integer (1), controllo.getListaScalaVerificata(m1).get(0));
		Assert.assertEquals(new Integer (2), controllo.getListaScalaVerificata(m1).get(1));
		Assert.assertEquals(new Integer (3), controllo.getListaScalaVerificata(m1).get(2));
		Assert.assertEquals(new Integer (4), controllo.getListaScalaVerificata(m1).get(3));
		Assert.assertEquals(new Integer (5), controllo.getListaScalaVerificata(m1).get(4));
	}
	
	@org.junit.jupiter.api.Test
	void testPunteggio() {
		
		Mano m1 = archivio.getLista().get(0);
		Mano m2 = archivio.getLista().get(1);
		
		Assert.assertEquals(5, controllo.getPunteggio(m1));
		Assert.assertEquals(3, controllo.getPunteggio(m2));
	}

}
