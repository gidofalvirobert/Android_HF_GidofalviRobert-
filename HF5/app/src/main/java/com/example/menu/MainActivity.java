package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.style.ForegroundColorSpan;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    ArrayAdapter<CharSequence> arrayAdapter;
    ArrayList<CharSequence> list = new ArrayList<>();

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        list.add("robi");
        list.add("dani");
        list.add("gabor");
        list.add("lidia");
        list.add("csenge");
        
        lista = findViewById(R.id.nevek);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,list);
        registerForContextMenu(lista);
        lista.setAdapter(arrayAdapter);
        
        
        
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        SpannableString elem;
        switch (item.getItemId())
        {
            case R.id.piros:
                elem = SpannableString.valueOf(list.get(info.position));
                elem.setSpan(new ForegroundColorSpan(Color.RED),0,elem.length(),0);
                list.set(info.position,elem);
                arrayAdapter.notifyDataSetChanged();
                return true;
            case R.id.zold:
                elem = SpannableString.valueOf(list.get(info.position));
                elem.setSpan(new ForegroundColorSpan(Color.GREEN),0,elem.length(),0);
                list.set(info.position,elem);
                arrayAdapter.notifyDataSetChanged();
                return true;
            case R.id.kek:
                elem = SpannableString.valueOf(list.get(info.position));
                elem.setSpan(new ForegroundColorSpan(Color.BLUE),0,elem.length(),0);
                list.set(info.position,elem);
                arrayAdapter.notifyDataSetChanged();
                return true;
            default:return super.onContextItemSelected(item);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.delete:
                list.clear();
                arrayAdapter.notifyDataSetChanged();
                return true;
            case R.id.sort:
                Collections.sort(list,new Comparator<CharSequence>(){
                    @Override
                    public int compare(CharSequence o1, CharSequence o2) {
                        return o1.toString().compareTo(o2.toString());
                    }


                });
                arrayAdapter.notifyDataSetChanged();
                return true;
            default: return super.onOptionsItemSelected(item);
        }

    }
}