/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cephy_2015;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Patient K.-MULEKYA
 */
public class KRIGE8 {
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
    double WOC;
    double GOC;
    double STOIIP;
    double VHuile=0;
     public KRIGE8(double [] DonneesLONGITUDE,double [] DonneesLATITUDE, double [] DonneesTOIT, double [] DonneesMUR, double a, double Co,double GOC,double WOC ){
        this.DonneesLONGITUDE=DonneesLONGITUDE;
        this.DonneesLATITUDE=DonneesLATITUDE;
        this.DonneesTOIT=DonneesTOIT;
        this.DonneesMUR=DonneesMUR;
        this.a=a;
        this.Co=Co;
        this.GOC=GOC;
        this.WOC=WOC;
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
      /*  double interval = (EpaisMax-EpaisMin)/15;
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
            sylvin = new Color(0,50,255);*/
        
        
       // else if (EpaisMin+7*interval <= epaisseur  )
    //        sylvin = Color.PINK;
        /*
        Color sylvin=Color.getHSBColor(246,100,50);
        double interval = (EpaisMax-EpaisMin)/50;
        System.out.println("interval :  " +interval);
        for (double i = 0; i<=50; i++){
            float in = (float)((240-6*i));
            if (in<0)
                in= in+360;
          if (EpaisMin+i*interval<=epaisseur && epaisseur<EpaisMin+(i+1)*interval)
              sylvin= Color.getHSBColor(in, 100, 50);
          
        }
        
        */
        double interval = (EpaisMax-EpaisMin)/35;
        if (epaisseur < EpaisMin+interval)
            sylvin = new Color(250,175,252);
        else if (EpaisMin+interval <= epaisseur && epaisseur < EpaisMin+2*interval )
            sylvin = new Color(252,106,248);
        else if (EpaisMin+2*interval <= epaisseur && epaisseur < EpaisMin+3*interval )
            sylvin = new Color(252,29,172);
        else if (EpaisMin+3*interval <= epaisseur && epaisseur < EpaisMin+4*interval )
            sylvin = new Color(252,12,69);
        else if (EpaisMin+4*interval <= epaisseur && epaisseur < EpaisMin+5*interval )
            sylvin = new Color(255,20,0);
        else if (EpaisMin+5*interval <= epaisseur && epaisseur < EpaisMin+6*interval )
            sylvin = new Color(255,50,0);
        else if (EpaisMin+6*interval <= epaisseur && epaisseur < EpaisMin+7*interval )
            sylvin = new Color(255,80,0);
        else if (EpaisMin+7*interval <= epaisseur && epaisseur < EpaisMin+8*interval )
            sylvin = new Color(255,110,0);
        else if (EpaisMin+8*interval <= epaisseur && epaisseur < EpaisMin+9*interval )
            sylvin = new Color(255,140,0);
        else if (EpaisMin+9*interval <= epaisseur && epaisseur < EpaisMin+10*interval )
            sylvin = new Color(255,170,0);
        else if (EpaisMin+10*interval <= epaisseur && epaisseur < EpaisMin+11*interval )
            sylvin = new Color(255,200,0);
        else if (EpaisMin+11*interval <= epaisseur && epaisseur < EpaisMin+12*interval )
            sylvin = new Color(255,230,0);
        else if (EpaisMin+12*interval <= epaisseur && epaisseur < EpaisMin+13*interval )
            sylvin = new Color(255,255,0);
        else if (EpaisMin+13*interval <= epaisseur && epaisseur < EpaisMin+14*interval )
            sylvin = new Color(200,255,0);
        else if (EpaisMin+14*interval <= epaisseur && epaisseur < EpaisMin+15*interval )
            sylvin = new Color(150,255,0);
        else if (EpaisMin+15*interval <= epaisseur && epaisseur < EpaisMin+16*interval )
            sylvin = new Color(100,255,0);
        else if (EpaisMin+16*interval <= epaisseur && epaisseur < EpaisMin+17*interval )
            sylvin = new Color(50,255,0);
        else if (EpaisMin+17*interval <= epaisseur && epaisseur < EpaisMin+18*interval )
            sylvin = new Color(0,255,0);
        else if (EpaisMin+18*interval <= epaisseur && epaisseur < EpaisMin+19*interval )
            sylvin = new Color(0,255,50);
        else if (EpaisMin+19*interval <= epaisseur && epaisseur < EpaisMin+20*interval )
            sylvin = new Color(0,255,90);
        else if (EpaisMin+20*interval <= epaisseur && epaisseur < EpaisMin+21*interval )
            sylvin = new Color(0,255,130);
        else if (EpaisMin+21*interval <= epaisseur && epaisseur < EpaisMin+22*interval )
            sylvin = new Color(0,255,170);
        else if (EpaisMin+22*interval <= epaisseur && epaisseur < EpaisMin+23*interval )
            sylvin = new Color(0,255,210);
        else if (EpaisMin+23*interval <= epaisseur && epaisseur < EpaisMin+24*interval )
            sylvin = new Color(0,255,255);
        else if (EpaisMin+24*interval <= epaisseur && epaisseur < EpaisMin+25*interval )
            sylvin = new Color(0,245,255);
        else if (EpaisMin+25*interval <= epaisseur && epaisseur < EpaisMin+26*interval )
            sylvin = new Color(0,232,255);
        else if (EpaisMin+26*interval <= epaisseur && epaisseur < EpaisMin+27*interval )
            sylvin = new Color(0,220,255);
        else if (EpaisMin+27*interval <= epaisseur && epaisseur < EpaisMin+28*interval )
            sylvin = new Color(0,200,255);
        else if (EpaisMin+28*interval <= epaisseur && epaisseur < EpaisMin+29*interval )
            sylvin = new Color(0,175,255);
        else if (EpaisMin+29*interval <= epaisseur && epaisseur < EpaisMin+30*interval )
            sylvin = new Color(0,150,255);
        else if (EpaisMin+30*interval <= epaisseur && epaisseur < EpaisMin+31*interval )
            sylvin = new Color(0,125,255);
        else if (EpaisMin+31*interval <= epaisseur && epaisseur < EpaisMin+32*interval )
            sylvin = new Color(0,100,255);
        else if (EpaisMin+32*interval <= epaisseur && epaisseur < EpaisMin+33*interval )
            sylvin = new Color(0,75,255);
        else if (EpaisMin+33*interval <= epaisseur && epaisseur <= EpaisMin+34*interval )
            sylvin = new Color(0,50,255);
        
        
       // else if (EpaisMin+7*interval <= epaisseur  )
    //        sylvin = Color.PINK;
        /*
        Color sylvin=Color.getHSBColor(246,100,50);
        double interval = (EpaisMax-EpaisMin)/50;
        System.out.println("interval :  " +interval);
        for (double i = 0; i<=50; i++){
            float in = (float)((240-6*i));
            if (in<0)
                in= in+360;
          if (EpaisMin+i*interval<=epaisseur && epaisseur<EpaisMin+(i+1)*interval)
              sylvin= Color.getHSBColor(in, 100, 50);
          
        }*/
        
        return sylvin;
        
    }
      
