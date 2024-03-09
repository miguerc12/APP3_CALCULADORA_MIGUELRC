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
}



