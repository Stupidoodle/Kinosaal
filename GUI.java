import java.awt.*;
import javax.swing.*;

public class GUI extends JPanel{
    private Sitzplatz[][] saalplan;
    public GUI(Sitzplatz[][] pSaalplan){
        saalplan = pSaalplan;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        System.out.println();
        for(int j = 0; j < saalplan.length; j++){
            for(int i = 0; i < saalplan[j].length; i++){
                if(saalplan[j][i].getEinzelplatz())
                    g.setColor(new Color(25, 25, 255));
                else if(saalplan[j][i].getLogenplatz())
                    g.setColor(new Color(200, 200, 100));
                else if(saalplan[j][i].getRollstuhlplatz())
                    g.setColor(new Color(25, 255, 25));
                    
                if(saalplan[j][i].getBelegt()){
                    g.setColor(new Color(255, 25, 25));
                    g.drawRect(i * 55, j * 55, 50, 50);
                }
                else{
                    g.drawRect(i * 55, j * 55, 50, 50);
                }
            }
            System.out.println();
        }
    }
}
