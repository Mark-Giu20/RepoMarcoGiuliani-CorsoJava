class Es_IfElse {
    public static void main(String[] args) {
        // Inizializzazione variabili e valorizzazione
        int num1 = 3;
        int num2 = 13;
        int num3 = 13;

        // Tipo else if
        if (num1 == num2) { // Apertura else-if

            System.out.println("Numero 1 uguale a numero 2"); // Caso in cui num3 è uguale a num2

        } else if (num1 == num3) {

            System.out.println("Numero 1 uguale a numero 3"); // Caso in cui num1 è uguale a num3

        } else if (num2 == num3) {

            System.out.println("Numero 2 uguale a numero 3"); // Caso in cui num2 è uguale a num3

        } else {

            System.out.println("Tutti i numeri sono diversi"); // Caso in cui nessun numero è uguale a l'altro
        } // Fine else-if

        // Tipo if annidati
        if (num1 != num2) { //Apertura primo else-if

            if (num1 != num3) { //Apertura secondo else-if

                if (num2 == num3) { //Apertura terzo else-if

                    System.out.println("Numero 2 uguale a numero 3"); // Caso in cui num2 è uguale a num3

                }else{

                    System.out.println("Tutti i numeri sono diversi"); // Caso in cui nessun numero è uguale a l'altro

                }   //Chiusura terzo else-if

            } else {

                System.out.println("numero 1 uguale a numero 3"); // Caso in cui num1 è uguale a num3

            }   //Chiusura secondo else-if
        } else {

            System.out.println("numero 1 uguale a numero 2"); // Caso in cui num3 è uguale a num2

        }   //Chiusura primo else-if
    }// Fine main
}// Fine classe Es_IfElse
