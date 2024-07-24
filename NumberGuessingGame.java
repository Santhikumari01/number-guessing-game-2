import java.util.*;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minNumber = 1;
        int maxNumber = 100;
        int attemptsLimit = 5;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Number Guessing Game!");

        while (playAgain) {
            int targetNumber = random.nextInt(maxNumber - minNumber + 1) + minNumber;
            int attempts = 0;
            boolean guessedCorrectly = false;
            System.out.println("COMPUTER Genareted number between " + minNumber + " and " + maxNumber + ".\nCan you guess the number?");

            while (attempts < attemptsLimit) {
                System.out.println("Enter your guess:");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulations! Your guess is correct.");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Your guess is too low!");
                } else if (guess > targetNumber) {
                    System.out.println("Your guess is too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct answer was: " + targetNumber);
            }

            System.out.println("Do you want to play again? (yes/no):");
            String playAgainInput = scanner.next();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }
        System.out.println("Game Over. Your total score is: " + score);
        scanner.close();
    }
}