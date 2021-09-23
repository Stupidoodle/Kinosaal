public class Kinosaal
{

    private Sitzplatz[][] saalplan;
    private int saalnr;

    public Kinosaal(int pSaalnr, int pAnzahlReihen, int pAnzahlplätzeProReihe)
    {
        saalnr = pSaalnr;
        saalplan = new Sitzplatz[pAnzahlReihen][pAnzahlplätzeProReihe];

        for(int i = 0; i < pAnzahlReihen; i++){
            for(int j = 0; j < pAnzahlplätzeProReihe; j++){
                int reihe = i + 1;
                int platznr = j + 1;

                boolean istRollstuhlplatz = (reihe <= 3 && platznr <= 2);
                boolean istLogenplatz = (reihe % 3 == 0);
                boolean istEinzelplatz = (reihe % 2 == 0);
                double preis = brechnePreis(istLogenplatz, istEinzelplatz, istRollstuhlplatz);
                
                saalplan[i][j] = new Sitzplatz(platznr, reihe, istEinzelplatz, istLogenplatz, istRollstuhlplatz, preis);
            }
        }
    }

    public Sitzplatz[][] getSaalplan(){
        return saalplan;
    }

    public int getSaalnr(){
        return saalnr;
    }

    public boolean buchen(int pPlatznr, int pReihe){
        if(!saalplan[pReihe - 1][pPlatznr - 1].getBelegt()){
            saalplan[pReihe - 1][pPlatznr - 1].setBelegt(true);
            return true;
        }

        return false;
    }

    public int[] sucheFreienPlatz(boolean pLoge, boolean pEinzel, boolean pRollstuhl){
        for(int i = 0; i < saalplan.length; i++){
            for(int j = 0; j < saalplan[0].length; j++){
                if(saalplan[i][j].getLogenplatz() == pLoge && saalplan[i][j].getEinzelplatz() == pEinzel && saalplan[i][j].getRollstuhlplatz() == pRollstuhl && !saalplan[i][j].getBelegt())
                    return new int[]{saalplan[i][j].getReihe(), saalplan[i][j].getPlatznr()};
                break;
            }
        }
        return new int[]{-1, -1};
    }

    public void saalLeeren(){
        for(int i = 0; i < saalplan.length; i++){
            for(int j = 0; j < saalplan[0].length; j++){
                saalplan[i][j].setBelegt(false);
            }
        }
    }

    public double brechnePreis(boolean pLoge, boolean pEinzel, boolean pRollstuhl){
        double preis = 10;

        if(pLoge)
            preis += 5;
        
        if(pEinzel)
            preis += 2;

        if(pRollstuhl)
            preis -= 3;
        
        return preis;
    }

    public double getUmsatz(){
        double einnahmen = 0;
        for(int i = 0; i < saalplan.length; i++){
            for(int j = 0; j < saalplan[0].length; j++){
                if(saalplan[i][j].getBelegt())
                    einnahmen += brechnePreis(saalplan[i][j].getLogenplatz(), saalplan[i][j].getEinzelplatz(), saalplan[i][j].getRollstuhlplatz());
            }
        }
        return einnahmen;
    }

    public void showPlan(){
        System.out.println();
        for(int j = 0; j < saalplan.length; j++){
            for(int i = 0; i < saalplan[j].length; i++){
                System.err.println(j + " " + i);    
                if(saalplan[j][i].getBelegt())
                    System.out.print("X");
                else
                    System.out.print("O");
            }
            System.out.println();
        }
    }
}
