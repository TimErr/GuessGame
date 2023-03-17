import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GuessGameTest {
    private GuessGame testGuessGame;

    public void setUp () {
        testGuessGame = new GuessGame();
    }
    @Test
    //test to see if guess limit calculates correctly using inputs between 10 and 30
    void testCalculateGuessLimit () {

        assertEquals(5, testGuessGame.calculateGuessLimit(10));
        assertEquals(5,testGuessGame.calculateGuessLimit(30));
        assertEquals(10, testGuessGame.calculateGuessLimit(31));
        assertEquals(10, testGuessGame.calculateGuessLimit(50));
        assertEquals(15, testGuessGame.calculateGuessLimit(51));
        assertEquals(15, testGuessGame.calculateGuessLimit(100));
        assertEquals(20, GuessGame.calculateGuessLimit(101));
        assertEquals(20, testGuessGame.calculateGuessLimit(1001));
    }
}