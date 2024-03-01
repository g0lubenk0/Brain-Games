package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                0 - Exit""");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your choice: ");
        int gameNumber = Integer.parseInt(scanner.next());
        System.out.println();
        String username = Cli.sayHello();
        switch (gameNumber) {
            case 2:
                Even.play(username);
                break;
            case 3:
                Calc.play(username);
                break;
            case 4:
                Gcd.play(username);
                break;
            case 5:
                Progression.play(username);
                break;
            default:
                break;
        }
    }
}
