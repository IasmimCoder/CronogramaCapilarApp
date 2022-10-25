import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import models.Cabelo;
import models.Cronograma;
import models.enums.EspessuraDosFios;
import models.enums.SaudeDoCabelo;
import models.enums.TipoDeCabelo;
import models.enums.TipoDeTratamento;
import view.Forms;

public class Main {
    public static void main(String[] args) {
    
        Forms formulario = new Forms();

        formulario.iniciarTituloDoPrograma();
        formulario.iniciarApresentacao();
        Cabelo usuario = formulario.inserirDadosDeCabelo();

        
        Cronograma cronograma = new Cronograma(usuario);
        
        cronograma.iniciarCronogramaDefault();
        
        formulario.mostrarCronograma(cronograma.getCronograma(), "SEU CRONOGRAMA CAPILAR");
    }
}