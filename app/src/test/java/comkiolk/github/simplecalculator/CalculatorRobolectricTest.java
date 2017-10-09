package comkiolk.github.simplecalculator;

import android.content.pm.ActivityInfo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class CalculatorRobolectricTest {

    private MainActivity activity;
    private Calculator mCalculator;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(MainActivity.class).create().resume().get();
        mCalculator = Robolectric.buildActivity(Calculator.class).create().resume().get();
    }

    @Test
    public void shouldNotBeNull() throws Exception {
        assertNotNull(activity);
    }

    @Test
    public void shouldNotBeNullCalculator() throws Exception {

        assertNotNull(mCalculator);
    }

    @Test
    public void checkingIsEnabledResultButton() throws Exception {
        assertEquals(false, mCalculator.findViewById(R.id.result_button).isEnabled());
    }

    @Test
    public void checking() throws Exception {
        mCalculator.setOfFirstOperand("3");
        assertEquals("3", mCalculator.getStringFirstOperand());
    }

    @Test
    public void checkingSumOfNumbers() throws Exception {
        mCalculator.setOfFirstOperand("3");
        mCalculator.mSecondOperand.setText("7");
        mCalculator.findViewById(R.id.minus_button).performClick();
        assertEquals("-4", mCalculator.mResultText.getText().toString());
    }

    @Test
    public void checkingSaveDataIfChangeOrientation() throws Exception{
        mCalculator.setOfFirstOperand("98");
        mCalculator.mSecondOperand.setText("13");
        mCalculator.saveData();
        mCalculator.setOfFirstOperand("56");
        mCalculator.mSecondOperand.setText("25");
        mCalculator.loadData();
        mCalculator.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        assertEquals("98", mCalculator.getStringFirstOperand());
        assertEquals("13", mCalculator.mSecondOperand.getText().toString());
    }
}
