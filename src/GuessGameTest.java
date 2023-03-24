import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import static org.junit.jupiter.api.Assertions.*;

public class GuessGameTest {

    private GuessGame guessGame;

    @BeforeEach
    void setUp() {
        guessGame = new GuessGame();

    }

    /* functional tests */


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

    /* Non-functional tests */

    @Test
    public void testProcessingSpeedForRandomNumberRanges() {
        long start = System.currentTimeMillis();
        int result = GuessGame.generateRandomNumber(1);
        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.println("Execution time for range 0 to 1 is "+ formatter.format((end - start) / 1000d) + " seconds");

        start = System.currentTimeMillis();
        result = GuessGame.generateRandomNumber(150);
        end = System.currentTimeMillis();
        formatter = new DecimalFormat("#0.00000");
        System.out.println("Execution time for range 0 to 150 is "+ formatter.format((end - start) / 1000d) + " seconds");

        start = System.currentTimeMillis();
        result = GuessGame.generateRandomNumber(100000);
        end = System.currentTimeMillis();
        formatter = new DecimalFormat("#0.00000");
        System.out.println("Execution time for range 0 to 100000 is "+ formatter.format((end - start) / 1000d) + " seconds");

    }

}
