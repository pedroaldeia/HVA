package hva;

public class Test {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        int a = hotel.registerHabitat("123", "hot", 100);
        int b = hotel.registerHabitat("143", "vac", 12);
        //System.out.println(a);
        //System.out.println(b);
        System.out.print(hotel.showAllHabitats());

        hotel.registerSpecies("55", "Cat"); 
        int c = hotel.registerAnimal("1234", "kit", "55", "123");
        int d = hotel.registerAnimal("1235", "puf", "55", "123");
        System.out.println();
        System.out.println(hotel.showAllAnimals());
    }
    
}
