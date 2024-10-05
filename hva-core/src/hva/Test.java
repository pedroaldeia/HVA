package hva;

public class Test {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        int a = hotel.registerHabitat("123", "hot", 100);
        int b = hotel.registerHabitat("456", "vac", 12);
        System.out.println(a);
        System.out.println(b);
    }
    
}
