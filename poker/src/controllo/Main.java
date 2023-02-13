package controllo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import interfaccia.InterfacciaConsoleUtente;
import modello.Archivio;
import modello.Carta;
import modello.Mano;
import persistenza.DataBase;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        Archivio archivio = new Archivio();
        InterfacciaConsoleUtente interfaccia = new InterfacciaConsoleUtente();
        Controllo controllo = new Controllo (archivio);
        DataBase database = new DataBase ();
        
        Mano m1 = new Mano ();
        m1.setId(1);
        System.out.println("inserire carte della prima mano" + "\n");
        while(m1.getInsieme().size() < 5) {
        	m1.aggiungiCarta(interfaccia.leggiCarta());
        }
        
        Mano m2 = new Mano ();
        m2.setId(2);
        System.out.println("inserire carte della seconda mano" + "\n");
        while(m2.getInsieme().size() < 5) {
        	m2.aggiungiCarta(interfaccia.leggiCarta());
        }
        
        archivio.aggiungiMano(m1);
        archivio.aggiungiMano(m2);
        
        System.out.println("mano 1 :");
        for(Carta carta : m1.getInsieme()) {
        	System.out.println(carta);
        }
        
        int punteggio1 = controllo.getPunteggio(m1);
        System.out.println("punteggio : " + punteggio1);
        
        System.out.println("mano 2:");
        for(Carta carta : m2.getInsieme()) {
        	System.out.println(carta);
        }
        
        int punteggio2 = controllo.getPunteggio(m2);
        System.out.println("punteggio : " + punteggio2);
        
        
        
    }

}
