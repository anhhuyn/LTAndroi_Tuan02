package vn.iotstar.baitap01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EvenOddActivity extends AppCompatActivity {

    private EditText txtInput;
    private Button btnResult;
    private TextView txtEven;
    private TextView txtOdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_even_odd_numbers);

        txtInput = findViewById(R.id.txtInput);
        btnResult = findViewById(R.id.btnResult);
        txtEven = findViewById(R.id.txtEven);
        txtOdd = findViewById(R.id.txtOdd);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = txtInput.getText().toString().trim();

                if (input.isEmpty()) {
                    txtEven.setText("Bạn chưa nhập số liệu");
                    txtOdd.setText("");
                    return;
                }

                String[] inputNumbers = input.split(",");
                ArrayList<Integer> evenNumbers = new ArrayList<>();
                ArrayList<Integer> oddNumbers = new ArrayList<>();

                for (String numStr : inputNumbers) {
                    try {
                        int number = Integer.parseInt(numStr.trim());
                        if (number % 2 == 0) {
                            evenNumbers.add(number);
                        } else {
                            oddNumbers.add(number);
                        }
                    } catch (NumberFormatException e) {
                    }
                }

                String evenNumbersStr = joinNumbers(evenNumbers);
                String oddNumbersStr = joinNumbers(oddNumbers);

                Log.d("EvenOddActivity", "Số chẵn: " + evenNumbersStr);
                Log.d("EvenOddActivity", "Số lẻ: " + oddNumbersStr);

                txtEven.setText("Số chẵn: " + evenNumbersStr);
                txtOdd.setText("Số lẻ: " + oddNumbersStr);
            }
        });
    }

    private String joinNumbers(ArrayList<Integer> numbers) {
        StringBuilder result = new StringBuilder();
        for (Integer number : numbers) {
            result.append(number).append(" ");
        }
        return result.toString().trim();
    }
}
