/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cephy_2015;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Patient K.-MULEKYA
 */

public class VARIOGRAPH extends JPanel {
    int [] DonneesLAGDISTANCE;
    double [] DonneesVARIOGRAMME;
        
    public VARIOGRAPH(Regress REGRESSION){
        this.DonneesLAGDISTANCE=REGRESSION.DonneesLAGDISTANCE;
        this.DonneesVARIOGRAMME=REGRESSION.DonneesVARIOGRAMME;
    }
    public void paintComponent(Graphics g){
        //recherche valeur maximale
        double varioMax=0;
        for (int i=0;i<DonneesVARIOGRAMME.length;i++){
            if (varioMax<DonneesVARIOGRAMME[i])
                varioMax=DonneesVARIOGRAMME[i];
        }
        double echelle;
        echelle=400/varioMax;
        g.setColor(Color.white);
        g.fillRect(0, 0, 900, 900);
        g.setColor(Color.black);
        g.drawLine(50, 20, 50, 440);
        g.drawLine(50, 440, 470, 440);
        g.drawLine(50,20,45,30);
        g.drawLine(50,20,55,30);
        g.drawLine(470, 440, 460, 435);
        g.drawLine(470, 440, 460, 445);
        
        double  LagMax=0, VarMax=0;
           for (int i=0;i<DonneesLAGDISTANCE.length;i++){
           if (LagMax<DonneesLAGDISTANCE[i])
               LagMax=DonneesLAGDISTANCE[i];
           if (VarMax<DonneesVARIOGRAMME[i])
               VarMax=DonneesVARIOGRAMME[i];
           }
           double VarInterC= VarMax/5;
           double LagInterC=LagMax/5;
        for (int i=0;i<5;i++){
            g.drawLine(45, i*80+40, 50, i*80+40);
            g.drawString(""+(int)((VarMax-i*VarInterC)),25,i*80+38);
            g.drawLine(i*80+130, 440, i*80+130, 445);
            g.drawString(""+(int)(((i+1)*LagInterC)), (i+1)*80+52, 452);
        }
        //le point (0,0)
        g.fillOval(47, 437, 6, 6);
        g.drawString("0", 35, 449);
        //D'autres points
        for (int i=0; i<DonneesVARIOGRAMME.length; i++)
            if (DonneesVARIOGRAMME[i]!=0)
                g.fillOval((50+i*400/DonneesLAGDISTANCE.length)-3,((int)((440-(DonneesVARIOGRAMME[i]*echelle))))-3, 6,6);
        
    }
}
