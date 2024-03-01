package hexlet.code;

import java.util.Scanner;

public class Even {
    public static void play(String username) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int correct = 0;
        Scanner scanner = new Scanner(System.in);
        while (correct < 3) {
            int number = (int)(Math.random() * 50);
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            String answer = scanner.next();
            if (answer.equals(isEven(number))) {
                System.out.println("Correct!");
                correct += 1;
            } else {
                correct = 0;
            }
        }
        System.out.println("Congratulations, " + username + "!");
    }

    public static String isEven(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}
