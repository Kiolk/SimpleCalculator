package comkiolk.github.simplecalculator;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class Calculator extends AppCompatActivity {

    public static final String FIRST_NUMBER = "first number";
    public static final String SECOND_NUMBER = "second number";
   // public static final String RESULT_CALCULATION = "result of calculation";
    private EditText mFirstOperand;
    public EditText mSecondOperand;
    public TextView mResultText;
    private SharedPreferences mSaveInputData;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        final Button mAddButton;
        final Button mMinusButton;
        final Button mMultiButton;
        final Button mDevisionButton;

        mFirstOperand = (EditText) findViewById(R.id.first_operand_edit_text);
        mSecondOperand = (EditText) findViewById(R.id.second_operand_edit_text);
        mResultText = (TextView) findViewById(R.id.result_text_view);
        mAddButton = (Button) findViewById(R.id.add_button);
        mMinusButton = (Button) findViewById(R.id.minus_button);
        mMultiButton = (Button) findViewById(R.id.multi_button);
        mDevisionButton = (Button) findViewById(R.id.devision_button);

        final View.OnClickListener presButton = new View.OnClickListener() {

            @Override
            public void onClick(final View pView) {
                if (chekingNumberInString(mFirstOperand.getText().toString()) && chekingNumberInString(mSecondOperand.getText().toString())) {

                    final int first = getInteger(mFirstOperand.getText().toString());
                    final int second = getInteger(mSecondOperand.getText().toString());

                    switch (pView.getId()) {
                        case R.id.add_button:
                            final int sum = summOfNumbers(first, second);
                            mResultText.setText("" + sum);
                            break;
                        case R.id.minus_button:
                            mResultText.setText("" + minusOfNumbers(first, second));
                            break;
                        case R.id.multi_button:
                            mResultText.setText("" + multiplication(first, second));
                            break;
                        case R.id.devision_button:
                            if (checkDevisionByZero(second)) {
                                mResultText.setText("" + devision(first, second));
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        };
        mAddButton.setOnClickListener(presButton);
        mMinusButton.setOnClickListener(presButton);
        mMultiButton.setOnClickListener(presButton);
        mDevisionButton.setOnClickListener(presButton);

        loadData();
    }
//add comment

    @Override
    protected void onDestroy() {
        super.onDestroy();
        saveData();
    }

    public int getInteger(final String enteredText) {
        return Integer.parseInt(enteredText);
    }

    public boolean chekingNumberInString(final String string) {
        final Scanner scanner = new Scanner(string);
        if (scanner.hasNextInt()) {
            return true;
        }
        showToast();
        return false;
    }

    public int showToast() {
        Toast.makeText(this, "Pleas, entered number", Toast.LENGTH_LONG).show();
        return 1;
    }

    public int summOfNumbers(final int firstNumber, final int secondNumber) {
        return firstNumber + secondNumber;
    }

    public int minusOfNumbers(final int firstNumber, final int secondNumber) {
        return firstNumber - secondNumber; //change - for +
    }

    public int multiplication(final int firstNumber, final int secondNumbder) {
        return firstNumber * secondNumbder;
    }

    public int devision(final int firstNumber, final int secondNumbder) {
        return firstNumber / secondNumbder;
    }

    public boolean checkDevisionByZero(final int secondNumber) {
        if (secondNumber == 0) {
            Toast.makeText(this, "Not possible devided by 0", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public void saveData() {
        mSaveInputData = getPreferences(MODE_PRIVATE);
        final SharedPreferences.Editor editorForData = mSaveInputData.edit();
        editorForData.putString(FIRST_NUMBER, mFirstOperand.getText().toString());
        editorForData.putString(SECOND_NUMBER, mSecondOperand.getText().toString());
//        editorForData.putString(RESULT_CALCULATION, mResultText.getText().toString());
        editorForData.commit();
    }

    public void loadData() {
        mSaveInputData = getPreferences(MODE_PRIVATE);
        mFirstOperand.setText(mSaveInputData.getString(FIRST_NUMBER, ""));
        mSecondOperand.setText(mSaveInputData.getString(SECOND_NUMBER, ""));
//        mResultText.setText(mSaveInputData.getString(RESULT_CALCULATION, ""));
    }

    public String getStringFirstOperand() {
        return mFirstOperand.getText().toString();
    }

    public void setOfFirstOperand(final String string){
        mFirstOperand.setText(string);
    }
}
