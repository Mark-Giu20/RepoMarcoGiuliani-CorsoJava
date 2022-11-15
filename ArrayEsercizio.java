import java.util.Scanner;

class ArrayEsercizio {
    public static void main(String[] args) {

        // Inizializzazione e valorizzazione variabili
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserire la lunghezza massima lista di parole"); // Richiesta lunghezza massima array stringhe
        int StrMax = scanner.nextInt(); // Lunghezza massima array stringhe preso in input da utente
        System.out.println("Inserire la lunghezza massima lista di numeri"); // Richiesta lunghezza massima array interi
        int IntMax = scanner.nextInt(); // Lunghezza massima array interi preso in input da utente

        String[] arStringhe = new String[StrMax]; // Arrey stringhe con lunghezza massima presa in input precedentemente
        int iArStr = 0; // Lunghezza attuale dell'array stringhe
        int[] arInt = new int[IntMax]; // Arrey interi con lunghezza massima presa in input precedentemente
        int iArInt = 0; // Lunghezza attuale dell'array interi
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

                if (iArStr < StrMax) { // Controllo se è stata raggiunta la lunghezza massima dell'array

                    Scanner inputStr = new Scanner(System.in); // Scanner per input di stringhe
                    String strAdd; // Valore da aggiungere
                    System.out.println("inserire la parola da aggiungere");
                    strAdd = inputStr.nextLine(); // Valore da aggiungere preso in input
                    arStringhe[iArStr] = strAdd; // Aggiunta del valore
                    iArStr++; // Incremento della lunghezza dell'array di stringhe
                    System.out.println("Aggiunta eseguita");

                } else { // Messaggio per lunghezza array uguale a lunghezza massima

                    System.out.println("La lista è piena");

                }
            } else if (scelta == 2) { // Aggiungere un valore all'array di interi

                if (iArInt < IntMax) { // Controllo se è stata raggiunta la lunghezza massima dell'array

                    Scanner inputInt = new Scanner(System.in); // Scanner per input di interi
                    int intAdd; // Valore da aggiungere
                    System.out.println("inserire il numero da aggiungere");
                    intAdd = inputInt.nextInt(); // Valore da aggiungere preso in input
                    arInt[iArInt] = intAdd; // Aggiunta del valore
                    iArInt++; // Incremento della lunghezza dell'array di interi
                    System.out.println("Aggiunta eseguita");

                } else { // Messaggio per lunghezza array uguale a lunghezza massima
                    System.out.println("La lista è piena");
                }

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
                        if (iArStr == 0) { // Controllo se l'array è vuoto

                            System.out.println("Non è possibile stampare una lista vuota");
                            stampato = true;

                        } else {

                            int i = 0;
                            while (i < iArStr) { // While per stampa array
                                int temp = i + 1;
                                System.out.println(temp + ") " + arStringhe[i]); // Stampa la stringa in posizione i
                                i++;

                            }

                            stampato = true;

                        }
                    } else if (sceltaStampa == 2) { // Stampa array stringhe

                        if (iArInt == 0) { // Controllo se l'array è vuoto

                            System.out.println("Non è possibile stampare una lista vuota");
                            stampato = true;

                        } else {

                            int i = 0;
                            while (i < iArInt) { // While per la stampa di tutto l'array

                                int temp = i + 1;
                                System.out.println(temp + ") " + arInt[i]); // Stampa l'intero in posizione i
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
}