import java.util.Scanner;
import java.util.ArrayList;

class TestComplessivoJava {
    public static void main(String[] args) {
        String adminUser;
        String adminPass;
        String opzioneAccesso;
        int utente;
        boolean chiudi;
        Scanner sceltaUtente;
        Scanner inputDati;
        ArrayList<String> UtentiRegistrati;
        ArrayList<String> PasswordUtenti;
        ArrayList<String> CarrelloUtente;
        ArrayList<Double> PrezzoPiattiCarrello;
        ArrayList<String> Piatti;
        ArrayList<Double> PrezzoPiatti;

        UtentiRegistrati = new ArrayList<>();
        PasswordUtenti = new ArrayList<>();
        CarrelloUtente = new ArrayList<>();
        PrezzoPiattiCarrello = new ArrayList<>();
        Piatti = new ArrayList<>();
        Piatti.add("Pasta al pomodoro");
        Piatti.add("Lasagna");
        Piatti.add("Pollo con peperoni");
        Piatti.add("Pizza Margherita");
        PrezzoPiatti = new ArrayList<>();
        PrezzoPiatti.add(10.0);
        PrezzoPiatti.add(11.50);
        PrezzoPiatti.add(12.30);
        PrezzoPiatti.add(8.50);
        sceltaUtente = new Scanner(System.in);
        inputDati = new Scanner(System.in);
        chiudi = false;
        adminUser = "admin";
        adminPass = "admin";
        opzioneAccesso = "";
        utente = -2;

        System.out.println("Benvenuto");
        do {

            System.out.println("Scrivi Registrati per registrarti nel sistema");
            System.out.println("Scrivi Accedi per accedere al sistema");
            System.out.println("Scrivi Chiudi per chiudere");
            opzioneAccesso = sceltaUtente.nextLine();
            if (opzioneAccesso.equalsIgnoreCase("chiudi")) {
                System.out.println("Arrivederci");
                chiudi = true;
            } else if (opzioneAccesso.equalsIgnoreCase("registrati")) {
                String nomeUtente;
                String passUtente;
                boolean controlloNome;
                do {
                    System.out.print("Inserire nome utente: ");
                    nomeUtente = inputDati.nextLine();
                    controlloNome = ControlloVuoto(nomeUtente);
                } while (controlloNome == false);
                System.out.print("Inserire password: ");
                passUtente = inputDati.nextLine();
                if (giaRegistrato(UtentiRegistrati, nomeUtente) == true) {
                    System.out.println("Utente già registrato");
                } else {
                    UtentiRegistrati.add(nomeUtente);
                    PasswordUtenti.add(passUtente);
                    System.out.println("Registrato");
                }
            } else if (opzioneAccesso.equalsIgnoreCase("accedi")) {
                String nomeUtente;
                String passUtente;
                boolean controlloNome;
                do {
                    System.out.print("Inserire nome utente: ");
                    nomeUtente = inputDati.nextLine();
                    controlloNome = ControlloVuoto(nomeUtente);
                } while (controlloNome == false);
                System.out.print("Inserire password: ");
                passUtente = inputDati.nextLine();
                utente = controlloAccesso(nomeUtente, passUtente, UtentiRegistrati, PasswordUtenti, adminUser,
                        adminPass);
                if (utente == -1) {
                    Scanner sceltaAdmin = new Scanner(System.in);
                    String operazione = "";
                    System.out.println("Pannello di controllo admin");
                    do {
                        System.out.println("Scrivi Aggiungi per aggiungere un piatto");
                        System.out.println("Scrivi Rimuovi per rimuovere un piatto");
                        System.out.println("Scrivi Modifica per modificare un piatto");
                        System.out.println("Scrivi Stampa per stampare i piatti");
                        System.out.println("Scrivi Logout per uscire");
                        operazione = sceltaAdmin.nextLine();
                        if (operazione.equalsIgnoreCase("logout")) {
                            System.out.println("Disconnesso");
                        } else if (operazione.equalsIgnoreCase("aggiungi")) {
                            Scanner aggiungi = new Scanner(System.in);
                            System.out.print("Inserire il nuovo prodotto: ");
                            String newProdotto = aggiungi.nextLine();
                            Piatti.add(newProdotto);
                            System.out.print("Inserire il prezzo del prodotto: ");
                            double newPrezzo = aggiungi.nextDouble();
                            PrezzoPiatti.add(newPrezzo);
                            System.out.println("Prodotto aggiunto");
                        } else if (operazione.equalsIgnoreCase("rimuovi")) {
                            int indexElimina;
                            StampaPiatti(Piatti, PrezzoPiatti);
                            do {
                                System.out.println(
                                        "Scegli un numero tra 1 e " + Piatti.size() + " per eliminare un prodotto");
                                indexElimina = inputDati.nextInt() - 1;
                                if (indexElimina < 0 || indexElimina >= Piatti.size()) {
                                    System.out.println("Errore: Il prodotto selezionato non esiste");
                                }
                            } while (indexElimina < 0 || indexElimina >= Piatti.size());
                            Piatti.remove(indexElimina);
                            PrezzoPiatti.remove(indexElimina);
                            System.out.println("Eliminato");
                        } else if (operazione.equalsIgnoreCase("modifica")) {
                            int indexModifica;
                            Scanner modifica = new Scanner(System.in);
                            Scanner modificaNum = new Scanner(System.in);
                            StampaPiatti(Piatti, PrezzoPiatti);
                            do {
                                System.out.println(
                                        "Scegli un numero tra 1 e " + Piatti.size() + " per eliminare un prodotto");
                                indexModifica = inputDati.nextInt() - 1;
                                if (indexModifica < 0 || indexModifica >= Piatti.size()) {
                                    System.out.println("Errore: Il prodotto selezionato non esiste");
                                }
                            } while (indexModifica < 0 || indexModifica >= Piatti.size());
                            System.out.print("Inserire prodotto: ");
                            String prodotto = modifica.nextLine();
                            Piatti.set(indexModifica, prodotto);
                            System.out.print("Inserire prezzo: ");
                            double prezzo = modificaNum.nextDouble();
                            PrezzoPiatti.set(indexModifica, prezzo);
                            System.out.println("Modificato");
                        } else if (operazione.equalsIgnoreCase("stampa")) {
                            StampaPiatti(Piatti, PrezzoPiatti);
                        } else {
                            System.out.println("Errore: Non è stato selezionato nessuna opzione disponibile");
                        }
                    } while (!(operazione.equalsIgnoreCase("logout")));
                } else if (utente == -2) {
                    System.out.println("Nome utente o password sbagliata o non sei registrato");
                } else {
                    String scelta = "";
                    int totPiattiQ = 0;
                    double contoTot = 0;
                    System.out.println("Benvenuto " + UtentiRegistrati.get(utente));
                    System.out.print("Inserisci il tuo budget: ");
                    double budgetUtente = inputDati.nextDouble();
                    do {
                        System.out.println("\nScrivi Piatti per visualizzare i piatti disponibili e ordinare");
                        System.out.println("Scrivi Carrello per visualizzare il carrello e pagare");
                        System.out.println("Scrivi Svuota per liberare il carrello");
                        System.out.println("Scrivi Logout per disconnetterti");
                        scelta = sceltaUtente.nextLine();

                        if (scelta.equalsIgnoreCase("logout")) {
                            System.out.println("Riepilogo acquisti:");
                        } else if (scelta.equalsIgnoreCase("piatti")) {
                            String sceltaAgg;
                            int aggiunta;
                            Scanner inputAggiungi = new Scanner(System.in);
                            System.out.println("\nQuesto è il menù:");
                            StampaPiatti(Piatti, PrezzoPiatti);
                            System.out.println("\nVuoi aggiungere qualcosa all'ordine? [y/n]");
                            sceltaAgg = inputAggiungi.nextLine();
                            if (sceltaAgg.equalsIgnoreCase("y") || sceltaAgg.equalsIgnoreCase("si")) {
                                do {
                                    System.out.println(
                                            "Scegli un numero tra 1 e " + Piatti.size() + " per selezionare il piatto");
                                    aggiunta = inputAggiungi.nextInt() - 1;
                                    if (aggiunta < 0 || aggiunta >= Piatti.size()) {
                                        System.out.println("Errore: Il piatto selezionato non esiste");
                                    }
                                } while (aggiunta < 0 || aggiunta >= Piatti.size());
                                System.out.print("Inserisci quanti piatti ordinare: ");
                                int quantità = inputAggiungi.nextInt();
                                for (int i = 0; i < quantità; i++) {
                                    CarrelloUtente.add(Piatti.get(aggiunta));
                                    PrezzoPiattiCarrello.add(PrezzoPiatti.get(aggiunta));
                                }
                                System.out.println("Piatti aggiunto al carrello");
                            } else if (sceltaAgg.equalsIgnoreCase("n") || sceltaAgg.equalsIgnoreCase("no")) {
                                System.out.println("Ok");
                            } else {
                                System.out.println("Errore: Non è stato selezionato nessuna opzione disponibile");
                            }
                        } else if (scelta.equalsIgnoreCase("carrello")) {
                            String pagare = "";
                            boolean pagato = false;
                            Boolean autorizzato = false;
                            Scanner inputPaga = new Scanner(System.in);
                            if (CarrelloUtente.isEmpty()) {
                                System.out.println("Il carrello è vuoto");
                            } else {
                                System.out.println("Questi sono i piatti nel carrello:");
                                StampaPiatti(CarrelloUtente, PrezzoPiattiCarrello);
                                System.out.println("Il tuo budget è: " + budgetUtente);
                                do {
                                    System.out.println("Vuoi pagare? [y/n]");
                                    pagare = inputPaga.nextLine();
                                    if (pagare.equalsIgnoreCase("y") || pagare.equalsIgnoreCase("si")) {
                                        double totAcq = 0;
                                        for (int i = 0; i < PrezzoPiattiCarrello.size(); i++) {
                                            totAcq += PrezzoPiattiCarrello.get(i);
                                        }
                                        double budgetAtt = budgetUtente - totAcq;
                                        if (budgetAtt >= 0) {
                                            do {
                                                autorizzato = controlloPass(PasswordUtenti.get(utente), inputPaga);
                                            } while (autorizzato == false);
                                            for (int i = 0; i < CarrelloUtente.size(); i++) {
                                                totPiattiQ++;
                                            }
                                            contoTot += totAcq;
                                            budgetUtente = budgetAtt;
                                            CarrelloUtente.clear();
                                            PrezzoPiattiCarrello.clear();
                                            System.out.println(
                                                    "Ordine eseguito, il tuo budget rimanente è: " + budgetUtente);
                                            pagato = true;
                                        } else {
                                            System.out.println("Non hai abbastanza soldi per pagare");
                                            System.out.println("Il tuo budget è: " + budgetUtente
                                                    + ", Il costo dell'ordine è: " + totAcq);
                                        }
                                    } else if (pagare.equalsIgnoreCase("n") || pagare.equalsIgnoreCase("no")) {
                                        System.out.println("Ok");
                                        pagato = true;
                                    }
                                } while (pagato == false);
                            }

                        } else if (scelta.equalsIgnoreCase("svuota")) {
                            CarrelloUtente.clear();
                            PrezzoPiattiCarrello.clear();
                            System.out.println("Carrello svuotato");
                        } else {
                            System.out.println("Errore: Non è stato selezionato nessuna opzione disponibile");
                        }
                    } while (!(scelta.equalsIgnoreCase("logout")));
                    System.out.println("Hai acquistato: " + totPiattiQ + " piatti e hai speso: " + contoTot);
                }
            } else {
                System.out.println("Errore: Non è stato selezionato nessuna opzione disponibile");
            }

        } while (chiudi == false);

    }

