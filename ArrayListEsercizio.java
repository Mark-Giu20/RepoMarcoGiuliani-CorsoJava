import java.util.Scanner;
import java.util.ArrayList;

class ArrayListEsercizio {
    public static void main(String[] args) {

        // Inizializzazione e valorizzazione variabili
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> ArString = new ArrayList<>(); // Creazione oggetto ArrayList di che conterrà stringhe
        ArrayList<Integer> ArInt = new ArrayList<>(); // Creazione oggetto ArrayList di che conterrà interi
        int scelta = -1;

        // Inizio do while
        do {

            // Menù richieste
            System.out.println("Scrivere 1 per aggiungere una parola");
            System.out.println("Scrivere 2 per aggiungere un numero");
            System.out.println("Scrivere 3 per stampare una lista a scelta");
            System.out.println("Srivere 0 per uscire");
            scelta = scanner.nextInt();

            if (scelta == 0) // Uscita dal ciclo
            {

                System.out.println("Arrivederci");

            } else if (scelta == 1) { // Aggiungere un valore all'array di stringhe

                Scanner inputStr = new Scanner(System.in); // Scanner per input di stringhe
                System.out.println("inserire la parola da aggiungere");
                ArString.add(inputStr.nextLine()); // Aggiunta tramite metodo add della stringa inserita dell'utente
                System.out.println("Aggiunta eseguita");

            } else if (scelta == 2) { // Aggiungere un valore all'array di interi

                Scanner inputInt = new Scanner(System.in); // Scanner per input di interi
                System.out.println("inserire il numero da aggiungere");
                ArInt.add(inputInt.nextInt()); // Aggiunta tramite metodo add dell'intero inserito dell'utente
                System.out.println("Aggiunta eseguita");

            } else if (scelta == 3) { // Stampa array a scelta

                int sceltaStampa = 0; // Scelta di stampa preso in input da utente
                boolean stampato = false; // Controllo stampa

                // Do while scelta stampa
                do {

                    // Scelta di stampa
                    System.out.println("Premere 1 per stampare lista di parole");
                    System.out.println("Premere 2 per stampare lista di numeri");
                    sceltaStampa = scanner.nextInt();

                    if (sceltaStampa == 1) { // Stampa array stringhe
                        if (ArString.isEmpty()) { // Controllo se l'array è vuoto

                            System.out.println("Non è possibile stampare una lista vuota");
                            stampato = true;

                        } else {

                            int i = 0;
                            while (i < ArString.size()) { // While per stampa array
                                int temp = i + 1;
                                System.out.println(temp + ") " + ArString.get(i)); // Stampa la stringa in posizione i tramite il metodo get
                                i++;

                            }
                            stampato = true;

                        }
                    } else if (sceltaStampa == 2) { // Stampa array stringhe

                        if (ArInt.isEmpty()) { // Controllo se l'array è vuoto

                            System.out.println("Non è possibile stampare una lista vuota");
                            stampato = true;

                        } else {

                            int i = 0;
                            while (i < ArInt.size()) { // While per la stampa di tutto l'array

                                int temp = i + 1;
                                System.out.println(temp + ") " + ArInt.get(i)); // Stampa l'intero in posizione i tramite il metodo get
                                i++;
                            }
                            stampato = true;
                        }
                    } else { // Caso in cui l'utente non seleziona nessuna opzione disponibile

                        System.out.println("Errore: Non è stato selezionato nessuna opzione disponibile");
                    }
                } while (stampato == false); // Fine do while stampa

            } else { // Caso in cui l'utente non seleziona nessuna opzione disponibile

                System.out.println("Errore: Non è stato selezionato nessuna opzione disponibile");

            }
        } while (!(scelta == 0)); // Fine do while menù
    }// Fine main
}// Fine classe ArrayListEsercizio