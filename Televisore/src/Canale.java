public class Canale {
    private String nomeCanale;
    private int nrCanale;
    private int frequenza;
    private int potenzaRilevata;

    //COSTRUTTORE
    public Canale(String nomeCanale, int nrCanale, int frequenza, int potenzaRilevata) {
        this.nomeCanale = nomeCanale;
        this.nrCanale = nrCanale;
        this.frequenza = frequenza;
        this.potenzaRilevata = potenzaRilevata;
    }
    
    //GETTERS
    public String getNomeCanale() {
        return nomeCanale;
    }
    
    public int getNrCanale() {
        return nrCanale;
    }
    
    public int getFrequenza() {
        return frequenza;
    }
    
    public int getPotenzaRilevata() {
        return potenzaRilevata;
    }

    //TO STRING
    @Override
    public String toString() {
        return "Nome canale= " + nomeCanale + ", frequenza=" + frequenza
                + ", potenzaRilevata=" + potenzaRilevata;
    }

}
