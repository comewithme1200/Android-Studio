package com.example.customadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Sinhvien> dsSV;

    private CustomFilter filter;
    private ArrayList<Sinhvien> filterList;

    public CustomAdapter(Context context, ArrayList<Sinhvien> dsSV) {
        this.context = context;
        this.dsSV = dsSV;
        this.filterList = dsSV;
    }


    @Override

    public int getCount() {
        return dsSV.size(); 
    }

    @Override
    public Object getItem(int position) {
        return dsSV.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.activity_customplayer_view, null);
        }
        Sinhvien p = (Sinhvien) getItem(position);
        if (p != null) {
            // Anh xa + Gan gia tri
            TextView txt1 = (TextView) view.findViewById(R.id.textViewname);
            txt1.setText(p.getName());
            ImageView img = (ImageView) view.findViewById(R.id.imageViewPlay);
            img.setImageResource(p.getFace());
        }
        return view;
    }
    public Filter getFilter()
    {
        if(filter == null)
        {
            filter = new CustomFilter();
        }
        return filter;
    }
    private class CustomFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if (constraint != null && constraint.length() > 0) {
                constraint = constraint.toString().toUpperCase();
                ArrayList<Sinhvien> filters = new ArrayList<Sinhvien>();
                for (int i = 0; i < filterList.size(); i++) {
                    if (filterList.get(i).getName().toUpperCase().contains(constraint)) {
                        Sinhvien p = new Sinhvien(filterList.get(i).getName(),filterList.get(i).getFace());
                        filters.add(p);
                    }
                }
                results.count = filters.size();
                results.values = filters;
            }
            else
            {
                results.count = filterList.size();
                results.values = filterList;
            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            dsSV = (ArrayList<Sinhvien>)results.values;
            notifyDataSetChanged();
        }
    }

}
