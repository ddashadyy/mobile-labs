package com.example.twonumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.editTextNumber1);
        et2 = findViewById(R.id.editTextNumber2);
        tvResult = findViewById(R.id.textViewResult);
    }

    public void onClick(View v) {
        String n1 = et1.getText().toString();
        String n2 = et2.getText().toString();

        if (n1.isBlank() || n2.isBlank()) {
            Toast.makeText(
                this,
                "Введите числа",
                Toast.LENGTH_SHORT).show();
            return;
        }

        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);
        String sum = Integer.toString(num1+num2);
        tvResult.setText(sum);
    }
}