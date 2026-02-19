import java.util.Scanner;
public class Main{
    public static void main(String[] args){
   
    Scanner scanner = new Scanner(System.in);
    System.out.println("TAMAGOCHI GAME");
    System.out.println("->PUT A NAME FOR YOUR TAMAGOCHI:");
   String name = scanner.nextLine();

    ClsTamago Tamago1 = new ClsTamago(name);
    
    while(true){

                Tamago1.timeLapse();

        if(!Tamago1.isAlive()){
            break;
        }

        System.out.println("##################################################");
        Tamago1.status();
        System.out.println("##################################################");

        System.out.println("----------------------MENU------------------------");
        System.out.println("          1. Feed  || 2. Sleep || 3. Play");
        System.out.println("--------------------------------------------------");
        System.out.println("chose the way to interact whith " +Tamago1.getName()+", press 1,2 or 3 :");


        try {
        Thread.sleep(1000); // 1000 ms = 1 seconde
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int choice = scanner.nextInt(); 

        switch(choice){
            case 1:Tamago1.eat();break;
            case 2:Tamago1.sleep();break;
            case 3:Tamago1.play();break;
            default:
                System.out.println(" ");
        }
        if(!Tamago1.isAlive()){
            break;
        }
    }
    scanner.close();
    }
}