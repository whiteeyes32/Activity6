package com.example.floorplanning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editLength;
    private EditText editWidth;
    private TextView textError;
    private Button buttonResults;

    private double length;
    private double width;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editLength = findViewById(R.id.editLength);
        editWidth = findViewById(R.id.editWidth);
        textError = findViewById(R.id.textError);
        buttonResults = findViewById(R.id.button);

        buttonResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateButton();
            }
        });

        length = 0;
        width = 0;
    }

    public void calculateButton()
    {
        if(editLength.getText().toString() != "" && editWidth.getText().toString() != "")
        {
            try {
                length = Double.parseDouble(editLength.getText().toString());
                width = Double.parseDouble(editWidth.getText().toString());
                calculate();
            }
            catch (NumberFormatException e) {
                textError.setText("Error: Please enter a valid length and width.");
            }
        }
        else
        {
            textError.setText("Error: Please enter a length and width.");
        }
    }

    private void calculate()
    {
        Intent resultScreenIntent = new Intent(this, ResultScreen.class);
        resultScreenIntent.putExtra("length", length);
        resultScreenIntent.putExtra("width", width);
        startActivity(resultScreenIntent);
    }
}