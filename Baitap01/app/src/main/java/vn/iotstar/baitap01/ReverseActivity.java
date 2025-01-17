package vn.iotstar.baitap01;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReverseActivity extends AppCompatActivity {
    private EditText edtInputString;
    private Button btnReverse;
    private TextView txtReverse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_reverse_string);

        edtInputString = findViewById(R.id.txtInputString);
        btnReverse = findViewById(R.id.btnReverse);
        txtReverse = findViewById(R.id.txtReverse);

        btnReverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputString = edtInputString.getText().toString().trim();

                if (inputString.isEmpty()) {
                    txtReverse.setText("Vui lòng nhập một chuỗi");
                    Toast.makeText(ReverseActivity.this, "Vui lòng nhập một chuỗi", Toast.LENGTH_SHORT).show();
                    return;
                }

                String[] words = inputString.split(" ");
                StringBuilder reversedString = new StringBuilder();

                for (int i = words.length - 1; i >= 0; i--) {
                    reversedString.append(words[i]).append(" ");
                }

                String result = reversedString.toString().trim().toUpperCase();

                txtReverse.setText("Chuỗi đảo ngược: " + result);

                Toast.makeText(ReverseActivity.this, "Chuỗi đảo ngược: " + result, Toast.LENGTH_LONG).show();
            }
        });
    }
}
