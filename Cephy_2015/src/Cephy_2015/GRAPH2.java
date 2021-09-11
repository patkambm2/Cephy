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
public class GRAPH2 extends JPanel {    
    double echelle;
    double [] DonneesLONGITUDE;
    double [] DonneesLATITUDE;
    String [] DonneesETIQUETTE;
    int coté=500;
    int largeurC;
    int []DonneesLONGITUDEalorigine;
    int [] DonneesLATITUDEalorigine;
    double [] ParametreG;
    double ParametreGMin;
    double ParametreGMax;
    
    
    public GRAPH2(String [] DonneesETIQUETTE, double [] DonneesLONGITUDE,double [] DonneesLATITUDE, double [] Parametre){
        this.DonneesETIQUETTE=DonneesETIQUETTE;
        this.DonneesLONGITUDE=DonneesLONGITUDE;
        this.DonneesLATITUDE=DonneesLATITUDE;
        this.ParametreG=Parametre;
    }
    public int echelleParametre(double Parametre){
        int diametre=0;
        diametre= (int)(((Parametre-ParametreGMin)/(ParametreGMax-ParametreGMin)*20));
        return diametre;        
    }
    
    public void paintComponent(Graphics g){
        //Obtention des valeurs minima et maxima pour la création du cadre de la carte
       double LatMin=9999999999999.0, LatMax=0, LongMin=999999999999.0, LongMax=0;
       ParametreGMin=9999999999999.0;
       ParametreGMax=0;
       for (int i=0;i<DonneesLONGITUDE.length;i++){
           if (LongMax<DonneesLONGITUDE[i])
               LongMax=DonneesLONGITUDE[i];
           if (LatMax<DonneesLATITUDE[i])
               LatMax=DonneesLATITUDE[i];
           if (ParametreGMax<ParametreG[i])
               ParametreGMax=ParametreG[i];
           if (ParametreGMin>ParametreG[i])
               ParametreGMin=ParametreG[i];
           if (LongMin>DonneesLONGITUDE[i])
               LongMin=DonneesLONGITUDE[i];
           if (LatMin>DonneesLATITUDE[i])
               LatMin=DonneesLATITUDE[i];
       }
       //System.out.println("LongMax="+LongMax+"  LongMin="+LongMin+"  LatMax"+LatMax+"  LatMin="+LatMin);
       // Calcul de l'échelle de la carte (pixel/mètre
       double longueurT= LongMax-LongMin;
       double largeurT= LatMax-LatMin;
       
       if (largeurT<longueurT)
           echelle=450/longueurT;
           else echelle=450/largeurT;
       int longueurC =(int)((longueurT*echelle)+10);
        largeurC=(int)((largeurT*echelle)+10);
        g.setColor(Color.white);
        g.fillRect(0, 0, 10000, 10000);
        g.fillRect(20, 20,longueurC, largeurC);
        g.setColor(Color.BLACK);
        g.drawRect(20, 20,longueurC, largeurC);
        g.drawRect(20+500, 20,longueurC, largeurC);
        DonneesLONGITUDEalorigine=new int [DonneesLONGITUDE.length];
        DonneesLATITUDEalorigine=new int [DonneesLONGITUDE.length];
        for (int i=0;i<DonneesLONGITUDE.length;i++ ){
            DonneesLONGITUDEalorigine[i]=(int)((DonneesLONGITUDE[i]-LongMin)*echelle);
            DonneesLATITUDEalorigine[i]= (int)((DonneesLATITUDE[i]-LatMin)*echelle);
        }
         g.setColor(Color.green);
        for (int i=0;i<DonneesLONGITUDE.length;i++){
            //j'additionne +21 pour remettre les points dans le rectangle d'origine (20,20)
            
            g.fillOval(DonneesLONGITUDEalorigine[i]+21,(largeurC-DonneesLATITUDEalorigine[i]-10)+21, 5, 5);
          
        }
        g.setColor(Color.BLACK);
        
        //Je vais graduer la carte (géoréférencement)
        int intervalLONGITUDE = (int)((longueurC/5));
        for (int i=20;i<=longueurC+20;i+=intervalLONGITUDE){
            g.drawLine(i,15,i,20);
            g.drawString(""+(int)((i/echelle+LongMin-2*echelle)), i, 15);
            g.drawLine(i,largeurC+20,i,largeurC+25);
            g.drawString(""+(int)((i/echelle+LongMin-2*echelle)), i, largeurC+35);
        }
        int intervalLATITUDE = (int)((largeurC/5)) ;
        for (int i=20;i<=largeurC+30;i+=intervalLATITUDE){
            g.drawLine(15,i,20,i);
           // g.drawString(""+(int)((i/echelle+LatMin)), i, 15);
            g.drawLine(20+longueurC, i, 25+longueurC, i);
            g.drawString(""+(int)((-(i-20)/echelle+LatMax+2/echelle)), 20+longueurC, i);
        }
        //etiquettage
        for (int i=0;i<DonneesLONGITUDE.length;i++){
            //j'additionne +22 pour remettre les points dans le rectangle d'origine (20,20)
            
            g.drawString(DonneesETIQUETTE[i], DonneesLONGITUDEalorigine[i]+22,(largeurC-DonneesLATITUDEalorigine[i]-10)+22);
          
        }
         /*
         * DEUXIEME CARTE 
         */
        g.setColor(Color.BLUE);
        
        // Les cercles aux rayons proportionnels à la valeur du paramètre séléctionné
        for (int i=0;i<DonneesLONGITUDE.length;i++){
            //j'additionne +22 pour remettre les points dans le rectangle d'origine (20,20
            int p=echelleParametre(ParametreG[i]);
            g.drawOval(DonneesLONGITUDEalorigine[i]+500+23-p/2,(largeurC-DonneesLATITUDEalorigine[i]-10)+23-p/2, p, p);
        }
        // point au milieu des cercles
        g.setColor(Color.BLACK);
        for (int i=0;i<DonneesLONGITUDE.length;i++){
            // point au milieu des cercles
            g.fillOval(DonneesLONGITUDEalorigine[i]+500+22,(largeurC-DonneesLATITUDEalorigine[i]-10)+22, 3, 3); 
        }         
        
        //Je vais graduer la carte (géoréférencement)
        
        for (int i=20;i<=longueurC+20;i+=intervalLONGITUDE){
            g.drawLine(i+500,15,i+500,20);
            g.drawString(""+(int)((i/echelle+LongMin-2*echelle)), i+500, 15);
            g.drawLine(i+500,largeurC+20,i+500,largeurC+25);
            g.drawString(""+(int)((i/echelle+LongMin-2*echelle)), i+500, largeurC+35);
        }
        
        for (int i=20;i<=largeurC+30;i+=intervalLATITUDE){
            g.drawLine(15+500,i,20+500,i);
           
            g.drawLine(20+longueurC+500, i, 25+longueurC+500, i);
            g.drawString(""+(int)((-(i-20)/echelle+LatMax+2/echelle)), 20+longueurC+500, i);
        }        
    }    
}
