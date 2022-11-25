import java.util.Scanner;
import java.util.ArrayList;

public class EsercizioTotale {
    public static void main(String[] args) {

        // Inizializzazione variabili
        String nomeUtente;
        String passwordUtente;
        ArrayList<String> ArrayString;
        ArrayList<String> ArrayStringTemp;
        ArrayList<Integer> ArrayNum;
        ArrayList<Integer> ArrayNumTemp;
        Scanner inputDatiUtente;
        Scanner scannerScelta;
        boolean accesso;
        boolean controlloNome;
        boolean salva;
        String sceltaMenu;

        // Valorizzazione variabili
        ArrayString = new ArrayList<>();
        ArrayStringTemp = new ArrayList<>();
        ArrayNum = new ArrayList<>();
        ArrayNumTemp = new ArrayList<>();
        inputDatiUtente = new Scanner(System.in);
        scannerScelta = new Scanner(System.in);
        accesso = false;
        controlloNome = false;
        salva = false;
        sceltaMenu = "";

        System.out.println("Per accedere registrati");
        do {
            System.out.print("Inserire nome utente: ");
            nomeUtente = inputDatiUtente.nextLine();
            controlloNome = ControlloVuoto(nomeUtente);
        } while (controlloNome == false);
        System.out.print("Inserire la password: ");
        passwordUtente = inputDatiUtente.nextLine();
        System.out.println("Verifica dei dati inseriti");
        do {
            accesso = controlloAccesso(nomeUtente, passwordUtente, inputDatiUtente);
        } while (accesso == false);

        System.out.println("Benvenuto " + nomeUtente);

        do {
            menu();
            sceltaMenu = scannerScelta.nextLine();
            if (sceltaMenu.equalsIgnoreCase("esci")) {
                break;
            } else if (sceltaMenu.equalsIgnoreCase("aggiungi")) {
                boolean aggiunto = false;
                String mod;
                do {
                    System.out.println("Scrivi Parola per aggiungere una parola");
                    System.out.println("Scrivi Numero per aggiungere un numero");
                    mod = scannerScelta.nextLine();
                    if (mod.equalsIgnoreCase("parola")) {
                        ArrayStringTemp.add(AggiungiStr());
                        System.out.println("Aggiunta eseguita");
                        aggiunto = true;
                    } else if (mod.equalsIgnoreCase("numero")) {
                        ArrayNumTemp.add(AggiungiInt());
                        System.out.println("Aggiunta eseguita");
                        aggiunto = true;
                    } else {
                        System.out.println("Errore: Non è stato selezionato nessuna opzione disponibile");
                    }
                } while (aggiunto == false);
            } else if (sceltaMenu.equalsIgnoreCase("stampa")) {
                boolean stampato = false;
                String mod;
                do {
                    System.out.println("Scrivi Parole per stampare la lista di parole");
                    System.out.println("Scrivi Numeri per stampare la lista di numeri");
                    System.out.println("Scrivi Tutti per stampare entrambe le liste");
                    mod = scannerScelta.nextLine();
                    if (mod.equalsIgnoreCase("parole")) {
                        StampaArray(ArrayStringTemp);
                        stampato = true;
                    } else if (mod.equalsIgnoreCase("numeri")) {
                        StampaArray(ArrayNumTemp);
                        stampato = true;
                    } else if (mod.equalsIgnoreCase("tutti")) {
                        System.out.println("Lista di parole:");
                        StampaArray(ArrayStringTemp);
                        System.out.println("Lista numeri:");
                        StampaArray(ArrayNumTemp);
                        stampato = true;
                    } else {
                        System.out.println("Errore: Non è stato selezionato nessuna opzione disponibile");
                    }
                } while (stampato == false);
            } else if (sceltaMenu.equalsIgnoreCase("rimuovi")) {
                Scanner sceltaElimina = new Scanner(System.in);
                boolean eliminato = false;
                int indexElimina = -1;
                String mod;
                do {
                    System.out.println("Scrivi Parola per eliminare un elemento dalla lista delle parole");
                    System.out.println("Scrivi Numero per eliminare un elemento dalla lista dei numeri");
                    mod = scannerScelta.nextLine();
                    if (mod.equalsIgnoreCase("parola")) {
                        System.out.println("Questa è la lista di parole:");
                        StampaArray(ArrayStringTemp);
                        do {
                            System.out
                                    .println("Scegli un numero tra 1 e " + ArrayStringTemp.size() + " per eliminarlo");
                            indexElimina = sceltaElimina.nextInt() - 1;
                            if (indexElimina < 0 || indexElimina >= ArrayStringTemp.size()) {
                                System.out
                                        .println("Errore: la scelta della parola da eliminare non esiste nella lista");
                            }
                        } while (indexElimina < 0 || indexElimina >= ArrayStringTemp.size());
                        ArrayStringTemp.remove(indexElimina);
                        eliminato = true;
                    } else if (mod.equalsIgnoreCase("numero")) {
                        System.out.println("Questa è la lista dei numeri:");
                        StampaArray(ArrayNumTemp);
                        do {
                            System.out.println("Scegli un numero tra 1 e " + ArrayNumTemp.size() + " per eliminarlo");
                            indexElimina = sceltaElimina.nextInt() - 1;
                            if (indexElimina < 0 || indexElimina >= ArrayNumTemp.size()) {
                                System.out
                                        .println("Errore: la scelta della parola da eliminare non esiste nella lista");
                            }
                        } while (indexElimina < 0 || indexElimina >= ArrayStringTemp.size());
                        ArrayNumTemp.remove(indexElimina);
                        eliminato = true;
                    } else {
                        System.out.println("Errore: Non è stato selezionato nessuna opzione disponibile");
                    }
                } while (eliminato == false);
                System.out.println("Eliminato");
            } else if (sceltaMenu.equalsIgnoreCase("modifica")) {
                Scanner sceltaModifica = new Scanner(System.in);
                Scanner inputModifica = new Scanner(System.in);
                boolean modificato = false;
                int indexModifica = -1;
                String mod;
                do {
                    System.out.println("Scrivi Parola per modificare una parola");
                    System.out.println("Scrivi Numero per modificare un numero");
                    mod = scannerScelta.nextLine();
                    if (mod.equalsIgnoreCase("parola")) {
                        System.out.println("Questa è la lista di parole:");
                        StampaArray(ArrayStringTemp);
                        do {
                            System.out.println("Scegli un numero tra 1 e " + ArrayStringTemp.size() + " per modificare");
                            indexModifica = sceltaModifica.nextInt() - 1;
                            if (indexModifica < 0 || indexModifica >= ArrayStringTemp.size()) {
                                System.out.println("Errore: la scelta della parola da modificare non esiste nella lista");
                            }
                        } while (indexModifica < 0 || indexModifica >= ArrayStringTemp.size());
                        System.out.print("Inserire nuova parola: ");
                        String newStr = inputModifica.nextLine();
                        ArrayStringTemp.set(indexModifica, newStr);
                        modificato = true;
                    } else if (mod.equalsIgnoreCase("numero")) {
                        System.out.println("Questa è la lista dei numeri:");
                        StampaArray(ArrayNumTemp);
                        do {
                            System.out.println("Scegli un numero tra 1 e " + ArrayNumTemp.size() + " per modificare");
                            indexModifica = sceltaModifica.nextInt() - 1;
                            if (indexModifica < 0 || indexModifica >= ArrayNumTemp.size()) {
                                System.out.println("Errore: la scelta della parola da modificare non esiste nella lista");
                            }
                        } while (indexModifica < 0 || indexModifica >= ArrayStringTemp.size());
                        System.out.print("Inserire nuovo numero: ");
                        int newNum = inputModifica.nextInt();
                        ArrayNumTemp.set(indexModifica, newNum);
                        modificato = true;
                    } else {
                        System.out.println("Errore: Non è stato selezionato nessuna opzione disponibile");
                    }
                } while (modificato == false);
                System.out.println("Modificato");
            } else {
                System.out.println("Errore: Non è stato selezionato nessuna opzione disponibile");
            }
        } while (!(sceltaMenu.equalsIgnoreCase("esci")));

        System.out.println("Questa è la lista di parole: ");
        StampaArray(ArrayStringTemp);
        salva = Salva(passwordUtente);
        if (salva == true) {
            for (int i = 0; i < ArrayStringTemp.size(); i++) {
                ArrayString.add(ArrayStringTemp.get(i));
            }
            System.out.println("Salvato");
        } else {
            System.out.println("Non Salvato");
        }
        System.out.println("Questa è la lista dei numeri: ");
        StampaArray(ArrayNumTemp);
        salva = Salva(passwordUtente);
        if (salva == true) {
            for (int i = 0; i < ArrayNumTemp.size(); i++) {
                ArrayNum.add(ArrayNumTemp.get(i));
            }
            System.out.println("Salvato");
        } else {
            System.out.println("Non Salvato");
        }
        System.out.println("Arrivederci");
    }

