import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Televisore {

    Random r = new Random();
    List<Canale> canaliMemorizzati;
    ArrayList<Canale> listaCanali;
    String[] nomiCanali = {
            "Rai 1", "Rai 2", "Rai 3",
            "Canale 5", "Italia 1", "Rete 4",
            "La7", "TV8", "Nove", "Paramount Network"
    };
    private boolean acceso;
    private boolean canaliScansionati;
    private int volume;

    //COSTRUTTORE
    public Televisore() {
        acceso = false;
        canaliScansionati = false;
        volume = 5;
        listaCanali = new ArrayList<>();
    }

    //METODI
    public void ON_OFF() {
        if (acceso) {
            System.out.println("La TV è spenta\n");
            acceso = false;
        } else {
            System.out.println("La TV è accesa\n");
            acceso = true;
        }
    }

    public void scansionaCanali() {
        if (!acceso) {
            System.out.println("Per effettuare la scansione, il televisore deve essere acceso!");
            return;
        } else {
            listaCanali.clear();
            for (int i = 0; i < nomiCanali.length; i++) {
                listaCanali.add(new Canale(nomiCanali[i], i, r.nextInt(), r.nextInt(100) + 1));
            }
            canaliMemorizzati = listaCanali.stream().filter(canale -> canale.getFrequenza() >= 30).collect(Collectors.toList());
            canaliScansionati = true;
        }
        if (canaliMemorizzati.isEmpty()) {
            System.out.println("Nessun canale trovato (la potenza del segnale era troppo bassa!).");
        }
    }

    public boolean listaVuota() {
        return canaliMemorizzati.isEmpty();
    }

    public Canale guardaCanale(int nrCanale) {
        if (!acceso) throw new IllegalStateException("Non puoi guardare un canale se la TV è spenta");

        if (listaVuota()) return null;
        if (nrCanale >= canaliMemorizzati.size()) return null;

        return canaliMemorizzati.get(nrCanale);
    }

    public void alzaVolume() {
        if (!acceso) {
            System.out.println("Per effettuare la scansione, il televisore deve essere acceso!");
            return;
        }
        if (volume == 10) {
            System.out.println("Volume massimo");
        } else {
            volume++;
            System.out.println("Volume alzato a: " + volume);
        }
    }

    public void abbassaVolume() {
        if (!acceso) {
            System.out.println("Per effettuare la scansione, il televisore deve essere acceso!");
            return;
        }
        if (volume == 1) {
            System.out.println("Volume minimo");
        } else {
            volume--;
            System.out.println("Volume abbassato a: " + volume);
        }
    }

    //GETTER
    public boolean isAcceso() {
        return acceso;
    }

    public boolean isCanaliScansionati() {
        return canaliScansionati;
    }

    @Override
    public String toString() {
        return "Televisore [acceso=" + acceso + ", volume=" + volume + ", canaliMemorizzati=" + canaliMemorizzati + "canaliScansionati=" + canaliScansionati
                + ", listaCanali=" + listaCanali + "]";
    }
}
