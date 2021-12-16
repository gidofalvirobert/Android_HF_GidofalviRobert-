package com.example.tablayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<product> prodlist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText prodname = findViewById(R.id.pname);
        EditText prodcode = findViewById(R.id.pcode);
        EditText prodprice = findViewById(R.id.pprice);
        TextView termekek = findViewById(R.id.termekek);

        Button button1 = findViewById(R.id.adprod);
        Button button2 = findViewById(R.id.cancelprod);
        Button button3 = findViewById(R.id.show);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prodlist.add(new product(prodcode.getText().toString(),prodname.getText().toString(),Double.parseDouble(prodprice.getText().toString())));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prodcode.setText("");
                prodname.setText("");
                prodprice.setText("");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(product p:prodlist)
                {
                    termekek.append(p.toString() + "\n");
                }
            }
        });
    }
    class product{
        public String prodcode;
        public String prodname;
        public double prodprice;

        public product(String prodcode, String prodname, double prodprice) {
            this.prodcode = prodcode;
            this.prodname = prodname;
            this.prodprice = prodprice;
        }

        @Override
        public String toString() {
            return "product{" +
                    "prodcode='" + prodcode + '\'' +
                    ", prodname='" + prodname + '\'' +
                    ", prodprice=" + prodprice +
                    '}';
        }
    }
}