package com.example.curency;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;


public class CustomListAdapter extends ArrayAdapter {

    private final Activity context;
    private final Integer[] imageIDarray;
    private  final double[] vetel;
    private final double[] eladas;
    private final String[] nevv;
    private final String[] rovidd;

    public CustomListAdapter(@NonNull Context context, int resource, Activity context1, Integer[] imageIDarray, double[] vetel, double[] elad, String[] nev, String[] rovid) {
        super(context, resource);
        this.context = context1;
        this.imageIDarray = imageIDarray;
        this.vetel = vetel;
        this.eladas = elad;
        this.nevv = nev;
        this.rovidd = rovid;
    }

    @NonNull
    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listview_row,null,true);
        TextView rovid = rowView.findViewById(R.id.rovid);
        TextView nev = rowView.findViewById(R.id.nev);
        ImageView kep = rowView.findViewById(R.id.kep);
        TextView elad = rowView.findViewById(R.id.elad);
        TextView vesz = rowView.findViewById(R.id.vesz);

        nev.setText((nevv[position]));
        rovid.setText((rovidd[position]));
        kep.setImageResource(imageIDarray[position]);
        elad.setText((int) eladas[position]);
        vesz.setText((int) vetel[position]);


        return rowView;
    }
}
