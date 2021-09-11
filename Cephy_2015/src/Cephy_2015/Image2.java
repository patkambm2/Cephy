/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cephy_2015;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author nestor
 */
public class Image2 extends JPanel {
    double echelle;
    double [] DonneesLONGITUDE;
    double [] DonneesLATITUDE;
    double [] DonneesTOIT ;
    double [] DonneesMUR;
    String [] DonneesETIQUETTE;
    double dimCoteBlock;
    int largeurC;
    int [] DonneesLONGITUDEalorigine;
    int [] DonneesLATITUDEalorigine;
    double [][] GeneratedLONGITUDE;
    double [][] GeneratedLATITUDE;
    double [][] GeneratedEPAISSEUR;
    double a;
    double Co;
    ArrayList epaisseurEAU=new ArrayList();
    ArrayList epaisseurHUILE=new ArrayList();
    ArrayList epaisseurGAZ=new ArrayList();
    double WOC=950;
    double GOC=930;
    double STOIIP;
    double VHuile=0;
    int [][] GeneratedLONGITUDEalorigine;
    int [][] GeneratedLATITUDEalorigine;
    double [][] EstimatedPARAMETER;
    double [][] EstimatedPARAMETER2;
    double EpaisMin2, EpaisMax2, EpaisMin1,EpaisMax1;
    
    public Image2(String [] DonneesETIQUETTE, double [] DonneesLONGITUDE,double [] DonneesLATITUDE, int [][] GeneratedLONGITUDEalorigine,int [][] GeneratedLATITUDEalorigine, double [][] EstimatedPARAMETER, double [][] EstimatedPARAMETER2){
        this.GeneratedLONGITUDEalorigine=GeneratedLONGITUDEalorigine;
        this.GeneratedLATITUDEalorigine=GeneratedLATITUDEalorigine;
        this.EstimatedPARAMETER=EstimatedPARAMETER;
        this.EstimatedPARAMETER2=EstimatedPARAMETER2;
        this.DonneesETIQUETTE=DonneesETIQUETTE;
        this.DonneesLONGITUDE=DonneesLONGITUDE;
        this.DonneesLATITUDE=DonneesLATITUDE;
        
                EpaisMin1=200000000000000000000.0; EpaisMax1=0;
        for (int h=0;h<EstimatedPARAMETER.length;h++){
            for (int k=0;k<EstimatedPARAMETER[1].length;k++){
           if (EpaisMax1<EstimatedPARAMETER[h][k]&&EstimatedPARAMETER[h][k]!=0)
               EpaisMax1=EstimatedPARAMETER[h][k];
           if (EpaisMin1>EstimatedPARAMETER[h][k]&&EstimatedPARAMETER[h][k]!=0)
               EpaisMin1=EstimatedPARAMETER[h][k]; 
            }
        }
        
        EpaisMin2=200000000000000000000.0; EpaisMax2=0;
        for (int h=0;h<EstimatedPARAMETER2.length;h++){
            for (int k=0;k<EstimatedPARAMETER2[1].length;k++){
           if (EpaisMax2<EstimatedPARAMETER2[h][k]&&EstimatedPARAMETER2[h][k]!=0)
               EpaisMax2=EstimatedPARAMETER2[h][k];
           if (EpaisMin2>EstimatedPARAMETER2[h][k]&&EstimatedPARAMETER2[h][k]!=0)
               EpaisMin2=EstimatedPARAMETER2[h][k]; 
            }
        }
        
    }

