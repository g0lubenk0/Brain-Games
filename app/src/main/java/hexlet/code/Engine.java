package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static void printDescription(String game) {
        switch (game) {
            case "Even":
                System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
                break;
            case "Calc":
                System.out.println("What is the result of the expression?");
                break;
            case "GCD":
                System.out.println("Find the greatest common divisor of given numbers.");
                break;
            case "Progression":
                System.out.println("What number is missing in the progression?");
                break;
            case "Prime":
                System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
                break;
            default:
                break;
        }
    }
    public static void playGame(String game, String username) {
        printDescription(game);
        int correct = 0;
        Scanner scanner = new Scanner(System.in);
        boolean failure = false;
        while (correct < 3) {
            String[] calc = calculateQuestionResult(game);
            System.out.println("Question: " + calc[0]);
            System.out.print("Answer: ");
            String answer = scanner.nextLine();
            String result = calc[1];
            if (answer.equals(result)) {
                System.out.println("Correct!");
                correct += 1;
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'%n", answer, result);
                System.out.println("Let's try again, " + username + "!");
                failure = true;
                break;
/*                if (game.equals("Even")) {
                    correct = 0;
                } else {*/
                /*}*/
            }
        }
        if (!failure) {
            System.out.println("Congratulations, " + username + "!");
        }
    }

    public static String[] calculateQuestionResult(String game) {
        String question = "";
        String result = "";
        int num1;
        int num2;
        int start = 1;
        int stop = 100;

        switch (game) {
            case "Even":
                question = Integer.toString(getRandomNumber(start, stop));
                result = isEven(Integer.parseInt(question));
                break;
            case "Calc":
                num1 = getRandomNumber(start, stop);
                num2 = getRandomNumber(start, stop);
                String operation = getRandomOperation();
                question = num1 + " " + operation + " " + num2;
                result = Integer.toString(calculateResult(num1, num2, operation));
                break;
            case "GCD":
                num1 = getRandomNumber(start, stop);
                num2 = getRandomNumber(start, stop);
                question = num1 + " " + num2;
                result = Integer.toString(getGCD(num1, num2));
                break;
            case "Progression":
                int arrLengthMax = 10;
                int arrLengthMin = 5;
                start = 0;
                String[] progression = new String[getRandomNumber(arrLengthMin, arrLengthMax)];
                int missingIndex = getRandomNumber(start, progression.length);
                int first = getRandomNumber(start, stop);
                int step = getRandomNumber(start, stop);
                fillProgression(progression, first, step);
                result = hideElementAtIndex(progression, missingIndex);
                question = formProgressionString(progression);
                break;
            case "Prime":
                num1 = getRandomNumber(start, stop);
                question = Integer.toString(num1);
                result = isPrime(num1);
                break;
            default:
                break;
        }
        return new String[]{question, result};
    }

    public static int getRandomNumber(int start, int stop) {
        return (int) (Math.random() * stop) + start;
    }
    public static String getRandomOperation() {
        String operation = Integer.toString((int) (Math.random() * 4) + 1);

        return switch (operation) {
            case "2" -> "-";
            case "3" -> "*";
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

    public static int getGCD(int num1, int num2) {
        int lesser = Math.min(num1, num2);
        while (lesser > 1) {
            if (num1 % lesser == 0 && num2 % lesser == 0) {
                return lesser;
            }
            lesser -= 1;
        }
        return 1;
    }

    public static void fillProgression(String[] progression, int start, int step) {
        for (var i = 0; i < progression.length; i += 1) {
            progression[i] = Integer.toString(start);
            start += step;
        }
    }

    public static String hideElementAtIndex(String[] arr, int index) {
        String hidden = "";
        for (var i = 0; i < arr.length; i += 1) {
            if (i == index) {
                hidden = arr[i];
                arr[i] = "..";
            }
        }
        return hidden;
    }

    public static String formProgressionString(String[] progression) {
        StringBuilder res = new StringBuilder();
        for (var element: progression) {
            res.append(element).append(" ");
        }
        return res.toString();
    }

    public static String isPrime(int number) {
        int count = 0;
        for (var i = 1; i < number / 2; i++) {
            if (number % i == 0) {
                count += 1;
            }
        }
        return number != 1 && number != 0 && count < 2 ? "yes" : "no";
    }
}