    public static boolean ControlloVuoto(String str) {
        if (str.equals("") || str.equals(" ")) {
            System.out.println("Non può essere lasciato vuoto");
            return false;
        }
        return true;
    }

    public static int controlloAccesso(String user, String pass, ArrayList<String> Utenti, ArrayList<String> Password,
            String adminU, String adminPass) {
        if (user.equals(adminU) && pass.equals(adminPass)) {
            return -1;
        }
        for (int i = 0; i < Utenti.size(); i++) {
            if (user.equalsIgnoreCase(Utenti.get(i)) && pass.equals(Password.get(i))) {
                return i;
            }
        }
        return -2;
    }

    public static boolean giaRegistrato(ArrayList<String> Utenti, String user) {
        for (int i = 0; i < Utenti.size(); i++) {
            if (user.equalsIgnoreCase(Utenti.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean controlloPass(String pass, Scanner sc) {
        System.out.print("Inserire la password: ");
        String verPass = sc.nextLine();
        if (verPass.equals(pass)) {
            return true;
        } else {
            System.out.println("Password errata, riprova");
            return false;
        }
    }

    public static void StampaPiatti(ArrayList<String> Piatti, ArrayList<Double> prezzo) {
        for (int i = 0; i < Piatti.size(); i++) {
            System.out.println(Piatti.get(i) + ": " + prezzo.get(i) + " Euro");
        }
    }
}
