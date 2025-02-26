import java.util.Date;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        AkidoTrainer akidoTrainer;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter your name: ");
            String plauerName = sc.nextLine();
            if (!plauerName.equals("")) {
                akidoTrainer = new AkidoTrainer(plauerName);
                break;
            }
        }
        while (true) {

            System.out.println("Press 1 to train, 2 to check are you Kuy master" +
                    " or 3 to exit: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: akidoTrainer.addSession(new Date(), 60);
                break;
                case 2: akidoTrainer.checkGraduation();
                break;
                case 3: System.exit(0);
            }


        }



    }
}
