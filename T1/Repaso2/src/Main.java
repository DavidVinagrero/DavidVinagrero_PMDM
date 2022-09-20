import model.Coche;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int edad= 80;
        String nombre= "Pepe";

        //Coche[marca= "M", modelo="C220", cv=0, cc=0.0, bastidor=null, vel=0,km=0]
        Coche coche1= new Coche("Mercedes","C220","3A75b");
        Coche coche2= new Coche("CATERPILLAR","775b","G234F",300);
        Coche coche3= new Coche("Audi","A5","9SD0");
        Coche coche4= new Coche("Audi","A3","09SDG",220);

        ArrayList<Coche> listaCoches= new ArrayList();
        listaCoches.add(coche1);
        listaCoches.add(coche2);
        listaCoches.add(coche3);
        listaCoches.add(coche4);

        //media de CV de los coches que estan en el concesionario
        double media=0;
        for (Coche coche:listaCoches) {
            media+= coche.getCv();
        }
        media/=listaCoches.size();
        System.out.println("La media de CV es: "+media);

        /*coche1.acelerarCoche(100);
        coche2.acelerarCoche(100);
        coche1.acelerarCoche(50);
        coche2.acelerarCoche(20);

        System.out.println(coche1);
        System.out.println(coche2+"\n");

        if(!coche1.decelerarCoche(190)){
            System.out.println("Ha ocurrido alg, frenazo en seco");
        }
        System.out.println(coche1);*/
    }
}
