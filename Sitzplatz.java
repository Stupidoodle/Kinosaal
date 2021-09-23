
public class Sitzplatz
{
    
    private int platznr;
    private int reihe;
    private boolean istBelegt;
    private boolean istEinzelplatz;
    private boolean istLogenplatz;
    private boolean istRollstuhlplatz;
    private double preis;
    
    public Sitzplatz(int pPlatznr, int pReihe, boolean pIstEinzelplatz, boolean pIstLogenplatz, boolean pIstRollstuhlplatz, double pPreis)
    {
        platznr = pPlatznr;
        reihe = pReihe;
        istBelegt = false;
        istEinzelplatz = pIstEinzelplatz;
        istLogenplatz = pIstLogenplatz;
        istRollstuhlplatz = pIstRollstuhlplatz;
        preis = pPreis;
    }
    
    public int getPlatznr(){
        return platznr;
    }

    public int getReihe(){
        return reihe;
    }

    public boolean getBelegt(){
        return istBelegt;
    }

    public boolean getEinzelplatz(){
        return istEinzelplatz;
    }

    public boolean getLogenplatz(){
        return istLogenplatz;
    }

    public boolean getRollstuhlplatz(){
        return istRollstuhlplatz;
    }

    public double getPreis(){
        return preis;
    }

    public void setBelegt(boolean pBelegung){
        istBelegt = pBelegung;
    }

    public void setPreis(double pPreis){
        preis = pPreis;
    }
}
