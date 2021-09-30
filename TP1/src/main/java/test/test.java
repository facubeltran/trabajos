

package test;

import entities.AutoClasico;
import entities.AutoNuevo;
import entities.Radio;


public class test {
    public static void main(String[] args) {
        
        AutoNuevo auto1=new AutoNuevo("Google","rojo", "toyota", 2005, "Sanyo", 54000);
        System.out.println(auto1);
        
        System.out.println("*****************Cambio de radio autoNuevo****************");
        auto1.cambiarRadio("JB");
        System.out.println(auto1);
        
        System.out.println("**********************************************************************************");
        
        AutoClasico clasicoConRadio = new AutoClasico("Pirelli","azul","toyota", 1964,"Sony", 150001);
        System.out.println(clasicoConRadio);
        System.out.println("*********cambio de radio*********");
        clasicoConRadio.cambiarRadio("Sanyo");
        System.out.println(clasicoConRadio);
        
        System.out.println("*********************** creo auto sin radio******************************");
        AutoClasico clasicoSinRadio = new AutoClasico("Pirelli", "verde", "chevrolet", 1984, 451222);
        System.out.println(clasicoSinRadio);
        // agrego una radio
        clasicoSinRadio.agregarRadio("Xiaomi");
        System.out.println("************************agrego una radio****************************");
        System.out.println(clasicoSinRadio);
        
    }
}
