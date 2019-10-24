package ar.com.rys.z2020.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.com.rys.z2020.R;

public class HomeAdapter extends ArrayAdapter<String> {
    private Context context;


    public HomeAdapter(Context context, int layautResource) {
        super(context, layautResource);
        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View rowView = inflater.inflate(R.layout.fragment_home_list_item, parent, false);


        return rowView;
    }


}