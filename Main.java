import java.util.Scanner;

import models.Cabelo;
import models.Cronograma;

public class Main{
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        

        System.out.println("FAÇA SEU CRONOGRAMA CAPILAR");
        
        Cronograma cronograma = new Cronograma();

        cronograma.iniciarCronograma();

        System.out.println(cronograma);





    }
}