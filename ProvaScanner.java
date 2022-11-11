import java.util.Scanner;   //Import della  classe scanner per input dalla console
class ProvaScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   //Creazione oggetto Scanner
        System.out.println("Inserisci il tuo nome:");   //Richiesta nome utente
        String nome = scanner.nextLine();   //Input da console per nome utente
        System.out.println("Inserisci la tua età:");    //Richiesta età utente
        int eta = scanner.nextInt();    //Input da console dell'età di un utente
        System.out.println("\nIl tuo nome è " + nome + " e hai " + eta + " anni"); //Stampa della variabile appena presa in input
    }//Fine main   
}//Fine classe ProvaScannerg
