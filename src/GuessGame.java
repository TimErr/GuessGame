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
    public static void main(String[] args) {

        Random random = new Random();
        Scanner input = new Scanner(System.in);

        //Set variables for number guess game
        int numberLimit; //highLimit of number range to guess
        int guess; //the input of the users guess
        int rand; //the random number
        int guessLimit; //the guess limit dependent on the range to guess from

        //Get user to input a high limit for guessing
        System.out.println("Enter The High Limit for Range to guess from : 0 to High Limit");
        numberLimit = input.nextInt();

        rand = random.nextInt(numberLimit);
        //set the limit for the number of guesses allowed depending on the high limit of the range
        guessLimit = 2;

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
                    } else {
                        System.out.println("You got the correct answer in " + i + " guesses!!");
                    }
                    break;
                } else if (guess < rand) {
                    System.out.println("Guess Higher");
                } else {
                    System.out.println("Guess Lower");
                }
                //user ran out of guesses, give the answer
            if (i==guessLimit)
            {
                System.out.println("You ran out of guesses the number was " + rand);
            }
        }

    }
}