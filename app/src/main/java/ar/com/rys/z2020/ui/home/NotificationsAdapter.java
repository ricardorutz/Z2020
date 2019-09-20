package ar.com.rys.z2020.ui.home;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.List;

import ar.com.rys.z2020.R;
import info.androidhive.fontawesome.FontDrawable;

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




       // LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       //final View root = inflater.inflate(R.layout.fragment_gallery, parent, false);


        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);

        TextView textViewMessage = rowView.findViewById(R.id.itemText);

        Log.d("Posicion","I am here" + position);

        textViewMessage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_menu_home, 0, 0, 0);




//https://www.androidhive.info/2019/06/use-font-awesome-icons-android/
//        FontDrawable drawable = new FontDrawable(context, R.string.fa_paper_plane_solid, true, false);
//        drawable.setTextColor(ContextCompat.getColor(context, android.R.color.white));
//        drawable.setTextSize(22);
//        textViewMessage.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);



        /*
        TextView textViewMessage = (TextView) rowView.findViewById(R.id.text_view_notifications_list_item);
        textViewMessage.setText(list.get(position));

        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo_notifications_list_item);
        imageView.setImageResource(R.drawable.iconsmall);

        TextView textViewTimeStamp = (TextView) rowView.findViewById(R.id.time_stamp_notifications_list_item);
        textViewTimeStamp.setText(listTimeStamp.get(position));

 */

        return rowView;
    }
}