    public Color echelleCouleur(double epaisseur, boolean PouD){
        double EpaisMin, EpaisMax;
         if (PouD){
             EpaisMax=EpaisMax1;
             EpaisMin=EpaisMin1;
         }
         else {
             EpaisMax=EpaisMax2;
             EpaisMin=EpaisMin2;
         }
        Color sylvin=Color.WHITE;
        double interval = (EpaisMax-EpaisMin)/18;
        if (EpaisMin<=epaisseur && epaisseur < EpaisMin+interval)
            sylvin = new Color(250,175,252);
        else if (EpaisMin+interval <= epaisseur && epaisseur < EpaisMin+2*interval )
            sylvin = new Color(252,106,248);
        
        else if (EpaisMin+2*interval <= epaisseur && epaisseur < EpaisMin+3*interval )
            sylvin = new Color(252,12,69);
        
        else if (EpaisMin+3*interval <= epaisseur && epaisseur < EpaisMin+4*interval )
            sylvin = new Color(255,50,0);
        
        else if (EpaisMin+4*interval <= epaisseur && epaisseur < EpaisMin+5*interval )
            sylvin = new Color(255,110,0);
       
        else if (EpaisMin+5*interval <= epaisseur && epaisseur < EpaisMin+6*interval )
            sylvin = new Color(255,170,0);
        
        else if (EpaisMin+6*interval <= epaisseur && epaisseur < EpaisMin+7*interval )
            sylvin = new Color(255,230,0);
        
        else if (EpaisMin+7*interval <= epaisseur && epaisseur < EpaisMin+8*interval )
            sylvin = new Color(200,255,0);
        
        else if (EpaisMin+8*interval <= epaisseur && epaisseur < EpaisMin+9*interval )
            sylvin = new Color(100,255,0);
        
        else if (EpaisMin+9*interval <= epaisseur && epaisseur < EpaisMin+10*interval )
            sylvin = new Color(0,255,0);
        
        else if (EpaisMin+10*interval <= epaisseur && epaisseur < EpaisMin+11*interval )
            sylvin = new Color(0,255,90);
        
        else if (EpaisMin+11*interval <= epaisseur && epaisseur < EpaisMin+12*interval )
            sylvin = new Color(0,255,170);
        
        else if (EpaisMin+12*interval <= epaisseur && epaisseur < EpaisMin+13*interval )
            sylvin = new Color(0,255,255);
       
        else if (EpaisMin+13*interval <= epaisseur && epaisseur < EpaisMin+14*interval )
            sylvin = new Color(0,232,255);
       
        else if (EpaisMin+14*interval <= epaisseur && epaisseur < EpaisMin+15*interval )
            sylvin = new Color(0,200,255);
        
        else if (EpaisMin+15*interval <= epaisseur && epaisseur < EpaisMin+16*interval )
            sylvin = new Color(0,150,255);
       
        else if (EpaisMin+16*interval <= epaisseur && epaisseur < EpaisMin+17*interval )
            sylvin = new Color(0,100,255);
        
        else if (EpaisMin+17*interval <= epaisseur && epaisseur <= EpaisMin+18*interval )
            sylvin = new Color(0,50,255);
                
        return sylvin;
        
    }
    public static Color echelleGOW(double GOC, double WOC, double TOITEstimé){
        Color Christelle = Color.black;
        if (TOITEstimé<GOC)
            Christelle=Color.lightGray;
        else if (TOITEstimé<WOC&&TOITEstimé>GOC)
            Christelle=Color.darkGray;
        else if(TOITEstimé>WOC)
            Christelle=Color.blue;
        return Christelle;
    }
           
