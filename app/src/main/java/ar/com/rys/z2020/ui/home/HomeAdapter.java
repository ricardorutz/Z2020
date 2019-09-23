package ar.com.rys.z2020.ui.home;

import android.content.Context;
import android.util.Log;
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
    private List<Integer> listOfTexts;
    private List<Integer> iconResourcesIds;



    public HomeAdapter(Context context, int layautResource, List<Integer> listOfTexts) {
        super(context, layautResource, listOfTexts.stream().map(s -> String.valueOf(s)).collect(Collectors.toList()));
        this.context = context;
        this.listOfTexts = listOfTexts;
        this.iconResourcesIds= initResources();
    }

    private List<Integer> initResources() {

        if(iconResourcesIds == null){
            iconResourcesIds = new ArrayList();
            iconResourcesIds.add(R.drawable.ic_calendar_alt_solid);
            iconResourcesIds.add(R.drawable.ic_cloud_sun_rain_solid);
            iconResourcesIds.add(R.drawable.ic_temperature_high_solid);
            iconResourcesIds.add(R.drawable.ic_temperature_low_solid);
        }

        return iconResourcesIds;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);

        TextView textViewMessage = rowView.findViewById(R.id.itemText);

        Log.d("Posicion","I am here" + position);

        //textViewMessage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_calendar_alt_solid, 0, 0, 0);
        textViewMessage.setCompoundDrawablesWithIntrinsicBounds(iconResourcesIds.get(position), 0, 0, 0);


        String formattedText = "This <i>is</i> a <b>test</b> of <a href='http://foo.com'>html</a>";
        //textViewMessage.setText(Html.fromHtml(formattedText));
        textViewMessage.setText(listOfTexts.get(position));

        return rowView;
    }
}