package comkiolk.github.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Calculator extends AppCompatActivity {

    private View mFirstOperand;
    private View mSecondOperand;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        mFirstOperand = findViewById(R.id.first_operand_edit_text);
        mSecondOperand = findViewById(R.id.second_operand_edit_text);

    }

    public int summOfNumbers(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }

}
