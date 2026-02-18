import java.util.Scanner;
public class Main{
    public static void main(String[] args){
   
    Scanner scanner = new Scanner(System.in);
    System.out.println("tamagochi");
    System.out.println("tape le nom de ton tamagochi");
    String name = scanner.nextLine();

    ClsTamago Tamago1 = new ClsTamago(name);
    
    while(Tamago1.isAlive()){

        Tamago1.timeLapse();
        Tamago1.status();

        try {
        Thread.sleep(5000); // 1000 ms = 1 seconde
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    scanner.close();
    }
}