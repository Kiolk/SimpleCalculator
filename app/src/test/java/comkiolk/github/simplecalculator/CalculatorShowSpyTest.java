package comkiolk.github.simplecalculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorShowSpyTest {

//    private final Calculator calculator = new Calculator();
//    private final Calculator mMockCalculator = mock(Calculator.class);

    @Test
    public void usingSpy() {
        final Calculator calculator = new Calculator();
        final Calculator spy = spy(calculator);

        when(spy.minusOfNumbers(4, 2)).thenReturn(5);
        assertEquals(5, spy.minusOfNumbers(4, 2));

        assertEquals(2, calculator.minusOfNumbers(4, 2));

    }
}
