package services;

import java.util.Scanner;

import models.enums.SaudeDoCabelo;
import models.enums.TipoDeCabelo;

public class Services {
    Scanner leitor = new Scanner(System.in);

    
    public SaudeDoCabelo escolheSaudeDoCabelo(int i){

        while(i > 3 || i < 1){
            System.out.println("Digite novamente: ");
            i = Integer.parseInt(leitor.nextLine());
        }
        switch (i) {
            case 1:
               return SaudeDoCabelo.SAUDAVEL;
            case 2:
                return SaudeDoCabelo.POUCO_DANIFICADO;
            case 3:
             return SaudeDoCabelo.MUITO_DANIFICADO;
        }
        
        return null;
    }
      
    public TipoDeCabelo escolheTipoCabelo(int i){
        while(i > 4 || i < 1){
            System.out.println("Digite novamente: ");
            i = Integer.parseInt(leitor.nextLine());
        }
        switch (i) {
            case 1:
                return TipoDeCabelo.LISO;
            case 2:
                return TipoDeCabelo.ONDULADO;
            case 3:
                return TipoDeCabelo.CACHEADO;
            case 4:
                return TipoDeCabelo.CRESPO;
        }
        
        return null;
    }
}
