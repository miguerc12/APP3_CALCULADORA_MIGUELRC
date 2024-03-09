package rodriguez.miguel.app3_calculadora_miguel_rc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView display;
    TextView resultDisplay;
    String currentNumber = "";
    String currentExpression = "";
    double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        resultDisplay = findViewById(R.id.result_display);
    }

    public void onNumberClick(View view) {
        Button button = (Button) view;
        currentNumber += button.getText().toString();
        currentExpression += button.getText().toString();
        display.setText(currentExpression);
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        currentExpression += button.getText().toString();
        display.setText(currentExpression);
        currentNumber = "";
    }
    public void onEqualClick(View view) {
        try {
            result = evaluateExpression(currentExpression);
            display.setText(String.valueOf(result));
            resultDisplay.setText(currentExpression + "=" + String.valueOf(result));
            currentNumber = String.valueOf(result);
            currentExpression = "";
        } catch (Exception e) {
            display.setText("Error: " + e.getMessage());
        }
    }

    public void onClearClick(View view) {
        currentNumber = "";
        currentExpression = "";
        display.setText("");
        resultDisplay.setText("");
    }

    private double evaluateExpression(String expression) throws Exception {
        String[] numbers = expression.split("[+\\-*/]");
        String[] operators = expression.split("\\d+");
        double result = Double.parseDouble(numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            double num = Double.parseDouble(numbers[i]);
            String operator = operators[i];
            switch (operator) {
                case "+":
                    result += num;
                    break;
                case "-":
                    result -= num;
                    break;
                case "*":
                    result *= num;
                    break;
                case "/":
                    if (num != 0) {
                        result /= num;
                    } else {
                        throw new Exception("Division by zero");
                    }
                    break;
                default:
                    throw new Exception("Invalid operator: " + operator);
            }
        }
        return result;
    }



}



