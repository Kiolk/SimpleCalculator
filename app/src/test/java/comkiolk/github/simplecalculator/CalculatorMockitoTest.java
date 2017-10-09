package comkiolk.github.simplecalculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorMockitoTest {

    private final Calculator calculator = new Calculator();
    private final Calculator mMockCalculator = mock(Calculator.class);
//    @Mock
//    Calculator mMockCalculator;

//    @Before
//    public void setUp() throws Exception {
//        calculator = new Calculator();
//    }

    @Test
    public void summOfNumbers() throws Exception {
        assertEquals(3, calculator.summOfNumbers(2, 1));
    }

    @Test
    public void minusOfNumbers() throws Exception {
        assertEquals(9, calculator.minusOfNumbers(27, 18));
    }

    @Test
    public  void  getInteger() throws Exception{
        when(mMockCalculator.getInteger(anyString())).thenReturn(6);
        assertEquals(6, mMockCalculator.getInteger("Fake"));
    }

    @Test
    public void chekingNumberInString() throws Exception{
        //when(mMockCalculator.showToast()).thenReturn(1);
        assertEquals(true, calculator.chekingNumberInString("3"));
        assertEquals(false, mMockCalculator.chekingNumberInString("Fake number"));
    }
}
