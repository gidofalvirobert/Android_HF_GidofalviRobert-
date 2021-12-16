package com.example.fel1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button ossz = findViewById(R.id.osszead);
        Button kiv = findViewById(R.id.kivon);
        Button szor = findViewById(R.id.szoroz);
        Button oszt = findViewById(R.id.oszt);
        
        EditText szam1 = findViewById(R.id.szam1);
        EditText szam2 = findViewById(R.id.szam2);

        TextView eredmeny = findViewById(R.id.eredmeny);

        ossz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double ossz = Double.parseDouble(szam1.getText().toString()) + Double.parseDouble(szam2.getText().toString());
                eredmeny.setText(String.valueOf(ossz));
            }
        });

        kiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double kiv = Double.parseDouble(szam1.getText().toString()) - Double.parseDouble(szam2.getText().toString());
                eredmeny.setText(String.valueOf(kiv));
            }
        });
        szor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double szor = Double.parseDouble(szam1.getText().toString()) * Double.parseDouble(szam2.getText().toString());
                eredmeny.setText(String.valueOf(szor));
            }
        });
        oszt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double oszt = Double.parseDouble(szam1.getText().toString()) / Double.parseDouble(szam2.getText().toString());
                eredmeny.setText(String.valueOf(oszt));
            }
        });


    }
}