    public static void menu() {
        System.out.println("Scrivi Aggiungi per aggiungere una parola o un numero alle liste");
        System.out.println("Scrivi Stampa per stampare una o tutte le liste");
        System.out.println("Scrivi Rimuovi per rimuovere un stringa/numero dalle rispettive liste");
        System.out.println("Scrivi Modifica per modificare un elemento della lista");
        System.out.println("Scrivi Esci per chiudere e salvare le modifiche");
    }

    public static boolean ControlloVuoto(String str) {
        if (str.equals("") || str.equals(" ")) {
            System.out.println("Non può essere lasciato vuoto");
            return false;
        }
        return true;
    }

    public static boolean controlloAccesso(String user, String pass, Scanner sc) {
        String verUser, verPass;
        boolean controlloUser;
        do {

            System.out.print("Reinserire il nome utente: ");
            verUser = sc.nextLine();
            controlloUser = ControlloVuoto(verUser);

        } while (controlloUser == false);
        System.out.print("Reinserire la password: ");
        verPass = sc.nextLine();
        if (verUser.equalsIgnoreCase(user) && verPass.equals(pass)) {
            return true;
        } else {
            System.out.println("Nome utente o password sbagliato");
            return false;
        }
    }

    public static int AggiungiInt() {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        System.out.println("inserire il numero da aggiungere");
        n = sc.nextInt();
        return n;
    }