    @Override
    public void paintComponent(Graphics g){
        int d=0;
        int blockLong=GeneratedLONGITUDEalorigine.length/2;
        int nbreBlockLAT=GeneratedLONGITUDEalorigine[1].length/2;
        int dimCoteBlockC=450/blockLong;
        int largeC;
        if (GeneratedLONGITUDEalorigine.length<GeneratedLONGITUDEalorigine[1].length)
            largeC=dimCoteBlockC*GeneratedLONGITUDEalorigine.length/2;
        else largeC=dimCoteBlockC*GeneratedLONGITUDEalorigine[1].length/2;
        
        
        
        
        //Obtention des valeurs minima et maxima pour la création du cadre de la carte
       double LatMin=10000000, LatMax=0, LongMin=10000000, LongMax=0;
       for (int i=0;i<DonneesLONGITUDE.length;i++){
           if (LongMax<DonneesLONGITUDE[i])
               LongMax=DonneesLONGITUDE[i];
           if (LatMax<DonneesLATITUDE[i])
               LatMax=DonneesLATITUDE[i];
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
        //g.setColor(Color.white);
        //g.fillRect(0, 0, 10000, 10000);
    //    g.fillRect(20, 20,longueurC, largeurC);
        DonneesLONGITUDEalorigine=new int [DonneesLONGITUDE.length];
        DonneesLATITUDEalorigine=new int [DonneesLONGITUDE.length];
        for (int i=0;i<DonneesLONGITUDE.length;i++ ){
            DonneesLONGITUDEalorigine[i]=(int)((DonneesLONGITUDE[i]-LongMin)*echelle);
            DonneesLATITUDEalorigine[i]= (int)((DonneesLATITUDE[i]-LatMin)*echelle);
        }
        g.setColor(Color.BLACK);
        g.drawRect(20, 20,longueurC, largeurC);
        for (int h=0; h<blockLong*2-1; h+=2){
               for (int k=0; k<nbreBlockLAT*2-1; k+=2){
                   
                   /*
                    * Dessin  structure carte à gauche (1er paramètre)
                    */
                   g.setColor(echelleCouleur(EstimatedPARAMETER[h/2][k/2],true ));
                   g.drawRect(GeneratedLONGITUDEalorigine[h][k]+22,largeurC-GeneratedLATITUDEalorigine[h][k]-10+22,dimCoteBlockC ,dimCoteBlockC);
                   g.fillRect(GeneratedLONGITUDEalorigine[h][k]+22,largeurC-GeneratedLATITUDEalorigine[h][k]-10+22,dimCoteBlockC ,dimCoteBlockC);
                   
                   /*
                    * Dessin carte à droite (2è paramètre)
                    */
                   
                   g.setColor(echelleCouleur(EstimatedPARAMETER2[h/2][k/2],false));
                   g.drawRect(GeneratedLONGITUDEalorigine[h][k]+22+500,largeurC-GeneratedLATITUDEalorigine[h][k]-10+22,dimCoteBlockC ,dimCoteBlockC);
                   g.fillRect(GeneratedLONGITUDEalorigine[h][k]+22+500,largeurC-GeneratedLATITUDEalorigine[h][k]-10+22,dimCoteBlockC ,dimCoteBlockC);    
                                      
                   d++;
                   System.out.println("block number "+d);
                   System.out.println("----------------------------------");
               }
        }
        
        g.setColor(Color.BLACK);
        for (int i=0;i<DonneesLONGITUDE.length;i++){
            //j'additionne +22 pour remettre les points dans le rectangle d'origine (20,20)
            g.fillOval(DonneesLONGITUDEalorigine[i]+22,(largeurC-DonneesLATITUDEalorigine[i]-10)+22, 3, 3);          
        }
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
        g.setColor(Color.BLACK);
        g.drawRect(20, 20,longueurC, largeurC);
        g.drawRect(20+500, 20,longueurC, largeurC);
        /*
         * CARTE DES ZONES
         */
        g.setColor(Color.BLACK);
        for (int i=0;i<DonneesLONGITUDE.length;i++){
            //j'additionne +22 pour remettre les points dans le rectangle d'origine (20,20)
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
           // g.drawString(""+(int)((i/echelle+LatMin)), i, 15);
            g.drawLine(20+longueurC+500, i, 25+longueurC+500, i);
            g.drawString(""+(int)((-(i-20)/echelle+LatMax+2/echelle)), 20+longueurC+500, i);
        }
        //etiquettage
        for (int i=0;i<DonneesLONGITUDE.length;i++){
            //j'additionne +22 pour remettre les points dans le rectangle d'origine (20,20)
            
            g.drawString(DonneesETIQUETTE[i], DonneesLONGITUDEalorigine[i]+500+22,(largeurC-DonneesLATITUDEalorigine[i]-10)+22);
          
      /*
       * LEGEND BAR 1 (pour la carte à gauche)
       */
            
            g.setColor(new Color(250,175,252));
            g.fillRect(900, 50, 20, 15);
            
        
            g.setColor(new Color(252,106,248));
        g.fillRect(900, 65, 20, 15);
        
            g.setColor(new Color(252,12,69));
        g.fillRect(900, 80, 20, 15);
        
           g.setColor(new Color(255,50,0));
        g.fillRect(900, 95, 20, 15);
        
            g.setColor(new Color(255,110,0));
       g.fillRect(900, 110, 20, 15);
        
            g.setColor(new Color(255,170,0));
        g.fillRect(900, 125, 20, 15);
       
            g.setColor(new Color(255,230,0));
        g.fillRect(900, 140, 20, 15);
        
            g.setColor(new Color(200,255,0));
        g.fillRect(900, 155, 20, 15);
        
            g.setColor(new Color(100,255,0));
        g.fillRect(900, 170, 20, 15);
        
            g.setColor(new Color(0,255,0));
        g.fillRect(900, 185, 20, 15);
        
            g.setColor(new Color(0,255,90));
        g.fillRect(900, 200, 20, 15);
        
            g.setColor(new Color(0,255,170));
        g.fillRect(900, 215, 20, 15);
       
            g.setColor(new Color(0,255,255));
       g.fillRect(900, 230, 20, 15);
       
            g.setColor(new Color(0,205,255));
       g.fillRect(900, 245, 20, 15);
        
            g.setColor(new Color(0,155,255));
        g.fillRect(900, 260, 20, 15);
        
            g.setColor(new Color(0,105,255));
       g.fillRect(900, 275, 20, 15);
        
            g.setColor(new Color(0,55,255));
        g.fillRect(900, 290, 20, 15);
        
            g.setColor(Color.BLUE);
        g.fillRect(900, 305, 20, 15);
        
        g.setColor(Color.BLACK);
        g.drawString(""+(int)EpaisMax2, 922, 320);
        g.drawString(""+(int)EpaisMin2,922,50);
            
      /*
       * LEGEND BAR 1 (pour la carte à gauche)
       */
        
        
                      g.setColor(new Color(250,175,252));
            g.fillRect(400, 50, 20, 15);
            
        
            g.setColor(new Color(252,106,248));
        g.fillRect(400, 65, 20, 15);
        
            g.setColor(new Color(252,12,69));
        g.fillRect(400, 80, 20, 15);
        
           g.setColor(new Color(255,50,0));
        g.fillRect(400, 95, 20, 15);
        
            g.setColor(new Color(255,110,0));
       g.fillRect(400, 110, 20, 15);
        
            g.setColor(new Color(255,170,0));
        g.fillRect(400, 125, 20, 15);
       
            g.setColor(new Color(255,230,0));
        g.fillRect(400, 140, 20, 15);
        
            g.setColor(new Color(200,255,0));
        g.fillRect(400, 155, 20, 15);
        
            g.setColor(new Color(100,255,0));
        g.fillRect(400, 170, 20, 15);
        
            g.setColor(new Color(0,255,0));
        g.fillRect(400, 185, 20, 15);
        
            g.setColor(new Color(0,255,90));
        g.fillRect(400, 200, 20, 15);
        
            g.setColor(new Color(0,255,170));
        g.fillRect(400, 215, 20, 15);
       
            g.setColor(new Color(0,255,255));
       g.fillRect(400, 230, 20, 15);
       
            g.setColor(new Color(0,205,255));
       g.fillRect(400, 245, 20, 15);
        
            g.setColor(new Color(0,155,255));
        g.fillRect(400, 260, 20, 15);
        
            g.setColor(new Color(0,105,255));
       g.fillRect(400, 275, 20, 15);
        
            g.setColor(new Color(0,55,255));
        g.fillRect(400, 290, 20, 15);
        
            g.setColor(Color.BLUE);
        g.fillRect(400, 305, 20, 15);
        
        g.setColor(Color.BLACK);
        g.drawString(""+(int)EpaisMax1, 422, 320);
        g.drawString(""+(int)EpaisMin1,422,50);  
            
            
        }
        
    }
}
   
