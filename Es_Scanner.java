import java.util.Scanner;

class Es_Scanner {
    public static void main(String[] args) {
        // Inizializzazione variabili
        Scanner scanner = new Scanner(System.in);
        String nomeUtente;
        String cognomeUtente;
        int etaUtente;

        System.out.println("Inserisci il tuo nome:"); // Richiesta nome
        nomeUtente = scanner.nextLine(); // Input nome

        System.out.println("Inserisci il tuo cognome:"); // Richiesta cognome
        cognomeUtente = scanner.nextLine(); // Input cognome

        System.out.println("Inserisci la tua età:"); // Richiesta età
        etaUtente = scanner.nextInt(); // Input età

        // Stampa profilo utente
        System.out.println("Questo è il tuo profilo:");
        System.out.println("Nome: " + nomeUtente);
        System.out.println("Cognome: " + cognomeUtente);
        System.out.println("Età: " + etaUtente + "\n");

        // Stampa opzioni menù
        System.out.println("Menù:");
        System.out.println("Digita 1 per stampare Banana");
        System.out.println("Digita 2 per stampare Pippo");
        System.out.println("Digita 3 per stampare Limoni");
        int scelta = scanner.nextInt(); // Utilizzo scanner per scelta utente

        if (scelta == 1) { // Apertura if-else

            System.out.println("Banana\n"); // Caso scelta 1

        } else if (scelta == 2) {

            System.out.println("Pippo\n"); // Caso scelta 2

        } else if (scelta == 3) {

            System.out.println("Limoni\n"); // Caso scelta 3

        } else {
            
            System.out.println("Non è stata selezionata nessuna opzione disponibile\n"); // Caso generico

        } // Fine if-else
    }// Fine main
}// Fine classe Es_Scanner
