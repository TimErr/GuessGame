import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessGameTest {
    @Test
    //test to see if guess limit calculates correctly using inputs between 10 and 30
    void guessLimitShouldBeFive () {
        GuessGame testGuessLimit = new GuessGame();
        assertEquals(5, testGuessLimit.calculateGuessLimit(10));
        assertEquals(5,testGuessLimit.calculateGuessLimit(30));
    }

    @Test
        //test to see if guess limit calculates correctly using inputs between 31 and 50
    void guessLimitShouldBeTen () {
        GuessGame testGuessLimit = new GuessGame();
        assertEquals(10, testGuessLimit.calculateGuessLimit(31));
        assertEquals(10, testGuessLimit.calculateGuessLimit(50));
    }

    @Test
        //test to see if guess limit calculates correctly using inputs between 51 and 100
    void guessLimitShouldBeFifteen () {
        GuessGame testGuessLimit = new GuessGame();
        assertEquals(15, testGuessLimit.calculateGuessLimit(51));
        assertEquals(15, testGuessLimit.calculateGuessLimit(100));
    }
    @Test
        //test to see if guess limit calculates correctly using inputs higher than 100
    void guessLimitShouldBeTwenty () {
        GuessGame testGuessLimit = new GuessGame();
        assertEquals(20, testGuessLimit.calculateGuessLimit(101));
        assertEquals(20, testGuessLimit.calculateGuessLimit(1001));
    }
}