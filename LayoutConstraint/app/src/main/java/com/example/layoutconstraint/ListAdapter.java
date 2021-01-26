package com.example.layoutconstraint;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class ListAdapter<S> extends ArrayAdapter<Sinhvien> {

    public ListAdapter(Context context, int resource, List<Sinhvien> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.activity_custom_view_s_v, null);
        }
        Sinhvien p = getItem(position);
        if (p != null) {
            // Anh xa + Gan gia tri
            TextView txt1 = (TextView) view.findViewById(R.id.textViewHoten);
            txt1.setText(p.getName());
            TextView txt2 = (TextView) view.findViewById(R.id.textViewnamsinh);
            txt2.setText(p.getYear()+"");
        }
        return view;
    }

}

