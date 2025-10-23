package com.example.aviatickets;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText editTextDepartureDate, editTextArrivalDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextDepartureDate = findViewById(R.id.editTextDepartureDate);
        editTextArrivalDate = findViewById(R.id.editTextArrivalDate);

        EditText editTextAdults = findViewById(R.id.editTextAdults);
        EditText editTextChildren = findViewById(R.id.editTextChildren);
        EditText editTextInfants = findViewById(R.id.editTextInfants);

        editTextDepartureDate.setOnClickListener(v -> showDatePicker(editTextDepartureDate, true));
        editTextArrivalDate.setOnClickListener(v -> showDatePicker(editTextArrivalDate, false));

    }

    private void showDatePicker(EditText editText, boolean isDepartureDate) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    Calendar selectedDate = Calendar.getInstance();
                    selectedDate.set(selectedYear, selectedMonth, selectedDay);

                    String date = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
                    editText.setText(date);

                    if (isDepartureDate && !editTextArrivalDate.getText().toString().isEmpty())
                        checkDates(selectedDate, getDateFromEditText(editTextArrivalDate));
                    else if (!isDepartureDate && !editTextDepartureDate.getText().toString().isEmpty())
                        checkDates(getDateFromEditText(editTextDepartureDate), selectedDate);
                },
                year, month, day
        );
        datePickerDialog.show();
    }

    private Calendar getDateFromEditText(EditText editText) {
        String[] dateParts = editText.getText().toString().split("/");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(dateParts[2]),
                Integer.parseInt(dateParts[1]) - 1,
                Integer.parseInt(dateParts[0]));
        return calendar;
    }

    private void checkDates(Calendar departure, Calendar arrival) {
        if (departure.after(arrival)) {
            Toast.makeText(this, "Дата вылета не может быть позже даты прилета", Toast.LENGTH_LONG).show();
            editTextArrivalDate.setText("");
        }
    }
}