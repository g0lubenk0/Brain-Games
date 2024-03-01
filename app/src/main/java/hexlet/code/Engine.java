package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static void printDescription(String game) {
        switch(game) {
            case "Even":
                System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
                break;
            case "Calc":
                System.out.println("What is the result of the expression?");
                break;
        }
    }
    public static void playGame(String game, String username) {
        printDescription(game);
        int correct = 0;
        Scanner scanner = new Scanner(System.in);
        while (correct < 3) {
            String[] calc = QuestionCalculation(game);
            System.out.println("Question: " + calc[0]);
            System.out.print("Answer: ");
            String answer = scanner.next();
            String result = calc[1];
            if (answer.equals(result)) {
                System.out.println("Correct!");
                correct += 1;
            } else {
                if (game.equals("Even")) {
                    correct = 0;
                } else {
                    System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'%n", answer, result);
                    System.out.println("Let's try again, " + username + "!");
                }
            }
        }
        System.out.println("Congratulations, " + username + "!");
    }

    public static String[] QuestionCalculation(String game) {
        String question = "";
        String result = "";
        switch(game) {
            case "Even":
                question = Integer.toString(getRandomNumber(1, 100));
                result = isEven(Integer.parseInt(question));
                break;
            case "Calc":
                int num1 = getRandomNumber(1, 20);
                int num2 = getRandomNumber(1, 20);
                String operation = getRandomOperation();
                question = num1 + operation + num2;
                result = Integer.toString(calculateResult(num1, num2, operation));
                break;
        }
        return new String[]{question, result};
    }

    public static int getRandomNumber(int start, int stop) {
        return (int)(Math.random() * stop) + start;
    }
    public static String getRandomOperation() {
        int operation = (int)(Math.random() * 4) + 1;

        return switch (operation) {
            case 2 -> "-";
            case 3 -> "*";
            default -> "+";
        };
    }
    public static int calculateResult(int num1, int num2, String operation) {
        return switch (operation) {
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> num1 + num2;
        };
    }

    public static String isEven(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}
