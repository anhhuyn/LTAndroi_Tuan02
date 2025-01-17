package vn.iotstar.baitap01;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private Button btnEvenOdd;
    private Button btnReverseString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Ẩn thanh tiêu đề của Android
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        CircleImageView circleImageView = findViewById(R.id.imgStudent);
        circleImageView.setImageResource(R.drawable.img);

        btnEvenOdd =findViewById(R.id.btnEvenOdd);
        btnEvenOdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EvenOddActivity.class);
            startActivity(intent);
        });

        btnReverseString =findViewById(R.id.btnReverseString);
        btnReverseString.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ReverseActivity.class);
            startActivity(intent);
        });

    }
}