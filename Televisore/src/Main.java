import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        Televisore televisore = new Televisore();
        int scelta = 0;

        while (scelta != 6) {
            System.out.println("Benvenuto nel menù del televisore\n");
            System.out.println("Stato attuale del televisore: " + televisore.toString());

            System.out.println("1. accendi/spegni");
            System.out.println("2. scansiona canali");
            System.out.println("3. guarda canale");
            System.out.println("4. alza volume");
            System.out.println("5. abbassa volume");
            System.out.println("6. esci");

            System.out.print("Scegli l'azione da eseguire: ");
            scelta = input.nextInt();

            switch (scelta) {
                case 1:
                    televisore.ON_OFF();
                    break;
                case 2:
                    televisore.scansionaCanali();
                case 3:
                    int canale = -1;

                    if (televisore.isacceso() && televisore.isCanaliScansionati()) {
                        System.out.println("Quale canale vuoi guardare?");
                        canale = input.nextInt();
                    }

                    Canale canale2;
                    canale2 = televisore.guardaCanale(canale);

                    if (canale2 == null) {
                        System.out.println("Per guardare il canale, il televisore deve essere acceso!\n");
                    
                        if (!televisore.isCanaliScansionati()) {
                            System.out.println("Per guardare i canali devi prima effettuare la scansione\n");
                        }
                        else if (televisore.listaVuota()) {
                            System.out.println("Nessun canale trovato\n");
                        }
                        break;
                    }

                    if (!televisore.isCanaliScansionati()) {
                        System.out.println("Nessun canale scansionato\n");
                    } else
                        System.out.println("Stai guardando il canale: " + canale2 + "\n");
                    break;
                case 4:
                    televisore.alzaVolume();
                    break;
                case 5:
                    televisore.abbassaVolume();
                    break;
                case 6:
                    System.out.println("Arrivederci");
            }
        }
        input.close();
    }
}
