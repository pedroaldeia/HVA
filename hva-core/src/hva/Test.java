package hva;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class Test implements Serializable{
    public static void main(String[] args) {
        //*
        Hotel hotel = new Hotel();
        int a = hotel.registerHabitat("H1", "Casa do Pedro", 100);
        int b = hotel.registerHabitat("H2", "Casa do Tiago", 12);
        //System.out.println(a);
        //System.out.println(b);
        System.out.println("Visualizar Habitats");
        System.out.println(hotel.showAllHabitats());

        hotel.registerSpecies("S0", "Cão de Água"); 
        hotel.registerSpecies("S1", "Gato");
        int x = hotel.registerSpecies("01", "Dog");
        //System.out.println("x: " + x);
        hotel.registerAnimal("A3", "piupiu", "S1", "H1");
        hotel.registerAnimal("A4", "Rocky", "S0", "H1");
        int d = hotel.registerAnimal("A1", "puf", "S0", "H1");
        int y = hotel.registerAnimal("A2", "pompom", "S1", "H2");
        int c = hotel.registerAnimal("A0", "kit", "S1", "H2");
        //System.out.println("y: " + y);
        System.out.println("Visualizar Animais");
        System.out.println(hotel.showAllAnimals());

        hotel.registerEmployee("E1", "Pedro", "TRT");
        hotel.registerEmployee("E0", "Tiago", "VET");
        System.out.println("Visualizar Funcionários");
        System.out.println(hotel.showAllEmployees());

        hotel.registerVaccine("V1", "Vaccine B", "S0");
        hotel.registerVaccine("V0", "Vaccine A", "S1");
        hotel.registerVaccine("V2", "Vaccine C", "S0,    S1");
        System.out.println("Visualizar Vacinas");
        System.out.println(hotel.showAllVaccines());
        /*/

        /*
        Employee vet = new Vet("idVet", "nameVet");
        Employee taker = new Caretaker("idTaker", "nameTaker");
        System.out.println(vet);
        System.out.println(taker);
        */
        /*
        Species species1 = new Species("idSpecies1", "nameSpecies1");
        Species species2 = new Species("idSpecies2", "nameSpecies2");
        Species species3 = new Species("idSpecies3", "nameSpecies3");
        ArrayList<Species> listSpecies = new ArrayList<>();
        listSpecies.add(species1);
        listSpecies.add(species2);
        listSpecies.add(species3);
        Vaccine vacc = new Vaccine("idVacc", "nameVacc", listSpecies);

        System.out.println(vacc);
        */
 
    }
    
}
