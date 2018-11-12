
package nomina;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Plantilla {
    HashMap<String,Double> membre = new HashMap<String,Double>();//Creacio de HashMap llistaParaules
    
    
    public void afegirEmpleat(String dni, double sou){
        
        membre.put(dni,sou);//Añadimos un miembro al HashMap
        //System.out.print("DNI: "+dni+"\tSou: "+sou);
        
    }
    public void mostrarEmpleats(){
        Set <String> empleado = membre.keySet();
        System.out.println("\n");
        
        for(String clau:empleado){
            System.out.print("\nDNI: "+clau+"\tSou: "+membre.get(clau)+"\n");
            //Imprimimos el DNI y el sueldo de los empleados
        }
    }
    public double totalNominas(){
        double sou = 0;
        Collection<Double> nomina = membre.values();//Agrupamos los dineros en nomina
        for(double n:membre.values()){
            sou += n;
        }//Recorremos nomina para sumar todos los dineros en sou
        return sou;
    }
    
    public void augmentNomina(double percentatge){
        Set<String>claus=membre.keySet();//agrupem les claus en el Set
        for(String c:claus){//Recorrem totes les claus del HashMap
            /**/System.out.println("\tDNI: "+c+" Sou: "+membre.get(c));//Mostra el dni i el sou
            membre.replace(c,membre.get(c)*(1 + percentatge / 100));
            System.out.println("Augment del "+percentatge+"%");
            /**/System.out.println("\tDNI: "+c+" Sou: "+membre.get(c));//Mostra el dni i el sou
        }
    }
    
    public Set<String> nominesMajorsQue(double limit){
        Set <String> resultat = null;
        Set<String>nominesAltes=membre.keySet();//agrupem les claus en el Set
        for(String c:nominesAltes){
            if(membre.get(c)>limit){
                resultat.add(c);
                //Guardem el DNI del sou que superi el limit
            }
        }
        return resultat;
    }
    
    public void mostrarResultat(Set<String> resultat){
        for(String c:resultat){
            System.out.println("DNI: "+c+" Sou: "+membre.get(c));
        }
    }
    
    public void buscarEmpleat(String dni){
        if (membre.containsKey(dni)){
            System.out.println("\nEl sou del empleat"+dni+"es: "+membre.get(dni));
        }else{
            System.out.println("No existe");
        }
    }
    
    public  boolean isNumeric(String numero) {

        try {
            Integer.parseInt(numero);
            return true;
        } catch (NumberFormatException excepcion) {
            return false;
        }
    }
    public boolean isDouble(String numero){
        try {
            Double.parseDouble(numero);
            return true;
        } catch (NumberFormatException excepcion) {
            return false;
        }
    }
}
