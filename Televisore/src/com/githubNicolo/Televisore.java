package com.githubNicolo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Televisore {

    Random r = new Random();
    List<Canale> canaliMemorizzati;
    ArrayList<Canale> listaCanali;
    String[] nomiCanali = {
            "Rai 1", "Rai 2", "Rai 3", "Rete 4",
            "Canale 5", "Italia 1",
            "La7", "TV8", "Nove", "Paramount Network"
    };
    private boolean acceso;
    private boolean canaliScansionati;
    private int volume;

    // COSTRUTTORE
    public Televisore() {
        acceso = false;
        canaliScansionati = false;
        volume = 5;
        listaCanali = new ArrayList<>();
    }

    // METODI
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
            System.out.println("Per effettuare la scansione, il televisore deve essere acceso!\n");
            return;
        } else {
            listaCanali.clear();
            for (int i = 0; i < nomiCanali.length; i++) {
                listaCanali.add(new Canale(nomiCanali[i], i+1, r.nextInt(), r.nextInt(100) + 1));
            }
            canaliMemorizzati = listaCanali.stream().filter(canale -> canale.getPotenzaRilevata() >= 30)
                    .collect(Collectors.toList());
            canaliScansionati = true;
        }
        if (canaliMemorizzati.isEmpty()) {
            System.out.println("Nessun canale trovato (la potenza del segnale era troppo bassa!).\n");
        }
    }

    public boolean listaVuota() {
        return canaliMemorizzati.isEmpty();
    }

    private Canale selezionaCanale(int nrCanale) {
        for (Canale canale : canaliMemorizzati) {
            if (canale.getNrCanale()==nrCanale) {
                return canale;
            }
        }
        return null;
    }

    public Canale guardaCanale(int nrCanale) {
        if (!acceso)
            throw new IllegalStateException("Non puoi guardare un canale se la TV è spentan\n");

        if (listaVuota())
            return null;
        if (nrCanale >= canaliMemorizzati.size())
            return null;

        return selezionaCanale(nrCanale);
    }

    public void alzaVolume() {
        if (!acceso) {
            System.out.println("Per alzare il volume, il televisore deve essere acceso!\n");
            return;
        }
        if (volume == 10) {
            System.out.println("Volume massimo\n");
        } else {
            volume++;
            System.out.println("Volume alzato a: " + volume + "\n");
        }
    }

    public void abbassaVolume() {
        if (!acceso) {
            System.out.println("Per abbassare il volume, il televisore deve essere acceso!\n");
            return;
        }
        if (volume == 1) {
            System.out.println("Volume minimo\n");
        } else {
            volume--;
            System.out.println("Volume abbassato a: " + volume + "\n");
        }
    }

    // GETTER
    public boolean isAcceso() {
        return acceso;
    }

    public boolean isCanaliScansionati() {
        return canaliScansionati;
    }

    @Override
    public String toString() {
        return "Televisore [acceso=" + acceso + ", volume=" + volume + ", canaliMemorizzati=" + canaliMemorizzati
                + ", canaliScansionati=" + canaliScansionati
                + "]";
    }
}
