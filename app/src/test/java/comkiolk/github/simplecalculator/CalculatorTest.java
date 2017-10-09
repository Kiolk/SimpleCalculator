package comkiolk.github.simplecalculator;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void summOfNumbers() throws Exception {
        assertEquals(3, calculator.summOfNumbers(2, 1));
    }

    @Test
    public void minusOfNumbers() throws Exception {
        assertEquals(2, calculator.minusOfNumbers(5, 3));
    }

    @Test
    public void getInteger() throws Exception {
        assertEquals(8, calculator.getInteger("8"));
    }

    @Test
    public void chekingNumberInString() throws Exception {
        assertEquals(true, calculator.chekingNumberInString("3"));
    }
}
