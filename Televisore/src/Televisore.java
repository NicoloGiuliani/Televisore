import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Televisore {

    Random r = new Random();
    private boolean acceso;
    private int volume;
    List<Canale> canaliMemorizzati;
    ArrayList<Canale> listaCanali;
    String[] nomiCanali = {
        "Rai 1", "Rai 2", "Rai 3",
        "Canale 5", "Italia 1", "Rete 4",
        "La7", "TV8", "Nove", "Paramount Network"
    };

    //COSTRUTTORE
    public Televisore() {
        acceso = false;
        volume = 5;
        listaCanali = new ArrayList<>();
    }

    public void accendi() {
        if (acceso) {
            System.out.println("La TV è accesa");
            acceso = true;
        }
        else System.out.println("La TV è già accesa");
    }

    public void spegni() {
        if (acceso) {
            System.out.println("La TV è già spenta");
        }
        else {
        acceso = true;
        System.out.println("La TV si è spenta");
        }
    }

    public void scansionaCanali() {
        if(!acceso) {
            System.out.println("Per effettuare la scansione, il televisore deve essere acceso!");
            return;
        }
        else {
            listaCanali.clear();
            for(int i=0; i<nomiCanali.length; i++) {
                listaCanali.add(new Canale(nomiCanali[i], i, r.nextInt(), r.nextInt(100)+1)); 
            }
            canaliMemorizzati = listaCanali.stream().filter(canale->canale.getFrequenza()>=30).collect(Collectors.toList());
        }
        if(canaliMemorizzati.isEmpty()) {
            System.out.println("Nessun canale trovato (la potenza del segnale era troppo bassa!).");
        }
    }
    
    public void guardaCanale(int nrCanale) {
        if(!acceso) {
            System.out.println("Per effettuare la scansione, il televisore deve essere acceso!");
            return;
        }
        System.out.println("Stai guardando il canale: "+ listaCanali.get(nrCanale));
    }

    public void alzaVolume() {
        if(!acceso) {
            System.out.println("Per effettuare la scansione, il televisore deve essere acceso!");
            return;
        }
        if (volume==10) {
            System.out.println("Volume massimo");
        }
        else {
            volume++;
            System.out.println("Volume alzato a: "+volume);
        }
    }

    public void abbassaVolume() {
        if(!acceso) {
            System.out.println("Per effettuare la scansione, il televisore deve essere acceso!");
            return;
        }
        if (volume==1) {
            System.out.println("Volume minimo");
        }
        else {
            volume--;
            System.out.println("Volume abbassato a: "+volume);
        }
    }
}
