package interfaccia;

import java.util.Scanner;

import controllo.Controllo;
import modello.Carta;


public class InterfacciaConsoleUtente {

	
	
    public Carta leggiCarta () {
    	
        Scanner scanner = new Scanner(System.in);
        System.out.println("inserisci valore della carta");
        String valore = scanner.next();
        while(!valore.equals("asso")  && !valore.equals("2")  && !valore.equals("3")  && !valore.equals("4")
        		&& !valore.equals("5") && !valore.equals("6")  && !valore.equals("7")  && !valore.equals("8")
        		&& !valore.equals("9")  && !valore.equals("10")  && !valore.equals("jack")  && !valore.equals("regina") && !valore.equals("re") ) {
        	System.out.println("errore: inserisci valore corretto");
        	valore = scanner.next();
        }
        System.out.println("inserisci seme della carta");
        String seme = scanner.next();
        while(!seme.equals("fiori")  && !seme.equals("quadri")  && !seme.equals("cuori")  && !seme.equals("picche")) {
        	System.out.println("errore: rinserire il seme correttamente");
        	seme = scanner.next();
        }
        return new Carta(valore,seme);
    }
    
   
}
