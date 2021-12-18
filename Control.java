import javax.swing.*;
import java.awt.*;

import java.util.Random;

public class Control extends JPanel{
    private JFrame frame;
    private Kinosaal kinosaal;
    private GUI gui;

    private Random rand;
    private int x;
    private int y;

    public Control(int pSaalnr, int pAnzahlReihen, int pAnzahlplätzeProReihe){
        x = pAnzahlplätzeProReihe;
        y = pAnzahlReihen;

        kinosaal = new Kinosaal(pSaalnr, pAnzahlReihen, pAnzahlplätzeProReihe);
        gui = new GUI(kinosaal.getSaalplan());
        rand = new Random();
        frame = new JFrame();
        frame.add(gui);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setVisible(true);
        frame.pack();
    }

    public void visit(){
        for(int i = 0; i < x - x / 2; i++){
            int n = rand.nextInt(x);
            int na = rand.nextInt(y);
            n += 1;
            na += 1;
            this.buchen(n, na);
        }
    }

    public int getSaalnr(){
        return kinosaal.getSaalnr();
    }

    public boolean buchen(int pPlatznr, int pReihe){
        boolean temp = kinosaal.buchen(pPlatznr, pReihe);
        SwingUtilities.updateComponentTreeUI(frame);

        return temp;
    }

    public int[] sucheFreienPlatz(boolean pLoge, boolean pEinzel, boolean pRollstuhl){
        return kinosaal.sucheFreienPlatz(pLoge, pEinzel, pRollstuhl);
    }

    public void saalLeeren(){
        kinosaal.saalLeeren();
        SwingUtilities.updateComponentTreeUI(frame);
    }

    public double berechnePreis(boolean pLoge, boolean pEinzel, boolean pRollstuhl){
        return kinosaal.brechnePreis(pLoge, pEinzel, pRollstuhl);
    }

    public double getUmsatz(){
        return kinosaal.getUmsatz();
    }

    public void showPlan(){
        kinosaal.showPlan();
    }
}
