import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessGameTest {
    private GuessGame testGuessLimit;

    public void setUp () {
        testGuessLimit = new GuessGame();
    }
    @Test
    //test to see if guess limit calculates correctly using inputs between 10 and 30
    void guessLimitShouldBeFive () {

        assertEquals(5, testGuessLimit.calculateGuessLimit(10));
        assertEquals(5,testGuessLimit.calculateGuessLimit(30));
    }

    @Test
        //test to see if guess limit calculates correctly using inputs between 31 and 50
    void guessLimitShouldBeTen () {

        assertEquals(10, testGuessLimit.calculateGuessLimit(31));
        assertEquals(10, testGuessLimit.calculateGuessLimit(50));
    }

    @Test
        //test to see if guess limit calculates correctly using inputs between 51 and 100
    void guessLimitShouldBeFifteen () {

        assertEquals(15, testGuessLimit.calculateGuessLimit(51));
        assertEquals(15, testGuessLimit.calculateGuessLimit(100));
    }
    @Test
        //test to see if guess limit calculates correctly using inputs higher than 100
    void guessLimitShouldBeTwenty () {

        assertEquals(20, testGuessLimit.calculateGuessLimit(101));
        assertEquals(20, testGuessLimit.calculateGuessLimit(1001));
    }
}