/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cephy_2015;

/**
 *
 * @author Patient K.-MULEKYA
 */
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

public class VARIOGRAPH2 extends JPanel {

    Regress REGRESSION;
    
    public VARIOGRAPH2(Regress REGRESSION){
        this.REGRESSION=REGRESSION;
    }
    
    public void paintComponent(Graphics g){
        //recherche valeur maximale
        REGRESSION.spherique();
        double varioMax=0;
        double lagdistMax=0;
        for (int i=0;i<REGRESSION.DonneesLAGDISTANCE.length;i++){
            if (varioMax<REGRESSION.DonneesVARIOGRAMME[i]){
                varioMax=REGRESSION.DonneesVARIOGRAMME[i];
        }
            if (lagdistMax<REGRESSION.DonneesLAGDISTANCE[i])
                lagdistMax=REGRESSION.DonneesLAGDISTANCE[i];
                
        }
        
        double echelleDist =400/lagdistMax; 
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
        
        
           double VarInterC= varioMax/5;
           double LagInterC=lagdistMax/5;
           if (VarInterC>=10){
                for (int i=0;i<5;i++){
                    g.drawLine(45, i*80+40, 50, i*80+40);
                    g.drawString(""+(int)((varioMax-i*VarInterC)),25,i*80+38);
                    g.drawLine(i*80+130, 440, i*80+130, 445);
                    g.drawString(""+(int)(((i+1)*LagInterC)), (i+1)*80+52, 452);
                }
        }
           else {
               
               for (int i=0;i<5;i++){
                    g.drawLine(45, i*80+40, 50, i*80+40);
                    g.drawString(""+((int)(((varioMax-i*VarInterC)*100000)))/100000.0,25,i*80+38);
                    g.drawLine(i*80+130, 440, i*80+130, 445);
                    g.drawString(""+(int)((i+1)*LagInterC), (i+1)*80+52, 452);
                }
           }
        //le point (0,0)
        g.fillOval(47, 437, 6, 6);
        g.drawString("0", 35, 449);
        //D'autres points
        for ( int i=0; i<REGRESSION.DonneesLAGDISTANCE.length; i++)
            if (REGRESSION.DonneesVARIOGRAMME[i]!=0)
                g.fillOval((50+i*400/20)-3,((int)((440-(REGRESSION.DonneesVARIOGRAMME[i]*echelle))))-3, 6,6);
        
        for ( int i=1; i<REGRESSION.DonneesLAGDISTANCE.length-1; i++)
            if (REGRESSION.DonneesVARIOGRAMME[i]!=0){
                int b=i;
                while (REGRESSION.DonneesVARIOGRAMME[b-1]==0 && b-1!=0){
                    b=i-1;
                   
                }
                    g.drawLine((50+i*400/20)-1,((int)((440-(REGRESSION.DonneesVARIOGRAMME[i]*echelle))))-1,(50+(b-1)*400/20)-1,((int)((440-(REGRESSION.DonneesVARIOGRAMME[(b-1)]*echelle))))-1);
                }
        // Soit le modèle sphérique du variogramme y(L) = t*L-u*L^3
        double t = REGRESSION.Co*3/(2*REGRESSION.a);
        double u = REGRESSION.Co/(2*Math.pow(REGRESSION.a,3));
        
        
        System.out.println("VarioMax = " +varioMax);
        System.out.println("LagMax  = " +lagdistMax);
        System.out.println("the range is " +REGRESSION.a);
        System.out.println("la covariance log O est égale à " +REGRESSION.Co);
        g.setColor(Color.blue);
        int i=0;
        while (i<REGRESSION.a*echelleDist){
            double L=i/echelleDist;
            g.drawRect(50+i,(int)((440-(t*L-u*Math.pow(L, 3))*echelle)),1,1);
            //50+i+1,(int)((440-(t*(L+1)-u*Math.pow(L+1,3)*echelle))));
          //  System.out.println(i);
            i++;
        }
        
        for (i=(int)((REGRESSION.a*echelleDist)); i<lagdistMax*echelleDist; i++){
            double L=REGRESSION.a;
            g.drawRect(50+i,(int)((440-(t*L-u*Math.pow(L, 3))*echelle)) , 1, 1);
        }
            
        g.setColor(Color.red);
        g.drawLine((int)((50+REGRESSION.a*echelleDist)), (int)((440-REGRESSION.Co*echelle)), 50, (int)((440-REGRESSION.Co*echelle)));
        g.drawLine((int)((50+REGRESSION.a*echelleDist)), (int)((440-REGRESSION.Co*echelle)), (int)((50+REGRESSION.a*echelleDist)),440);
        if (VarInterC>=10)
            g.drawString(""+(int)REGRESSION.Co,20, (int)((440-REGRESSION.Co*echelle)));
        else g.drawString(""+((int)((REGRESSION.Co*100000)))/100000.0,20, (int)((440-REGRESSION.Co*echelle)));
        g.drawString(""+(int)REGRESSION.a,(int)((50+REGRESSION.a*echelleDist)),452);
        g.setColor(Color.BLACK);
        g.drawString("v",7,100);
        g.drawString("a",7,110);
        g.drawString("r",8,120);
        g.drawString("i",9,130);
        g.drawString("o",7,140);
        g.drawString("g",7,150);
        g.drawString("r",8,160);
        g.drawString("a",7,170);
        g.drawString("m",5,180);
        g.drawString("m",5,190);
        g.drawString("e",7,200);
        g.drawString("distance", 250, 465);
        
    }
}
