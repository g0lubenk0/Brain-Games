package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void sayHello() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("May I have your name? ");
        String username = scanner.next();
        System.out.println("Hello, " + username + "!");
    }
}
