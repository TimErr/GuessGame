import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GuessGameTest {

    private GuessGame guessGame;

    @BeforeEach
    void setUp() {
        guessGame = new GuessGame();

    }
    @Test
    void testCalculateGuessLimitWithNumberLimitLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> {
            GuessGame.calculateGuessLimit(0);
        });
    }

    @Test
    void testCalculateGuessLimitWithNumberLimitEqualToOne() {

        int result = GuessGame.calculateGuessLimit(1);
        assertEquals(1, result);
    }


    @Test
    public void testCalculateGuessLimitWithNumberInRange1() {
        int result = GuessGame.calculateGuessLimit(10);
        assertEquals(5, result);
    }

    @Test
    public void testCalculateGuessLimitWithNumberInRange2() {
        int result = GuessGame.calculateGuessLimit(30);
        assertEquals(5, result);
    }

    @Test
    public void testCalculateGuessLimitWithNumberInRange3() {
        int result = GuessGame.calculateGuessLimit(50);
        assertEquals(10, result);
    }

    @Test
    public void testCalculateGuessLimitWithNumberInRange4() {
        int result = GuessGame.calculateGuessLimit(100);
        assertEquals(15, result);
    }

    @Test
    public void testCalculateGuessLimitWithNumberGreaterThan100() {
        int result = GuessGame.calculateGuessLimit(200);
        assertEquals(20, result);
    }

}
