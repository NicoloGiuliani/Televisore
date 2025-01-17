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
                    break;
                case 3:
                    if (televisore.isAcceso()) {
                        if (televisore.isCanaliScansionati()) {
                            System.out.println("Inserisci il canale: ");
                            scelta = input.nextInt();
                            Canale canale = televisore.guardaCanale(scelta);
                            if (canale != null) {
                                System.out.println("Stai guardando " + canale);
                            } else {
                                System.out.println("Canale " + scelta + " non trovato!");
                            }
                        } else {
                            System.out.println("Non sono stati scansionati i canali");
                        }
                    } else {
                        System.out.println("Il televisore dev'essere acceso");
                    }
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
