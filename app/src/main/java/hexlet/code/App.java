package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.\n1 - Greet\n2 - Even\n0 - Exit");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your choice: ");
        int gameNumber = Integer.parseInt(scanner.next());
        System.out.println();
        switch (gameNumber) {
            case 1:
                Cli.sayHello();
            case 2:
                String username = Cli.sayHello();
                Even.play(username);
                break;
            default:
                break;
        }
    }
}
