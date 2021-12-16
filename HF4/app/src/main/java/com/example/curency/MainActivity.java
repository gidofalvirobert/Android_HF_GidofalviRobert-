package com.example.curency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] nameArray = {"Anglia","Amerika","Ausztralia" ,"Kanada",
            "Europa","Hollandia","Magyarorszag","Svajc"};
    String[] rovidArray = {"GBP","USD","AUD" ,"CAD",
            "EUR","DKK","HUF","CHF"};

    double[] vetelArray = {
            4.4100,
            3.9750,
            6.1250,
            2.9600,
            3.0950,
            4.2300,
            0.5850,
            0.0136
    };
    double[] eladArray = {
            4.5500,
            4.1450,
            6.3550,
            3.0600,
            3.2650,
            4.3300,
            0.3150,
            0.0146
    };

    Integer[] imageArray = {R.drawable.anglia,
            R.drawable.amerika,
            R.drawable.ausztralia,
            R.drawable.canada,
            R.drawable.europe,
            R.drawable.hollandia,
            R.drawable.magyarorszag,
            R.drawable.svajc
    };

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.currencylist);
        ArrayAdapter<String>Egyszeruadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,nameArray);
        listView.setAdapter(Egyszeruadapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                double vet = vetelArray[i];
                String name = nameArray[i];
                Toast.makeText(MainActivity.this,Double.toString(vet), Toast.LENGTH_SHORT).show();
                Log.d("penz",name);
            }
        });
    }
}