      public void paintComponent(Graphics g){
      g.drawLine(1, 2, 2, 2);
        //16 POINTS PAR BLOCKS ET 8 VOISINS   
        // Calcul de la dimension du block
/*
    //somme des épaisseurs tenant compte de WOC et ou de GOC
   /* if (TOITEstimeee>WOC)
        epaisseurEAU.add(MUREstimeee-TOITEstimeee);
    if (TOITEstimeee<=WOC && MUREstimeee<WOC)
        epaisseurEAU.add(MUREstimeee-WOC);
    if (TOITEstimeee<WOC && TOITEstimeee>GOC){
        if (MUREstimeee<WOC)
            epaisseurHUILE.add(MUREstimeee-TOITEstimeee);
        else epaisseurHUILE.add(WOC-TOITEstimeee);
    }
    if (TOITEstimeee<=GOC){
        if (MUREstimeee<WOC&&MUREstimeee>GOC)
            epaisseurHUILE.add(MUREstimeee-GOC);
        else epaisseurHUILE.add (WOC-GOC);
    }
    if (TOITEstimeee<GOC){
        if (MUREstimeee>GOC)
            epaisseurGAZ.add(GOC-TOITEstimeee);
        else epaisseurGAZ.add(MUREstimeee-TOITEstimeee);
    }
        */
    
    
   // epaisseursEstimees.add(epaisseurEstimee*surfaceBlock);
  //  System.out.println("toit estimé = "+TOITEstimeee+'\n'+"mur estimé = "+MUREstimeee);
   /* 
    int GeneratedLONGITUDEalorigine = (int)(((GeneratedLONGITUDE[h][k]-dimCoteBlock/8-LongMin)*echelle));
    int GeneratedLATITUDEalorigine = (int)(((GeneratedLATITUDE[h][k]-dimCoteBlock/8-LatMin)*echelle));
 /*j'additionne +22 pour remettre les points dans le rectangle d'origine (20,20)
  * comme signalé ci-haut dans la conception du cadre de la carte
  * 
  */
    /*    
    g.setColor(echelleGOW(GOC,WOC,TOITEstimeee));
    g.drawRect(GeneratedLONGITUDEalorigine+22+500,largeurC-GeneratedLATITUDEalorigine-10+22,dimCoteBlockC ,dimCoteBlockC);
    g.fillRect(GeneratedLONGITUDEalorigine+22+500,largeurC-GeneratedLATITUDEalorigine-10+22,dimCoteBlockC ,dimCoteBlockC);    
    
    g.setColor(echelleCouleur(DonneesTOIT, TOITEstimeee));
    g.drawRect(GeneratedLONGITUDEalorigine+22,largeurC-GeneratedLATITUDEalorigine-10+22,dimCoteBlockC ,dimCoteBlockC);
    g.fillRect(GeneratedLONGITUDEalorigine+22,largeurC-GeneratedLATITUDEalorigine-10+22,dimCoteBlockC ,dimCoteBlockC);
    d++;
    System.out.println("block number "+d);
    System.out.println("----------------------------------");
       }
   }
      /* double [] epHUILE = new double [epaisseurHUILE.size()];
       double [] epGAZ = new double [epaisseurGAZ.size()];
       double [] epEAU = new double [epaisseurEAU.size()];
       for (int in=0; in<epaisseurHUILE.size(); in++)
           epHUILE[in] =(double)epaisseurHUILE.get(in);
       for (int in=0; in<epaisseurHUILE.size(); in++)
           epGAZ[in] =(double)epaisseurGAZ.get(in);
       for (int in=0; in<epaisseurEAU.size();in++)
           epEAU [in]=(double)epaisseurEAU.get(in);
       for (int st=0; st<epHUILE.length;st++)
      VHuile= VHuile + epHUILE[st];
       STOIIP = VHuile*surfaceBlock+2;
       System.out.println("STOIIP/krige = "+STOIIP);*/
      }
}
