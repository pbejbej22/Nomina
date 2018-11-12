
package nomina;

import java.util.Scanner;
import java.util.Set;

public class Nomina {

    public static void main(String[] args) {
        Plantilla plantilla = new Plantilla();
        int opcio = 0;
        String numero;
        String dni;
        double sou;
        double suma = 0;
        double percentatge = 0;
        Set<String> major=null;
        Scanner lector = new Scanner(System.in);
        //Scanner lactor = new Scanner(System.in);

        do{
            System.out.println("\n______MENÚ______\n");
            System.out.println("1.Afegir empleat\n2.Buscar empleat per DNI\n3.Mostrar tots els empleats");
            System.out.println("4.Augmentar sou\n5.Sumar tots els sous\n6.Sortit\n");
            numero = (lector.nextLine());
            
            while(!plantilla.isNumeric(numero)){
                System.out.println("Tens que ficar un numero");
                numero = (lector.nextLine());
            }
            opcio = Integer.parseInt(numero);
            //Transformo de String a Int
            
            switch(opcio){
                case 1:System.out.println("\tAfegir empleat");
                    System.out.println("\nIntrodueix el DNI:\n");
                    dni= lector.nextLine();
                    while(!dni.matches("[0-9]{8}[A-Z]")){
                        //Quan el dni no sigui correcte entrara aqui
                        System.out.println("DNI incorrecte");
                        dni= lector.nextLine();
                    }
                    do{
                        System.out.println("Introdueix el sou\n");
                        sou= lector.nextDouble();
                    }while(plantilla.isDouble(numero));
                    plantilla.afegirEmpleat(dni, sou);
                    break;
                
                case 2:System.out.println("\tBuscar el sou del empleat per DNI");
                    System.out.println("Introdueix el DNI");
                    dni= lector.nextLine();
                    while(!dni.matches("[0-9]{8}[A-Z]")){
                        //Quan el dni no sigui correcte entrara aqui
                        System.out.println("DNI incorrecte");
                        dni= lector.nextLine();
                    }
                    plantilla.buscarEmpleat(dni);
                    break;
                    
                case 3:System.out.println("\tMostrar tots els emleats");
                    plantilla.mostrarEmpleats();
                    break;
                    
                case 4:System.out.println("\tAugmentar sou");
                    System.out.println("Introdueix el percentatje d'augment");
                    String nume;
                    nume = lector.nextLine();
                    while(!plantilla.isNumeric(nume)){
                    System.out.println("Tens que ficar un numero");
                    nume = (lector.nextLine());
                    }
                    percentatge = Double.parseDouble(nume);
                    //Transformamos nume de String a percentatge Double
                    percentatge= lector.nextDouble();
                    plantilla.augmentNomina(percentatge);
                    break;
                    
                case 5:System.out.println("\tSumar tots els sous");
                    suma=plantilla.totalNominas();
                    System.out.println("El total del sous es de: "+suma);
                    break;
            }
        }while (opcio != 6);
    }
}