    public static String AggiungiStr() {
        Scanner sc = new Scanner(System.in);
        String str;
        System.out.println("Scrivi la parola");
        str = sc.nextLine();
        return str;
    }

    public static void StampaArray(ArrayList ar) {
        if (ar.isEmpty()) {
            System.out.println("Non si possono stampare liste vuote");
        } else {
            int temp;
            for (int i = 0; i < ar.size(); i++) {
                temp = i + 1;
                System.out.println(temp + ") " + ar.get(i));
            }
        }
    }

    public static boolean controlloPass(String pass, Scanner sc) {
        String verPass = sc.nextLine();
        if (verPass.equals(pass)) {
            return true;
        } else {
            System.out.println("Password errata, riprova");
            return false;
        }
    }

    public static boolean Salva(String password) {
        Scanner scelta = new Scanner(System.in);
        boolean passEsatta = false;
        String risposta;
        do {
            System.out.println("Sei sicuro di volerlo salvare? [y/n]");
            risposta = scelta.nextLine();
            if (risposta.equals("y") || risposta.equals("s")) {
                do {
                    System.out.print("Inserisci la password: ");
                    passEsatta = controlloPass(password, scelta);
                } while (passEsatta == false);
                return true;
            } else if (risposta.equals("n")) {
                return false;
            } else {
                System.out.println("Errore: Non è stato selezionato nessuna opzione disponibile");
            }
        } while (true);
    }
}
