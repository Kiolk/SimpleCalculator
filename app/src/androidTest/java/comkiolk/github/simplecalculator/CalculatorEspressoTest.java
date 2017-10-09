package comkiolk.github.simplecalculator;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CalculatorEspressoTest {

    @Rule
    //Context context = this.getInstrumentation().getTargetContext().getApplicationContext();
    public ActivityTestRule<Calculator> mCalculatorTestRule = new ActivityTestRule<>(Calculator.class);


    @Test
    public void checkingToastView() {
        onView(withId(R.id.add_button)).perform(click()).check(matches(isDisplayed()));

    }

    @Test
    public void checkingEnabledResultButton() {
        onView(withId(R.id.minus_button)).check(matches(isEnabled()));
    }

    @Test
    public void checkingEnteredTwoNumber() {
        onView(withId(R.id.second_operand_edit_text)).perform(clearText()).perform(typeText("3"));
        onView(withId(R.id.second_operand_edit_text)).check(matches(withText("3")));
        onView(withId(R.id.first_operand_edit_text)).perform(clearText()).perform(typeText("foo"));
        onView(withId(R.id.first_operand_edit_text)).check(matches(withText("foo")));
    }

    @Test
    public void checkingResultForCorrectAnswer() {
        onView(withId(R.id.second_operand_edit_text)).perform(clearText()).perform(typeText("3"));
        onView(withId(R.id.first_operand_edit_text)).perform(clearText()).perform(typeText("5"));
        onView(withId(R.id.add_button)).perform(click());
        onView(withId(R.id.result_text_view)).check(matches(withText("8")));

        onView(withId(R.id.second_operand_edit_text)).perform(clearText()).perform(typeText("25"));
        onView(withId(R.id.first_operand_edit_text)).perform(clearText()).perform(typeText("50"));
        onView(withId(R.id.devision_button)).perform(click());
        onView(withId(R.id.result_text_view)).check(matches(withText("2")));

        onView(withId(R.id.second_operand_edit_text)).perform(clearText()).perform(typeText("17"));
        onView(withId(R.id.first_operand_edit_text)).perform(clearText()).perform(typeText("26"));
        onView(withId(R.id.minus_button)).perform(click());
        onView(withId(R.id.result_text_view)).check(matches(withText("9")));

        onView(withId(R.id.second_operand_edit_text)).perform(clearText()).perform(typeText("99"));
        onView(withId(R.id.first_operand_edit_text)).perform(clearText()).perform(typeText("2"));
        onView(withId(R.id.multi_button)).perform(click());
        onView(withId(R.id.result_text_view)).check(matches(withText("198")));
    }
}

