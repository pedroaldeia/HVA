package hva;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        
        Hotel hotel = new Hotel();
        int a = hotel.registerHabitat("123", "hot", 100);
        int b = hotel.registerHabitat("143", "vac", 12);
        //System.out.println(a);
        //System.out.println(b);
        System.out.print(hotel.showAllHabitats());

        hotel.registerSpecies("55", "Cat"); 
        hotel.registerSpecies("66", "Dog");
        int x = hotel.registerSpecies("66", "Dog");
        System.out.println("x: " + x);
        int c = hotel.registerAnimal("1234", "kit", "55", "123");
        int d = hotel.registerAnimal("1235", "puf", "55", "123");
        int y = hotel.registerAnimal("1234", "kit", "66", "143");
        System.out.println("y: " + y);
        System.out.println(hotel.showAllAnimals());
        

        /*
        Employee vet = new Vet("idVet", "nameVet");
        Employee taker = new Caretaker("idTaker", "nameTaker");
        System.out.println(vet);
        System.out.println(taker);
        */
        /* 
        Species species = new Species("idSpecies", "nameSpecies", 0);
        ArrayList<Species> listSpecies = new ArrayList<>();
        listSpecies.add(species);
        Vaccine vacc = new Vaccine("idVacc", "nameVacc", listSpecies);

        System.out.println(vacc);
        */

    }
    
}
