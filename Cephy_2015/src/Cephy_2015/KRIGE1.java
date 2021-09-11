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
 * @author Patient K.-MULEKYA
 */
public class KRIGE1 extends JPanel{

 double [][] TOITEstimE;
 double [][] MUREstimE;
 double GOC, WOC;
 double [] DonneesLONGITUDE, DonneesLATITUDE;
 int blockLong;
 double [] DonneesTOIT ;
    
    
    public KRIGE1(double [] DonneesLONGITUDE,double [] DonneesLATITUDE, double [] DonneesTOIT,double [][] TOITEstimE, double [][] MUREstimE, double GOC,double WOC, int blockLong ){
        this.TOITEstimE=TOITEstimE;
        this.MUREstimE=MUREstimE;
        this.GOC=GOC;
        this.WOC=WOC;
        this.DonneesLONGITUDE=DonneesLONGITUDE;
        this.DonneesLATITUDE=DonneesLATITUDE;
        this.blockLong=blockLong;
        this.DonneesTOIT=DonneesTOIT;
    }
    public static Color echelleCouleur(double [] DonneesEPAISSEUR, double epaisseur){
        double EpaisMin=1000000, EpaisMax=0;
        for (int i=0;i<DonneesEPAISSEUR.length;i++){
           if (EpaisMax<DonneesEPAISSEUR[i])
               EpaisMax=DonneesEPAISSEUR[i];
           if (EpaisMin>DonneesEPAISSEUR[i])
               EpaisMin=DonneesEPAISSEUR[i]; 
        }
        
        Color sylvin=Color.WHITE;
        double interval = (EpaisMax-EpaisMin)/15;
        if (epaisseur < EpaisMin+interval)
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
      
       double longueurT= LongMax-LongMin;
       double largeurT= LatMax-LatMin;
       double echelle;
       int largeurC;
       if (largeurT<longueurT)
           echelle=450/longueurT;
           else echelle=450/largeurT;
       int longueurC =(int)((longueurT*echelle)+10);
       largeurC=(int)((largeurT*echelle)+10);
       double dimCoteBlock=longueurT/blockLong;
       int dimCoteBlockC= (int)((dimCoteBlock*echelle));
       double surfaceBlock = dimCoteBlock*dimCoteBlock;
       int nbreBlockLAT= (int) ((largeurT/dimCoteBlock));
       double [][]GeneratedLATITUDE=new double [blockLong*2][nbreBlockLAT*2];
       double [][]GeneratedLONGITUDE=new double [blockLong*2][nbreBlockLAT*2];
       int [][]GeneratedLATITUDEalorigine= new int [blockLong*2][nbreBlockLAT*2];
       int [][] GeneratedLONGITUDEalorigine= new int [blockLong*2][nbreBlockLAT*2];
       for (int h=0; h<blockLong*2; h++) {
           for (int k=0; k<nbreBlockLAT*2; k++){
               GeneratedLATITUDE [h][k]=LatMin+dimCoteBlock/4+k*dimCoteBlock/2;
               GeneratedLATITUDEalorigine[h][k] = (int)(((GeneratedLATITUDE[h][k]-dimCoteBlock/8-LatMin)*echelle));
               GeneratedLONGITUDE [h][k]=LongMin+dimCoteBlock/4+h*dimCoteBlock/2;
               GeneratedLONGITUDEalorigine[h][k] = (int)(((GeneratedLONGITUDE[h][k]-dimCoteBlock/8-LongMin)*echelle));
           }
       }
      
 /*j'additionne +22 pour remettre les points dans le rectangle d'origine (20,20)
  * comme signalé ci-haut dans la conception du cadre de la carte
  * 
  */
    for (int h=0; h<blockLong; h++){
           for (int k=0; k<nbreBlockLAT; k++){    
    g.setColor(echelleGOW(GOC,WOC,TOITEstimE[h][k]));
    g.drawRect(GeneratedLONGITUDEalorigine[h][k]+22+500,largeurC-GeneratedLATITUDEalorigine[h][k]-10+22,dimCoteBlockC ,dimCoteBlockC);
    g.fillRect(GeneratedLONGITUDEalorigine[h][k]+22+500,largeurC-GeneratedLATITUDEalorigine[h][k]-10+22,dimCoteBlockC ,dimCoteBlockC);    
    
    g.setColor(echelleCouleur(DonneesTOIT, TOITEstimE[h][k]));
    g.drawRect(GeneratedLONGITUDEalorigine[h][k]+22,largeurC-GeneratedLATITUDEalorigine[h][k]-10+22,dimCoteBlockC ,dimCoteBlockC);
    g.fillRect(GeneratedLONGITUDEalorigine[h][k]+22,largeurC-GeneratedLATITUDEalorigine[h][k]-10+22,dimCoteBlockC ,dimCoteBlockC);
   
    System.out.println("----------------------------------");
           }
    }
       
    }
}
