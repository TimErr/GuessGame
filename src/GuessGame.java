import java.util.Objects;
import java.util.Scanner;
import java.util.Random;
/*
    FileName: GuessGame
    Original Creator: UniProgrammer
    Date Created: Jan 14, 2018
    Last Edited by: Tim Errickson
    Version 1.1
    Guess Game was an example code from https://www.youtube.com/watch?v=pU5hjFxYpGA, I took the code from the video
    and some ideas from the comments and added some of my own ideas to come up with this current version. The idea is
    to enter the high limit so the user can try to guess the random number from 0 to the high limit put in by the user.
    There is logic to decide how many guesses the user can have based on the high limit entered. There is also logic
    that determines whether to tell the user higher, lower, they found the correct answer, or if they ran out of guesses.
 */
public class GuessGame {
    private static Scanner input;
    private static Random random;
    private static int numberLimit; //highLimit of number range to guess
    static int guessLimit; //the guess limit dependent on the range to guess from
    public static void main(String[] args) {
        runTheGame();
    }

    private static void runTheGame() {
        //set up the game with userInput for high range Limit
        numberLimit = getInputFromUser();
        //calculate the guessLimit allowed depending on value of numberLimit
        int guessLimit = calculateGuessLimit(numberLimit);
        //generate the random number
        int rand = generateRandomNumber(numberLimit);
        tryGuessing(rand, guessLimit);
    }

    /* the actual meat of the game, user inputs guess and program calculates if correct
        and provides feedback if too high or too low, if guess is correct, user gets
        message indicating how many guesses it took. if user ran out of guesses
        message states what the random number was.
     */
    private static void tryGuessing(int rand, int guessLimit) {
        int guess; //the input of the users guess
        String continuePlay;


        //inform user of the number of guesses allowed and the range to guess from
        System.out.println("Enter The Number You Think Is Correct between 0 and " + numberLimit + " < " + guessLimit + " Tries Only >");

        //loop through each guess and keep count of number of guesses, inform user of higher or lower
        for (int i = 1; i <= guessLimit; i++) {

            guess = input.nextInt();

            if (guess == rand) {
                //if guess is correct give a message with the number of guesses it took
                if (i == 1)
                {
                    System.out.println("You got the correct answer in " + i + " guess!!");
                    System.out.println("Would you like to play again? Y or N");
                    continuePlay = input.next();
                    if (Objects.equals(continuePlay, "Y") || Objects.equals(continuePlay, "y") || Objects.equals(continuePlay, "yes") || Objects.equals(continuePlay, "Yes")) {
                        runTheGame();
                    }
                } else {
                    System.out.println("You got the correct answer in " + i + " guesses!!");
                    System.out.println("Would you like to play again? Y or N");
                    continuePlay = input.next();
                    if (Objects.equals(continuePlay, "Y") || Objects.equals(continuePlay, "y") || Objects.equals(continuePlay, "yes") || Objects.equals(continuePlay, "Yes")) {
                        runTheGame();
                    }
                }
                break;
            }

            if (i==guessLimit)  {
                //user ran out of guesses, give the answer
                System.out.println("You ran out of guesses the number was " + rand);
                System.out.println("Would you like to play again? Y or N");
                continuePlay = input.next();
                if (Objects.equals(continuePlay, "Y") || Objects.equals(continuePlay, "y") || Objects.equals(continuePlay, "yes") || Objects.equals(continuePlay, "Yes")) {
                    runTheGame();
                }
            } else if (guess < rand)  {
                //users guess is too high, try again if any guesses left
                System.out.println("Guess Higher");
            } else {
                //users guess is too low, try again, if any guesses left
                System.out.println("Guess Lower");
            }


        }
    }


    /* getInputFromUser will get input from user for all setup functions*/

    public static int getInputFromUser() {
        //Get user to input a high limit for guessing
        input = new Scanner(System.in);
        System.out.println("Enter The High Limit for Range to guess from : 0 to High Limit");
        numberLimit = input.nextInt();
      while (numberLimit == 0) {
            System.out.println("Please enter a number greater than or equal to 1");
            System.out.println("Enter The High Limit for Range to guess from : 0 to High Limit");
            numberLimit = input.nextInt();
        }
        return numberLimit;
    }
    /* generateRandomNumber will generate a random number for the high end of the guessing range
     params are numberLimit from user input */
    public static int generateRandomNumber(int numberLimit) {
        int rand; //the random number

        random = new Random();

        rand = random.nextInt(numberLimit);
        return rand;
    }

    /* calculateGuessLimit is used to make gameplay realistic for both
     large and small guess ranges. With a minimum of 1 guess and a
     maximum of 20 guesses, dependent on the numberLimit entered by user. */
    public static int calculateGuessLimit(int numberLimit)  {

        //set the limit for the number of guesses allowed depending on the high limit of the range
        guessLimit = 1;

        if (numberLimit >=10 && numberLimit <= 30) {
            guessLimit = 5;
        } else if (numberLimit > 30 && numberLimit <= 50) {

            guessLimit = 10;
        } else if (numberLimit > 50 && numberLimit <= 100) {
            guessLimit = 15;
        } else if (numberLimit > 100)
        {
            guessLimit = 20;
        }
        return guessLimit;
    }
}