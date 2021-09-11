/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cephy_2015;

import java.util.ArrayList;

/**
 *
 * @author Patient K.-MULEKYA
 */
public class Regress {
    int [] DonneesLAGDISTANCE;
    double [] DonneesVARIOGRAMME;
    int maxL;
    double maxV;
    double a;
    double Co;
    public Regress(int [] DonneesLAGDISTANCE, double[] DonneesVARIOGRAMME){

        this.DonneesLAGDISTANCE=DonneesLAGDISTANCE ;
        this.DonneesVARIOGRAMME=DonneesVARIOGRAMME;
    }
    public void spherique(){
        double [] DonneesY= new double [DonneesVARIOGRAMME.length];
        double [] DonneesX= new double [DonneesLAGDISTANCE.length];
        /*
         *DonneesY étant y(L)/L
         *DonneesX étant L^2
         */
      //  System.out.println("LAGDISTANCE"+"\t"+"\t"+"VARIOGRAMME");
        for (int l=0; l<DonneesVARIOGRAMME.length; l++){
            DonneesY[l]=DonneesVARIOGRAMME[l]/DonneesLAGDISTANCE[l];
            DonneesX[l]=Math.pow(DonneesLAGDISTANCE[l],2);
            
        }
                    
        double sommeX=0;
        double sommeY=0;
        int w=0;
        for (int i =0;i<DonneesVARIOGRAMME.length ;i++){
            //condition pour ignorer les variogrammes rejetés suite à l'insuffisance du nombre des couples
            if (DonneesVARIOGRAMME[i]!=0){
                sommeX +=DonneesX [i];
                sommeY +=DonneesY [i];
                w++;
            }
        }
       double moyenneX=sommeX/w;
       double moyenneY=sommeY/w;
       double Cxy=0;
       double Cxx=0;
       for (int j=0; j<DonneesVARIOGRAMME.length; j++){
           if (DonneesVARIOGRAMME[j]!=0){
               Cxy +=(DonneesX[j]-moyenneX)*(DonneesY[j]-moyenneY);
               Cxx +=Math.pow((DonneesX[j]-moyenneX),2);
           }
       }
       double m = Cxy/Cxx;
       double n=moyenneY-m*moyenneX;
       Co=Math.sqrt(-4.0*Math.pow(n,3)/(27.0*m));
       a=Math.sqrt(-n/(3.0*m));
      // System.out.println ("m ="+ m);
      // System.out.println ("n ="+ n); 
    }
    
    public double a(){
        
        return a;
    }
    public double Co(){
        return Co;
    }  
}
