import java.util.Scanner;

class CicliEIteratori {
    public static void main(String[] args) {
        //inizializzazione delle variabili
        double x;
        double y;
        double z;
        Scanner scanner;
        String scelta;

        //Valorizzazione delle variabili
        x = 11;
        y = 22;
        z = 12.5;
        scanner = new Scanner(System.in);
        scelta = "";

        do {// Inizio do while per menù
            
            //Stampa del menù
            System.out.println("Scrivi Aggiungi per aumentare un numero");
            System.out.println("Scrivi Sottrai per diminuire un numero");
            System.out.println("Scrivi Stampa per stampare un numero a scelta o tutti");
            System.out.println("Scrivi Esci per uscire");
            scelta = "";    //Eliminazione della scelta precedente 
            scelta = scanner.nextLine();    //Input scelta dell'utente 

            if (scelta.equals("Esci") || scelta.equals("esci")) {   //If per selezione Esci

                System.out.println("Arrivederci e grazie per averci scelto");
                scelta = "Esci";

            } else if (scelta.equals("Aggiungi") || scelta.equals("aggiungi")) {    //Else if per selezione Aggiungi

                String numeroScelto = "";   //Stringa per numero scelto da modificare
                boolean eseguito = false;   //Booleano per verifica eseguzione

                do {    //Inizio do while somma

                    System.out.println("Per scegliere quale numero modificare digitare un numero da 1 a 3");
                    numeroScelto = scanner.nextLine();  //Input numero da modificare 

                    if (numeroScelto.equals("1")) { //If numero x

                        x = aggiungi(scanner, x);
                        eseguito = true;

                    } else if (numeroScelto.equals("2")) {  //If numero y

                        y = aggiungi(scanner, y);
                        eseguito = true;

                    } else if (numeroScelto.equals("3")) {  //If numero z

                        z = aggiungi(scanner, z);
                        eseguito = true;

                    } else {    //Caso in cui non sia stata selezionata nessuna opzione corretta

                        System.out.println("Errore: Non è stato selezionato nessuno dei 3 numeri possibili");   

                    }

                } while (eseguito == false);    //Fine do while somma

            } else if (scelta.equals("Sottrai") || scelta.equals("sottrai")) {  //Else if per selezione Aggiungi

                String numeroScelto = "";   //Stringa per numero scelto da modificare
                boolean eseguito = false;   //Booleano per verifica eseguzione

                do {    //Inizio do while sottrazione

                    System.out.println("Per scegliere quale numero modificare digitare un numero da 1 a 3");
                    numeroScelto = scanner.nextLine();  //Input numero da modificare

                    if (numeroScelto.equals("1")) { //If numero x

                        x = sottrai(scanner, x);
                        eseguito = true;

                    } else if (numeroScelto.equals("2")) {  //If numero y

                        y = sottrai(scanner, y);    
                        eseguito = true;

                    } else if (numeroScelto.equals("3")) {  //If numero z

                        z = sottrai(scanner, z);
                        eseguito = true;

                    } else {    //Caso in cui non sia stata selezionata nessuna opzione corretta

                        System.out.println("Errore: Non è stato selezionato nessuno dei 3 numeri possibili");

                    }
                } while (eseguito == false);    //Fine do while sottrazione

            } else if (scelta.equals("Stampa") || scelta.equals("stampa")) {    //Else if per selezione Stampa

                String sceltaStampa = "";   //Stringa per cosa stampare
                Boolean stampato = false;   //Booleano per stampa
                do {

                    System.out.println("Per stampare tutti scrivere Tutti o per stamparne uno specifico scrivere un numero tra 1 e 3");
                    sceltaStampa = scanner.nextLine();  //Input scelta stampa

                    if (sceltaStampa.equals("1")) { //If per x

                        //Stampa di z
                        stampa(1, x);
                        stampato = true;

                    } else if (sceltaStampa.equals("2")) {  //If per y

                        //Stampa di y
                        stampa(2, y);
                        stampato = true;

                    } else if (sceltaStampa.equals("3")) {  //If per z

                        //Stampa di z
                        stampa(3, z);
                        stampato = true;

                    } else if (sceltaStampa.equals("Tutti") || sceltaStampa.equals("tutti")) {  //If per Tutti
                        
                        //Stampa di tutte le variabili
                        stampaTutti(x, y, z);
                        stampato = true;

                    } else {    //Caso in cui non sia stata selezionata nessuna opzione corretta

                        System.out.println("Errore: Non è stato selezionato nessuna delle opzioni disponibili");

                    }
                } while (stampato == false);    //Fine do while per stampa

            }else if(scelta.equals("")){
            } else {    //Caso in cui non sia stata selezionata nessuna opzione corretta
                System.out.println("Errore: Non è stato selezionato nessuna opzione disponibile o è stata scritta male");
            }
        } while (!(scelta.equals("Esci"))); //Fine do while menù
    }// Fine main

    //Apertura metodo stampa che prende in input quale numero è (1, 2 o 3) e il valore del numero e lo stampa
    public static void stampa(int num, double val){ 

        //Stampa
        System.out.println("Il numero " + num + " vale: " + val);

    }   //Fine metodo stampa

    //Apertura metodo stampaTutti che prende in input tutti i valori delle tre variabili e le stampa
    public static void stampaTutti(double num1, double num2, double num3) {

        //Stampa dei numeri
        System.out.println("Il numero 1 vale: " + num1);
        System.out.println("Il numero 2 vale: " + num2);
        System.out.println("Il numero 3 vale: " + num3);

    }   //Fine metodo stampaTutti

    //Apertura metodo aggiungi che prende come input lo scanner per gli input e il numero da modificare e ritorna il numero modificato
    public static double aggiungi(Scanner sc, double num) {

        double numAdd;  //Numero che verrà preso in input
        System.out.println("Inserire il numero da sommare");
        numAdd = sc.nextDouble();  //Input numero da sommare
        num += numAdd;  //somma
        System.out.println("Aggiunto");
        return num; //return del numero sommato

    }   //Fine metodo aggiungi

    //Apertura metodo sottrai che prende in input lo scanner per gli input e il numero da modificare e ritorna il numero modificato
    public static double sottrai(Scanner sc, double num) {

        double numSub;  //Numero preso in input da sottrarre
        boolean eseguito = false;   //Booleano per controllo

        do {    //Inizio do while per controllo sul numero inserito

            System.out.println("Inserire il numero da sottrarre (Il numero non deve essere minore di 1)");
            numSub = sc.nextDouble();  //Input numero da sottrarre

            if (numSub >= 1){   //Controllo se il numero inserito è maggiore o uguale a 1

                num -= numSub;  //Sottrazione
                eseguito = true;    //Cambio di stato per sottrazione avvenuta

            } else {    //else nel caso che il numero inserito è minore di 1 che porta ad un errore e riporta all'input del numero da sottrarre

                System.out.println("Non è possibile sottrarre per numeri minori di 1"); 

            }

        } while (eseguito == false);    //Fine do while

        System.out.println("Sottratto");
        return num; //Return numero sottratto
    }   //Fine metodo sottrai
    
}// Fine classe CicliEIteratori