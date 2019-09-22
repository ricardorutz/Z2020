package ar.com.rys.z2020.ui.home;

import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.List;

import ar.com.rys.z2020.R;

public class NotificationsAdapter extends ArrayAdapter<String> {
    private Context context;
    private List<String> listCountry;
    private List<Integer> iconResourcesIds;

    public NotificationsAdapter(Context context, int layautResource, List<String> listCountry, List<Integer> iconResourcesIds) {

        super(context, layautResource, listCountry);
        this.context = context;
        this.listCountry = listCountry;
        this.iconResourcesIds= iconResourcesIds;
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
        textViewMessage.setText(listCountry.get(position));

        return rowView;
    }
}