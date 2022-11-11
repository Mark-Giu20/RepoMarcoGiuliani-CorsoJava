class Es_OperatoriLogici {
    public static void main(String[] args) {
        //Inizializzazione variabili
        double var1;
        double var2;
        int var3;
        boolean bool1;
        boolean bool2;
        
        //Valorizzazione variabili
        var1 = 'b';
        var2 = 123.34;
        var3 = 1;
        bool1 = true;
        bool2 = false;

        double somma = var1+var2+var3;  //Somma delle variabili
        System.out.println("Il risultato della somma è: " + somma); //Stampa della somma
        double divisione = somma/3; //Divisione della somma
        System.out.println("Dopo la divisione per 3 il risultato è: " + divisione); //Stampa della divisione
        System.out.println("Evviva!");   //Stampa Evviva
        
        System.out.println(bool1==(!bool2));    //Stampa del confronto tra i due booleani
    }//Fine Main
}//Fine classe Es_OperatoriLogici
