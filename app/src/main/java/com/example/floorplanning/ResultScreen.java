package com.example.floorplanning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultScreen extends AppCompatActivity {

    private TextView textArea;
    private double length;
    private double width;
    private Button buttonReturn;
    private String area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.results_screen);

        textArea = (TextView) findViewById(R.id.textArea);
        buttonReturn = (Button) findViewById(R.id.button2);

        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMain();
            }
        });

        Bundle extras = getIntent().getExtras();
        length = extras.getDouble("length");
        width = extras.getDouble("width");
        area = Double.toString(length*width);
        textArea.setText(area);
    }

    private void returnToMain()
    {
        Intent returnIntent = new Intent(this, MainActivity.class);
        startActivity(returnIntent);
    }

}
