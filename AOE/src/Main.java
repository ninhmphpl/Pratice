
import Unit.Human;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Human farmer1 = new Human("Farmer1", 100, 1, 0, 10);
        Human farmer2 = new Human("Farmer2", 100, 1, 0, 5);
        farmer2.setLocation(50,0);
        farmer1.setLocation(0,100);
        farmer1.move(200, 200);
        Thread.sleep(4000);
        farmer1.move(0,0);




    }
}
